package com.ai.platform.common.service.atom.tenant.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.platform.common.dao.mapper.bo.GnTenant;
import com.ai.platform.common.dao.mapper.factory.MapperFactory;
import com.ai.platform.common.service.atom.tenant.IGnTenantAtomService;

@Component
public class GnTenantAtomServiceImpl implements IGnTenantAtomService {

    @Override
    public GnTenant selectTenantById(String tenantId) {
        return MapperFactory.getGnTenantMapper().selectByPrimaryKey(tenantId);
    }

	@Override
	public List<GnTenant> selectAllTenant() throws BusinessException,SystemException {
		return MapperFactory.getGnTenantMapper().selectByExample(null);
	}
}
