package demo.travel.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import demo.travel.R;
import demo.travel.views.register.RegisterActivity;

public class WelcomeActivity extends Activity implements OnClickListener {
	private Button mBtnLogin;
	private Button mBtnRegister;
	private Button mBtnTest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		initViews();
		initEvents();
	}

	protected void initViews() {
		mBtnLogin = (Button) findViewById(R.id.btn_welcome_login);
		mBtnRegister = (Button) findViewById(R.id.btn_welcome_register);
		
		mBtnTest = (Button) findViewById(R.id.btn_test_go_main);
	}

	protected void initEvents() {
		mBtnRegister.setOnClickListener(this);
		mBtnLogin.setOnClickListener(this);
		
		mBtnTest.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_welcome_login:
			intent = new Intent();
			intent.setClass(this, LoginActivity.class);
			startActivity(intent);
			break;

		case R.id.btn_welcome_register:
			intent = new Intent();
			intent.setClass(this, RegisterActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_test_go_main:
			intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			break;
		}
	}
}
