package com.yazao.news.presenter.impl;

import android.content.Context;

import com.yazao.news.api.GlobalParams;
import com.yazao.news.bean.ImageListBean;
import com.yazao.news.bean.ImageListDataBean;
import com.yazao.news.interactor.FragmentListInteractor;
import com.yazao.news.interactor.impl.FragmentListInteractorImpl;
import com.yazao.news.listener.LoadDataCallback;
import com.yazao.news.presenter.FragmentListPresenter;
import com.yazao.news.view.FragmentListView;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 15:00
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class FragmentListPresenterImpl implements FragmentListPresenter<FragmentListView>,LoadDataCallback<ImageListDataBean> {

	private Context mContext;
	private FragmentListView mView;
	private FragmentListInteractor mInteractor;

	public FragmentListPresenterImpl(Context context,FragmentListView fragmentListView) {
		if (fragmentListView == null){
			throw new IllegalArgumentException("Constructor's parameters must not be Null");
		}
		this.mContext = context;
		this.mView = fragmentListView;
		mInteractor = new FragmentListInteractorImpl(this);
	}

	// Presenter
	@Override
	public void loadListData(String requestTag, int event_tag, String keywords, int page, boolean isSwipeRefresh) {
		mInteractor.getListData(requestTag, event_tag, keywords, page);
	}

	@Override
	public void onItemClickListener(int position, ImageListBean entity, int x, int y, int width, int height) {

	}

	// LoadDataCallback : 获取数据后，回调到这里
	@Override
	public void onSuccess(int event_tag, ImageListDataBean data) {
		if (event_tag == GlobalParams.EVENT_REFRESH_DATA){ //刷新的数据
			mView.refreshListData(data);
		}else if (event_tag == GlobalParams.EVENT_LOAD_MORE_DATA){//加载更多的数据

		}
	}

	@Override
	public void onFailed(String msg) {

	}
}
