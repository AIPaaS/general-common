package com.ai.platform.common.api.cache.param;

import com.ai.opt.base.vo.BaseInfo;

public class AreaNameQueryRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
    private String areaCode;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

}
