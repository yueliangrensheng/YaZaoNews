package com.yazao.news.presenter.impl;

import android.content.Context;

import com.yazao.news.interactor.YZFragmentInteractor;
import com.yazao.news.interactor.impl.YZFragmentInteractorImpl;
import com.yazao.news.presenter.YZFragmentPresenter;
import com.yazao.news.ui.fragment.YZImageFragment;
import com.yazao.news.ui.fragment.YZNewsFragment;
import com.yazao.news.ui.fragment.YZVideoFragment;
import com.yazao.news.view.YZFragmentView;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 15:44
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class YZFragmentPresenterImpl implements YZFragmentPresenter<YZFragmentView> {

	private Context mContext;
	private YZFragmentView mView;
	private YZFragmentInteractor mInteractor;


	public YZFragmentPresenterImpl(Context context, YZFragmentView fragmentView) {
		if (null == fragmentView) {
			throw new IllegalArgumentException("Constructor's parameters must not be Null");
		}
		this.mContext = context;
		this.mView = fragmentView;
		mInteractor = new YZFragmentInteractorImpl();
	}

	@Override
	public void initialized() {
		int categoryFlag=0;
		if (mView instanceof YZNewsFragment) {
			categoryFlag = 0;
		} else if (mView instanceof YZVideoFragment) {
			categoryFlag = 1;
		} else if (mView instanceof YZImageFragment) {
			categoryFlag = 2;
		}

		mView.initView(mInteractor.getCategoryDatas(mContext, categoryFlag));
	}
}
