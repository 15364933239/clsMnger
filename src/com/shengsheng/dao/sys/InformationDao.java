package com.shengsheng.dao.sys;

import java.util.List;

import com.shengsheng.model.sys.Dict;
import com.shengsheng.model.sys.Information;

import core.dao.Dao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:59:21
 * <dl>
 * 		<dt>InformationDao</dt>
 *		<dd>信息发布的数据持久层的接口</dd>
 * </dl>
 */
public interface InformationDao extends Dao<Information> {

	// 生成信息的索引
	void indexingInformation();

	// 全文检索信息
	List<Information> queryByInformationName(String name);
	
	List<Information> getPage(Integer page,Integer size);
	
	Long getCount();
	
	List<Information> getPage(Integer page,Integer size,Dict type);
	
	Long getCount(Dict type);
	
	

}
