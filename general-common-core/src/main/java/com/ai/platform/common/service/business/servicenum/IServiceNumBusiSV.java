package com.ai.platform.common.service.business.servicenum;

import com.ai.platform.common.api.servicenum.param.ServiceNum;

public interface IServiceNumBusiSV {
	ServiceNum getServiceNumByPhone(String phone);
}
