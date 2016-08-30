package com.ai.platform.common.api.area.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.platform.common.api.area.interfaces.IGnAreaMaintainSV;
import com.ai.platform.common.api.area.param.GnAreaCondition;
import com.ai.platform.common.api.area.param.GnAreaVo;
import com.ai.platform.common.service.business.area.IGnAreaBusinessService;
import com.ai.platform.common.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class GnAreaMaintainSVImpl implements IGnAreaMaintainSV {
	@Autowired
	private IGnAreaBusinessService iGnAreaBusinessService;
	@Override
	public String addArea(GnAreaVo area) throws BusinessException,SystemException {
		VoValidateUtils.validateAddArea(area);
		return iGnAreaBusinessService.addArea(area);
	}

	@Override
	public void modifyArea(GnAreaVo area) throws BusinessException,SystemException {
		VoValidateUtils.validateModifyArea(area);
		iGnAreaBusinessService.modifyArea(area);
	}

	@Override
	public void deleteArea(GnAreaCondition gnAreaCondition)
			throws BusinessException,SystemException {
		VoValidateUtils.validateDeleteArea(gnAreaCondition);
		iGnAreaBusinessService.deleteArea(gnAreaCondition);
	}

	@Override
	public void deleteAreas(List<GnAreaCondition> gnAreaCondition)
			throws BusinessException,SystemException {
		VoValidateUtils.validateDeleteAreas(gnAreaCondition);
		iGnAreaBusinessService.deleteAreas(gnAreaCondition);

	}

}
