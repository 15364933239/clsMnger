package com.shengsheng.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.sys.InformationDao;
import com.shengsheng.model.sys.Dict;
import com.shengsheng.model.sys.Information;
import com.shengsheng.service.sys.InformationService;

import core.service.BaseService;
import core.util.HtmlUtils;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:25:30
 * <dl>
 * 		<dt>InformationServiceImpl</dt>
 *		<dd>信息发布的业务逻辑层的实现</dd>
 * </dl>
 */
@Service
public class InformationServiceImpl extends BaseService<Information> implements InformationService {

	private InformationDao informationDao;

	@Resource
	public void setInformationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
		this.dao = informationDao;
	}

	// 获取信息，包括内容的HTML和过滤HTML两部分

	public List<Information> queryInformationHTMLList(List<Information> resultList) {
		List<Information> informationList = new ArrayList<Information>();
		for (Information entity : resultList) {
			Information information = new Information();
			information.setId(entity.getId());
			information.setTitle(entity.getTitle());
			information.setAuthor(entity.getAuthor());
			information.setRefreshTime(entity.getRefreshTime());
			information.setContent(entity.getContent());
			information.setContentNoHTML(HtmlUtils.htmltoText(entity.getContent()));
			information.setType(entity.getType());
			informationList.add(information);
		}
		return informationList;
	}

	// 生成信息的索引

	public void indexingInformation() {
		informationDao.indexingInformation();
	}

	// 全文检索信息

	public List<Information> queryByInformationName(String name) {
		return informationDao.queryByInformationName(name);
	}

	@Override
	public List<Information> getPage(Integer page, Integer size) {
		List<Information> list = informationDao.getPage(page, size);
		List<Information> newList = new ArrayList<>();
		for(Information item : list) {
			Information newItem = new Information();
			newItem.setTitle(item.getTitle());
			newItem.setPublishTime(item.getPublishTime());
			newItem.setType(item.getType());
			newItem.setId(item.getId());
			newList.add(newItem);
		}
		return newList;
	}

	@Override
	public List<Information> getPage(Integer page, Integer size, Dict type) {
		List<Information> list = informationDao.getPage(page, size, type);
		List<Information> newList = new ArrayList<>();
		for(Information item : list) {
			Information newItem = new Information();
			newItem.setTitle(item.getTitle());
			newItem.setPublishTime(item.getPublishTime());
			newItem.setType(item.getType());
			newItem.setId(item.getId());
			newList.add(newItem);
		}
		return newList;
	}

	@Override
	public Long getCount() {
		
		return informationDao.getCount();
	}

	@Override
	public Long getCount(Dict type) {
		// TODO Auto-generated method stub
		return informationDao.getCount(type);
	}

}
