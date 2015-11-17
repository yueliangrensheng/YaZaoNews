package com.yazao.news.presenter.impl;

import com.yazao.news.interactor.YZMainInteractor;
import com.yazao.news.interactor.impl.YZMainInteractorImpl;
import com.yazao.news.presenter.YZMainPresenter;
import com.yazao.news.view.YZMainView;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public class YZMainPresenterImpl implements YZMainPresenter {

	private  YZMainView mMainView;
	private YZMainInteractor interactor;

	public YZMainPresenterImpl(YZMainView mainView) {
		this.mMainView=mainView;
		interactor =new YZMainInteractorImpl();
	}

	@Override
	public void initialized() {

	}
}
