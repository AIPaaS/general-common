package com.ai.platform.common.service.business.sysuser;

import java.util.List;

import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeResponse;
import com.ai.platform.common.dao.mapper.bo.SysUser;


public interface ISysUserBusiSV {
	
	SysUser queryUser(SysUserQueryRequest request);
	
	SysUserThemeResponse queryUserTheme(SysUserThemeRequest requst);
	
	List<SysUser> queryUserByOfficeId(SysUserListQueryRequest request);
}
