package com.yazao.news.interactor.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.google.gson.reflect.TypeToken;
import com.yazao.news.bean.ImageListDataBean;
import com.yazao.news.interactor.FragmentListInteractor;
import com.yazao.news.lib.util.net.VolleyHelper;
import com.yazao.news.listener.LoadDataCallback;
import com.yazao.news.util.UriHelper;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 15:14
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class FragmentListInteractorImpl implements FragmentListInteractor {

	private LoadDataCallback<ImageListDataBean> mLoadDataListener;

	public FragmentListInteractorImpl(LoadDataCallback<ImageListDataBean> mLoadDataListener) {
		this.mLoadDataListener = mLoadDataListener;
	}

	@Override
	public void getListData(String requestTag, final int event_tag, String keywords, int page) {
		// TODO get data from net
		GsonRequest<ImageListDataBean> request = new GsonRequest<ImageListDataBean>(
				UriHelper.getInstance().getImagesListUrl(keywords, page),
				null,
				new TypeToken<ImageListDataBean>() {
				}.getType(),
				new Response.Listener<ImageListDataBean>() {
					@Override
					public void onResponse(ImageListDataBean response) {
						mLoadDataListener.onSuccess(event_tag, response);
					}
				},
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						mLoadDataListener.onFailed(error.getMessage());
					}
				}
		);
		request.setShouldCache(true);
		request.setTag(requestTag);
		VolleyHelper.getInstance().getRequestQueue().add(request);
	}
}
