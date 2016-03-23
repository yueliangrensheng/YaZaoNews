package com.yazao.news.interactor.impl;

import android.content.Context;

import com.yazao.news.R;
import com.yazao.news.interactor.FragmentInteractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 16:29
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class FragmentInteractorImpl implements FragmentInteractor {

	@Override
	public List<String> getCategoryDatas(Context context, int categoryFlag) {
		List<String> list = new ArrayList<String>();
		String[] array = null;
		switch (categoryFlag) {
			case 1://视频
				array = context.getResources().getStringArray(R.array.videos_category_list);
				break;
			case 2: //图片
				array = context.getResources().getStringArray(R.array.images_category_list);
				break;
			case 0: //新闻
			default:
				array = context.getResources().getStringArray(R.array.news_category_list);

		}
		if (array != null && array.length > 0) {
			for (String category : array) {
				list.add(category);
			}
		}

		return list;
	}
}
