package com.yazao.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yazao.news.lib.util.log.Log;
import com.yazao.news.ui.fragment.YZImageListFragment;
import com.yazao.news.ui.fragment.YZNewsListFragment;
import com.yazao.news.ui.fragment.YZVideoListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 15:29
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class FragmentMainAdapter extends FragmentPagerAdapter {

	private List<String> oneCategoryDatas = new ArrayList<>();
	private int categoryFlag = 0;

	public FragmentMainAdapter(FragmentManager fm, List<String> oneCategoryDatas, int categoryFlag) {
		super(fm);
		this.oneCategoryDatas = oneCategoryDatas;
		this.categoryFlag = categoryFlag;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;
		switch (categoryFlag) {
			case 2://美图
				fragment=new YZImageListFragment();
				break;
			case 1://视频
				fragment=new YZVideoListFragment();
				break;
			case 0://新闻
			default:
				fragment=new YZNewsListFragment();
		}
		Log.i("fragment= "+fragment.toString());
		return fragment;
	}

	@Override
	public int getCount() {
		return oneCategoryDatas.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return oneCategoryDatas.get(position);
	}
}
