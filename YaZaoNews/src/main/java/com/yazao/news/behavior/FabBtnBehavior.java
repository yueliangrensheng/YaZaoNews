package com.yazao.news.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.yazao.news.util.SystemBarUtil;

/**
 * Author:  MoonLife
 * Time: 2015/12/22 15:54
 * Email: shaopingzhai@gmail.com
 * Descripton:
 */
public class FabBtnBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

	private int toolBarHeight = 0;

	public FabBtnBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
		toolBarHeight = (int) SystemBarUtil.getInstance().getToolBarHeight(context);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
		return dependency instanceof AppBarLayout;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
		if (dependency instanceof AppBarLayout) {
			CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();

			int distanceToScroll = child.getMeasuredHeight() + layoutParams.bottomMargin;
			float radio = dependency.getY() / toolBarHeight;
			child.setTranslationY(-distanceToScroll * radio);
		}
		return true;
	}
}
