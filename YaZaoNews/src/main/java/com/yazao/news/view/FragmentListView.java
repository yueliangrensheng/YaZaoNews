package com.yazao.news.view;

import com.yazao.news.bean.ImageListDataBean;
import com.yazao.news.view.base.BaseView;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 15:01
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface FragmentListView extends BaseView{
	void refreshListData(ImageListDataBean imageListDataBean);

}
