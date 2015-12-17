package com.yazao.news.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yazao.news.R;
import com.yazao.news.lib.base.YZBaseFragment;

import butterknife.Bind;

/**
 * <p>
 * Author:  shaopingzhai on 15/12/10. <Br>
 * Time: 2015/12/10 14:22<Br>
 * Contact: shaopingzhai@gmail.com<Br>
 * Weibo: <a href="http://weibo.com/zsp21">微博</a><Br>
 * </p>
 */
public abstract class BaseFragment extends YZBaseFragment {
	@Bind(R.id.swiprefreshlayout)
	protected SwipeRefreshLayout swiprefreshlayout;

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

	}

	protected void initSwipeLayout() {
		if (swiprefreshlayout!=null){
			swiprefreshlayout.setColorSchemeColors(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
		}
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initSwipeLayout();
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}
}
