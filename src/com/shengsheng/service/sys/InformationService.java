package com.shengsheng.service.sys;

import java.util.List;

import com.shengsheng.model.sys.Dict;
import com.shengsheng.model.sys.Information;

import core.service.Service;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:27:23
 * <dl>
 * 		<dt>InformationService</dt>
 *		<dd>信息发布的业务逻辑层的接口</dd>
 * </dl>
 */
public interface InformationService extends Service<Information> {

	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>获取信息，包括内容的HTML和过滤HTML两部分</dd>
	 * </dl>
	 * @param resultList
	 * @return
	 */
	List<Information> queryInformationHTMLList(List<Information> resultList);

	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>生成信息的索引</dd>
	 * </dl>
	 */
	void indexingInformation();

	// 全文检索信息
	List<Information> queryByInformationName(String name);
	
	List<Information> getPage(Integer page,Integer size);
	
	List<Information> getPage(Integer page,Integer size,Dict type);
	
	Long getCount();
	
	Long getCount(Dict type);


}
