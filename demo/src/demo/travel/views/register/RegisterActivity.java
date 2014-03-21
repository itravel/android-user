package demo.travel.views.register;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import demo.travel.R;

public class RegisterActivity extends ActionBarActivity implements
		OnClickListener {

	private Button mBtnRegisterPreStep;
	private Button mBtnRegisterNextStep;
	private int mCurrentIndex = 0;
	private List<Fragment> mFragmentList = new ArrayList<Fragment>();
	private Fragment mCurrentFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		initViews();
		initEvents();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		mFragmentList.add(new RegisterPhoneFragment());
		mFragmentList.add(new RegisterCodeFragment());
		mFragmentList.add(new RegisterPasswordFragment());
		mFragmentList.add(new RegisterBaseInfoFragment());
		mFragmentList.add(new RegisterPhotoFragment());

		if (savedInstanceState == null) {
			mCurrentFragment = mFragmentList.get(mCurrentIndex);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.register_content_frame, mCurrentFragment)
					.commit();
			initFragment();
		}
	}

	protected void initViews() {
		mBtnRegisterPreStep = (Button) findViewById(R.id.btn_register_pre_step);
		mBtnRegisterNextStep = (Button) findViewById(R.id.btn_register_next_step);
	}

	protected void initEvents() {
		mBtnRegisterPreStep.setOnClickListener(this);
		mBtnRegisterNextStep.setOnClickListener(this);
	}

	public void switchContent(Fragment from, Fragment to) {
		if (mCurrentFragment != to) {
			mCurrentFragment = to;
			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();
			if (!to.isAdded()) { // 先判断是否被add过
				transaction.hide(from).add(R.id.register_content_frame, to)
						.commit(); // 隐藏当前的fragment，add下一个到Activity中
			} else {
				transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
			}
		}
	}

	public void initFragment() {
		switchContent(mCurrentFragment, mFragmentList.get(mCurrentIndex));
		switch (mCurrentIndex) {
		case 0:
			getSupportActionBar().setTitle("注册新账号(1/5)");
			mBtnRegisterPreStep.setText("返    回");
			mBtnRegisterNextStep.setText("下一步");
			break;
		case 1:
			getSupportActionBar().setTitle("填写验证码(2/5)");
			mBtnRegisterPreStep.setText("上一步");
			mBtnRegisterNextStep.setText("下一步");
			break;
		case 2:
			getSupportActionBar().setTitle("设置密码(3/5)");
			mBtnRegisterPreStep.setText("上一步");
			mBtnRegisterNextStep.setText("下一步");
			break;
		case 3:
			getSupportActionBar().setTitle("填写基本资料(4/5)");
			mBtnRegisterPreStep.setText("上一步");
			mBtnRegisterNextStep.setText("下一步");
			break;
		case 4:
			getSupportActionBar().setTitle("设置头像(5/5)");
			mBtnRegisterPreStep.setText("上一步");
			mBtnRegisterNextStep.setText("完    成");
			break;
		}
	}

	public void prevStep() {
		if (mCurrentIndex == 0) {
			// mBackDialog.show();
		} else {
			mCurrentIndex--;
			initFragment();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register_pre_step:
			if (mCurrentIndex > 0) {
				prevStep();
			}
			break;
		case R.id.btn_register_next_step:
			if (mCurrentIndex < mFragmentList.size() - 1) {
				mCurrentIndex++;
				initFragment();
			}
			break;
		}
	}

	@Override
	public void onBackPressed() {
		prevStep();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			prevStep();
		}
		return false;
	}
}