package com.yazao.news.interactor.impl;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yazao.news.R;
import com.yazao.news.api.GlobalParams;
import com.yazao.news.bean.NavigationBean;
import com.yazao.news.interactor.YZMainInteractor;
import com.yazao.news.ui.fragment.YZImageFragment;
import com.yazao.news.ui.fragment.YZNewsFragment;
import com.yazao.news.ui.fragment.YZVideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public class YZMainInteractorImpl implements YZMainInteractor {

	@Override
	public List<NavigationBean> getNavigationData(Context context) {

		List<NavigationBean> list = new ArrayList<>();
		if (context != null) {
			String[] array = context.getResources().getStringArray(R.array.navigation_list);
			if (array != null && array.length > 0) {
				list.add(new NavigationBean(""+ GlobalParams.YZ_CATEGORY_NEWS, array[0], R.mipmap.ic_launcher));
				list.add(new NavigationBean(""+ GlobalParams.YZ_CATEGORY_VIDEO, array[1], R.mipmap.ic_launcher));
				list.add(new NavigationBean(""+ GlobalParams.YZ_CATEGORY_IMAGE, array[2], R.mipmap.ic_launcher));
			}
		}
		return list;
	}


	@Override
	public List<Fragment> getCategoryFragments() {
		List<Fragment> fragments = new ArrayList<>();
		fragments.add(new YZNewsFragment());
		fragments.add(new YZVideoFragment());
		fragments.add(new YZImageFragment());
		return fragments;
	}
}
