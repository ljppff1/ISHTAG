package com.example.ishtag;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.fragment.Fragment1a;
import com.example.ishtag.TZ4_1bActivity.Holder;
import com.example.ishtag.TZ4_1bActivity.Myadapter;
import com.example.ishtag.TZ4_1cActivity.Data;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class TZ4_1eActivity extends Activity {

	private Button mBtnRegister;
	private ListView mLv1;
	private Myadapter myadapter;
	private ImageView mTIvt41d;
	private ImageView mTIvt41b;
	private ImageView mTIvt41c;
	private ImageView mTIvt41e;
	private ImageView mTIvt41a;
	private ImageView mTIvt41h1;
	private ImageView mTIvt41f;
	private ImageView mTIvt41g;
	private DisplayImageOptions options;
	private ArrayList<Data> mDataList_origin=new ArrayList<TZ4_1eActivity.Data>();
	private ArrayList<Data> mDataList=new ArrayList<TZ4_1eActivity.Data>();
	protected ImageLoader imageLoader = ImageLoader.getInstance();


	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG/";
	private File tempFile1;
	private ProgressBar progressBar_sale;
	private ImageView mTIvt41i;
	private String UserID;
	private static final int TAKE_PICTURE = 0x000001;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t41e);
		SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
		UserID=	mySharedPreferences.getString("UserID", ""); 

		initView();
		
		
	}


	private void initView() {
		progressBar_sale =(ProgressBar)this.findViewById(R.id.progressBar_sale);
		progressBar_sale.setVisibility(View.GONE);
       initData();
			mTIvt41d =(ImageView)this.findViewById(R.id.mTIvt41d);
			mTIvt41d.setOnClickListener(listener);
			mTIvt41b =(ImageView)this.findViewById(R.id.mTIvt41b);
			mTIvt41b.setOnClickListener(listener);
			mTIvt41c =(ImageView)this.findViewById(R.id.mTIvt41c);
			mTIvt41c.setOnClickListener(listener);
			mTIvt41e =(ImageView)this.findViewById(R.id.mTIvt41e);
			mTIvt41e.setOnClickListener(listener);
			mTIvt41a =(ImageView)this.findViewById(R.id.mTIvt41a);
			mTIvt41a.setOnClickListener(listener);
			mTIvt41f =(ImageView)this.findViewById(R.id.mTIvt41f);
			mTIvt41f.setOnClickListener(listener);
			mTIvt41h1 =(ImageView)this.findViewById(R.id.mTIvt41h1);
			mTIvt41h1.setOnClickListener(listener);
			mTIvt41g =(ImageView)this.findViewById(R.id.mTIvt41g);
			mTIvt41g.setOnClickListener(listener);
			mTIvt41i =(ImageView)this.findViewById(R.id.mTIvt41i);
			mTIvt41i.setOnClickListener(listener);


	}

private void initData() {
	progressBar_sale.setVisibility(View.VISIBLE);

	downloadsearch("0");
}
private void initImageLoaderOptions() {
	options = new DisplayImageOptions.Builder()
			.showImageForEmptyUri(R.drawable.ic_launcher)
			.cacheInMemory()
			.cacheOnDisc().displayer(new FadeInBitmapDisplayer(2000))
			.bitmapConfig(Bitmap.Config.RGB_565).build();
}

