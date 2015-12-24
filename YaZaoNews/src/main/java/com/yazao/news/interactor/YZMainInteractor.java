package com.yazao.news.interactor;

import android.content.Context;
import android.support.v4.app.Fragment;

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
	 * 获取分类的fragment
	 * @return
	 */
	List<Fragment> getCategoryFragments();
}
