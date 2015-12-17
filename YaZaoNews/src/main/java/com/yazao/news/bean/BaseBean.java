package com.yazao.news.bean;

/**
 * Author:  MoonLife
 * Time: 2015/12/16 19:10
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class BaseBean {
	private String id;
	private String name;

	public BaseBean(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
