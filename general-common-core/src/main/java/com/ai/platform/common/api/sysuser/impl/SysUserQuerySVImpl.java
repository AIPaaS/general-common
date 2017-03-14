package com.ai.platform.common.api.sysuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.platform.common.api.sysuser.interfaces.ISysUserQuerySV;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeResponse;
import com.ai.platform.common.api.sysuser.param.SysUserVO;
import com.ai.platform.common.constants.ResultCodeConstants;
import com.ai.platform.common.dao.mapper.bo.SysUser;
import com.ai.platform.common.service.business.sysuser.ISysUserBusiSV;
import com.ai.platform.common.util.SystemValidateUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
@Component
public class SysUserQuerySVImpl implements ISysUserQuerySV {
	@Autowired
	private ISysUserBusiSV iSysUserBusiSV;

	/**
	 * 查詢用戶信息
	 */
	public SysUserQueryResponse queryUserInfo(SysUserQueryRequest request)
			throws BusinessException, SystemException {
		SysUserQueryResponse  response;
		// 参数校验
		SystemValidateUtil.validateQueryUserInfo(request);
		SysUser user = iSysUserBusiSV.queryUser(request);
		if(user!=null){
			response =new SysUserQueryResponse();
			BeanUtils.copyProperties(response, user);
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.SUCCESS_CODE);
		    responseHeader.setResultMessage("查询成功");
		    response.setResponseHeader(responseHeader);
		}else{
			response =new SysUserQueryResponse();
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.NULL_CODE);
		    responseHeader.setResultMessage("无数据");
		    response.setResponseHeader(responseHeader);
		}
		return response;
	}

	/**
	 * 查詢用戶主題
	 */

	@Override
	public SysUserThemeResponse queryUserTheme(SysUserThemeRequest request) {
		// 参数校验
		SystemValidateUtil.validateQueryUserTheme(request);
		return iSysUserBusiSV.queryUserTheme(request);
	}

	@Override
	public SysUserListQueryResponse queryUserByOfficeId(SysUserListQueryRequest request)
			throws BusinessException,SystemException {
		SysUserListQueryResponse  response;
		// 参数校验
		SystemValidateUtil.validateQueryUserByOfficeId(request);
		List<SysUser> list = iSysUserBusiSV.queryUserByOfficeId(request);
		if(!CollectionUtil.isEmpty(list)){
			response = new SysUserListQueryResponse();
			String sysuserListJson = JSonUtil.toJSon(list);
			Gson gson = new Gson();
			List<SysUserVO> useres = gson.fromJson(sysuserListJson, new TypeToken<List<SysUserVO>>(){}.getType());
			response.setSysUserList(useres);
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.SUCCESS_CODE, "查询成功");
			response.setResponseHeader(responseHeader);
		}else{
			response = new SysUserListQueryResponse();
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.NULL_CODE, "无数据");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}
}
