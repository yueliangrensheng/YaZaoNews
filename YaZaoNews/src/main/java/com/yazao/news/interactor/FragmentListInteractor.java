package com.yazao.news.interactor;

import com.yazao.news.interactor.base.BaseInteractor;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 15:13
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface FragmentListInteractor extends BaseInteractor{
	void  getListData(String requestTag, final int event_tag, String keywords, int page);
}
