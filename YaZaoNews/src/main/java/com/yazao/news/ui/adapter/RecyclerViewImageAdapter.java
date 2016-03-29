package com.yazao.news.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yazao.news.R;
import com.yazao.news.bean.ImageListBean;
import com.yazao.news.lib.util.log.Log;

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
public class RecyclerViewImageAdapter extends RecyclerView.Adapter<RecyclerViewImageAdapter.ViewHolder> {

	List<ImageListBean> imageListBeanData = new ArrayList<ImageListBean>();
	private Context mContext;
	public RecyclerViewImageAdapter() {
	}

	public RecyclerViewImageAdapter(Context context,List<ImageListBean> data) {
		this.mContext = context;
		this.imageListBeanData = data;
	}

	public RecyclerViewImageAdapter(Context context) {
		this.mContext = context;
	}

	public List<ImageListBean> getListData() {
		return imageListBeanData;
	}

	@Override
	public RecyclerViewImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_image_item, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final RecyclerViewImageAdapter.ViewHolder holder, final int position) {
		int width = (int) (imageListBeanData.get(position).getThumbnailWidth() *2.5);
		int height = (int) (imageListBeanData.get(position).getThumbnailHeight()*2.5);
		String imageUrl = imageListBeanData.get(position).getThumbnailUrl();
		Log.i("position= "+position+" ,width="+width+" ,height= "+height+",imageUrl= "+ imageUrl);
		if (!"".equals(imageUrl)&& imageUrl!=null){
			//load image
			Glide.with(mContext) //Glide 的 好多功能 直接加在 load（）和into（）方法之间即可。
					.load(imageUrl)
					.fitCenter()// 中心fit 以原来的图片的长宽为主
//					.override(BitmapImageViewTarget.SIZE_ORIGINAL, BitmapImageViewTarget.SIZE_ORIGINAL)
					.override(width, height)
//					.centerCrop() //中心切圆 会填满
					.placeholder(R.drawable.logo)//默认的占位图片
					.error(R.drawable.logo)// 加载错误图
					.crossFade()
					.thumbnail(0.7f) //缩略图 是 原来图片的 n(0~1)倍
					.diskCacheStrategy(DiskCacheStrategy.RESULT) //缓存所有的图片到本地
					.into(holder.list_image_imageView);
		}

		//设置点击事件
		if (mOnItemClickListener !=null){
			holder.list_image_imageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					mOnItemClickListener.onItemClick(holder.list_image_imageView,holder.getLayoutPosition());
				}
			});
			holder.list_image_imageView.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					mOnItemClickListener.onItemLongClick(holder.list_image_imageView,holder.getLayoutPosition());
					return false;
				}
			});
		}


	}

	@Override
	public int getItemCount() {
		return imageListBeanData.size();
	}


	public static class ViewHolder extends RecyclerView.ViewHolder {

		@Bind(R.id.list_image_imageView)
		ImageView list_image_imageView;

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
	private OnItemClickListener mOnItemClickListener=null;

	public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
		this.mOnItemClickListener = mOnItemClickListener;
	}

	public interface OnItemClickListener{
		void onItemClick(View view,int position);
		void onItemLongClick(View view,int position);
	}
}
