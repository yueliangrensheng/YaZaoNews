package com.yazao.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yazao.news.ui.fragment.YZNewsFragment;

import java.util.List;

/**
 * 新闻页展示 的 适配器
 * Created by shaopingzhai on 15/11/17.
 */
public class YZViewPagerAdapter extends FragmentPagerAdapter {
	List<String> newsCategoryData;

	public YZViewPagerAdapter(FragmentManager fm, List<String> newsCategoryData) {
		super(fm);
		this.newsCategoryData = newsCategoryData;

	}

	@Override
	public Fragment getItem(int position) {
		YZNewsFragment newsFragment = new YZNewsFragment();
		newsFragment.setText("news Page" + position);
		return newsFragment;
	}

	@Override
	public int getCount() {
		return newsCategoryData != null ? newsCategoryData.size() : 0;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return newsCategoryData!=null?newsCategoryData.get(position):"";
	}
}
