package com.ai.platform.common.service.atom.menu;

import java.util.List;

import com.ai.platform.common.dao.mapper.bo.SysMenu;

public interface ISysMenuAtomService {
	
	 List<SysMenu> findByUserId(String userId);
	 List<SysMenu> findAll();
}
