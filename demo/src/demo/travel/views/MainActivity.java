package demo.travel.views;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import demo.travel.R;
import demo.travel.adapters.MainFragmentPagerAdapter;

public class MainActivity extends ActionBarActivity implements
		ActionBar.TabListener {

	MainFragmentPagerAdapter mMainFragmentPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ActionBar actionBar = getSupportActionBar();

		// ViewPager and its adapters use support library
		// fragments, so use getSupportFragmentManager.
		mMainFragmentPagerAdapter = new MainFragmentPagerAdapter(
				getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mMainFragmentPagerAdapter);

		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						// When swiping between pages, select the
						// corresponding tab.
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// setup action bar for tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab tab = actionBar.newTab().setText(R.string.home)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.explore).setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.biz).setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.me).setTabListener(this);
		actionBar.addTab(tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/* The following are each of the ActionBar.TabListener callbacks */

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
}
