package demo.travel.views.register;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import demo.travel.R;

public class RegisterCodeFragment extends RegisterBaseFragment {
	private TextView mTextViewRegisterCodePhone;
	private EditText mEditTextRegisterCode;

	private boolean mIsChange = true;
	private String mCode;

	public void initViews() {
		mTextViewRegisterCodePhone = (TextView) findViewById(R.id.register_code_phone);
		mTextViewRegisterCodePhone.setText(mActivity.getPhone());

		mEditTextRegisterCode = (EditText) findViewById(R.id.register_code);
	}

	public void initEvents() {

	}

	@Override
	public void nextStep() {
		mOnNextActionListener.next();
	}
	
	@Override
	public int getLayoutId() {
		return R.layout.fragment_register_code;
	}

	@Override
	public boolean validate() {
		if (isNull(mEditTextRegisterCode)) {
			Toast.makeText(getActivity(), "请输入验证码", Toast.LENGTH_SHORT).show();
			mEditTextRegisterCode.requestFocus();
			return false;
		}
		mCode = mEditTextRegisterCode.getText().toString().trim();
		return true;
	}

	@Override
	public boolean isChange() {
		return mIsChange;
	}
}
