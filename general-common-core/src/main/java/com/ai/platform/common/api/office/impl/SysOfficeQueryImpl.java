package com.ai.platform.common.api.office.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.platform.common.api.office.interfaces.ISysOfficeQuerySV;
import com.ai.platform.common.api.office.param.OfficeAllQueryRequest;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryResponse;
import com.ai.platform.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.platform.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.platform.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeParentListQueryResponse;
import com.ai.platform.common.api.office.param.OfficeVO;
import com.ai.platform.common.constants.ResultCodeConstants;
import com.ai.platform.common.dao.mapper.bo.SysOffice;
import com.ai.platform.common.service.business.office.ISysOfficeBusinessService;
import com.ai.platform.common.util.SystemValidateUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
@Component
public class SysOfficeQueryImpl implements ISysOfficeQuerySV {

	@Autowired
	ISysOfficeBusinessService iSysofficeBusinessService;
	
	@Override
	public OfficeDetailQueryResponse queryOfficeDetail(OfficeDetailQueryRequest queryRequest) throws BusinessException,
			SystemException {
		SystemValidateUtil.validateQueryOfficeDetail(queryRequest);
		SysOffice sysOfficeInfo = iSysofficeBusinessService.queryOfficeDetail(queryRequest);
		OfficeDetailQueryResponse queryResponse = new OfficeDetailQueryResponse();
		if(sysOfficeInfo != null){
			OfficeVO officeVo = new OfficeVO();
			BeanUtils.copyProperties(officeVo,sysOfficeInfo);
			queryResponse.setOfficeVo(officeVo );
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功");
			queryResponse.setResponseHeader(responseHeader);
		}else{
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.NULL_CODE, "无数据");
			queryResponse.setResponseHeader(responseHeader);
		}
		
		return queryResponse;
	}

	@Override
	public OfficeParentListQueryResponse queryParentOfficeList(
			OfficeParentListQueryRequest queryRequest)
			throws BusinessException, SystemException {
		SystemValidateUtil.validateQueryParentOfficeList(queryRequest);
		return iSysofficeBusinessService.queryParentOfficeList(queryRequest);
	}

	@Override
	public OfficeChildrenListQueryResponse queryChildrenOfficeList(
			OfficeChildrenListQueryRequest queryRequest)
			throws BusinessException, SystemException {
		//参数校验
		SystemValidateUtil.validateQueryChildrenOfficeList(queryRequest);
		List<SysOffice> sysOfficeList = iSysofficeBusinessService.queryChildrenOfficeList(queryRequest);
		OfficeChildrenListQueryResponse queryResponse = new OfficeChildrenListQueryResponse();
		if(!CollectionUtil.isEmpty(sysOfficeList)){
			String officeListJson = JSonUtil.toJSon(sysOfficeList);
			Gson gson = new Gson();
			List<OfficeVO> childrenOffices = gson.fromJson(officeListJson, new TypeToken<List<OfficeVO>>(){}.getType());
			queryResponse.setOfficeList(childrenOffices);
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.SUCCESS_CODE, "查询成功");
			queryResponse.setResponseHeader(responseHeader);
		} else {
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.NULL_CODE, "无数据");
			queryResponse.setResponseHeader(responseHeader);
		}
		
		return queryResponse;
	}

	@Override
	public PageInfo<OfficeVO> queryOfficeAll(OfficeAllQueryRequest queryRequest)
			throws BusinessException, SystemException {
		//参数校验
		SystemValidateUtil.validateQueryOfficeAll(queryRequest);
		PageInfo<OfficeVO> pageResult=new PageInfo<OfficeVO>();
		PageInfo<SysOffice> pageInfo = iSysofficeBusinessService.queryOfficeAll(queryRequest);
		pageResult.setCount(pageInfo.getCount());
		pageResult.setPageSize(pageInfo.getPageSize());
		pageResult.setPageNo(pageInfo.getPageNo());
		List<OfficeVO> officeVOList=new ArrayList<OfficeVO>();
		if(pageInfo.getResult()!=null&&!CollectionUtil.isEmpty(pageInfo.getResult())){
			for(SysOffice office:pageInfo.getResult()){
				OfficeVO officeVO=new OfficeVO();
				BeanUtils.copyProperties(officeVO, office);
				officeVOList.add(officeVO);
			}
			pageResult.setResult(officeVOList);
		}
		return pageResult;
	}


}
