package com.shengsheng.dao.sys;

import java.util.List;

import com.shengsheng.model.sys.Attachment;

import core.dao.Dao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:58:09
 * <dl>
 * 		<dt>AttachmentDao</dt>
 *		<dd>附件的数据持久层的接口</dd>
 * </dl>
 */
public interface AttachmentDao extends Dao<Attachment> {

	List<Object[]> queryFlowerList(String epcId);

	void deleteAttachmentByForestryTypeId(Long umTypeId);

	List<Object[]> querySensorList();

}
