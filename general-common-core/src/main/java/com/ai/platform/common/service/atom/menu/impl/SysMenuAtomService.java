package com.ai.platform.common.service.atom.menu.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.platform.common.dao.mapper.bo.SysMenu;
import com.ai.platform.common.dao.mapper.factory.MapperFactory;
import com.ai.platform.common.service.atom.menu.ISysMenuAtomService;

@Component
public class SysMenuAtomService implements ISysMenuAtomService{


	@Override
	public List<SysMenu> findByUserId(String userId) {
		return MapperFactory.getSysMenuMapper().findByUserId(userId);
	}
	@Override
	public List<SysMenu> findAll() {
		return MapperFactory.getSysMenuMapper().findAll();
	}

	

}