public void downloadsearch(String area11){
	 RequestParams params = new RequestParams();
   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);
   nameValuePairs.add(new BasicNameValuePair("UserID", UserID));
   params.addBodyParameter(nameValuePairs);
   HttpUtils http = new HttpUtils();
   http.send(HttpRequest.HttpMethod.POST,
  		 "http://josie.i3.com.hk/dishtag/json/m_my_restaurants.php",
           params,
           new RequestCallBack<String>() {

				private String msg;

				@Override
				public void onFailure(HttpException arg0, String arg1) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(ResponseInfo<String> arg0) {
					JSONObject jsonObject;
					try {
						jsonObject = new JSONObject(arg0.result);
						String string_code = jsonObject.getString("code");
						 msg = jsonObject.getString("msg");

						 int  num_code=Integer.valueOf(string_code);
						 if (num_code==1) {
							 //保存到本地
							 mDataList_origin.clear();
							 JSONArray array = jsonObject.getJSONArray("data");
							  for (int i = 0; i < array.length(); i++) {
								  
								  Data  data=new Data();
								  
								 JSONObject jsonObject2 = array.getJSONObject(i);
								 data.ID= jsonObject2.getString("RID");
								 data.Name= jsonObject2.getString("RName");
								 mDataList_origin.add(data);
								 
		                          data.toString();						 
							}
							  mDataList.clear();
							  mDataList.addAll(mDataList_origin);
									progressBar_sale.setVisibility(View.GONE);
							  initListView();
						}
						 else {
							 Toast.makeText(getApplicationContext(), msg, 0).show();
								progressBar_sale.setVisibility(View.GONE);
						}
					} catch (JSONException e) {
						 if(mDataList.isEmpty())
							 Toast.makeText(getApplicationContext(), "暫無相關內容", 0).show();
						e.printStackTrace();
					}					
				}

   });
}
	private void initListView() {
	mLv1 =(ListView)this.findViewById(R.id.mLv1);
    myadapter = new Myadapter();
    
    mLv1.setAdapter(myadapter);
	
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

	
	
	class Holder{
		TextView mTvri10;
		ImageView mIv1,mIv2;
	}
	private String RID;

	class  Myadapter extends   BaseAdapter{
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			        
			
			Holder holder = null;
			if(convertView==null){
				convertView = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.item_listview_41b, null);
				holder = new Holder();
	/*			holder.mTvri10 =(TextView)convertView.findViewById(R.id.mTvri10);
				holder.mTvri11 =(TextView)convertView.findViewById(R.id.mTvri11);
				holder.mTvri12 =(TextView)convertView.findViewById(R.id.mTvri12);
				holder.imageView =(ImageView)convertView.findViewById(R.id.iv_listview_rent_pic);
	*/							holder.mIv1 =(ImageView)convertView.findViewById(R.id.mIv1);
   	holder.mIv2 =(ImageView)convertView.findViewById(R.id.mIv2);
   	holder.mTvri10 =(TextView)convertView.findViewById(R.id.mTvw1);
           	
				convertView.setTag(holder);

			}else{
				holder =(Holder)convertView.getTag();
			}
			holder.mIv2.setOnClickListener(new OnClickListener() {
				

				@Override
				public void onClick(View v) {
					RID=mDataList.get(position).ID;
					initData1();
				}
			});
			holder.mTvri10.setText(mDataList.get(position).Name);
		/*	holder.mTvri10.setText(mDataList.get(position).Name);
			holder.mTvri11.setText(mDataList.get(position).StreetName);
			initImageLoaderOptions();
			imageLoader.displayImage(mDataList.get(position).CoverPic,
					holder.imageView, options);
			*/
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

			}
			return convertView;

		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mDataList.size();
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
	

	/**
	 * 取消关注用户
	 */
	private void initData1() {
		progressBar_sale.setVisibility(View.VISIBLE);
		downloadsearch1("0");
	}
	public void downloadsearch1(String area11){
		 RequestParams params = new RequestParams();
	   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);
	   nameValuePairs.add(new BasicNameValuePair("UserID", UserID));
	   nameValuePairs.add(new BasicNameValuePair("RID", RID));
	   params.addBodyParameter(nameValuePairs);
	   HttpUtils http = new HttpUtils();
	   http.send(HttpRequest.HttpMethod.POST,
	  		 "http://josie.i3.com.hk/dishtag/json/m_my_restaurants_del.php",
	           params,
	           new RequestCallBack<String>() {
					private String msg;

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						
					}
					@Override
					public void onSuccess(ResponseInfo<String> arg0) {
						JSONObject jsonObject;
						try {
							jsonObject = new JSONObject(arg0.result);
							String string_code = jsonObject.getString("code");
							 msg = jsonObject.getString("msg");
							 int  num_code=Integer.valueOf(string_code);
							 if (num_code==1) {
								 Toast.makeText(getApplicationContext(), msg, 0).show();
									progressBar_sale.setVisibility(View.GONE);
									for(int i=0;i<mDataList.size();i++){
										if(RID.equals(mDataList.get(i).ID)){
											mDataList.remove(i);
										}
									}
									myadapter.notifyDataSetChanged();
							}
							 else {
								 Toast.makeText(getApplicationContext(), msg, 0).show();
									progressBar_sale.setVisibility(View.GONE);

							}
						} catch (JSONException e) {
							 Toast.makeText(getApplicationContext(), msg, 0).show();
							e.printStackTrace();
						}
						
					}
	   });
	}
	
	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mTIvt41i:
				
				startActivity(new Intent(getApplicationContext(), TZ4_1iActivity.class));

				break;

			case R.id.mBtnRegister:
				//startActivity(new Intent(getApplicationContext(), ChoiceWhat2Activity.class));
				break;
			case R.id.mTIvt41d:
				startActivity(new Intent(getApplicationContext(), TZ4_1dActivity.class));
				break;
			case R.id.mTIvt41b:
				startActivity(new Intent(getApplicationContext(), TZ4_1bActivity.class));
				break;
			case R.id.mTIvt41c:
				startActivity(new Intent(getApplicationContext(), TZ4_1cActivity.class));
				break;
			case R.id.mTIvt41e:
				startActivity(new Intent(getApplicationContext(), TZ4_1eActivity.class));
				break;
			case R.id.mTIvt41a:
				startActivity(new Intent(getApplicationContext(), TZ4_1aActivity.class));
				break;

			case R.id.mTIvt41f:
				startActivity(new Intent(getApplicationContext(), TZ4_1Activity.class));
				break;
			case R.id.mTIvt41h1:
				startActivity(new Intent(getApplicationContext(), TZ4_1sActivity.class));
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
            Intent intent =new Intent(getApplicationContext(), TZ4_1pActivity.class);
            intent.putExtra("PATH", tempFile1.getPath());
            startActivity(intent);
		break;
	}
}
}
