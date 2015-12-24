package com.yazao.news.presenter.impl;

import android.app.Activity;

import com.yazao.news.interactor.YZMainInteractor;
import com.yazao.news.interactor.impl.YZMainInteractorImpl;
import com.yazao.news.presenter.YZMainPresenter;
import com.yazao.news.view.YZMainView;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public class YZMainPresenterImpl implements YZMainPresenter<YZMainView> {

	private Activity mContext;
	private YZMainView mView;
	private YZMainInteractor mInteractor;

	public YZMainPresenterImpl(Activity context, YZMainView mainView) {
		if (null == mainView) {
			throw new IllegalArgumentException("Constructor's parameters must not be Null");
		}

		this.mContext = context;
		this.mView = mainView;
		mInteractor = new YZMainInteractorImpl();
	}

	@Override
	public void initialized() {
		mView.initMainView(mInteractor.getCategoryFragments(), mInteractor.getNavigationData(mContext));
	}
}
