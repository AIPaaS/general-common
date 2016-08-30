package com.ai.platform.common.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.platform.common.dao.mapper.bo.GnIpAddr;
import com.ai.platform.common.dao.mapper.bo.GnIpAddrCriteria;

public interface GnIpAddrMapper {
    int countByExample(GnIpAddrCriteria example);

    int deleteByExample(GnIpAddrCriteria example);

    int insert(GnIpAddr record);

    int insertSelective(GnIpAddr record);

    List<GnIpAddr> selectByExample(GnIpAddrCriteria example);

    int updateByExampleSelective(@Param("record") GnIpAddr record, @Param("example") GnIpAddrCriteria example);

    int updateByExample(@Param("record") GnIpAddr record, @Param("example") GnIpAddrCriteria example);
}