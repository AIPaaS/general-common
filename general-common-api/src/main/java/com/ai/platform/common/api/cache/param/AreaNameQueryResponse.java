package com.ai.platform.common.api.cache.param;

import com.ai.opt.base.vo.BaseResponse;

public class AreaNameQueryResponse extends BaseResponse{

	private static final long serialVersionUID = 1L;
	
	private String areaName;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
