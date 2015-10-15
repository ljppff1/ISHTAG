package com.example.ishtag1;

import java.io.File;
import java.io.IOException;

import com.example.ishtag.BaseActivity;
import com.example.ishtag.GuangZhu1;
import com.example.ishtag.PingLun1;
import com.example.ishtag.R;
import com.example.ishtag.TZ4_1Activity;
import com.example.ishtag.TZ4_1iActivity;
import com.example.ishtag.TZ4_1pActivity;
import com.example.ishtag.TZ4_1sActivity;
import com.example.ishtag.TZ4_2pActivity;
import com.example.ishtag.TZ4_2sActivity;
import com.example.utils.TypeFace;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TZ5_2Activity extends BaseActivity {

	private ImageView mTIvt41h1;
	private ImageView mTIvt41f;
	private ImageView mTIvt41g;
	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG/";
	private File tempFile1;
	private ImageView mTIvt41i;
	private ListView mLv;
	private Myadapter myadapter;
	private int width;
	private RelativeLayout edittext_layout;
	private EditText mEt51;
	private Button mbtsend;
	private Typeface face1;
	private Typeface face2;
	private ImageView mIvwhat;
	private static final int TAKE_PICTURE = 0x000001;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t52);
		face1 =new TypeFace().getTypeFace2(getApplicationContext());
		face2 =new TypeFace().getTypeFace1(getApplicationContext());

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE); 
         width = wm.getDefaultDisplay().getWidth();//фад╩©М╤х 

		initView();
		
		
	}
	
	private void initView() {
		edittext_layout = (RelativeLayout) findViewById(R.id.edittext_layout);
		mEt51 =(EditText)this.findViewById(R.id.mEt51);
		mbtsend =(Button)this.findViewById(R.id.mbtsend);
		mbtsend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 View view = getWindow().peekDecorView();
			        if (view != null) {
			            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
			        }
			        edittext_layout.setVisibility(View.GONE);
			}
		});
		mLv =(ListView)this.findViewById(R.id.mLv);
	       myadapter = new Myadapter();
	       mLv.setAdapter(myadapter);
	       mLv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent,
						View view, int position, long id) {
				}
			});
			mIvwhat=(ImageView)this.findViewById(R.id.mIvwhat);
			mIvwhat.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mLv.setSelection(0);
				}
			});

		mTIvt41h1 =(ImageView)this.findViewById(R.id.mTIvt41h1);
		mTIvt41h1.setOnClickListener(listener);
		
		mTIvt41f =(ImageView)this.findViewById(R.id.mTIvt41f);
		mTIvt41f.setOnClickListener(listener);
		mTIvt41g =(ImageView)this.findViewById(R.id.mTIvt41g);
		mTIvt41g.setOnClickListener(listener);
		mTIvt41i =(ImageView)this.findViewById(R.id.mTIvt41i);
		mTIvt41i.setOnClickListener(listener);


	}
	class Holder{
		TextView mTvattep,mTvri10,mTvri11,mTvri12,mTIvt41h,mTIvt41o1,mTy1,mTIvt41q,mTIvt41o,mTIvt41q1;
		ImageView imageView,mTIvt41n1,mTIvt41n;
		LinearLayout mRlc1;
		RelativeLayout mRlt51a;
	}
	class  Myadapter extends   BaseAdapter{
		@SuppressLint("NewApi")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Holder holder = null;
			if(convertView==null){
				convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_listview_t52, null);
				holder = new Holder();
/*				holder.mTvri10 =(TextView)convertView.findViewById(R.id.mTvri10);
				holder.mTvri11 =(TextView)convertView.findViewById(R.id.mTvri11);
				holder.mTvri12 =(TextView)convertView.findViewById(R.id.mTvri12);
				holder.imageView =(ImageView)convertView.findViewById(R.id.iv_listview_rent_pic);
*/				
              holder.mRlc1 =(LinearLayout)convertView.findViewById(R.id.mRlc1);
              holder. mTIvt41n1 = (ImageView)convertView.findViewById(R.id.mTIvt41n1);
              holder. mTIvt41n = (ImageView)convertView.findViewById(R.id.mTIvt41n);
              
              holder.mRlt51a=(RelativeLayout)convertView.findViewById(R.id.mRlt51a);
              holder.mTIvt41h =(TextView)convertView.findViewById(R.id.mTIvt41h);
              holder.mTIvt41o1 =(TextView)convertView.findViewById(R.id.mTIvt41o1);
              
              holder.mTy1 =(TextView)convertView.findViewById(R.id.mTy1);
              holder.mTIvt41q =(TextView)convertView.findViewById(R.id.mTIvt41q);
              holder.mTIvt41o =(TextView)convertView.findViewById(R.id.mTIvt41o);
              holder.mTIvt41q1 =(TextView)convertView.findViewById(R.id.mTIvt41q1);
              holder.mTvattep =(TextView)convertView.findViewById(R.id.mTvattep);
              
    			holder.mTIvt41h.setTypeface (face1);
      			holder.mTIvt41o1.setTypeface (face1);
      			holder.mTvattep.setTypeface (face1);
      			
      			holder.mTy1.setTypeface (face2);
      			holder.mTIvt41q.setTypeface (face2);
      			holder.mTIvt41o.setTypeface (face2);
      			holder.mTIvt41q1.setTypeface (face2);

              
holder.imageView =(ImageView)convertView.findViewById(R.id.mTIvt41l);

				convertView.setTag(holder);
			}else{
				holder =(Holder)convertView.getTag();
			}
			holder.mRlt51a.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(getApplicationContext(), TZ5_2mpActivity.class));
				}
			});
			holder. mTIvt41n.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(getApplicationContext(), GuangZhu1.class));
					
				}
			});
				
			holder. mTIvt41n1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {/*
					edittext_layout.setVisibility(View.VISIBLE);
				//	edittext_layout.requestFocus();
					
					mEt51.requestFocus(3);
					InputMethodManager inputManager =(InputMethodManager)mEt51.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
					inputManager.showSoftInput(mEt51, 0);

					
				*/
					startActivity(new Intent(getApplicationContext(), PingLun1.class));
				
				}
			});
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, width);
			holder.mRlc1.setLayoutParams(params);
