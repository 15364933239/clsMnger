package com.shengsheng.controller.wl509;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shengsheng.core.Constant;
import com.shengsheng.core.JavaEEFrameworkBaseController;
import com.shengsheng.model.wl509.Device;
import com.shengsheng.model.wl509.Record;
import com.shengsheng.model.wl509.User;
import com.shengsheng.service.wl509.DeviceService;
import com.shengsheng.service.wl509.RecordService;
import com.shengsheng.service.wl509.UserService;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong 2019年3月28日 下午2:42:42
 *         <dl>
 *         <dd>OnlineController</dd>
 *         <dt>记录的控制层</dt>
 *         </dl>
 */
@Controller
@RequestMapping("/static/user")
public class UserController extends JavaEEFrameworkBaseController<User> implements Constant {

	@Resource
	private UserService userService;
	@Resource
	private DeviceService deviceService;
	@Resource
	private RecordService recordService;
	/** 批次 */
	static int batch = 1;
	/** 考勤时间 **/
	static double attencetime = 0;

	/**
	 * getuser
	 * 
	 * @Description: 查询用户的表格，包括分页、搜索和排序
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getUser", method = { RequestMethod.POST, RequestMethod.GET })
	public void getuser(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        List<User> list = new ArrayList<User>();
		List<User> list = userService.doQueryAll();
//        for (User user : queryAll) {
//            if(user.isState()) {
//                list.add(user);
//            }
//        }
//        Integer firstResult = Integer.valueOf(request.getParameter("page"));
//        Integer maxResults = Integer.valueOf(request.getParameter("rows"));
//        String sortedObject = request.getParameter("sidx");
//        String sortedValue = request.getParameter("sord");
//        String filters = request.getParameter("filters");
//        User user = new User();
//        if (StringUtils.isNotBlank(filters)) {
//            JSONObject jsonObject = JSONObject.fromObject(filters);
//            JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JSONObject result = (JSONObject) jsonArray.get(i);
//                if (result.getString("field").equals("number") && result.getString("op").equals("eq")) {
//                    user.set$eq_number(result.getString("name"));
//                }
//                if (result.getString("field").equals("userValue") && result.getString("op").equals("cn")) {
//                    user.set$like_name(result.getString("data"));
//                }
//            }
//            if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
//                user.setFlag("OR");
//            } else {
//                user.setFlag("AND");
//            }
//        }
//        user.setFirstResult((firstResult - 1) * maxResults);
//        user.setMaxResults(maxResults);
//        Map<String, String> sortedCondition = new HashMap<String, String>();
//        sortedCondition.put(sortedObject, sortedValue);
//        user.setSortedConditions(sortedCondition);
//        QueryResult<User> queryResult = userService.doPaginationQuery(user);
//        JqGridPageView<User> userListView = new JqGridPageView<User>();
//        userListView.setMaxResults(maxResults);
//        System.out.println(1);
//        List<User> userWithSubList = list;
//        System.out.println(2);
//        userListView.setRows(userWithSubList);
//        userListView.setRecords(queryResult.getTotalCount());
		writeJSON(response, list);
	}

	/**
	 * deviceReception
	 * 
	 * @Description: 接收局域网端发送的在线设备数据,存到数据库,并且对在线用户进行状态转化
	 * @param request
	 * @param response
	 * @param onLineDevices
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "/recept", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public void deviceReception(HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<Device> onLineDevices) throws ParseException, IOException {

		System.out.println("获取到在线设备：" + onLineDevices);
		List<Device> devices = new ArrayList<Device>();
		for (Device device : onLineDevices) {
			Device device2 = deviceService.getByProerties("mac", device.getMac());
			if (device2 == null) { // mac不存在
				deviceService.persist(device);
				device2 = device;
			}
			User user = new User();
			if (device2.getUser() != null && device2.getUser().getState() == "不在线") {
				user = device2.getUser();
				user.setState("在线");
				userService.update(user);
				List<User> userList = userService.doQueryAll();

				for (User u : userList) {
					if (userList.contains(user)) {
					} else {
						u.setState("不在线");
					}
				}
			}
			Record record = new Record();
			record.setTime(new Date());
			record.setDevice(device2);
			record.setBatch(batch);
			devices.add(device2);
			recordService.persist(record);
		}
		System.out.print("第" + batch + "批次");
		batch++;
	}

	/**
	 * 计算考勤
	 * 
	 * @Description: calAattendance
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/calAattendance", method = { RequestMethod.POST, RequestMethod.GET })
	public void calAattendance(HttpServletRequest request, HttpServletResponse response) throws Exception {/** 查询所有用户 */
		List<User> userlist = userService.doQueryAll();
		List<User> ulist = new ArrayList<User>();
		Map<String, List<User>> list2 = new HashMap<String, List<User>>();
		for (User user : userlist) {
			Calendar start = Calendar.getInstance();
			/** 设置开始时间 */
			start.set(2019, 4, 15);
			/** 得到这个人在记录表中所有在线设备的记录 */
			List<Record> recordlist = recordService.listByUser(user, start.getTime(), new Date());
			Map<Integer, Device> map = new HashMap<Integer, Device>();
			int maxB = Integer.MIN_VALUE;
			int minB = Integer.MAX_VALUE;
			for (Record r : recordlist) {
				/** 遍历人在这批次的所有在线设备 */
				map.put(r.getBatch(), r.getDevice());

				if (maxB < r.getBatch()) {
					maxB = r.getBatch();
				}
				if (minB > r.getBatch()) {
					minB = r.getBatch();
				}

			}
			/** 这个人的这批次的在线设备 */
			int allTime = 0;
			int time = 0;
			for (int i = minB; i <= maxB + 1; i++) {

				if (map.containsKey(i) && map.containsKey(i + 1)) {
					time = time + 3;
				} else {
					allTime = allTime + time;
					time = 0;
				}

			}
			user.setaAttendance(String.valueOf(allTime));
			/**将名字以及对应的考勤时间添加到数组里，并转成json格式 */
			ulist.add(user);			
			System.out.println(user.getaAttendance());
		}
		list2.put("user", ulist);
		writeJSON(response, list2);
		
	}

	/**
	 * 用户注册
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/register")
	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("注册");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		// 查找有无账户相同的User
		Map<String, Object> result = new HashMap<String, Object>();
		User proerties = userService.getByProerties("username", username);
		if (proerties != null) {
			result.put("result", -1);
			writeJSON(response, result);
			return;
		}
		// 无相同username，设置新的用户
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setMail(mail);
		// 添加新用户
		userService.persist(user);
		result.put("result", 1);
		writeJSON(response, result);
		System.out.println("注册成功");
	}

	/**
	 * 用户登录
	 * 
	 * @Description:
	 * @param userModel
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	public void userlogin(User userModel, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("登录");
		Map<String, Object> result = new HashMap<String, Object>();
		User user = userService.getByProerties("username", userModel.getUsername());
		if (user == null) { // 用户名有误
			result.put("result", -1);
			writeJSON(response, result);
			return;
		}
		if (!user.getPassword().equals(userModel.getPassword())) { // 密码错误
			result.put("result", -2);
			writeJSON(response, result);
			return;
		}
		user.setState("在线");
		userService.merge(user);
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute(SESSION_SYS_USER, user);

		result.put("result", 1);
		writeJSON(response, result);
		System.out.println("登陆成功");
	}

}
