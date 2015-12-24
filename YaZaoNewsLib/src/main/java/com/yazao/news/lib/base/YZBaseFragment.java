package com.yazao.news.lib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public abstract class YZBaseFragment extends Fragment {

	private boolean isFirstResume = true;
	private boolean isFirstVisible = true;
	private boolean isFirstInvisible = true;
	private boolean isPrepared;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Bundle
		Bundle extras=getActivity().getIntent().getExtras();
		if (extras!=null){
			getBundleExtras(extras);
		}
		Bundle arguments = getArguments();
		if (arguments!=null){
			getBundleArguments(arguments);
		}

	}

	protected abstract void getBundleArguments(Bundle arguments);

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		int layoutID = getContentViewLayoutID();
		View view = null;
		if (layoutID != 0) {
			view = inflater.inflate(layoutID, null);
			return view;
		}
		view = super.onCreateView(inflater, container, savedInstanceState);
		return view;
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);
		initViewsAndEvents();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.unbind(this);
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser) {
			if (isFirstVisible) {
				isFirstVisible = false;
				initPrepare();
			} else {
				onUserVisible();
			}
		} else {
			if (isFirstInvisible) {
				isFirstInvisible = false;
				onFirstUserInvisible();
			} else {
				onUserInvisible();
			}
		}
	}

	private synchronized void initPrepare() {
		if (isPrepared) {
			onFirstUserVisible();
		} else {
			isPrepared = true;
		}
	}


	@Override
	public void onDetach() {
		super.onDetach();
		// for bug ---> java.lang.IllegalStateException: Activity has been destroyed
		try {
			Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);

		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onPause() {
		super.onPause();
		if (getUserVisibleHint()) {
			onUserInvisible();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (isFirstResume) {
			isFirstResume = false;
			return;
		}
		if (getUserVisibleHint()) {
			onUserVisible();
		}
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initPrepare();
	}

	/**
	 * when fragment is visible for the first time, here we can do some initialized work or refresh data only once
	 */
	protected abstract void onFirstUserVisible();

	/**
	 * this method like the fragment's lifecycle method onResume()
	 */
	protected abstract void onUserVisible();

	/**
	 * when fragment is invisible for the first time
	 */
	private void onFirstUserInvisible() {
		// here we do not recommend do something
	}

	/**
	 * this method like the fragment's lifecycle method onPause()
	 */
	protected abstract void onUserInvisible();


	protected abstract void getBundleExtras(Bundle extras);


	protected abstract int getContentViewLayoutID();

	protected abstract void initViewsAndEvents();
}
