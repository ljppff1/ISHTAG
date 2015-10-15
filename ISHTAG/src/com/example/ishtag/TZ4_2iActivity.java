package com.example.ishtag;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.utils.AppManager;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TZ4_2iActivity extends BaseActivity {


	private GridView mGvm1;
	private Myadapter adapter;
	private ImageView mTIvt41h1;
	private ImageView mTIvt41f;
	private ImageView mTIvt41g;



	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG/";
	private File tempFile1;
	private String UserName;
	private String UserEmail;
	private EditText mEt1;
	private EditText mEt2;
	private static final int TAKE_PICTURE = 0x000001;
	private boolean mFlag=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t42i);
		
		initView();
		
		
	}
	private int femailormail;
	private Button mBtnRegister;
	private ProgressBar progressBar_sale;
	private String UserID;
	private String UserBranch;
	private EditText mEt3;

	private void initView() {
		progressBar_sale =(ProgressBar)this.findViewById(R.id.progressBar_sale);
		progressBar_sale.setVisibility(View.GONE);

		SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
		UserID=mySharedPreferences.getString("UserID",""); 
		UserName=mySharedPreferences.getString("UserName",""); 
		UserEmail=mySharedPreferences.getString("UserEmail",""); 
		UserBranch=mySharedPreferences.getString("UserGender",""); 
		mBtnRegister =(Button)this.findViewById(R.id.mBtnRegister);
		mBtnRegister.setOnClickListener(listener);
		mEt1 =(EditText)this.findViewById(R.id.mEt1);
		mEt1.setText(UserName);
		mEt2 =(EditText)this.findViewById(R.id.mEt2);
		mEt2.setText(UserEmail);
		mEt3=(EditText)this.findViewById(R.id.mEt3);
		mEt3.setText(UserBranch);
		mTIvt41f =(ImageView)this.findViewById(R.id.mTIvt41f);
		mTIvt41f.setOnClickListener(listener);
		mTIvt41h1 =(ImageView)this.findViewById(R.id.mTIvt41h1);
		mTIvt41h1.setOnClickListener(listener);
		mTIvt41g =(ImageView)this.findViewById(R.id.mTIvt41g);
		mTIvt41g.setOnClickListener(listener);

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
			case R.id.mBtnRegister:
				if (mBtnRegister.getText().toString().equals(getResources().getString(R.string.a101))) {
					mEt1.setFocusable(true);
					mEt1.setFocusableInTouchMode(true);
					mEt3.setFocusable(true);
					mEt3.setFocusableInTouchMode(true);
					mFlag =true;
					mEt1.requestFocus(3);
					InputMethodManager inputManager =(InputMethodManager)mEt1.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
					inputManager.showSoftInput(mEt1, 0);

					   mBtnRegister
						.setText(getResources().getString(R.string.a102));

				} else {

					initData();
				}

				break;
			case R.id.mTIvt41f:
				startActivity(new Intent(getApplicationContext(), TZ4_2Activity.class));
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


private void initData() {
	downloadsearch("0");
}
public void downloadsearch(String area11){
	progressBar_sale.setVisibility(View.VISIBLE);
	 RequestParams params = new RequestParams();
	 
   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);
	   nameValuePairs.add(new BasicNameValuePair("UserName", mEt1.getEditableText().toString()));
	   nameValuePairs.add(new BasicNameValuePair("UserID",  UserID));
   nameValuePairs.add(new BasicNameValuePair("UserBranch", mEt3.getEditableText().toString()));
   
   params.addBodyParameter(nameValuePairs);
   HttpUtils http = new HttpUtils();
   http.send(HttpRequest.HttpMethod.POST,
  		 "http://josie.i3.com.hk/dishtag/json/r_infoedit.php",
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
							 //保存到本地
							 JSONObject array = jsonObject.getJSONObject("data");
							 Toast.makeText(getApplicationContext(), msg, 0).show();
								progressBar_sale.setVisibility(View.GONE);
								
								
								SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
										SharedPreferences.Editor editor = mySharedPreferences.edit(); 
										editor.putString("UserName",mEt1.getEditableText().toString()); 
										editor.putString("UserGender",mEt3.getEditableText().toString()); 
										editor.commit(); 
										mBtnRegister.setText(getResources().getString(
												R.string.a101));
										mEt1.setFocusableInTouchMode(false);
										mEt1.setFocusable(false);
										mEt3.setFocusableInTouchMode(false);
										mEt3.setFocusable(false);
										mFlag =false;
						 }
						 else {
							 Toast.makeText(getApplicationContext(), msg, 0).show();
									progressBar_sale.setVisibility(View.GONE);
						}
					} catch (JSONException e) {
						//new Dialog_noInternet(SaleActivity.this).show();
						progressBar_sale.setVisibility(View.GONE);
						 Toast.makeText(getApplicationContext(), msg, 0).show();
						e.printStackTrace();
					}
				}
   });
}
	
	
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
