package com.yazao.news.ui.activity;

import android.os.Bundle;

import com.yazao.news.lib.base.YZBaseActivity;
import com.yazao.news.presenter.base.BasePresenter;

/**
 * Author:  shaopingzhai on 15/12/9.
 * Time: 2015/12/09 18:20
 * Contact: shaopingzhai@gmail.com
 */
public abstract class BaseActivity<YZ extends BasePresenter> extends YZBaseActivity{

	protected YZ mPresenter;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initPresenter();
		checkPresenterIsNull();
	}

	private void initSwipeLayout() {

	}

	/**
	 * 初始化presenter
	 */
	public abstract void initPresenter();


	private void checkPresenterIsNull(){
		if(mPresenter == null){
			throw new IllegalStateException("please init mPresenter in initPresenter() method ");
		}
	}
}
