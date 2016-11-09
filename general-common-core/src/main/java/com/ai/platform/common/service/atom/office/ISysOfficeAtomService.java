package com.ai.platform.common.service.atom.office;

import java.util.List;

import com.ai.opt.base.vo.PageInfo;
import com.ai.platform.common.api.office.param.OfficeAllQueryRequest;
import com.ai.platform.common.dao.mapper.bo.SysOffice;

public interface ISysOfficeAtomService {
	
	SysOffice selectSysOfficeInfo(String id, String tenantId);
	
	/**
	 * 查询当前租户所有机构数据
	 * @param tenantId
	 * @return
	 */
	PageInfo<SysOffice> selectSysOfficeAll(OfficeAllQueryRequest queryRequest);
	
	/**
	 * 获取当前id及所有上级节点
	 * @param ids
	 * @return
	 */
	List<SysOffice> selectSysOfficeList(List<String> ids);
	
	/**
	 * 查询当前id及所有子集几点对象集合
	 * @param id
	 * @return
	 */
	List<SysOffice> selectChildrenOfficeList(String id, String tenantId);
	
}
