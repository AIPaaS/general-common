package com.ai.platform.common.api.menu.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.platform.common.api.menu.param.SysMenuListQueryRequest;
import com.ai.platform.common.api.menu.param.SysMenuListQueryResponse;

@Path("/menuservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ISysMenuQuerySV {
	/**
	 * 查询用户菜单权限
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhouxh
	 * @ApiCode	PLAT_100
	 * @ApiDocMethod
	 * @RestRelativeURL menuservice/queryMenuByUserId
	 */
	@POST
	@Path("/queryMenuByUserId")
	SysMenuListQueryResponse queryMenuByUserId(SysMenuListQueryRequest request)throws BusinessException,SystemException;
}
