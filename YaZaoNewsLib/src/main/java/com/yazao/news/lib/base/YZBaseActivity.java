package com.yazao.news.lib.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yazao.news.lib.net.NetChangeObserver;
import com.yazao.news.lib.net.NetChangeReceiver;
import com.yazao.news.lib.util.ActivityManager;
import com.yazao.news.lib.util.SmartBarUtils;
import com.yazao.news.lib.net.NetUtil;

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
		if (isNoTitle()){
		 	/*set it to be no title*/
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		super.onCreate(savedInstanceState);
		if (isNoStateBar()){
//			View doctorView =findViewById(android.R.id.content);
			View doctorView =getWindow().getDecorView();
			doctorView.setSystemUiVisibility(View.INVISIBLE);
		}
		if (isFullScreen()){
	   		/*set it to be full screen*/
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);

		}

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
		int layoutID = getContentViewLayoutID();
		if (layoutID != 0) {
			setContentView(layoutID);
		} else {
			throw new IllegalArgumentException("You must return a right ContentView Layout.");
		}

		initViewsAndEvents();
	}

	protected abstract boolean isNoStateBar();

	protected abstract boolean isFullScreen();

	protected abstract boolean isNoTitle();

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

	protected abstract int getContentViewLayoutID();


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
