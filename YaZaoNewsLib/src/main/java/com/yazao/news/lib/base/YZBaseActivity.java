package com.yazao.news.lib.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yazao.news.lib.net.NetChangeObserver;
import com.yazao.news.lib.net.NetChangeReceiver;
import com.yazao.news.lib.util.ActivityManager;
import com.yazao.news.lib.util.SmartBarUtils;
import com.yazao.news.lib.util.net.NetUtil;

import butterknife.ButterKnife;

/**
 * Created by shaopingzhai on 15/11/17.
 */
public abstract class YZBaseActivity extends AppCompatActivity {

	/**
	 * network status
	 */
	protected NetChangeObserver mNetChangeObserver = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Bundle
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			getBundleExtras(extras);
		}

		//Activity Manager
		ActivityManager.getInstance().addActivity(this);

		//NetWork Change Listener
		if (mNetChangeObserver == null) {
			mNetChangeObserver = new NetChangeObserver() {

				@Override
				public void onNetConnected(NetUtil.NetType type) {
					onNetWorkConneted(type);
				}

				@Override
				public void onNetDisConnect() {
					onNetWorkDisConneted();
				}
			};
		}
		NetChangeReceiver.registerObserver(mNetChangeObserver);

		//ActionBar
		SmartBarUtils.hide(getWindow().getDecorView());


		//set layout
		int layoutID = getContextViewLayoutID();
		if (layoutID != 0) {
			setContentView(layoutID);
		} else {
			throw new IllegalArgumentException("You must return a right ContentView Layout.");
		}

		initViewsAndEvents();
	}

	protected abstract void onNetWorkConneted(NetUtil.NetType type);

	protected abstract void onNetWorkDisConneted();

	protected abstract void getBundleExtras(Bundle extras);

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		ButterKnife.bind(this);
	}

	/**
	 * init
	 */
	protected abstract void initViewsAndEvents();

	protected abstract int getContextViewLayoutID();


	@Override
	protected void onDestroy() {
		super.onDestroy();
		ButterKnife.unbind(this);
		if (mNetChangeObserver != null) {
			NetChangeReceiver.unRegisterObserver(mNetChangeObserver);
		}
	}

	@Override
	public void finish() {
		super.finish();
		ActivityManager.getInstance().removeActivity(this);
	}
}
