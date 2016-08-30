package com.ai.platform.common.cache;

import java.util.List;

import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.platform.common.constants.CacheNSMapper;
import com.ai.platform.common.dao.mapper.bo.GnArea;
import com.ai.platform.common.util.CacheFactoryUtil;
import com.alibaba.fastjson.JSON;

public class GnAreaCacheTread extends Thread{
    private List<GnArea> resultList;
    ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
    
    public GnAreaCacheTread(List<GnArea> resultList){
        this.resultList=resultList;
    }
    @Override
    public void run() {
        for (GnArea area : resultList) {          
            String key=area.getAreaCode().toUpperCase();
            cacheClient.hset(CacheNSMapper.CACHE_GN_AREA, key, JSON.toJSONString(area));
        } 
        //System.out.println("【"+Thread.currentThread().getName()+"】");
    } 
}
