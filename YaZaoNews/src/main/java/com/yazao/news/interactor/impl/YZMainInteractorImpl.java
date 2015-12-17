package com.yazao.news.interactor.impl;

import android.content.Context;

import com.yazao.news.R;
import com.yazao.news.bean.NavigationBean;
import com.yazao.news.interactor.YZMainInteractor;

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
				list.add(new NavigationBean("0", array[0], R.mipmap.ic_launcher));
				list.add(new NavigationBean("1", array[1], R.mipmap.ic_launcher));
				list.add(new NavigationBean("2", array[2], R.mipmap.ic_launcher));
			}
		}
		return list;
	}

	@Override
	public List<String> getNewsCategoryData(Context context) {
		List<String> list = new ArrayList<>();
		if (context != null) {
			String[] array = context.getResources().getStringArray(R.array.news_category_list);
			if (array != null && array.length > 0) {
				for (String category : array) {
					list.add(category);
				}
			}
		}
		return list;
	}
}
