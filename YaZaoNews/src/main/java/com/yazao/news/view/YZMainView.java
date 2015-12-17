package com.yazao.news.view;

import com.yazao.news.bean.NavigationBean;
import com.yazao.news.view.base.YZBaseView;

import java.util.List;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public interface YZMainView extends YZBaseView{

	void initMainView(List<NavigationBean> navigationDatas,List<String> newsCategoryData);
}
