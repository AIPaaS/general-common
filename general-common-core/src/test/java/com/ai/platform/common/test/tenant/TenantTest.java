package com.ai.platform.common.test.tenant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.platform.common.api.tenant.interfaces.IGnTenantQuerySV;
import com.ai.platform.common.api.tenant.param.GnTenantConditon;
import com.ai.platform.common.api.tenant.param.GnTenantVo;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class TenantTest {
    
    @Autowired
    private IGnTenantQuerySV sv;
    
    @Test
    public void tenantListTest(){
        System.out.println("result="+JSON.toJSONString(sv.getTenants()));
    }

    @Test
    public void tenantTest(){
    	GnTenantConditon cond=new GnTenantConditon();
    	cond.setTenantId("changhong");
        GnTenantVo result= sv.getTenant(cond);
        System.out.println("param="+JSON.toJSONString(cond));
        System.out.println("result="+JSON.toJSONString(result));
    }
}
