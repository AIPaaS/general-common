package com.ai.platform.common.test.area;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.PageInfo;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.platform.common.api.area.interfaces.IGnAreaQuerySV;
import com.ai.platform.common.api.area.param.GnAreaPageCondition;
import com.ai.platform.common.api.area.param.GnAreaVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class AreaQueryTest {
	@Autowired
	private IGnAreaQuerySV sv;

	
	@Test
	public void queryAreaAll(){
		
		GnAreaPageCondition queryRequest = new GnAreaPageCondition();
		queryRequest.setTenantId("changhong");
		queryRequest.setPageNo(1);
		queryRequest.setPageSize(5);
		PageInfo<GnAreaVo> pageINfo = sv.getNationList(queryRequest );
		System.out.println(JSonUtil.toJSon(pageINfo));
	}
    
    
}