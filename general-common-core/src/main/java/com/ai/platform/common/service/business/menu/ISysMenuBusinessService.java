package com.ai.platform.common.service.business.menu;

import com.ai.platform.common.api.menu.param.SysMenuListQueryRequest;
import com.ai.platform.common.api.menu.param.SysMenuListQueryResponse;

public interface ISysMenuBusinessService {
	SysMenuListQueryResponse queryMenuByUserId(SysMenuListQueryRequest request);

}
