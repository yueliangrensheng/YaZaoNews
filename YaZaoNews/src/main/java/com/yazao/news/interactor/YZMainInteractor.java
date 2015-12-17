package com.yazao.news.interactor;

import android.content.Context;

import com.yazao.news.bean.NavigationBean;
import com.yazao.news.interactor.base.YZBaseInteractor;

import java.util.List;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public interface YZMainInteractor  extends YZBaseInteractor {
	/**
	 * 获取app分类数据列表
	 * @param context
	 * @return
	 */
	List<NavigationBean> getNavigationData(Context context);

	/**
	 * 获取新闻数据的分类列表
	 * @param context
	 * @return
	 */
	List<String> getNewsCategoryData(Context context);
}
