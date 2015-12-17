package com.yazao.news.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.yazao.news.R;
import com.yazao.news.lib.base.YZBaseFragment;
import com.yazao.news.ui.adapter.YZViewPagerAdapter;

import java.util.List;

import butterknife.Bind;


/**
 * 新闻首页
 * Created by shaopingzhai on 15/11/17.
 */
public class YZMainNewsFragment extends YZBaseFragment implements ViewPager.OnPageChangeListener {

	@Bind(R.id.viewpager)
	ViewPager mViewPager;
	@Bind(R.id.tabstrip)
	PagerSlidingTabStrip tabStrip;

	YZViewPagerAdapter mViewPagerAdapter;
	List<String> newsCategoryData;

	@Override
	protected void getBundleExtras(Bundle extras) {
		newsCategoryData = extras.getStringArrayList("newsCategoryData");
	}

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.fragment_main;
	}

	@Override
	protected void initViewsAndEvents() {
		mViewPagerAdapter = new YZViewPagerAdapter(getActivity().getSupportFragmentManager(),newsCategoryData);
		mViewPager.setAdapter(mViewPagerAdapter);

		tabStrip.setViewPager(mViewPager);
//		tabStrip.setOnPageChangeListener(this);


	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int position) {

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
