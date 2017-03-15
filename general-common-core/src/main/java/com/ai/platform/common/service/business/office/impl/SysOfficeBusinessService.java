package com.ai.platform.common.service.business.office.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.PageInfo;
import com.ai.platform.common.api.office.param.OfficeAllQueryRequest;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.platform.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeParentListQueryResponse;
import com.ai.platform.common.dao.mapper.bo.SysOffice;
import com.ai.platform.common.service.atom.office.ISysOfficeAtomService;
import com.ai.platform.common.service.business.office.ISysOfficeBusinessService;

@Service
@Transactional
public class SysOfficeBusinessService implements ISysOfficeBusinessService{

	@Autowired
	private ISysOfficeAtomService ISysOfficeAtomService;
	
	@Override
	public SysOffice queryOfficeDetail(OfficeDetailQueryRequest queryRequest) {
		SysOffice sysOfficeInfo = ISysOfficeAtomService.selectSysOfficeInfo(queryRequest.getId(),
				queryRequest.getTenantId());
		return sysOfficeInfo;
	}

	@Override
	public OfficeParentListQueryResponse queryParentOfficeList(OfficeParentListQueryRequest queryRequest) {
		return null;
	}

	@Override
	public List<SysOffice> queryChildrenOfficeList(
			OfficeChildrenListQueryRequest queryRequest) {
		List<SysOffice> sysOfficeList = ISysOfficeAtomService.selectChildrenOfficeList(queryRequest.getId(),
				queryRequest.getTenantId());
		return sysOfficeList;
	}

	@Override
	public PageInfo<SysOffice> queryOfficeAll(OfficeAllQueryRequest queryRequest) {
		return ISysOfficeAtomService.selectSysOfficeAll(queryRequest);
		
	}
}
