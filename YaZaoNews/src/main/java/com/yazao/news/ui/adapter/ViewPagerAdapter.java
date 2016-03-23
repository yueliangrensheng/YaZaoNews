package com.yazao.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻页展示 的 适配器
 * Created by shaopingzhai on 15/11/17.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
	List<Fragment> fragments = new ArrayList<Fragment>();

	public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

}
