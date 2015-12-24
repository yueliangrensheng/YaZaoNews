package com.yazao.news.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Author:  MoonLife
 * Time: 2015/12/24 10:42
 * Email: shaopingzhai@gmail.com
 * Descripton: customize ViewPager did scroll enable or not
 */
public class XViewPager extends ViewPager {

	private boolean isEnableScroll=true;

	public XViewPager(Context context) {
		super(context);
	}

	public XViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (!isEnableScroll){
			return  false;
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (!isEnableScroll){
			return  false;
		}
		return super.onTouchEvent(ev);
	}

	public void setIsEnableScroll(boolean isEnableScroll) {
		this.isEnableScroll = isEnableScroll;
	}

	public boolean isEnableScroll() {
		return isEnableScroll;
	}
}
