package com.shengsheng.model.sys.param;

import core.support.ExtJSBaseParameter;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 09:01:53
 * <dl>
 * 		<dt>AttachmentParameter</dt>
 *		<dd>附件的参数类</dd>
 * </dl>
 */
public class AttachmentParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = -1946385245181503185L;
	private String description;
	private String epcId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEpcId() {
		return epcId;
	}

	public void setEpcId(String epcId) {
		this.epcId = epcId;
	}

}
