package com.example.ishtag1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.fragment.Fragment2a;
import com.example.fragment.Fragment2b;
import com.example.fragment.Fragment51m1;
import com.example.fragment.Fragment51m2;
import com.example.fragment.Fragment51m2p;
import com.example.fragment.Fragment51m3;
import com.example.fragment.Fragment51m4;
import com.example.fragment.Fragment51m4p;
import com.example.fragment.Fragment51m5;
import com.example.ishtag.R;
import com.example.ishtag.TZ4_1pActivity;
import com.example.ishtag.TZ4_1sActivity;
import com.example.utils.AppManager;
import com.example.utils.TypeFace;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TZ5_1mpActivity extends FragmentActivity {
	private File tempFile1;
	private static final int TAKE_PICTURE = 0x000001;

	private Button mBtnRegister;
	private ViewPager vp;
	private Fragment51m1 f1;
	private Fragment51m2p f2;
	private ArrayList<Fragment> list;
	private Fragment51m3 f3;
	private Fragment51m4p f4;
	private Fragment51m5 f5;
	private RadioGroup rg1;
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private RadioButton rb4;
	private RadioButton rb5;
	private TextView mTvt1;
	private Typeface face1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AppManager.getAppManager().addActivity(this);

		setContentView(R.layout.t51mp);
		
		initView();
		
		
	}
	
	private void initView() {
		mTvt1 =(TextView)this.findViewById(R.id.mTvt1);
		face1 =new TypeFace().getTypeFace2(getApplicationContext());

		mTvt1.setTypeface (face1);

		
		vp=(ViewPager)this.findViewById(R.id.vp1);
		list = new ArrayList<Fragment>();
		 f1=new Fragment51m1();
		 f2=new Fragment51m2p();
		 f3=new Fragment51m3();
		 f4=new Fragment51m4p();
		 f5=new Fragment51m5();
		list.add(f1);
		list.add(f2);
		list.add(f5);
		list.add(f4);
		list.add(f3);
		rg1 = (RadioGroup) this.findViewById(R.id.rg1);
		rb1 = (RadioButton) this.findViewById(R.id.rb1);
		rb2 = (RadioButton) this.findViewById(R.id.rb2);
		rb3 = (RadioButton) this.findViewById(R.id.rb3);
		rb4 = (RadioButton) this.findViewById(R.id.rb4);
		rb5 = (RadioButton) this.findViewById(R.id.rb5);

		ZxzcAdapter zxzc = new ZxzcAdapter(getSupportFragmentManager(), list);
		vp.setAdapter(zxzc);
	    vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				if (arg0==0) {
		             rb1.setChecked(true);
					}
				if(arg0==1){
					rb2.setChecked(true);
				}
				if(arg0==2){
					rb3.setChecked(true);
				}
				if(arg0==3){
					rb4.setChecked(true);
				}
				if(arg0==4){
					rb5.setChecked(true);
				}

			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int cheakedId) {
				if (cheakedId == rb1.getId()) {
					vp.setCurrentItem(0);
				} else if (cheakedId == rb2.getId()) {
					vp.setCurrentItem(1);
				}else if (cheakedId == rb3.getId()) {
					vp.setCurrentItem(2);
				}else if (cheakedId == rb4.getId()) {
					vp.setCurrentItem(3);
				}else if (cheakedId == rb5.getId()) {
					vp.setCurrentItem(4);
				}
							
			}
		});

		
		
		zxzc.notifyDataSetChanged();

		rb1.setChecked(true);
		
	}
class ZxzcAdapter extends FragmentStatePagerAdapter {
		   
		
		List<Fragment> list;			
		public ZxzcAdapter(FragmentManager fm,List<Fragment> list) {
			super(fm);
			this.list=list;			
		}
		@SuppressLint("ResourceAsColor")
		@Override
		public Fragment getItem(int arg0) {		
			return list.get(arg0);
		}
		@Override
		public int getCount() {
		
			return list.size();
		}

	}
}
