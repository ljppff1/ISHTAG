package com.example.ishtag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends Activity {

	private Button mBtnLogin;
	private Button mBtnLogin1;
	private ImageView mIvwhat;
	private Button mBtnLogin2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		
		initView();
		
		
	}

	private void initView() {
		mBtnLogin =(Button)this.findViewById(R.id.mBtnLogin);
		mBtnLogin.setOnClickListener(listener);
		mBtnLogin1 =(Button)this.findViewById(R.id.mBtnLogin1);
		mBtnLogin1.setOnClickListener(listener);
		mBtnLogin2 =(Button)this.findViewById(R.id.mBtnLogin2);
		mBtnLogin2.setOnClickListener(listener);
		

	}

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mBtnLogin:
				startActivity(new Intent(getApplicationContext(), TZ4_1Activity.class));

				break;
			case R.id.mBtnLogin1:
				startActivity(new Intent(getApplicationContext(), ChoiceWhat2Activity.class));
				break;
			case R.id.mBtnLogin2:
				startActivity(new Intent(getApplicationContext(), TZ4_2Activity.class));
				break;

			default:
				break;
			}
		}
	};
}
