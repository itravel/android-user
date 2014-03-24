package demo.travel.views.register;

import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import demo.travel.R;

public class RegisterPhoneFragment extends RegisterBaseFragment implements
		TextWatcher {

	private EditText mEditTextRegisterPhoneArea;
	private EditText mEditTextRegisterPhone;
	private Button mBtnRegisterNextStep;

	private String mAreaCode = "+86";
	private String mPhone;
	private boolean mIsChange = true;

	@Override
	public int getLayoutId() {
		return R.layout.fragment_register_phone;
	}

	@Override
	public void initViews() {
		mEditTextRegisterPhoneArea = (EditText) findViewById(R.id.register_phone_area);
		mEditTextRegisterPhone = (EditText) findViewById(R.id.register_phone);

		mBtnRegisterNextStep = (Button) getActivity().findViewById(
				R.id.btn_register_next_step);
		if (mEditTextRegisterPhone.getText().length() == 0) {
			mBtnRegisterNextStep.setEnabled(false);
		} else {
			mBtnRegisterNextStep.setEnabled(true);
		}
	}

	@Override
	public void initEvents() {
		mEditTextRegisterPhone.addTextChangedListener(this);
	}

	@Override
	public boolean validate() {
		mPhone = null;
		if (isNull(mEditTextRegisterPhone)) {
			Toast.makeText(getActivity(), "请填写手机号码", Toast.LENGTH_SHORT).show();
			mEditTextRegisterPhone.requestFocus();
			return false;
		}
		String phone = mEditTextRegisterPhone.getText().toString().trim();
		if (matchPhone(mAreaCode + phone)) {
			mPhone = phone;
			return true;
		}
		Toast.makeText(getActivity(), "手机号码格式不正确", Toast.LENGTH_SHORT).show();
		mEditTextRegisterPhone.requestFocus();
		return false;
	}

	@Override
	public boolean isChange() {
		return mIsChange;
	}

	@Override
	public void nextStep() {
		mIsChange = false;
		showPhoneConfirmDialog();
	}

	public String getPhone() {
		return "(" + mEditTextRegisterPhoneArea.getText().toString() + ")"
				+ mEditTextRegisterPhone.getText().toString();
	}

	public void showPhoneConfirmDialog() {
		DialogFragment dialogFragment = PhoneConfirmDialogFragment
				.newInstance(((TextView) findViewById(R.id.register_phone))
						.getText().toString());
		dialogFragment.show(getActivity().getSupportFragmentManager(),
				"PhoneConfirmDialogFragment");
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

		if (mEditTextRegisterPhone.getText().length() == 0) {
			mBtnRegisterNextStep.setEnabled(false);
		} else {
			mBtnRegisterNextStep.setEnabled(true);
		}
	}

}
