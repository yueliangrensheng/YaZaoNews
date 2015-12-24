package com.yazao.news.view;

import com.yazao.news.view.base.YZBaseView;

import java.util.List;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 10:50
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface YZFragmentView extends YZBaseView {

	void initView(List<String> oneCategoryDatas);
}
