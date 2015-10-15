package com.example.ishtag;

import com.example.utils.TypeFace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChoiceWhat2Activity extends BaseActivity {

	private Button mBtnCW2;
	private Button mBtnCW1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.choicewhat2);
		
		initView();
		
		
	}

	private void initView() {
		mBtnCW1 =(Button)this.findViewById(R.id.mBtnCW1);
		mBtnCW1.setOnClickListener(listener);
		mBtnCW2 =(Button)this.findViewById(R.id.mBtnCW2);
		mBtnCW2.setOnClickListener(listener);
		mBtnCW1.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		mBtnCW2.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));

		
	}

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mBtnCW1:
				startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
				break;
			case R.id.mBtnCW2:
				startActivity(new Intent(getApplicationContext(), Register1Activity.class));
				break;

			default:
				break;
			}
		}
	};
}
