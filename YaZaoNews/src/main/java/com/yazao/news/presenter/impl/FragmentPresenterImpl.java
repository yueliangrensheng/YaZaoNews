package com.yazao.news.presenter.impl;

import android.content.Context;

import com.yazao.news.interactor.FragmentInteractor;
import com.yazao.news.interactor.impl.FragmentInteractorImpl;
import com.yazao.news.presenter.FragmentPresenter;
import com.yazao.news.ui.fragment.ImageFragment;
import com.yazao.news.ui.fragment.NewsFragment;
import com.yazao.news.ui.fragment.VideoFragment;
import com.yazao.news.view.FragmentView;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 15:44
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class FragmentPresenterImpl implements FragmentPresenter<FragmentView> {

	private Context mContext;
	private FragmentView mView;
	private FragmentInteractor mInteractor;


	public FragmentPresenterImpl(Context context, FragmentView fragmentView) {
		if (null == fragmentView) {
			throw new IllegalArgumentException("Constructor's parameters must not be Null");
		}
		this.mContext = context;
		this.mView = fragmentView;
		mInteractor = new FragmentInteractorImpl();
	}

	@Override
	public void initialized() {
		int categoryFlag=0;
		if (mView instanceof NewsFragment) {
			categoryFlag = 0;
		} else if (mView instanceof VideoFragment) {
			categoryFlag = 1;
		} else if (mView instanceof ImageFragment) {
			categoryFlag = 2;
		}

		mView.initView(mInteractor.getCategoryDatas(mContext, categoryFlag));
	}
}
