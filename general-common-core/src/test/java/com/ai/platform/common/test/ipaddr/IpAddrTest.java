package com.ai.platform.common.test.ipaddr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.platform.common.api.ipaddr.interfaces.IIpAddrSV;
import com.ai.platform.common.api.ipaddr.param.IpAddr;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class IpAddrTest {
	@Autowired
	private IIpAddrSV sv;

	@Test
	public void testGetIpAddr(){
		String ip="202.85.218.99";
		IpAddr result=sv.getIpAddrByIp(ip);
		System.out.println("result="+JSON.toJSONString(result));
	}
    
    
}