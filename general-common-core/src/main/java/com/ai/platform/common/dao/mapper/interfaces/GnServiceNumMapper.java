package com.ai.platform.common.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.platform.common.dao.mapper.bo.GnServiceNum;
import com.ai.platform.common.dao.mapper.bo.GnServiceNumCriteria;

public interface GnServiceNumMapper {
    int countByExample(GnServiceNumCriteria example);

    int deleteByExample(GnServiceNumCriteria example);

    int insert(GnServiceNum record);

    int insertSelective(GnServiceNum record);

    List<GnServiceNum> selectByExample(GnServiceNumCriteria example);

    int updateByExampleSelective(@Param("record") GnServiceNum record, @Param("example") GnServiceNumCriteria example);

    int updateByExample(@Param("record") GnServiceNum record, @Param("example") GnServiceNumCriteria example);
}