package com.yazao.news.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yazao.news.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author:  MoonLife
 * Time: 2015/12/21 10:53
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

	List<String> data = new ArrayList<>();


	public RecyclerViewAdapter(List<String> data) {
		this.data = data;
	}

	@Override
	public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_news_item, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
		holder.mImageView.setBackgroundResource(R.drawable.logo);
		holder.mTitle.setText("Title " + data.get(position));
		holder.mSummary.setText("Summary " + data.get(position));
	}

	@Override
	public int getItemCount() {
		return data.size();
	}


	public static class ViewHolder extends RecyclerView.ViewHolder {

		@Bind(R.id.imageView)
		ImageView mImageView;
		@Bind(R.id.title)
		TextView mTitle;
		@Bind(R.id.summary)
		TextView mSummary;

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
