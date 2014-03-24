package demo.travel.views.register;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import demo.travel.R;
import demo.travel.views.register.RegisterBaseFragment.onNextActionListener;

public class RegisterActivity extends ActionBarActivity implements
		OnClickListener, onNextActionListener, BackDialogFragment.BackDialogListener,
		PhoneConfirmDialogFragment.PhoneConfirmDialogListener {

	private Button mBtnRegisterPreStep;
	private Button mBtnRegisterNextStep;
	private int mCurrentIndex = 0;
	private List<RegisterBaseFragment> mFragmentList = new ArrayList<RegisterBaseFragment>();
	private RegisterBaseFragment mCurrentFragment;
	private RegisterBaseFragment mRegisterPhoneFragment;
	private RegisterBaseFragment mRegisterCodeFragment;
	private RegisterBaseFragment mRegisterPasswordFragment;
	private RegisterBaseFragment mRegisterBaseInfoFragment;
	private RegisterBaseFragment mRegisterPhotoFragment;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		initViews();
		initEvents();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		mRegisterPhoneFragment = new RegisterPhoneFragment();
		mRegisterCodeFragment = new RegisterCodeFragment();
		mRegisterPasswordFragment = new RegisterPasswordFragment();
		mRegisterBaseInfoFragment = new RegisterBaseInfoFragment();
		mRegisterPhotoFragment = new RegisterPhotoFragment();
		
		mFragmentList.add(mRegisterPhoneFragment);
		mFragmentList.add(mRegisterCodeFragment);
		mFragmentList.add(mRegisterPasswordFragment);
		mFragmentList.add(mRegisterBaseInfoFragment);
		mFragmentList.add(mRegisterPhotoFragment);
		
		for (RegisterBaseFragment f : mFragmentList) {
			f.setOnNextActionListener(this);
		}

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

	public void switchContent(RegisterBaseFragment from, RegisterBaseFragment to) {
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

	public RegisterBaseFragment initFragment() {
		RegisterBaseFragment fragment = (RegisterBaseFragment) mFragmentList.get(mCurrentIndex);
		switchContent(mCurrentFragment, fragment);
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
		return fragment;
	}

	public void prevStep() {
		if (mCurrentIndex > 0) {
			if (mCurrentIndex == 0) {
				// mBackDialog.show();
			} else {
				mCurrentIndex--;
				initFragment();
			}
		} else {
			showBackDialog();
		}
	}

	public void nextStep() {
		if (mCurrentIndex < mFragmentList.size() - 1) {
			if (mCurrentFragment.validate()) {
				if (mCurrentFragment.isChange()) {
					mCurrentFragment.nextStep();
				} else {
					next();
				}
			}
			
//			if (mCurrentIndex == 0) {
//				showPhoneConfirmDialog();
//			} else {
//				mCurrentIndex++;
//				initFragment();
//			}
		}
	}

	public void showBackDialog() {
		// Create an instance of the dialog fragment and show it
		DialogFragment dialog = new BackDialogFragment();
		dialog.show(getSupportFragmentManager(), "BackDialogFragment");
	}

	public void showPhoneConfirmDialog() {
		DialogFragment dialogFragment = PhoneConfirmDialogFragment
				.newInstance(((TextView) findViewById(R.id.register_phone))
						.getText().toString());
		dialogFragment.show(getSupportFragmentManager(),
				"PhoneConfirmDialogFragment");
	}
	
	public String getPhone() {
		return ((RegisterPhoneFragment)mRegisterPhoneFragment).getPhone();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register_pre_step:
			prevStep();
			break;
		case R.id.btn_register_next_step:
			nextStep();
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

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		String tag = dialog.getTag();

		if (tag == "BackDialogFragment") {
			this.finish();
		} else if (tag == "PhoneConfirmDialogFragment") {
			mCurrentIndex++;
			initFragment();
		}
	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {

	}

	@Override
	public void next() {
		mCurrentIndex++;
		mCurrentFragment = initFragment();
	}
}