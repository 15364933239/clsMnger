package com.shengsheng.controller.wl509;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shengsheng.core.Constant;
import com.shengsheng.core.JavaEEFrameworkBaseController;
import com.shengsheng.model.wl509.Device;
import com.shengsheng.model.wl509.Record;
import com.shengsheng.model.wl509.User;
import com.shengsheng.service.wl509.DeviceService;
import com.shengsheng.service.wl509.RecordService;
import com.shengsheng.service.wl509.UserService;

import core.support.JqGridPageView;
import core.support.QueryResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月31日 上午9:24:15
 * <dl>
 * 		<dd>RecodController</dd>
 * 		<dt>记录控制层</dt>
 * </dl>
 */
@Controller
@RequestMapping("/static/record")
public class RecordController extends JavaEEFrameworkBaseController<Record> implements Constant {

    
    private List<Device> nowDevices;
    @Resource
    private RecordService recordService;
    
    @Resource
    private DeviceService deviceService;
    
    @Resource
    private UserService userService;
    
    /**
     * getDevices
     * @Description: 查询记录的表格，包括分页、搜索和排序
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/getDevices", method = { RequestMethod.POST, RequestMethod.GET })
    public void getuser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer firstResult = Integer.valueOf(request.getParameter("page"));
        Integer maxResults = Integer.valueOf(request.getParameter("rows"));
        String sortedObject = request.getParameter("sidx");
        String sortedValue = request.getParameter("sord");
        String filters = request.getParameter("filters");
        Record record = new Record();
        if (StringUtils.isNotBlank(filters)) {
            JSONObject jsonObject = JSONObject.fromObject(filters);
            JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject result = (JSONObject) jsonArray.get(i);
                if (result.getString("field").equals("number") && result.getString("op").equals("eq")) {
                    record.set$eq_device((Device)result.get("device"));
                }
                if (result.getString("field").equals("userValue") && result.getString("op").equals("cn")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    record.set$like_time(sdf.parse(result.getString("time")));
                }
            }
            if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
                record.setFlag("OR");
            } else {
                record.setFlag("AND");
            }
        }
        record.setFirstResult((firstResult - 1) * maxResults);
        record.setMaxResults(maxResults);
        
        Map<String, String> sortedCondition = new HashMap<String, String>();
        sortedCondition.put(sortedObject, sortedValue);
        record.setSortedConditions(sortedCondition);
        
        QueryResult<Record> queryResult = recordService.doPaginationQuery(record);
        JqGridPageView<Record> userListView = new JqGridPageView<Record>();
        userListView.setMaxResults(maxResults);
        
        List<Record> userWithSubList = recordService.queryUserWithSubList(queryResult.getResultList());
        userListView.setRows(userWithSubList);
        userListView.setRecords(queryResult.getTotalCount());
        writeJSON(response, userListView);
    }
    
    
    
    /**
     * getAllServices
     * @Description: 得到所有的设备
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/getAllServices", method = { RequestMethod.POST, RequestMethod.GET })
    public void getAllServices(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Device> devicelist = deviceService.doQueryAll();
        Map<String, List<Device>> result = new HashMap<String, List<Device>>();
        result.put("devices", devicelist);
        writeJSON(response, result);
        return;
    }
    /**
     * getDevicesById
     * @Description:通过user的id查找user已经绑定的设备
     * @param request
     * @param response
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/getDevicesById", method = { RequestMethod.POST, RequestMethod.GET })
    public void getDevicesById(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("id") Integer id) throws Exception {
        User user = userService.get(id);
        User user1 = userService.get(1);
        List<Device> devices1 = user1.getDevices();
        List<Device> devices = user.getDevices();
        System.out.println(devices1.toString());
        Map<String, List<Device>> result = new HashMap<String, List<Device>>();
        result.put("devices", devices);
        writeJSON(response, result);
        return;
    }
    
    /**
     * getDevicesByIsBound
     * @Description: 得到未绑定的设备集合发送到wl509user.jsp
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/getDevicesByIsBound", method = { RequestMethod.POST, RequestMethod.GET })
    public void getDevicesByIsBound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Device> allDevice = deviceService.doQueryAll();
        List<Device> notBoundDevice = new ArrayList<Device>();
        for (Device device : allDevice) {
            if(!device.isBound()) {
                notBoundDevice.add(device);
            }
        }
        Map<String, List<Device>> result = new HashMap<String, List<Device>>();
        result.put("notBoundDevice", notBoundDevice);
        writeJSON(response, result);
        return;
    }
    
    /**
     * delDevicesRequest
     * @Description: 处理解除设备绑定请求
     * @param request
     * @param response
     * @param deviceDel
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delDevicesRequest", method = { RequestMethod.POST, RequestMethod.GET })
    public void delDevicesRequest(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("device") String deviceDel,@RequestParam("id") Integer id) throws Exception {
        
        //通过添加的设备名寻找设备
        Device device = deviceService.getByProerties("name", deviceDel);
        if(device == null) {
            device = deviceService.getByProerties("mac", deviceDel);
        }
        //通过id查找要解除绑定的user
        User user = userService.get(id);
        
        //将要解除关系的设备设为未绑定状态
        for(int i = 0; i < user.getDevices().size(); i++) {
            if(user.getDevices().get(i).getMac() == device.getMac()) {
                user.getDevices().get(i).setBound(false);
                user.getDevices().get(i).setUser(null);
            }
        }
        //移出要解除的设备
        user.getDevices().remove(device);
        //存到数据库
        userService.merge(user);
        //发送服务器端数据
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "解除绑定成功");
        return;
    }
    
    /**
     * delDevicesRequest
     * @Description: 处理设备绑定请求
     * @param request
     * @param response
     * @param deviceAdd
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/addDevicesRequest", method = { RequestMethod.POST, RequestMethod.GET })
    public void addDevicesRequest(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("device") String deviceAdd,@RequestParam("id") Integer id) throws Exception {
        
        List<Device> boundDevice = new ArrayList<Device>();
        //通过添加的设备名寻找设备
        Device device = deviceService.getByProerties("name", deviceAdd);
        if(device == null) {
            device = deviceService.getByProerties("mac", deviceAdd);
        }
        boundDevice.add(device);
        //通过id查找要绑定的user
        User user = userService.get(id);
        //添加已经有的设备集合
        for (Device device2 : user.getDevices()) {
            boundDevice.add(device2);
        }
        //将device的绑定值设为true
        device.setBound(true);
        //将device的user属性更新
        device.setUser(user);
        //存到数据
        deviceService.update(device);
        //发送服务器端数据
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "绑定设备成功");
        writeJSON(response, result);
        return;
    }
}
