package com.yazao.news.listener;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 21:38
 * Email: shaopingzhai@gmail.com
 * Descripton: 获取数据回调接口
 */
public interface LoadDataCallback<YZ> {
	/**
	 * 数据获取成功时回调该方法
	 * @param event_tag
	 * @param data
	 */
	void onSuccess(int event_tag,YZ data);

	/**
	 * 获取数据失败时回调该方法
	 * @param msg
	 */
	void onFailed(String msg);

}
