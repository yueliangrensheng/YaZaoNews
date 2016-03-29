package com.yazao.news.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.yazao.news.R;
import com.yazao.news.ui.adapter.RecyclerViewAdapter;
import com.yazao.news.widget.RecyclerViewLinearDividerItemDecoration;
import com.yazao.news.widget.XSwipeRefreshLayout;

import butterknife.Bind;
import jp.wasabeef.recyclerview.animators.adapters.SlideInRightAnimationAdapter;

/**
 * Author:  MoonLife
 * Time: 2015/12/23 16:18
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class VideoListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
	@Bind(R.id.fragment_news_recyclerview)
	protected RecyclerView mRecyclerView;
	@Bind(R.id.swiperefreshlayout)
	protected XSwipeRefreshLayout mSwipeRefreshLayout;

	@Override
	protected void getBundleArguments(Bundle arguments) {
	}

	@Override
	protected void onFirstUserVisible() {
	}

	@Override
	protected void onUserVisible() {
	}

	@Override
	protected void onUserInvisible() {
	}

	@Override
	protected void getBundleExtras(Bundle extras) {
	}

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.fragment_content_recyclerview;
	}

	@Override
	protected void initViewsAndEvents() {
		mRecyclerView.removeAllViews();
		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

		mRecyclerView.setLayoutManager(layoutManager);
		mRecyclerView.addItemDecoration(new RecyclerViewLinearDividerItemDecoration(getContext(), RecyclerViewLinearDividerItemDecoration.VERTICAL_LIST));

		RecyclerViewAdapter mRecyclerViewAdapter = new RecyclerViewAdapter();
//		AlphaInAnimationAdapter animationAdapter =new AlphaInAnimationAdapter(mRecyclerViewAdapter);
		SlideInRightAnimationAdapter animationAdapter = new SlideInRightAnimationAdapter(mRecyclerViewAdapter);
		animationAdapter.setDuration(1000);
		animationAdapter.setFirstOnly(false);//true: 加载过动画后，以后不会再有 动画了
		animationAdapter.setInterpolator(new OvershootInterpolator(1f));
		mRecyclerView.setAdapter(animationAdapter);
		mSwipeRefreshLayout.setColorSchemeColors(
				getResources().getColor(R.color.color_refresh_green),
				getResources().getColor(R.color.color_refresh_purple),
				getResources().getColor(R.color.colorPrimary),
				getResources().getColor(R.color.colorAccent)

		);
		mSwipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.grayLine));
		mSwipeRefreshLayout.setOnRefreshListener(this);
	}

	// mSwipeRefreshLayout
	@Override
	public void onRefresh() {

		mSwipeRefreshLayout.postDelayed(new Runnable() {
			@Override
			public void run() {
				mSwipeRefreshLayout.setRefreshing(false);
			}
		},5000);
		Toast.makeText(getActivity(), "onRefresh", Toast.LENGTH_SHORT).show();
	}
}
