package com.yazao.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yazao.news.ui.fragment.YZNewsFragment;

/**
 * 新闻页展示 的 适配器
 * Created by shaopingzhai on 15/11/17.
 */
public class YZViewPagerAdapter extends FragmentPagerAdapter {

	public YZViewPagerAdapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int position) {
		return new YZNewsFragment();
	}

	@Override
	public int getCount() {
		return 4;
	}
}
