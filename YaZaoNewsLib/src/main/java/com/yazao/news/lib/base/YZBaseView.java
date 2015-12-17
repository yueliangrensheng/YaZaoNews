package com.yazao.news.lib.base;

/**
 * Author:  MoonLife
 * Time: 2015/12/16 15:20
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface YZBaseView {

	/**
	 * show loading message
	 *
	 * @param msg
	 */
	void showLoading(String msg);

	/**
	 * hide loading
	 */
	void hideLoading();

	/**
	 * show error message
	 */
	void showError(String msg);

	/**
	 * show exception message
	 */
	void showException(String msg);

	/**
	 * show net error
	 */
	void showNetError();
}
