package com.example.ishtag;

import java.io.File;
import java.io.IOException;

import com.example.ishtag.TZ4_1aActivity.Holder;
import com.example.ishtag.TZ4_1aActivity.Holder1;
import com.example.ishtag.TZ4_1aActivity.Myadapter;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class TZ4_2aActivity extends Activity {

	private Button mBtnRegister;
	private ImageView mTIvt41h1;
	private ImageView mTIvt41f;
	private ImageView mTIvt41g;
	private ImageView mTIvt41c;
	private ImageView mTIvt41b;
	private ImageView mTIvt41d;
	private ImageView mTIvt41a;
	private ImageView mTIvt41e;
	
	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG/";
	private File tempFile1;
	private static final int TAKE_PICTURE = 0x000001;
	private ListView mLv1;
	private Myadapter myadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t42a);
		
		initView();
		
		
	}

	private void initView() {
		
		mLv1 =(ListView)this.findViewById(R.id.mLv1);
		mLv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivity(new Intent(getApplicationContext(), TZ4_2a1Activity.class));
			}
		});
	       myadapter = new Myadapter();
	       
	       mLv1.setAdapter(myadapter);

			mTIvt41f =(ImageView)this.findViewById(R.id.mTIvt41f);
			mTIvt41f.setOnClickListener(listener);
			mTIvt41h1 =(ImageView)this.findViewById(R.id.mTIvt41h1);
			mTIvt41h1.setOnClickListener(listener);
			mTIvt41g =(ImageView)this.findViewById(R.id.mTIvt41g);
			mTIvt41g.setOnClickListener(listener);
			
			
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
		
	}
	class Holder{
		TextView mTvri10;
		ImageView mIv1,mIv2;
	}
	class Holder1{
		TextView mTvri11;
		ImageView mIv3,mIv4;
	}
	class  Myadapter extends   BaseAdapter{
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			        
			
			View firstItemView = null;
		    View othersItemView=null;
		    if(position==1||position==3||position==6){
		    	firstItemView = convertView;
				Holder holder = null;
               // if(firstItemView==null){
                	firstItemView = LayoutInflater.from(getApplicationContext())
    						.inflate(R.layout.item_listview_41a1, null);
    				holder = new Holder();
    				holder.mIv1 =(ImageView)firstItemView.findViewById(R.id.mIv1);
    	        	holder.mIv2 =(ImageView)firstItemView.findViewById(R.id.mIv2);
    	        	firstItemView.setTag(holder);
            //    }else{
               // 	holder =(Holder)firstItemView.getTag();
             //   }
		    	
                if (position==1) {
    				holder.mIv1.setImageDrawable(getResources().getDrawable(R.drawable.t24));
    			}else{
    				holder.mIv1.setImageDrawable(getResources().getDrawable(R.drawable.t23));
    			}
    			if(position>8)
    			{
    				holder.mIv2.setImageDrawable(getResources().getDrawable(R.drawable.t21));
    			}else{
    				holder.mIv2.setImageDrawable(getResources().getDrawable(R.drawable.t20));
    			}
                
                convertView=firstItemView;
		    }else{
		    	othersItemView = convertView;
		    	Holder1 holder1 = null;
               // if(othersItemView==null){
                	othersItemView = LayoutInflater.from(getApplicationContext())
    						.inflate(R.layout.item_listview_41a2, null);
                	holder1 = new Holder1();
                	holder1.mIv3 =(ImageView)othersItemView.findViewById(R.id.mIv1);
                	holder1.mIv4 =(ImageView)othersItemView.findViewById(R.id.mIv2);
    	       // 	othersItemView.setTag(holder1);
            //    }else{
           //     	holder1 =(Holder1)othersItemView.getTag();
          //      }
                
    			if(position>4)
    			{
    				holder1.mIv3.setImageDrawable(getResources().getDrawable(R.drawable.t25));
    			}else{
    				holder1.mIv3.setImageDrawable(getResources().getDrawable(R.drawable.t22));
    			}

		    	
                convertView=othersItemView;

		    	
		    }
		    
		 /*   
			if(convertView==null){
				convertView = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.item_listview_41a1, null);
				holder = new Holder();
				holder.mTvri10 =(TextView)convertView.findViewById(R.id.mTvri10);
				holder.mTvri11 =(TextView)convertView.findViewById(R.id.mTvri11);
				holder.mTvri12 =(TextView)convertView.findViewById(R.id.mTvri12);
				holder.imageView =(ImageView)convertView.findViewById(R.id.iv_listview_rent_pic);
				holder.mIv1 =(ImageView)convertView.findViewById(R.id.mIv1);
        	holder.mIv2 =(ImageView)convertView.findViewById(R.id.mIv2);

				convertView.setTag(holder);

			}else{
				holder =(Holder)convertView.getTag();
			}
			
			holder.mTvri10.setText(mDataList.get(position).Name);
			holder.mTvri11.setText(mDataList.get(position).StreetName);
			initImageLoaderOptions();
			imageLoader.displayImage(mDataList.get(position).CoverPic,
					holder.imageView, options);
			
			if (position==0) {
				holder.mIv1.setImageDrawable(getResources().getDrawable(R.drawable.t25));
			}else{
				holder.mIv1.setImageDrawable(getResources().getDrawable(R.drawable.t22));
			}
			if(position>8)
			{
				holder.mIv2.setImageDrawable(getResources().getDrawable(R.drawable.t21));
			}else{
				holder.mIv2.setImageDrawable(getResources().getDrawable(R.drawable.t20));
			}*/
			return convertView;

		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 16;
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
			case R.id.mBtnRegister:
				//startActivity(new Intent(getApplicationContext(), ChoiceWhat2Activity.class));
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
