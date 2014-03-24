package demo.travel.views.register;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class PhoneConfirmDialogFragment extends DialogFragment {

	public static PhoneConfirmDialogFragment newInstance(String phone) {  
		PhoneConfirmDialogFragment fragment = new PhoneConfirmDialogFragment();  
        Bundle args = new Bundle();  
        args.putString("phone", phone);
        fragment.setArguments(args);  
        return fragment;  
    }
	
	public interface PhoneConfirmDialogListener {
		public void onDialogPositiveClick(DialogFragment dialog);

		public void onDialogNegativeClick(DialogFragment dialog);
	}

	PhoneConfirmDialogListener mListener;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		String phone = getArguments().getString("phone"); 
		
		builder.setTitle("确认手机号码").setMessage("我们将发送验证码短信到这个号码：" + phone)
				.setPositiveButton("确认", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						mListener.onDialogPositiveClick(PhoneConfirmDialogFragment.this);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						mListener.onDialogNegativeClick(PhoneConfirmDialogFragment.this);
					}
				});
		// Create the AlertDialog object and return it
		return builder.create();
	}

	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Verify that the host activity implements the callback interface
		try {
			// Instantiate the NoticeDialogListener so we can send events to the
			// host
			mListener = (PhoneConfirmDialogListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}
}
