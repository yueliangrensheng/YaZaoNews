package com.yazao.news.view;

import android.support.v4.app.Fragment;

import com.yazao.news.bean.NavigationBean;
import com.yazao.news.view.base.YZBaseView;

import java.util.List;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public interface YZMainView extends YZBaseView {

	void initMainView(List<Fragment> fragments,List<NavigationBean> navigationDatas);
}
