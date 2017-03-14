package com.ai.platform.common.service.business.sysuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeResponse;
import com.ai.platform.common.constants.ResultCodeConstants;
import com.ai.platform.common.dao.mapper.bo.SysUser;
import com.ai.platform.common.service.atom.sysuser.ISysUserAtomSV;
import com.ai.platform.common.service.business.sysuser.ISysUserBusiSV;
@Service
@Transactional
public class SysUserBusiSVImpl implements ISysUserBusiSV {   
	@Autowired
	ISysUserAtomSV iSysUserAtomSV;
	@Override
	public SysUser queryUser(SysUserQueryRequest request) {
		SysUser userRequest = new SysUser();
	    BeanUtils.copyProperties(userRequest, request);
		SysUser user=iSysUserAtomSV.queryUser(userRequest);
		/*try {
			Thread.sleep(35);
		} catch (InterruptedException e) {
		}*/
		return user;
	}

	@Override
	public SysUserThemeResponse queryUserTheme(SysUserThemeRequest request) {
		String theme = iSysUserAtomSV.queryUserTheme(request.getId(),request.getTenantId());
		SysUserThemeResponse response;
		if(!StringUtil.isBlank(theme)){
			response =new SysUserThemeResponse();
			response.setTheme(theme);
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.SUCCESS_CODE);
		    responseHeader.setResultMessage("查询成功");
		    response.setResponseHeader(responseHeader);
		}else{
			response =new SysUserThemeResponse();
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.NULL_CODE);
		    responseHeader.setResultMessage("无数据");
		    response.setResponseHeader(responseHeader);
		}
		return response;
	}

	@Override
	public List<SysUser> queryUserByOfficeId(SysUserListQueryRequest request) {
		List<SysUser> list = iSysUserAtomSV.selectSysUserByOfficeId(request.getTenantId(), 
				request.getOfficeId());
		return list;
	}

}
