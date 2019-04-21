package com.shengsheng.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.sys.DictDao;
import com.shengsheng.model.sys.Dict;
import com.shengsheng.service.sys.DictService;

import core.service.BaseService;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:25:18
 * <dl>
 * 		<dt>DictServiceImpl</dt>
 *		<dd>字典的业务逻辑层的实现</dd>
 * </dl>
 */
@Service
public class DictServiceImpl extends BaseService<Dict> implements DictService {

	private DictDao dictDao;

	@Resource
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
		this.dao = dictDao;
	}

	public List<Dict> queryDictWithSubList(List<Dict> resultList) {
		List<Dict> dictList = new ArrayList<Dict>();
		for (Dict entity : resultList) {
			Dict dict = new Dict();
			dict.setId(entity.getId());
			dict.setDictKey(entity.getDictKey());
			dict.setDictValue(entity.getDictValue());
			dict.setSequence(entity.getSequence());
			dict.setParentDictkey(entity.getParentDictkey());
			dictList.add(dict);
		}
		return dictList;
	}

}
