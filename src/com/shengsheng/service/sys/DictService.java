package com.shengsheng.service.sys;

import java.util.List;

import com.shengsheng.model.sys.Dict;

import core.service.Service;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:27:13
 * <dl>
 * 		<dt>DictService</dt>
 *		<dd>字典的业务逻辑层的接口</dd>
 * </dl>
 */
public interface DictService extends Service<Dict> {

	List<Dict> queryDictWithSubList(List<Dict> resultList);

}
