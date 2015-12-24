package com.yazao.news.interactor;

import android.content.Context;

import com.yazao.news.interactor.base.YZBaseInteractor;

import java.util.List;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 16:26
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public interface YZFragmentInteractor extends YZBaseInteractor{
	/**
	 * 获取某个分类的数据
	 * @param context
	 * @param categoryFlag 区分类别（新闻、视频、图片）
	 * @return
	 */
	List<String> getCategoryDatas(Context context, int categoryFlag);

}
