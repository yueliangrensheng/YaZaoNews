package com.yazao.news.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.yazao.news.R;

/**
 * Author:  MoonLife
 * Time: 2015/12/22 11:44
 * Email: shaopingzhai@gmail.com
 * Descripton: navigationbar、toolbar等相关工具类
 */
public class SystemBarUtil {
	private static volatile SystemBarUtil instance = null;
	private int[] attrs={
			R.attr.actionBarSize,//toolbar的高度
			R.attr.windowActionBarOverlay //toolbar是否悬浮在窗口上
	};

	public static SystemBarUtil getInstance() {
		if (instance == null) {
			synchronized (SystemBarUtil.class) {
				if (instance == null) {
					instance = new SystemBarUtil();
				}
			}
		}
		return instance;
	}

	private SystemBarUtil() {
	}

	private void checkContext(Context context) {
		if (context==null){
			throw new IllegalArgumentException("Argument context is null");
		}
	}

	/**
	 * 获取ToolBar的高度
	 * @param context
	 * @return
	 */
	public float getToolBarHeight(Context context){
		checkContext(context);
		float height=0f;
		TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs);
		height = typedArray.getDimension(0, 56.0f);
		typedArray.recycle();
		return  height;
	}

	/**
	 * 获取状态栏StatusBar的高度
	 * @param context
	 * @return
	 */
	public int getStatusBarHeight(Context context) {
		checkContext(context);
		Resources resources = context.getResources();
		int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
		int height = resources.getDimensionPixelSize(resourceId);
		return height;
	}

	/**
	 * 获取底部导航栏NavigationBar的高度
	 * @param context
	 * @return
	 */
	public int getNavigationBarHeight(Context context) {
		checkContext(context);
		Resources resources = context.getResources();
		int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
		int height = resources.getDimensionPixelSize(resourceId);
		return height;
	}
}
