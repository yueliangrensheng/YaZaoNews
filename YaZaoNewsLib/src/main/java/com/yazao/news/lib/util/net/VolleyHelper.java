package com.yazao.news.lib.util.net;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Author:  MoonLife
 * Time: 2015/12/15 11:45
 * Email: shaopingzhai@gmail.com
 * Weibo: <a href="http://weibo.com/zsp21">新浪微博</a>
 */
public class VolleyHelper {

	private static volatile VolleyHelper instance = null;

	private VolleyHelper() {
	}

	public static VolleyHelper getInstance() {
		if (null == instance) {
			synchronized (VolleyHelper.class) {
				if (null == instance) {
					instance = new VolleyHelper();
				}
			}
		}
		return instance;
	}

	/**
	 * 请求队列
	 */
	private RequestQueue requestQueue = null;

	/**
	 * init volley helper
	 *
	 * @param context
	 */
	public void init(Context context) {
		requestQueue = Volley.newRequestQueue(context);
	}

	/**
	 * get request queue
	 *
	 * @return
	 */
	public RequestQueue getRequestQueue() {
		if (null != requestQueue) {
			return requestQueue;
		} else {
			throw new IllegalArgumentException("RequestQueue is not initialized.");
		}
	}
}
