package com.shengsheng.service.sys;

import java.util.List;

import com.shengsheng.model.sys.Attachment;

import core.service.Service;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:26:39
 * <dl>
 * 		<dt>AttachmentService</dt>
 *		<dd>附件的业务逻辑层的接口</dd>
 * </dl>
 */
public interface AttachmentService extends Service<Attachment> {

	List<Object[]> queryFlowerList(String epcId);

	void deleteAttachmentByForestryTypeId(Long umTypeId);

	List<Object[]> querySensorList();

}
