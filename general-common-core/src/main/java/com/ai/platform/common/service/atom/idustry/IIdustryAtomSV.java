package com.ai.platform.common.service.atom.idustry;

import java.util.List;

import com.ai.platform.common.dao.mapper.bo.GnIndustry;
import com.ai.platform.common.dao.mapper.bo.GnIndustryCriteria;

public interface IIdustryAtomSV {

    List<GnIndustry> selectByExample(GnIndustryCriteria example);

    GnIndustry selectByPrimaryKey(String industryCode);
}
