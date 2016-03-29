package com.yazao.news.presenter;

import com.yazao.news.bean.ImageListBean;
import com.yazao.news.presenter.base.BasePresenter;
import com.yazao.news.view.base.BaseView;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 14:58
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface FragmentListPresenter<YZ extends BaseView> extends BasePresenter<YZ> {
	void loadListData(String requestTag, int event_tag, String keywords, int page, boolean isSwipeRefresh);
	void onItemClickListener(int position, ImageListBean entity, int x, int y, int width, int height);
}
