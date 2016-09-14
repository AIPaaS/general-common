package com.ai.platform.common.api.menu.param;

import com.ai.opt.base.vo.BaseInfo;

public class SysMenuListQueryRequest extends BaseInfo{
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID，必填
	 */
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	

}
