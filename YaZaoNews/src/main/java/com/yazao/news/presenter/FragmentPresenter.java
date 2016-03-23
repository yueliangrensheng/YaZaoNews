package com.yazao.news.presenter;

import com.yazao.news.presenter.base.BasePresenter;
import com.yazao.news.view.base.BaseView;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 15:37
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface FragmentPresenter<YZ extends BaseView> extends BasePresenter<YZ> {
	void initialized();
}
