package com.yazao.news.presenter.impl;

import android.app.Activity;

import com.yazao.news.interactor.MainInteractor;
import com.yazao.news.interactor.impl.MainInteractorImpl;
import com.yazao.news.presenter.MainPresenter;
import com.yazao.news.view.MainView;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public class MainPresenterImpl implements MainPresenter<MainView> {

	private Activity mContext;
	private MainView mView;
	private MainInteractor mInteractor;

	public MainPresenterImpl(Activity context, MainView mainView) {
		if (null == mainView) {
			throw new IllegalArgumentException("Constructor's parameters must not be Null");
		}

		this.mContext = context;
		this.mView = mainView;
		mInteractor = new MainInteractorImpl();
	}

	@Override
	public void initialized() {
		mView.initMainView(mInteractor.getCategoryFragments(), mInteractor.getNavigationData(mContext));
	}
}
