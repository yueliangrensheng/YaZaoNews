package com.yazao.news.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.OvershootInterpolator;

import com.yazao.news.R;
import com.yazao.news.ui.adapter.RecyclerViewAdapter;
import com.yazao.news.widget.RecyclerViewLinearDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import jp.wasabeef.recyclerview.animators.adapters.SlideInRightAnimationAdapter;

/**
 * 新闻页面展示的内容
 * Created by shaopingzhai on 15/11/17.
 */
public class NewsListFragment extends BaseFragment {

	@Bind(R.id.fragment_news_recyclerview)
	protected RecyclerView mRecyclerView;

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

		List<String> data = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			data.add("news " + (i + 1));
		}
		RecyclerViewAdapter mRecyclerViewAdapter = new RecyclerViewAdapter(data);
//		AlphaInAnimationAdapter animationAdapter =new AlphaInAnimationAdapter(mRecyclerViewAdapter);
		SlideInRightAnimationAdapter animationAdapter = new SlideInRightAnimationAdapter(mRecyclerViewAdapter);
		animationAdapter.setDuration(1000);
		animationAdapter.setFirstOnly(false);//true: 加载过动画后，以后不会再有 动画了
		animationAdapter.setInterpolator(new OvershootInterpolator(1f));
		mRecyclerView.setAdapter(animationAdapter);
		mRecyclerView.refreshDrawableState();
	}
}
