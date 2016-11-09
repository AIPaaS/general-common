package com.ai.platform.common.api.office.param;

import com.ai.opt.base.vo.BaseInfo;

public class OfficeAllQueryRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	private int limitStart;
	private int limitEnd;
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public int getLimitEnd() {
		return limitEnd;
	}
	public void setLimitEnd(int limitEnd) {
		this.limitEnd = limitEnd;
	}
	


}
