package demo.travel.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import demo.travel.views.BizFragment;
import demo.travel.views.ExploreFragment;
import demo.travel.views.HomeFragment;
import demo.travel.views.MeFragment;

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {
	private final int NUM_ITEMS = 4;

	public MainFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = null;
		switch (i) {
		case 0:
			fragment = new HomeFragment();
			break;
		case 1:
			fragment = new ExploreFragment();
			break;
		case 2:
			fragment = new BizFragment();
			break;
		case 3:
			fragment = new MeFragment();
			break;
		}

		// Fragment fragment = new DemoObjectFragment();
		// Bundle args = new Bundle();
		// // Our object is just an integer :-P
		// args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
		// fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return NUM_ITEMS;
	}
}
