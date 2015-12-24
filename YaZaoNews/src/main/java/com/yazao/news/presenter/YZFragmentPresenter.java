package com.yazao.news.presenter;

import com.yazao.news.presenter.base.YZBasePresenter;
import com.yazao.news.view.base.YZBaseView;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 15:37
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface YZFragmentPresenter<YZ extends YZBaseView> extends YZBasePresenter<YZ> {
	void initialized();
}