/*			holder.mTvri10.setText(mDataList.get(position).Name);
			holder.mTvri11.setText(mDataList.get(position).StreetName);
			initImageLoaderOptions();
			imageLoader.displayImage(mDataList.get(position).CoverPic,holder.imageView, options);
*/			return convertView;
		}
		@Override
		public int getCount() {
			return 16;
		}
		@Override
		public Object getItem(int position) {
			return null;
		}
		@Override
		public long getItemId(int position) {
			return 0;
		}
	}
	class Data{
		String   ID;
		String   Name;
		String   StreetName;
		String   AreaGross;
		String   AreaNet;
		String   SellingPrice;
		String   RentPrice;
		String   CoverPic;
		@Override
		public String toString() {
			return "Data [ID=" + ID + ", Name=" + Name + ", StreetName="
					+ StreetName + ", AreaGross=" + AreaGross + ", AreaNet="
					+ AreaNet + ", SellingPrice=" + SellingPrice
					+ ", RentPrice=" + RentPrice + ", CoverPic=" + CoverPic
					+ "]";
		}
		
	}

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mTIvt41i:
				
				startActivity(new Intent(getApplicationContext(), TZ5_2mActivity.class));

				break;

			case R.id.mBtnRegister:
				//startActivity(new Intent(getApplicationContext(), ChoiceWhat2Activity.class));
				break;
			case R.id.mTIvt41f:
			//	startActivity(new Intent(getApplicationContext(), TZ4_1Activity.class));
				break;
			case R.id.mTIvt41h1:
				startActivity(new Intent(getApplicationContext(), TZ4_2sActivity.class));
				break;
			case R.id.mTIvt41g:
				  photo();
					
					break;
					

			default:
				break;
			}
		}
	};
	private long exitTime=0;
	
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

	
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(edittext_layout.getVisibility()!=View.VISIBLE){
		if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK){
			if((System.currentTimeMillis() - exitTime) > 2000){
				Toast.makeText(getApplicationContext(), R.string.a105, 1).show();
				exitTime = System.currentTimeMillis();
				}else{
					com.example.utils.AppManager.getAppManager().AppExit(getApplicationContext());
					android.os.Process.killProcess(android.os.Process.myPid());
				}
			return true;
			}
		}else{
			edittext_layout.setVisibility(View.GONE);
			return true;
		}
		return super.dispatchKeyEvent(event);
	}
	
	

@SuppressLint("NewApi")
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	switch (requestCode) {
	case TAKE_PICTURE:
        if(tempFile1.getTotalSpace()!=0){   

		//	Bitmap bitmap = BitmapFactory.decodeFile(tempFile1.getPath());
		//Toast.makeText(getApplicationContext(), tempFile1.getPath(), 1).show();
            Intent intent =new Intent(getApplicationContext(), TZ4_2pActivity.class);
            intent.putExtra("PATH", tempFile1.getPath());
            startActivity(intent);
        }
		break;
	}
}

}
