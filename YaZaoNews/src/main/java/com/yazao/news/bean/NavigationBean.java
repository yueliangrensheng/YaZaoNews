package com.yazao.news.bean;

/**
 * Author:  MoonLife
 * Time: 2015/12/16 19:10
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class NavigationBean extends BaseBean {

	private int iconResID;

	public NavigationBean(String id, String name, int iconResID) {
		super(id, name);
		this.iconResID = iconResID;
	}

	public int getIconResID() {
		return iconResID;
	}

	public void setIconResID(int iconResID) {
		this.iconResID = iconResID;
	}
}
