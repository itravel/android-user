package demo.travel.views.register;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import demo.travel.R;

public class RegisterPasswordFragment extends RegisterBaseFragment implements
		TextWatcher {

	private EditText mEditTextRegisterPassword;
	private EditText mEditTextRegisterPasswordConfirm;

	private boolean mIsChange = true;

	public void initViews() {
		mEditTextRegisterPassword = (EditText) findViewById(R.id.register_password);
		mEditTextRegisterPasswordConfirm = (EditText) findViewById(R.id.register_password_confirm);
	}

	public void initEvents() {
		mEditTextRegisterPassword.addTextChangedListener(this);
		mEditTextRegisterPasswordConfirm.addTextChangedListener(this);
	}

	@Override
	public void nextStep() {
		mIsChange = false;
		mOnNextActionListener.next();
	}
	
	@Override
	public int getLayoutId() {
		return R.layout.fragment_register_password;
	}

	@Override
	public boolean validate() {
		String pwd = null;
		String rePwd = null;
		if (isNull(mEditTextRegisterPassword)) {
			Toast.makeText(getActivity(), "请输入密码", Toast.LENGTH_SHORT).show();
			mEditTextRegisterPassword.requestFocus();
			return false;
		} else {
			pwd = mEditTextRegisterPassword.getText().toString().trim();
			if (pwd.length() < 6) {
				Toast.makeText(getActivity(), "密码不能小于6位", Toast.LENGTH_SHORT)
						.show();
				mEditTextRegisterPassword.requestFocus();
				return false;
			}
		}
		if (isNull(mEditTextRegisterPasswordConfirm)) {
			Toast.makeText(getActivity(), "请重复输入一次密码", Toast.LENGTH_SHORT)
					.show();

			mEditTextRegisterPasswordConfirm.requestFocus();
			return false;
		} else {
			rePwd = mEditTextRegisterPasswordConfirm.getText().toString()
					.trim();
			if (!pwd.equals(rePwd)) {
				Toast.makeText(getActivity(), "两次输入的密码不一致", Toast.LENGTH_SHORT)
						.show();
				mEditTextRegisterPasswordConfirm.requestFocus();
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isChange() {
		return mIsChange;
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
