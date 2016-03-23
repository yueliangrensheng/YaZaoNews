package com.yazao.news.presenter;

import com.yazao.news.presenter.base.BasePresenter;
import com.yazao.news.view.base.BaseView;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public interface MainPresenter<YZ extends BaseView>  extends BasePresenter<YZ> {
	 void initialized();
}
