package com.example.ishtag;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.fragment.Fragment1a;
import com.example.fragment.Fragment1b;
import com.example.fragment.Fragment1c;
import com.example.fragment.Fragment2a;
import com.example.fragment.Fragment2b;
import com.example.ishtag.TZ4_1sdActivity.ZxzcAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TZ4_2cActivity extends FragmentActivity {

	private Button mBtnRegister;
	private ImageView mTIvt41h1;
	private ImageView mTIvt41f;
	private ImageView mTIvt41g;
	private ImageView mTIvt41c;
	private ImageView mTIvt41b;
	private ImageView mTIvt41d;
	private ImageView mTIvt41a;
	private ImageView mTIvt41e;
	private GridView mGvm1;
	private RadioGroup rg1;
	private RadioButton rb1;
	private RadioButton rb2;
	private ViewPager vp;
	private ArrayList<Fragment> list;
	private Fragment2a fa;
	private Fragment2b fb;

	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG/";
	private File tempFile1;
	private ImageView mTIvt41i;
	private static final int TAKE_PICTURE = 0x000001;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t42c);
		
		initView();
		
		
	}

	private void initView() {
		mTIvt41f =(ImageView)this.findViewById(R.id.mTIvt41f);
		mTIvt41f.setOnClickListener(listener);
		mTIvt41h1 =(ImageView)this.findViewById(R.id.mTIvt41h1);
		mTIvt41h1.setOnClickListener(listener);
		mTIvt41g =(ImageView)this.findViewById(R.id.mTIvt41g);
		mTIvt41g.setOnClickListener(listener);
		mTIvt41i =(ImageView)this.findViewById(R.id.mTIvt41i);
		mTIvt41i.setOnClickListener(listener);

		
		mTIvt41c =(ImageView)this.findViewById(R.id.mTIvt41c);
		mTIvt41c.setOnClickListener(listener);
		mTIvt41b =(ImageView)this.findViewById(R.id.mTIvt41b);
		mTIvt41b.setOnClickListener(listener);
		mTIvt41d =(ImageView)this.findViewById(R.id.mTIvt41d);
		mTIvt41d.setOnClickListener(listener);
		mTIvt41a =(ImageView)this.findViewById(R.id.mTIvt41a);
		mTIvt41a.setOnClickListener(listener);
		mTIvt41e =(ImageView)this.findViewById(R.id.mTIvt41e);
		mTIvt41e.setOnClickListener(listener);


		rg1 = (RadioGroup) this.findViewById(R.id.rg1);
		rb1 = (RadioButton) this.findViewById(R.id.rb1);
		rb2 = (RadioButton) this.findViewById(R.id.rb2);
		vp=(ViewPager)this.findViewById(R.id.vp1);
	    vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				if (arg0==0) {
		             rb1.setChecked(true);
					}
					if(arg0==1){
						rb2.setChecked(true);
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

		list = new ArrayList<Fragment>();
		 fa=new Fragment2a();
		 fb=new Fragment2b();
		list.add(fa);
		list.add(fb);
        
		ZxzcAdapter zxzc = new ZxzcAdapter(getSupportFragmentManager(), list);
		vp.setAdapter(zxzc);
		zxzc.notifyDataSetChanged();
		rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int cheakedId) {
				if (cheakedId == rb1.getId()) {
					vp.setCurrentItem(0);
				} else if (cheakedId == rb2.getId()) {
					vp.setCurrentItem(1);
				}
							
			}
		});
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


	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mTIvt41i:
				startActivity(new Intent(getApplicationContext(), TZ4_2iActivity.class));
				break;

			case R.id.mTIvt41f:
				startActivity(new Intent(getApplicationContext(), TZ4_2Activity.class));
				break;
			case R.id.mTIvt41h1:
				startActivity(new Intent(getApplicationContext(), TZ4_2sActivity.class));
				break;
				
			case R.id.mTIvt41c:
				startActivity(new Intent(getApplicationContext(), TZ4_2cActivity.class));
				break;
			case R.id.mTIvt41b:
				startActivity(new Intent(getApplicationContext(), TZ4_2bActivity.class));
				break;
			case R.id.mTIvt41d:
				startActivity(new Intent(getApplicationContext(), TZ4_2dActivity.class));
				break;
			case R.id.mTIvt41a:
				startActivity(new Intent(getApplicationContext(), TZ4_2aActivity.class));
				break;
			case R.id.mTIvt41e:
				startActivity(new Intent(getApplicationContext(), TZ4_2eActivity.class));
				break;
			case R.id.mTIvt41g:
				  photo();
				break;


			default:
				break;
			}
		}
	};
	


	private void photo() {
		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		String fileName = String.valueOf(System.currentTimeMillis());
		if (!com.example.utils.FileUtils.isFileExist("")) {
			try {
				File tempf = com.example.utils.FileUtils.createSDDir("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		File f = new File(SDPATH, fileName + ".jpg"); 
		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
				Uri.fromFile(f));
		tempFile1=f;

		startActivityForResult(openCameraIntent, TAKE_PICTURE);

	}

protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	switch (requestCode) {
	case TAKE_PICTURE:
		//	Bitmap bitmap = BitmapFactory.decodeFile(tempFile1.getPath());
		//Toast.makeText(getApplicationContext(), tempFile1.getPath(), 1).show();
            Intent intent =new Intent(getApplicationContext(), TZ4_2pActivity.class);
            intent.putExtra("PATH", tempFile1.getPath());
            startActivity(intent);
		break;
	}
}
}
