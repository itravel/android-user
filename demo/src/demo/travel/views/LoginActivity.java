package demo.travel.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import demo.travel.R;
import demo.travel.adapters.MainFragmentPagerAdapter;

public class LoginActivity extends ActionBarActivity {

	MainFragmentPagerAdapter mMainFragmentPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.login_content_frame, new LoginFragment())
					.commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static class LoginFragment extends Fragment implements
			OnClickListener {
		private View mRootView = null;

		public LoginFragment() {
		}

		private void initUI() {
			Button loginBtn = (Button) mRootView.findViewById(R.id.btn_login);
			loginBtn.setOnClickListener(this);

			Button registerBtn = (Button) mRootView
					.findViewById(R.id.btn_register);
			registerBtn.setOnClickListener(this);

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			mRootView = inflater.inflate(R.layout.fragment_login, container,
					false);

			initUI();
			return mRootView;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_login:
				break;
			case R.id.btn_register:
				break;
			default:
				break;
			}
		}
	}

}
