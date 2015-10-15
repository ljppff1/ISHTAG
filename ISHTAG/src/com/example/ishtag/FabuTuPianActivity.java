package com.example.ishtag;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.json.JSONException;
import org.json.JSONObject;

import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.sina.weibo.SinaWeibo.ShareParams;
import cn.sharesdk.twitter.Twitter;

import com.example.utils.TypeFace;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.multipart.MultipartEntity;


import HaoRan.ImageFilter.dialog.LoadingDialog;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FabuTuPianActivity extends BaseActivity {
	private RadioGroup rg1;
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private RadioButton rb4;
	private RadioButton rb5;
	private int i_choice;
	private TextView mtmy1;
	private TextView mtmy2;
	private TextView mtmy3;
	private TextView mtmy4;
	private TextView mtmy5;

	private String PATH;
	private ImageView mIvfbp;
	private ImageView mIvre1;
	private Spinner spinner;
	private ArrayList<String> data_list;
	private ArrayAdapter<String> arr_adapter;
	private EditText mEt2;
	private Button mBtnSure;
    private int mint =0;
	private String UserID;
	private com.example.utils.SocketHttpRequester socketHttp;
	private Handler handler =new Handler(){
		private LoadingDialog dialog1;
		private Platform platw;

		public void handleMessage(android.os.Message msg) {
		JSONObject jsonObject;
		switch (msg.what) {
		case 2:
			dialog.dismiss();

			Log.e("MY", (String) msg.obj);
			 Toast.makeText(getApplicationContext(),(String)msg.obj, 0).show();
          break;
		case 1:
			dialog.dismiss();

			String str = (String)msg.obj;
			Log.e("MY1", (String) msg.obj);

		    try {
				jsonObject = new JSONObject(str);
				String string_code = jsonObject.getString("code");
				String msg1 = jsonObject.getString("msg");
				 int  num_code=Integer.valueOf(string_code);
				 if (num_code==1) {
				 Toast.makeText(getApplicationContext(), msg1, 1).show();
				
					Log.e("MY1","num_code==1");
					
					dialog1 = new LoadingDialog(FabuTuPianActivity.this, getString(R.string.a110));
					dialog1.show();

					
ShareSDK.initSDK(FabuTuPianActivity.this);
 

ShareParams sp = new ShareParams();
switch (i_choice) {
case 0:
	sp.setText(mEt2.getEditableText().toString());

	platw = ShareSDK.getPlatform(Facebook.NAME);
	break;
case 1:
	sp.setImageUrl("www.baidu.com");
	sp.setImagePath("www.baidu.com");
	platw = ShareSDK.getPlatform(Instagram.NAME);
	break;
case 2:
	sp.setText(mEt2.getEditableText().toString());

	platw = ShareSDK.getPlatform(Twitter.NAME);
	break;
case 3:
	sp.setText(mEt2.getEditableText().toString());

	platw = ShareSDK.getPlatform(SinaWeibo.NAME);
	break;
case 4:
	sp.setText(mEt2.getEditableText().toString());

	platw = ShareSDK.getPlatform(GooglePlus.NAME);
	break;
	

default:
	break;
}
platw.setPlatformActionListener(new PlatformActionListener() {
	@Override
	public void onError(Platform arg0, int arg1, Throwable arg2) {
	Toast.makeText(getApplicationContext(), "fail", 0).show();
	Log.e("MY2","onError");
	dialog1.cancel();

	}
	
	@Override
	public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
		Toast.makeText(getApplicationContext(), "Success", 0).show();
		Log.e("MY2","onComplete");
		dialog1.cancel();
	}
	
	@Override
	public void onCancel(Platform arg0, int arg1) {
		Toast.makeText(getApplicationContext(), "Cancel", 0).show();

		Log.e("MY2","onCancel");
		dialog1.cancel();

	}
}); // 设置分享事件回调
// 执行图文分享
platw.share(sp);
Looper.getMainLooper().loop();
				 }else{
					 Toast.makeText(getApplicationContext(), msg1,1).show();
					 Looper.getMainLooper().loop();

						Log.e("MY1","num_code==0");

				 }

			} catch (JSONException e) {
				 Toast.makeText(getApplicationContext(), R.string.a108, 1).show();
				 Looper.getMainLooper().loop();

					Log.e("MY1","num_code==n e");

			}
			
			 

			break;

		default:
			break;
		}
		};
	};
	private EditText mEt3;
	private EditText mEt4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.fabutupian);
		mtmy1 =(TextView)this.findViewById(R.id.mtmy1);
		mtmy2 =(TextView)this.findViewById(R.id.mtmy2);
		mtmy3 =(TextView)this.findViewById(R.id.mtmy3);
		mtmy4 =(TextView)this.findViewById(R.id.mtmy4);
		mtmy5 =(TextView)this.findViewById(R.id.mtmy5);
		mtmy1.setTypeface(new TypeFace().getTypeFace2(getApplicationContext()));
		mtmy2.setTypeface(new TypeFace().getTypeFace2(getApplicationContext()));
		mtmy3.setTypeface(new TypeFace().getTypeFace2(getApplicationContext()));
		mtmy4.setTypeface(new TypeFace().getTypeFace2(getApplicationContext()));
		mtmy5.setTypeface(new TypeFace().getTypeFace2(getApplicationContext()));
		 mEt2=(EditText)this.findViewById(R.id.mEt2);
		 mEt3=(EditText)this.findViewById(R.id.mEt3);
		 mEt4=(EditText)this.findViewById(R.id.mEt4);
		 mEt3.setTypeface(new TypeFace().getTypeFace1(getApplicationContext()));
		 mEt2.setTypeface(new TypeFace().getTypeFace1(getApplicationContext()));
		 mEt4.setTypeface(new TypeFace().getTypeFace1(getApplicationContext()));


		SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
		UserID =mySharedPreferences.getString("UserID", ""); 
		socketHttp=new com.example.utils.SocketHttpRequester(FabuTuPianActivity.this);
		rg1 = (RadioGroup) this.findViewById(R.id.rg1);
		rb1 = (RadioButton) this.findViewById(R.id.rb1);
		rb2 = (RadioButton) this.findViewById(R.id.rb2);
		rb3 = (RadioButton) this.findViewById(R.id.rb3);
		rb4 = (RadioButton) this.findViewById(R.id.rb4);
		rb5 = (RadioButton) this.findViewById(R.id.rb5);
		 i_choice=0;
		rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int cheakedId) {
				if (cheakedId == rb1.getId()) {
				 i_choice=0;
				} else if (cheakedId == rb2.getId()) {
					 i_choice=1;
				}else if (cheakedId == rb3.getId()) {
					 i_choice=2;
				}else if (cheakedId == rb4.getId()) {
					 i_choice=3;
				}else if (cheakedId == rb5.getId()) {
					 i_choice=4;
				}
							
			}
		});

		
	 PATH =	getIntent().getExtras().getString("PATH");
	 mEt2=(EditText)this.findViewById(R.id.mEt2);
	 mBtnSure =(Button)this.findViewById(R.id.mBtnSure);
	 mBtnSure.setOnClickListener(listener);
	 mBtnSure.setTypeface(new TypeFace().getTypeFace1(getApplicationContext()));

		initView();
		
		
	}

	private void initView() {
        spinner = (Spinner) findViewById(R.id.spinner);
        //数据
        data_list = new ArrayList<String>();
        data_list.add("JOPPERSSATA PICCANTE");
        data_list.add("JOPPERSSATA PICCANTE1");
        data_list.add("JOPPERSSATA PICCANTE");
        data_list.add("JOPPERSSATA PICCANTE");
        mint =0;

		// 第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.myspinner, data_list);
		// 第三步：为适配器设置下拉列表下拉时的菜单样式。 simple_spinner_item
		adapter.setDropDownViewResource(R.layout.myspinnertheme);
		// 第四步：将适配器添加到下拉列表上
		
		spinner.setAdapter(adapter);
		// 第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        spinner
		.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				/* 将所选mySpinner 的值带入myTextView 中 */
				arg0.setVisibility(View.VISIBLE);
				spinner.setSelection(position);
				mint =position;
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				arg0.setVisibility(View.VISIBLE);
			}
		});
