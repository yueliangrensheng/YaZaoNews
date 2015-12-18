package com.yazao.news.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.yazao.news.R;
import com.yazao.news.bean.NavigationBean;
import com.yazao.news.lib.util.log.Log;
import com.yazao.news.lib.util.net.NetUtil;
import com.yazao.news.presenter.impl.YZMainPresenterImpl;
import com.yazao.news.ui.fragment.YZMainNewsFragment;
import com.yazao.news.view.YZMainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<YZMainPresenterImpl>
		implements NavigationView.OnNavigationItemSelectedListener, YZMainView {

	@Bind(R.id.toolbar)
	Toolbar toolbar;
	@Bind(R.id.fab)
	FloatingActionButton fab;
	@Bind(R.id.drawer_layout)
	DrawerLayout drawer;
	@Bind(R.id.nav_view)
	NavigationView navigationView;

	@Bind(R.id.contentView)
	FrameLayout contentView;

	private ActionBarDrawerToggle toggle;

	private long BACK_PRESS_TIME = 0L;


	@Override
	protected void initViewsAndEvents() {
		if (null != toolbar) {
			setSupportActionBar(toolbar);
			getSupportActionBar().setHomeButtonEnabled(true); //actionBar是否可以点击
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);//是否显示actionbar
		}

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		setDrawerToggle();

	}

	@Override
	protected int getContextViewLayoutID() {
		return R.layout.activity_main;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onNetWorkConneted(NetUtil.NetType type) {
		Log.i("网络连接成功： " + type.toString());
	}

	@Override
	protected void onNetWorkDisConneted() {
		Log.i("网络断开连接 ");
	}

	@Override
	protected void getBundleExtras(Bundle extras) {

	}

	private void setDrawerToggle() {

		toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				setTitle(R.string.app_name);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);

			}
		};
		drawer.setDrawerListener(toggle);
		if (toggle != null) {
			toggle.syncState();
		}

		navigationView.setNavigationItemSelectedListener(this);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		if (toggle != null) {
			//This should be called from your Activity's onPostCreate method to synchronize after
			// the DrawerLayout's instance state has been restored, and any other time when the state
			// may have diverged in such a way that the ActionBarDrawerToggle was not notified.
			toggle.syncState();
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		if (toggle != null) {
			toggle.syncState();
		}
	}

	@Override
	public void onBackPressed() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			//判断menu是否弹出
			//点击两次退出应用
			if (BACK_PRESS_TIME + 2000 > System.currentTimeMillis()) {
				//退出
				super.onBackPressed();
				android.os.Process.killProcess(Process.myPid());
				System.exit(0);
			} else {
				//提示再次返回
				Toast.makeText(MainActivity.this, "再次点击退出应用", Toast.LENGTH_SHORT).show();
				BACK_PRESS_TIME = System.currentTimeMillis();
			}

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_news) {
			//新闻
			YZMainNewsFragment newsFragment = new YZMainNewsFragment();
			getSupportFragmentManager().beginTransaction().replace(R.id.contentView, newsFragment).commit();
		} else if (id == R.id.nav_video) {
			//视频
			YZMainNewsFragment newsFragment = new YZMainNewsFragment();
			getSupportFragmentManager().beginTransaction().replace(R.id.contentView, newsFragment).commit();
		} else if (id == R.id.nav_img) {
			//美图
		} else if (id == R.id.nav_manage) {

		} else if (id == R.id.nav_share) {
			//分享
		} else if (id == R.id.nav_about) {
			//关于
		}
		setTitle(item.getTitle());
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}


	@Override
	public void initPresenter() {
		mPresenter = new YZMainPresenterImpl(this, this);
		mPresenter.initialized();
	}

	@Override
	public void initMainView(List<NavigationBean> navigationDatas, List<String> newsCategoryData) {

		YZMainNewsFragment newsFragment = new YZMainNewsFragment();
		Bundle bundle = new Bundle();
		bundle.putStringArrayList("newsCategoryData", (ArrayList) newsCategoryData);
		newsFragment.setArguments(bundle);
		getSupportFragmentManager().beginTransaction().replace(R.id.contentView, newsFragment).commit();

	}


}
