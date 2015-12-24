package com.yazao.news.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.yazao.news.R;
import com.yazao.news.api.GlobalParams;
import com.yazao.news.bean.NavigationBean;
import com.yazao.news.lib.util.log.Log;
import com.yazao.news.lib.util.net.NetUtil;
import com.yazao.news.presenter.impl.YZMainPresenterImpl;
import com.yazao.news.ui.adapter.YZViewPagerAdapter;
import com.yazao.news.view.YZMainView;
import com.yazao.news.widget.XViewPager;

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

	@Bind(R.id.viewpager)
	XViewPager mViewPager;


	private ActionBarDrawerToggle toggle;
	private long BACK_PRESS_TIME = 0L;

	/**
	 * 当前选中的分类(新闻、视频和美图)
	 */
	private static int mCurrentSelectedCategory = 0;

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
				Snackbar.make(view, "Don't touch me", Snackbar.LENGTH_LONG)
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
	protected boolean isNoStateBar() {
		return false;
	}

	@Override
	protected boolean isFullScreen() {
		return false;
	}

	@Override
	protected boolean isNoTitle() {
		return false;
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
			if (mCurrentSelectedCategory == GlobalParams.YZ_CATEGORY_NEWS) {
				setTitle(item.getTitle());
				drawer.closeDrawer(GravityCompat.START);
				return true;
			}
			mCurrentSelectedCategory = GlobalParams.YZ_CATEGORY_NEWS;
		} else if (id == R.id.nav_video) {
			//视频
			if (mCurrentSelectedCategory == GlobalParams.YZ_CATEGORY_VIDEO) {
				setTitle(item.getTitle());
				drawer.closeDrawer(GravityCompat.START);
				return true;
			}
			mCurrentSelectedCategory = GlobalParams.YZ_CATEGORY_VIDEO;
		} else if (id == R.id.nav_img) {
			//美图
			if (mCurrentSelectedCategory == GlobalParams.YZ_CATEGORY_IMAGE) {
				setTitle(item.getTitle());
				drawer.closeDrawer(GravityCompat.START);
				return true;
			}
			mCurrentSelectedCategory = GlobalParams.YZ_CATEGORY_IMAGE;
		}  else if (id == R.id.nav_share) {
			//分享
			mCurrentSelectedCategory=-1;
		} else if (id == R.id.nav_about) {
			//关于
			mCurrentSelectedCategory=-1;
		}
		if (mCurrentSelectedCategory >= GlobalParams.YZ_CATEGORY_NEWS && mCurrentSelectedCategory <= GlobalParams.YZ_CATEGORY_IMAGE) {
			mViewPager.setCurrentItem(mCurrentSelectedCategory, false);
			setTitle(item.getTitle());
		}
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}


	@Override
	public void initPresenter() {
		mPresenter = new YZMainPresenterImpl(this, this);
		mPresenter.initialized();
	}

	@Override
	public void initMainView(List<Fragment> fragments, List<NavigationBean> navigationDatas) {

		mViewPager.setOffscreenPageLimit(1);

		YZViewPagerAdapter mViewPagerAdapter = new YZViewPagerAdapter(getSupportFragmentManager(), fragments);
		//取消当前页面中的viewpager 滑动功能，将这个滑动功能传递到 其子view 中。也就是事件传递下发给子view
		mViewPager.setIsEnableScroll(false);
		mViewPager.setAdapter(mViewPagerAdapter);

	}

	@Override
	public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onPostCreate(savedInstanceState, persistentState);
	}
}
