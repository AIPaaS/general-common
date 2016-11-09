package com.ai.platform.common.api.office.param;

import com.ai.opt.base.vo.BaseInfo;

public class OfficeAllQueryRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	/**
     * 当前第几页,必填
     */
    private Integer pageNo;

    /**
     * 每页数据条数,必填
     */
    private Integer pageSize;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	


}
