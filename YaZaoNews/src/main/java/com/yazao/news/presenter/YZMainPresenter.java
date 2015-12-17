package com.yazao.news.presenter;

import com.yazao.news.presenter.base.YZBasePresenter;
import com.yazao.news.view.base.YZBaseView;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public interface YZMainPresenter<YZ extends YZBaseView>  extends YZBasePresenter<YZ>{
	 void initialized();
}
