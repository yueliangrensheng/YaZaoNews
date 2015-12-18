package com.yazao.news.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.yazao.news.R;

import butterknife.Bind;

/**
 * 每个新闻页面展示的内容
 * Created by shaopingzhai on 15/11/17.
 */
public class YZNewsFragment extends BaseFragment {
	@Bind(R.id.tv)
	TextView tv;

	String msg;

	@Override
	protected void getBundleArguments(Bundle arguments) {

	}

	@Override
	protected void getBundleExtras(Bundle extras) {

	}

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.fragment_news;
	}

	@Override
	protected void initViewsAndEvents() {
		tv.setText(msg);
	}

	public void setText(String message){
		msg=message;
	}
}
