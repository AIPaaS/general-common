package com.ai.platform.common.test.office;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.platform.common.api.office.interfaces.ISysOfficeQuerySV;
import com.ai.platform.common.api.office.param.OfficeAllQueryRequest;
import com.ai.platform.common.api.office.param.OfficeAllQueryResponse;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryResponse;
import com.ai.platform.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.platform.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.platform.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeParentListQueryResponse;
import com.ai.platform.common.api.office.param.OfficeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OfficeQueryTest {
	@Autowired
	private ISysOfficeQuerySV sv;

	@Test
	public void queryOfficeDetail(){
		OfficeDetailQueryRequest queryRequest=new OfficeDetailQueryRequest();
		queryRequest.setId("00731bc1847147c5983f73c514c6eada");
		queryRequest.setTenantId("changhong");
		OfficeDetailQueryResponse queryOfficeDetail = sv.queryOfficeDetail(queryRequest);
		System.out.println(JSonUtil.toJSon(queryOfficeDetail));
	}
	@Test
	public void queryChildrenOfficeList(){
		OfficeChildrenListQueryRequest queryRequest=new OfficeChildrenListQueryRequest();
		queryRequest.setId("27e5a124751143d1a04624a2bb716c57");
		queryRequest.setTenantId("changhong");
		OfficeChildrenListQueryResponse queryChildrenOfficeList = sv.queryChildrenOfficeList(queryRequest);
		System.out.println(JSonUtil.toJSon(queryChildrenOfficeList));
		System.out.println(queryChildrenOfficeList.getOfficeList().size());
	}
	@Test
	public void queryParentOfficeList(){
		OfficeParentListQueryRequest queryRequest = new OfficeParentListQueryRequest();
		queryRequest.setId("002c8874b40b4b86b14fb6e706a51069");
		queryRequest.setTenantId("changhong");
		OfficeParentListQueryResponse queryParentOfficeList = sv.queryParentOfficeList(queryRequest);
		System.out.println(JSonUtil.toJSon(queryParentOfficeList));
		System.out.println(queryParentOfficeList.getOfficeList().size());
	}
	@Test
	public void queryOfficeAll(){
		OfficeAllQueryRequest queryRequest = new OfficeAllQueryRequest();
		queryRequest.setTenantId("changhong");
		queryRequest.setPageNo(1);
		queryRequest.setPageSize(10);
		PageInfo<OfficeVO> pageINfo = sv.queryOfficeAll(queryRequest );
		System.out.println(JSonUtil.toJSon(pageINfo));
	}
    
    
}