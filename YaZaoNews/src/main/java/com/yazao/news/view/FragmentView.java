package com.yazao.news.view;

import com.yazao.news.view.base.BaseView;

import java.util.List;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 10:50
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface FragmentView extends BaseView {

	void initView(List<String> oneCategoryDatas);
}
