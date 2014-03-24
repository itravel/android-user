package demo.travel.views.register;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import demo.travel.R;

public class RegisterBaseInfoFragment extends RegisterBaseFragment implements
		TextWatcher, OnCheckedChangeListener {

	private EditText mEditTextUserName;
	private RadioGroup mRgGender;
	private RadioButton mRbMale;
	private RadioButton mRbFemale;

	private boolean mIsChange = true;

	@Override
	public int getLayoutId() {
		return R.layout.fragment_register_base_info;
	}

	@Override
	public void initViews() {
		mEditTextUserName = (EditText) findViewById(R.id.register_user_name);
		mRgGender = (RadioGroup) findViewById(R.id.register_gender);
		mRbMale = (RadioButton) findViewById(R.id.register_gender_male);
		mRbFemale = (RadioButton) findViewById(R.id.register_gender_female);
	}

	@Override
	public void initEvents() {
		mEditTextUserName.addTextChangedListener(this);
		mRgGender.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean validate() {
		if (isNull(mEditTextUserName)) {
			Toast.makeText(getActivity(), "请输入用户名", Toast.LENGTH_SHORT).show();
			mEditTextUserName.requestFocus();
			return false;
		}
		if (mRgGender.getCheckedRadioButtonId() < 0) {
			Toast.makeText(getActivity(), "请选择性别", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	@Override
	public boolean isChange() {
		return mIsChange;
	}

	@Override
	public void nextStep() {
		mIsChange = false;
		mOnNextActionListener.next();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		mIsChange = true;
		switch (checkedId) {
		case R.id.register_gender_male:
			mRbMale.setChecked(true);
			break;

		case R.id.register_gender_female:
			mRbFemale.setChecked(true);
			break;
		}
	}

	@Override
	public void afterTextChanged(Editable s) {

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		mIsChange = true;
	}
}
