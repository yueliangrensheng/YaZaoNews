package com.yazao.news.lib;

import android.app.Application;
import android.util.DisplayMetrics;

import com.yazao.news.lib.constant.GlobalParams;
import com.yazao.news.lib.net.NetChangeReceiverUtil;
import com.yazao.news.lib.util.ActivityManager;
import com.yazao.news.lib.util.ScreenUtil;
import com.yazao.news.lib.util.log.Log;
import com.yazao.news.lib.util.net.VolleyHelper;

/**
 * Author:  MoonLife
 * Time: 2015/12/15 11:43
 * Email: shaopingzhai@gmail.com
 * Weibo: <a href="http://weibo.com/zsp21">新浪微博</a>
 */
public class YZApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		//deal with Logger
		if (!BuildConfig.DEBUG) {
			//调试模式,显示日志
			Log.init("YaZao").hideThreadInfo();
		} else {
			Log.init("YaZao").setLogLevel(Log.LogLevel.NONE);
		}
		android.util.Log.i("YaZao","debug= "+BuildConfig.DEBUG);

		//deal with Volley framework
		VolleyHelper.getInstance().init(this);

		//deal with Screen Width and Height
		DisplayMetrics displayMetrics = ScreenUtil.getInstance().getScreenMetrics(this);
		if (displayMetrics != null) {
			GlobalParams.screenWidth = displayMetrics.widthPixels;
			GlobalParams.screenHeiht = displayMetrics.heightPixels;
			GlobalParams.screenDensity = displayMetrics.density;
		}

		//deal with Listen Net Work Change
		//注册网络状态的监听
		NetChangeReceiverUtil.getInstance().registerNetworkStateReceiver(this);
		//发送广播
		NetChangeReceiverUtil.getInstance().sendNetChangeBroadcastReceiver(this);

	}



	@Override
	public void onLowMemory() {
		//注销网络状态的监听
		NetChangeReceiverUtil.getInstance().unRegisterNetworkStateReceiver(this);
		android.os.Process.killProcess(android.os.Process.myPid());
		super.onLowMemory();
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);

	}

	@Override
	public void onTerminate() {
		super.onTerminate();

	}


	public void exitApp() {
		//注销网络状态的监听
		NetChangeReceiverUtil.getInstance().unRegisterNetworkStateReceiver(this);

		ActivityManager.getInstance().clear();
		System.exit(0);
		System.gc();
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}
