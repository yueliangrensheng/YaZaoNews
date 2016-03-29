package com.yazao.news.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yazao.news.R;
import com.yazao.news.lib.net.NetUtil;
import com.yazao.news.lib.util.log.Log;

import butterknife.Bind;

/**
 * Author:  MoonLife
 * Time: 2016/03/25 10:41
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class ImageListDetailActivity extends BaseActivity {
	public static final String INTENT_IMAGE_URL_TAG = "ImageListDetailActivity_Image_Url";
	public static final String INTENT_IMAGE_LOCATION_X_TAG = "ImageListDetailActivity_Image_Location_X";
	public static final String INTENT_IMAGE_LOCATION_Y_TAG = "ImageListDetailActivity_Image_Location_Y";
	public static final String INTENT_IMAGE_WIDTH_TAG = "ImageListDetailActivity_Image_Width";
	public static final String INTENT_IMAGE_HEIGHT_TAG = "ImageListDetailActivity_Image_Height";
	public static final String INTENT_IMAGE_TITLE_TAG = "ImageListDetailActivity_Image_Title";


	private String mImageUrl;
	private int mLocationX;
	private int mLocationY;
	private int mWidth;
	private int mHeight;
	private String mTitle;

	@Bind(R.id.image_detail)
	ImageView mImageView;

	@Override
	public void initPresenter() {

	}

	@Override
	protected boolean isNoStateBar() {
		return true;
	}

	@Override
	protected boolean isFullScreen() {
		return true;
	}

	@Override
	protected boolean isNoTitle() {
		return true;
	}

	@Override
	protected void onNetWorkConneted(NetUtil.NetType type) {
		switch (type) {
			case CMNET:
			case CMWAP: //数据流量
				Glide.with(this).pauseRequests();
				break;
			case WIFI://无线
				Glide.with(this).resumeRequests();
				break;
			case NONE:
			default:
				Glide.with(this).pauseRequests();
				break;
		}
	}

	@Override
	protected void onNetWorkDisConneted() {
		//TODO 提示网络异常，停止在线加载图片
	}

	@Override
	protected void getBundleExtras(Bundle extras) {
		mImageUrl = extras.getString(INTENT_IMAGE_URL_TAG);
		mTitle = extras.getString(INTENT_IMAGE_TITLE_TAG);
		mLocationX = extras.getInt(INTENT_IMAGE_LOCATION_X_TAG);
		mLocationY = extras.getInt(INTENT_IMAGE_LOCATION_Y_TAG);
		mWidth = extras.getInt(INTENT_IMAGE_WIDTH_TAG);
		mHeight = extras.getInt(INTENT_IMAGE_HEIGHT_TAG);
		Log.i("mImageUrl= " + mImageUrl + " ,mLocationX= " + mLocationX + ",mLocationY= " + mLocationY + ",mWidth= " + mWidth + ",mHeight= " + mHeight);
	}

	@Override
	protected void initViewsAndEvents() {

		setTitle(mTitle);

		Glide.with(this).load(mImageUrl).into(mImageView);

	}

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_image_detail;
	}

	@Override
	protected void onPause() {
		super.onPause();
		Glide.with(this).pauseRequests();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Glide.with(this).resumeRequests();
	}
}
