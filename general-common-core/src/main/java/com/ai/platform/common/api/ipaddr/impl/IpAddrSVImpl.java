package com.ai.platform.common.api.ipaddr.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.platform.common.api.ipaddr.interfaces.IIpAddrSV;
import com.ai.platform.common.api.ipaddr.param.IpAddr;
import com.ai.platform.common.service.business.ipaddr.IIpAddrBusiSV;
import com.ai.platform.common.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class IpAddrSVImpl implements IIpAddrSV {
	@Autowired
	private IIpAddrBusiSV iIpAddrBusiSV;

	@Override
	public IpAddr getIpAddrByIp(String ip) {
		VoValidateUtils.validateGetIpAddrByIp(ip);
		return iIpAddrBusiSV.getIpAddrByIp(ip);
	}

}
