package com.yazao.news.lib.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.yazao.news.lib.util.log.Log;

/**
 * Author:  MoonLife
 * Time: 2015/12/15 15:27
 * Email: shaopingzhai@gmail.com
 * Weibo: <a href="http://weibo.com/zsp21">新浪微博</a>
 * Descripton:
 */
public class NetChangeReceiverUtil {
//	public final static String CUSTOM_ANDROID_NET_CHANGE_ACTION = "com.yazao.news.lib.conn.CONNECTIVITY_CHANGE";
//	private final static String ANDROID_NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

	private static BroadcastReceiver netChangeObserverReceiver;

	private static NetChangeReceiverUtil instance;

	private NetChangeReceiverUtil() {
	}

	public static NetChangeReceiverUtil getInstance() {
		if (instance == null) {
			synchronized (NetChangeReceiverUtil.class) {
				if (instance == null) {
					instance = new NetChangeReceiverUtil();
				}
				if (netChangeObserverReceiver==null){
					netChangeObserverReceiver = NetChangeReceiver.getReceiver();
				}
			}
		}
		return instance;
	}

	public  void registerNetworkStateReceiver(Context mContext) {
		if (netChangeObserverReceiver != null) {
			IntentFilter filter = new IntentFilter();
			filter.addAction(NetChangeReceiver.CUSTOM_ANDROID_NET_CHANGE_ACTION);
			filter.addAction(NetChangeReceiver.ANDROID_NET_CHANGE_ACTION);
			mContext.getApplicationContext().registerReceiver(netChangeObserverReceiver, filter);
			Log.i("registerNetworkStateReceiver");
		}
	}

	public  void unRegisterNetworkStateReceiver(Context mContext) {
		if (netChangeObserverReceiver != null) {
			try {
				mContext.getApplicationContext().unregisterReceiver(netChangeObserverReceiver);
				netChangeObserverReceiver=null;
				Log.i("unRegisterNetworkStateReceiver");
			} catch (Exception e) {
				Log.d(e.getMessage());
			}
		}

	}

	public  void sendNetChangeBroadcastReceiver(Context mContext) {
		Intent intent = new Intent();
		intent.setAction(NetChangeReceiver.CUSTOM_ANDROID_NET_CHANGE_ACTION);
		mContext.sendBroadcast(intent);
		Log.i("sendNetChangeBroadcastReceiver");
	}
}
