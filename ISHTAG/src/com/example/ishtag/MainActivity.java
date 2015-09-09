package com.example.ishtag;


import java.util.ArrayList;

import com.example.fragment.*;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity  {

	private Fragment1 f1;
	private Fragment2 f2;
	private Fragment3 f3;
	private Fragment4 f4;
	private RadioGroup group;
	private ArrayList<Fragment> fragments;
	private long exitTime = 0;
	private ImageView mIvwhat1;
	private ImageView mIvwhat2;
	private ImageView mIvwhat3;
	private ImageView mIvwhat4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initViews();
		
		fragments = new ArrayList<Fragment>();
		fragments.add(f1);
		fragments.add(f2);
		fragments.add(f3);
		fragments.add(f4);
		

		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		Fragment fragment = null;
		fragment = fragments.get(0);
		transaction.replace(R.id.main_framelayout, fragment);
		transaction.commit();

		
	}

	private void initViews() {
		f1 =new Fragment1();
		f2 =new Fragment2();
		f3 =new Fragment3();
		f4 =new Fragment4();
		mIvwhat1 =(ImageView)this.findViewById(R.id.mIvwhat1);
		mIvwhat2 =(ImageView)this.findViewById(R.id.mIvwhat2);
		mIvwhat3 =(ImageView)this.findViewById(R.id.mIvwhat3);
		mIvwhat4 =(ImageView)this.findViewById(R.id.mIvwhat4);
		mIvwhat1.setOnClickListener(listener);
		mIvwhat2.setOnClickListener(listener);
		mIvwhat3.setOnClickListener(listener);
		mIvwhat4.setOnClickListener(listener);
	}

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			FragmentManager manager = getSupportFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			Fragment fragment = null;

			switch (v.getId()) {
			
			case R.id.mIvwhat1:
				fragment = fragments.get(0);
				transaction.replace(R.id.main_framelayout, new Fragment1());
				transaction.commit();
				break;
			case R.id.mIvwhat2:
				fragment = fragments.get(1);
				transaction.replace(R.id.main_framelayout, fragment);
				transaction.commit();
				break;
			case R.id.mIvwhat3:
				fragment = fragments.get(2);
				transaction.replace(R.id.main_framelayout, fragment);
				transaction.commit();

				break;
			case R.id.mIvwhat4:
				fragment = fragments.get(3);
				transaction.replace(R.id.main_framelayout, fragment);
				transaction.commit();
				break;

			default:
				break;
			}
		}
	};
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK){
			if((System.currentTimeMillis() - exitTime) > 2000){
				//Toast.makeText(getApplicationContext(), R.string.toast, 1).show();
				exitTime = System.currentTimeMillis();
				}else{
					finish();
					android.os.Process.killProcess(android.os.Process.myPid());
				}
			return true;
			}
		return super.dispatchKeyEvent(event);
	}
	

	
}
