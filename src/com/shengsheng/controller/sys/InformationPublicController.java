package com.shengsheng.controller.sys;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shengsheng.core.Constant;
import com.shengsheng.core.JavaEEFrameworkBaseController;
import com.shengsheng.model.sys.Dict;
import com.shengsheng.model.sys.Information;
import com.shengsheng.service.sys.DictService;
import com.shengsheng.service.sys.InformationService;

import core.support.ExtJSBaseParameter;
import core.support.JqGridPageView;
import core.support.QueryResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:52:57
 * <dl>
 * 		<dt>InformationController</dt>
 *		<dd>信息发布的控制层</dd>
 * </dl>
 */
@Controller
@RequestMapping("/static/information")
public class InformationPublicController extends JavaEEFrameworkBaseController<Information> implements Constant {

	@Resource
	private InformationService informationService;
	
	@Resource
	private DictService dictService;

	// 查询信息发布的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getList", method = { RequestMethod.GET })
	public void getList(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("page") Integer page
			, @RequestParam("size") Integer size
			, @RequestParam("type") String type) throws Exception {
		
		type = URLDecoder.decode(type);
		List<Information> list = null;
		Long records = 0L;
		
		if("".equals(type) || "null".equals(type) || null==type) {
			list = informationService.getPage(page, size);
			records = informationService.getCount();
		}
		else {
			Dict typeDict = dictService.getByProerties("dictValue", type);
			if( typeDict != null) {
				list = informationService.getPage(page, size, typeDict);
				records = informationService.getCount(typeDict);
			}			
		}

		JqGridPageView<Information> listView = new JqGridPageView<Information>();
		listView.setMaxResults(size);
		listView.setRows(list);
		listView.setRecords(records);
		writeJSON(response, listView);
	}

	// 删除信息发布
	@RequestMapping("/getDetail")
	public void getInformation(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("id") Long id) throws IOException {
		Information info = informationService.get(id);
		Map<String,Information> map = new HashMap<String,Information>();
		map.put("information", info);
		writeJSON(response, map);
		
	}

}
