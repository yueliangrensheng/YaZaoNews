package com.yazao.news.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.yazao.news.R;
import com.yazao.news.api.GlobalParams;
import com.yazao.news.bean.ImageListBean;
import com.yazao.news.bean.ImageListDataBean;
import com.yazao.news.lib.net.NetUtil;
import com.yazao.news.lib.util.log.Log;
import com.yazao.news.presenter.impl.FragmentListPresenterImpl;
import com.yazao.news.ui.activity.ImageListDetailActivity;
import com.yazao.news.ui.adapter.RecyclerViewImageAdapter;
import com.yazao.news.view.FragmentListView;
import com.yazao.news.widget.XSwipeRefreshLayout;

import butterknife.Bind;
import jp.wasabeef.recyclerview.animators.adapters.SlideInRightAnimationAdapter;

/**
 * 每个新闻页面展示的内容
 * Created by shaopingzhai on 15/11/17.
 */
public class ImageListFragment extends BaseFragment<FragmentListPresenterImpl> implements SwipeRefreshLayout.OnRefreshListener, FragmentListView, RecyclerViewImageAdapter.OnItemClickListener {

	@Bind(R.id.fragment_news_recyclerview)
	protected RecyclerView mRecyclerView;
	@Bind(R.id.swiperefreshlayout)
	protected XSwipeRefreshLayout mSwipeRefreshLayout;

	private RecyclerViewImageAdapter mRecyclerViewAdapter;
	/**
	 * this variable must be initialized.
	 */
	private static String mCurrentImagesCategory = null;
	/**
	 * the page number
	 */
	private int mCurrentPage = 0;

	@Override
	protected void getBundleArguments(Bundle arguments) {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mCurrentImagesCategory = getResources().getStringArray(R.array.images_category_list)[0];
	}

	@Override
	protected void onFirstUserVisible() {
		mCurrentPage= 0;
		mPresenter = new FragmentListPresenterImpl(getActivity(), this);
		if (NetUtil.getInstance().isNetworkconnected(getActivity())) {
			if (mSwipeRefreshLayout != null) {
				mSwipeRefreshLayout.postDelayed(new Runnable() {
					@Override
					public void run() {
						mPresenter.loadListData(TAG_LOG, GlobalParams.EVENT_REFRESH_DATA, mCurrentImagesCategory, mCurrentPage, false);
					}
				}, 200);
			}
		} else {
			//TODO no net

		}
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
//		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

		mRecyclerView.setLayoutManager(layoutManager);
//		mRecyclerView.addItemDecoration(new RecyclerViewLinearDividerItemDecoration(getContext(), RecyclerViewLinearDividerItemDecoration.VERTICAL_LIST));

		mRecyclerViewAdapter = new RecyclerViewImageAdapter(getActivity());
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
		mSwipeRefreshLayout.setOnRefreshListener(this);

		mRecyclerViewAdapter.setOnItemClickListener(this);
	}

	// mSwipeRefreshLayout
	@Override
	public void onRefresh() {
		mCurrentPage= 0;
		mPresenter.loadListData(TAG_LOG, GlobalParams.EVENT_REFRESH_DATA,mCurrentImagesCategory,mCurrentPage,true);
	}

	//view
	@Override
	public void refreshListData(ImageListDataBean imageListDataBean) {
		if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
			mSwipeRefreshLayout.setRefreshing(false);
		}
		if (imageListDataBean != null ) {
			if (mRecyclerViewAdapter != null ) {
				mRecyclerViewAdapter.getListData().clear();
				if (imageListDataBean.getImgs().get(imageListDataBean.getImgs().size()-1).getImageUrl()==null){
					imageListDataBean.getImgs().remove(imageListDataBean.getImgs().size()-1);
				}
				mRecyclerViewAdapter.getListData().addAll(imageListDataBean.getImgs());
				//	mRecyclerViewAdapter.notifyDataSetChanged(); // 不起作用 ,因为recyclerview的adapter是 动画的adapter
				mRecyclerView.getAdapter().notifyDataSetChanged();
				Log.i("mRecyclerViewAdapter.getListData()= "+mRecyclerViewAdapter.getListData().size());
			}
		}
	}

	//recyclerview Item click
	@Override
	public void onItemClick(View view, int position) {
		if (mRecyclerViewAdapter!=null&& mRecyclerViewAdapter.getListData()!=null){
			ImageListBean bean = mRecyclerViewAdapter.getListData().get(position);
			if (bean!=null){
				int[] location=new int[2];
				view.getLocationOnScreen(location);
				Bundle bundle =new Bundle();
				bundle.putString(ImageListDetailActivity.INTENT_IMAGE_URL_TAG, bean.getThumbnailUrl());
				bundle.putInt(ImageListDetailActivity.INTENT_IMAGE_LOCATION_X_TAG, location[0]);
				bundle.putInt(ImageListDetailActivity.INTENT_IMAGE_LOCATION_Y_TAG, location[1]);
				bundle.putInt(ImageListDetailActivity.INTENT_IMAGE_WIDTH_TAG, view.getWidth());
				bundle.putInt(ImageListDetailActivity.INTENT_IMAGE_HEIGHT_TAG, view.getHeight());
				bundle.putString(ImageListDetailActivity.INTENT_IMAGE_TITLE_TAG, bean.getTitle());
				Intent intent = new Intent(getActivity(),ImageListDetailActivity.class);
				intent.putExtras(bundle);
				getActivity().startActivity(intent);
			}
		}
	}

	@Override
	public void onItemLongClick(View view, int position) {
		Toast.makeText(getActivity(),"Long click : position= "+ position,Toast.LENGTH_SHORT).show();
	}
}
