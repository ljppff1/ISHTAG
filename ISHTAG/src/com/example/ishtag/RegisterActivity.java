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
import android.widget.RelativeLayout;

public class RegisterActivity extends Activity {

	private Button mBtnRegister;
	private RelativeLayout mRlr1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.register);
		
		initView();
		
		
	}

	private void initView() {
		mBtnRegister =(Button)this.findViewById(R.id.mBtnRegister);
		mBtnRegister.setOnClickListener(listener);
		
		mRlr1 =(RelativeLayout)this.findViewById(R.id.mRlr1);
		mRlr1.setOnClickListener(listener);
		
		
	}

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mBtnRegister:
				startActivity(new Intent(getApplicationContext(), TZ4_1Activity.class));
				break;

			default:
				break;
			}
		}
	};
}
