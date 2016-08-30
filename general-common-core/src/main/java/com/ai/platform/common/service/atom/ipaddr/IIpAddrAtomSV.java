package com.ai.platform.common.service.atom.ipaddr;

import com.ai.platform.common.dao.mapper.bo.GnIpAddr;

public interface IIpAddrAtomSV {
	GnIpAddr getIpAddrByIp(String ip);
}
