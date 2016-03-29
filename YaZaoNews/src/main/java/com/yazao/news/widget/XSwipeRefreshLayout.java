package com.yazao.news.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Author:  MoonLife
 * Time: 2016/03/23 13:43
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class XSwipeRefreshLayout extends SwipeRefreshLayout {
	public XSwipeRefreshLayout(Context context) {
		this(context, null);
	}

	public XSwipeRefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private float xDistance, yDistance, xLast, yLast;

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				xDistance = yDistance = 0;
				xLast = ev.getX();
				yLast = ev.getY();
				break;

			case MotionEvent.ACTION_MOVE:
				float curX = ev.getX();
				float curY = ev.getY();

				xDistance += Math.abs(curX - xLast);
				yDistance += Math.abs(curY - yLast);
				xLast = curX;
				yLast = curY;

				if (xDistance>yDistance){
					//水平滑动---滑动事件传递给子元素
					return  false;
				}
				break;

			case MotionEvent.ACTION_UP:
				break;
		}
		return super.onInterceptTouchEvent(ev);
	}


	private OnScrollListener mOnScrollListener = null;

	public void setOnScrollListener(OnScrollListener mOnScrollListener) {
		this.mOnScrollListener = mOnScrollListener;
	}

	public  interface OnScrollListener{
		void onScrollChanged(int l, int t, int oldl, int oldt);
	}


	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (mOnScrollListener!=null){
			mOnScrollListener.onScrollChanged(l,t,oldl,oldt);
		}
	}
}