/* 下拉菜单弹出的内容选项触屏事件处理 */
        spinner.setOnTouchListener(new Spinner.OnTouchListener() {
	public boolean onTouch(View v, MotionEvent event) {
		return false;
	}
	
});
        spinner.setVisibility(View.VISIBLE);
/* 下拉菜单弹出的内容选项焦点改变事件处理 */
        spinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				v.setVisibility(View.VISIBLE);
			}
		});
		mIvfbp =(ImageView)this.findViewById(R.id.mIvfbp);
		mIvre1 =(ImageView)this.findViewById(R.id.mIvre1);
		mIvre1.setOnClickListener(listener);
		  Bitmap bitmap = BitmapFactory.decodeFile(PATH);
		  mIvfbp.setImageBitmap(bitmap);

	}
	private LoadingDialog dialog;

	OnClickListener listener =new OnClickListener() {
		

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mIvre1:
				finish();
				break;
			case R.id.mBtnSure:
				if(!TextUtils.isEmpty(mEt2.getEditableText().toString())){
			//	initData();
				//	upload();
//					files.put("photo5.jpg", new File("/sdcard/photo5.jpg"));
//					files.put("photo6.jpg", new File("/sdcard/photo6.jpg"));
//					files.put("photo7.jpg", new File("/sdcard/photo7.jpg"));
					
					Log.e("MY", new File(PATH).getName()+"");
					Log.e("MY", new File(PATH)+"");

					dialog = new LoadingDialog(FabuTuPianActivity.this, getString(R.string.a109));
					dialog.show();

						new Thread(new Runnable() {
							
							@Override
							public void run() {
								Looper.prepare(); 
								String actionUrl ="http://josie.i3.com.hk/dishtag/json/s_post.php";
								Map<String, String> params = new HashMap<String, String>();
								params.put("UserID", UserID);
								params.put("STitle", data_list.get(mint));
								params.put("SText", mEt2.getEditableText().toString());
								params.put("SPhotoNum", "1");
								Map<String, File> files = new HashMap<String, File>();
								files.put( new File(PATH).getName(), new File(PATH));

								try {
									com.example.utils.HttpFileUpTool.post(actionUrl, params, files,handler);
								} catch (IOException e) {
									Message msg =new Message();
									msg.what=2;
									msg.obj=e.getMessage().toString();
								    handler.sendMessage(msg);
								}
							}
						}).start();

				}else{
					Toast.makeText(getApplicationContext(), R.string.a103, 0).show();
				}
				break;
			default:
				break;
			}
		}

		private void upload() {
			uploadThread uThread=new uploadThread();
			new Thread(uThread).start();

	}
	};
	
	class uploadThread implements Runnable{

		/* (非 Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			
			try {
			//	socketHttp.upoloadFile(PATH,data_list.get(mint),mEt2.getEditableText().toString(), "1",UserID,"http://josie.i3.com.hk/dishtag/json/s_post.php");
				//upLoadByCommonPost(PATH,"http://josie.i3.com.hk/dishtag/json/s_post.php");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}			


	
	
	private void initData() {
		HttpUtils HTTP_UTILS = new HttpUtils(60 * 1000);
		RequestParams params = new RequestParams();
		   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);
		   nameValuePairs.add(new BasicNameValuePair("Stitle",data_list.get(mint)));
		   nameValuePairs.add(new BasicNameValuePair("Stext",mEt2.getEditableText().toString()));
		   nameValuePairs.add(new BasicNameValuePair("SPhotoNum", "1"));
		   nameValuePairs.add(new BasicNameValuePair("UserID",UserID));
		   params.addBodyParameter(nameValuePairs);
			params.addBodyParameter("SPhoto_1", new File(PATH));
		HttpUtils http = new HttpUtils();
		http.send(HttpRequest.HttpMethod.POST,
		    "http://josie.i3.com.hk/dishtag/json/s_post.php",
		    params,
		    new RequestCallBack<String>() {

		        @Override
		        public void onStart() {
		        	
		        }

		        @Override
		        public void onLoading(long total, long current, boolean isUploading) {
		            if (isUploading) {
		                //testTextView.setText("upload: " + current + "/" + total);
						Toast.makeText(getApplicationContext(), "upload: " + current + "/" + total, 0).show();

		            } else {
						Toast.makeText(getApplicationContext(), "upload: " + current + "/" + total, 0).show();

		              //  testTextView.setText("reply: " + current + "/" + total);
		            }
		        }

		        @Override
		        public void onSuccess(ResponseInfo<String> responseInfo) {
		          //  testTextView.setText("reply: " + responseInfo.result);
					Toast.makeText(getApplicationContext(),"reply: " + responseInfo.result, 0).show();

		        }

		        @Override
		        public void onFailure(HttpException error, String msg) {
		          //  testTextView.setText(error.getExceptionCode() + ":" + msg);
					Toast.makeText(getApplicationContext(),"error: " + error.getExceptionCode(), 0).show();

		        }
		});
		
	}

	
	
}
