package com.yazao.news.lib.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public abstract  class YZBaseActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//set layout
		if (getContextViewLayoutID()!=0){
			setContentView(getContextViewLayoutID());
		}else {
			throw new IllegalArgumentException("You must return a right ContentView Layout.");
		}

		initViewsAndEvents();
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		ButterKnife.bind(this);
	}

	/** init*/
	protected abstract void initViewsAndEvents();

	protected abstract int getContextViewLayoutID();


}
