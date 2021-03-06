package com.example.ishtag;


import java.io.File;
import java.io.IOException;

import com.example.ishtag1.TZ5_2Activity;
import com.example.ishtag1.TZ5_2mActivity;
import com.example.utils.TypeFace;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TZ4_2sActivity extends BaseActivity {


	private GridView mGvm1;
	private Myadapter adapter;
	private ImageView mTIvt41h1;
	private ImageView mTIvt41f;
	private ImageView mTIvt41g;



	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG/";
	private File tempFile1;
	private ImageView mTIvt41i;
	private TextView mEttt1;
	private TextView mTvww1;
	private Typeface face1;
	private RelativeLayout mRlse;
	private TextView mTvattep;
	private Typeface face2;
	private static final int TAKE_PICTURE = 0x000001;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t42s);
		
		initView();
		
		
	}

	private void initView() {
		mRlse =(RelativeLayout)this.findViewById(R.id.mRlse);
		mRlse.setOnClickListener(listener);
		mEttt1 =(TextView)this.findViewById(R.id.mEttt1);
		mTvww1 =(TextView)this.findViewById(R.id.mTvww1);
		mTvattep =(TextView)this.findViewById(R.id.mTvattep);
		face1 =new TypeFace().getTypeFace2(getApplicationContext());
		face2 =new TypeFace().getTypeFace1(getApplicationContext());
		mEttt1.setTypeface(face1);
		mTvww1.setTypeface(face1);
		mTvattep.setTypeface(face2);
		mGvm1 =(GridView)this.findViewById(R.id.mGvm1);
		adapter= new Myadapter();
		mGvm1.setAdapter(adapter);
		mGvm1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivity(new Intent(getApplicationContext(), CaiPin2.class));
			}
		});
		mTIvt41f =(ImageView)this.findViewById(R.id.mTIvt41f);
		mTIvt41f.setOnClickListener(listener);
		mTIvt41h1 =(ImageView)this.findViewById(R.id.mTIvt41h1);
		mTIvt41h1.setOnClickListener(listener);
		mTIvt41g =(ImageView)this.findViewById(R.id.mTIvt41g);
		mTIvt41g.setOnClickListener(listener);
		mTIvt41i =(ImageView)this.findViewById(R.id.mTIvt41i);
		mTIvt41i.setOnClickListener(listener);

	}	class Holder{
		TextView mTvri12;
		ImageView imageView;
	}

	class  Myadapter extends   BaseAdapter{
		@SuppressLint("NewApi")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			        
			
			Holder holder = null;
			if(convertView==null){
				convertView = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.item_listview_41s, null);
				holder = new Holder();
				//holder.mTvri12 =(TextView)convertView.findViewById(R.id.mTvg1);
				convertView.setTag(holder);
	
			}else{
				holder =(Holder)convertView.getTag();
			}
			return convertView;

		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 36;
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
	}


	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mRlse:
				startActivity(new Intent(getApplicationContext(), TZ4_2sdActivity.class));
				break;
			case R.id.mTIvt41i:
				startActivity(new Intent(getApplicationContext(), TZ5_2mActivity.class));
				break;
			case R.id.mTIvt41f:
				startActivity(new Intent(getApplicationContext(), TZ5_2Activity.class));
				break;
			case R.id.mTIvt41h1:
				//startActivity(new Intent(getApplicationContext(), TZ4_2sActivity.class));
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
