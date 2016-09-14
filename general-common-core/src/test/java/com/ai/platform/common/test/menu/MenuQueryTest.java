package com.ai.platform.common.test.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.platform.common.api.menu.interfaces.ISysMenuQuerySV;
import com.ai.platform.common.api.menu.param.SysMenuListQueryRequest;
import com.ai.platform.common.api.menu.param.SysMenuListQueryResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class MenuQueryTest {
	@Autowired
	private ISysMenuQuerySV sv;

	@Test
	public void queryChildrenMenuList(){
		SysMenuListQueryRequest queryRequest=new SysMenuListQueryRequest();
		queryRequest.setUserId("311");;
		queryRequest.setTenantId("changhong");
		SysMenuListQueryResponse queryChildrenMenuList = sv.queryMenuByUserId(queryRequest);
		System.out.println(JSonUtil.toJSon(queryChildrenMenuList));
	}
}