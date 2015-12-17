package com.yazao.news.lib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public abstract class YZBaseFragment extends Fragment {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Bundle
		Bundle extras=getActivity().getIntent().getExtras();
		if (extras!=null){
			getBundleExtras(extras);
		}
	}

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
	public void onAttach(Context context) {
		super.onAttach(context);

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	protected abstract void getBundleExtras(Bundle extras);


	protected abstract int getContentViewLayoutID();

	protected abstract void initViewsAndEvents();
}
