package com.yazao.news.ui.fragment;

import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.yazao.news.R;
import com.yazao.news.lib.base.YZBaseFragment;
import com.yazao.news.ui.adapter.YZViewPagerAdapter;

import butterknife.Bind;



/**
 * 新闻首页
 * Created by shaopingzhai on 15/11/17.
 */
public class YZMainFragment extends YZBaseFragment implements ViewPager.OnPageChangeListener {

	@Bind(R.id.viewpager)
	ViewPager mViewPager;
	@Bind(R.id.horizontalScrollView)
	TextView horizontalScrollView;
	YZViewPagerAdapter mViewPagerAdapter;


	@Override
	protected int getContentViewLayoutID() {
		return R.layout.fragment_news;
	}

	@Override
	protected void initViewsAndEvents() {
		mViewPagerAdapter = new YZViewPagerAdapter(getActivity().getSupportFragmentManager());
		mViewPager.setAdapter(mViewPagerAdapter);

		mViewPager.setOnPageChangeListener(this);
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
