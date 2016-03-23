package com.yazao.news.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.yazao.news.R;
import com.yazao.news.api.GlobalParams;
import com.yazao.news.presenter.impl.FragmentPresenterImpl;
import com.yazao.news.ui.adapter.FragmentMainAdapter;
import com.yazao.news.view.FragmentView;
import com.yazao.news.widget.XViewPager;

import java.util.List;

import butterknife.Bind;

/**
 * 每个新闻页面展示的内容
 * Created by shaopingzhai on 15/11/17.
 */
public class NewsFragment extends BaseFragment<FragmentPresenterImpl> implements FragmentView {
	@Bind(R.id.tablayout)
	TabLayout tablayout;

	@Bind(R.id.fragment_viewpager)
	XViewPager fragment_viewpager;

	@Override
	protected void getBundleArguments(Bundle arguments) {

	}

	@Override
	protected void onFirstUserVisible() {
		mPresenter = new FragmentPresenterImpl(getContext(), this);
		mPresenter.initialized();
	}

	@Override
	protected void onUserVisible() {

	}

	@Override
	protected void onUserInvisible() {

	}

	@Override
	protected void getBundleExtras(Bundle extras) {

	}

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.fragment_main;
	}

	@Override
	protected void initViewsAndEvents() {
	}

	@Override
	public void initView(List<String> oneCategoryDatas) {
		if (oneCategoryDatas != null && !oneCategoryDatas.isEmpty()) {
			fragment_viewpager.removeAllViews();
			fragment_viewpager.setOffscreenPageLimit(oneCategoryDatas.size());
			FragmentMainAdapter mFragmentMainAdapter = new FragmentMainAdapter(getChildFragmentManager(), oneCategoryDatas, GlobalParams.YZ_CATEGORY_NEWS);
			fragment_viewpager.setAdapter(mFragmentMainAdapter);

			tablayout.removeAllTabs();
			tablayout.setupWithViewPager(fragment_viewpager);
			tablayout.setTabsFromPagerAdapter(mFragmentMainAdapter);
			tablayout.refreshDrawableState();
		}

	}
}
