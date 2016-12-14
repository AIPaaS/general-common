package com.ai.platform.common.service.atom.office.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.PageInfo;
import com.ai.platform.common.api.office.param.OfficeAllQueryRequest;
import com.ai.platform.common.constants.VOConstants.DeleteFlagConstant;
import com.ai.platform.common.constants.VOConstants.UseableFlagConstant;
import com.ai.platform.common.dao.mapper.bo.SysOffice;
import com.ai.platform.common.dao.mapper.bo.SysOfficeCriteria;
import com.ai.platform.common.dao.mapper.bo.SysOfficeCriteria.Criteria;
import com.ai.platform.common.dao.mapper.factory.MapperFactory;
import com.ai.platform.common.service.atom.office.ISysOfficeAtomService;

@Component
public class SysOfficeAtomService implements ISysOfficeAtomService{

	@Override
	public SysOffice selectSysOfficeInfo(String id, String tenantId) {
		//return MapperFactory.getSysOfficeMapper().selectByPrimaryKey(id);
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andIdEqualTo(id.trim());
		officeCriteria.andTenantIdEqualTo(tenantId.trim());
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		List<SysOffice> sysOfficeList = MapperFactory.getSysOfficeMapper().selectByExample(example);
		if(sysOfficeList != null && sysOfficeList.size()>0){
			return sysOfficeList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<SysOffice> selectSysOfficeList(List<String> ids) {
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andIdIn(ids);
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		return MapperFactory.getSysOfficeMapper().selectByExample(example );
	}

	@Override
	public PageInfo<SysOffice> selectSysOfficeAll(OfficeAllQueryRequest queryRequest) {
		
		PageInfo<SysOffice> pageInfo = new PageInfo<SysOffice>();
		// 数据列表
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andTenantIdEqualTo(queryRequest.getTenantId().trim());
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		int limitStart = (queryRequest.getPageNo() - 1) * queryRequest.getPageSize();
		int limitEnd = queryRequest.getPageSize();
//		example.setLimitStart(limitStart);
//		example.setLimitEnd(limitEnd);
		example.setLimitStart(0);
		example.setLimitEnd(10);
		List<SysOffice> dblist= MapperFactory.getSysOfficeMapper().selectByExample(example);
		// 总记录数
		int totalCount =MapperFactory.getSysOfficeMapper().countByExample(example);
		pageInfo.setCount(totalCount);
		pageInfo.setPageNo(queryRequest.getPageNo());
		pageInfo.setPageSize(queryRequest.getPageSize());
		pageInfo.setResult(dblist);

		return pageInfo;
		
		
		
	}

	@Override
	public List<SysOffice> selectChildrenOfficeList(String id,String tenantId) {
		List<SysOffice> childrenOfficeList = new LinkedList<SysOffice>();
		getChildrenOffices(id, tenantId, childrenOfficeList);
		return childrenOfficeList;
	}
	
	private void getChildrenOffices(String id,String tenantId,List<SysOffice> OfficeList){
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andTenantIdEqualTo(tenantId.trim());
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		officeCriteria.andParentIdEqualTo(id.trim());
		example.setLimitStart(0);
		example.setLimitEnd(5);
		List<SysOffice> selectByExample = MapperFactory.getSysOfficeMapper().selectByExample(example);
		if(selectByExample != null){
			OfficeList.addAll(selectByExample);
			for(SysOffice sysOffice : selectByExample){
				getChildrenOffices(sysOffice.getId(),tenantId,OfficeList);
			}
		}
	}

}
