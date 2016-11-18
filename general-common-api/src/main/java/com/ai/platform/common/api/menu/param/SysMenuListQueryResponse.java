package com.ai.platform.common.api.menu.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class SysMenuListQueryResponse extends BaseResponse{

	private static final long serialVersionUID = 1L;

	private List<String> menuList;
	private List<String> allMenuList;

	public List<String> getAllMenuList() {
		return allMenuList;
	}

	public void setAllMenuList(List<String> allMenuList) {
		this.allMenuList = allMenuList;
	}

	public List<String> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<String> menuList) {
		this.menuList = menuList;
	}
	

}
