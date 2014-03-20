package demo.travel.views.explore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import demo.travel.R;

public class DestActivity extends FragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_explore_destination);
		
		Fragment fragment = new DestMapFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.activity_explore_destination, fragment).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_explore_sub_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_switch_list:
			switch2list();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void switch2list() {
		Fragment newFragment = new DestListFragment();
		Bundle args = new Bundle();
		args.putInt("hello", 0);
		newFragment.setArguments(args);
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.activity_explore_destination, newFragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}