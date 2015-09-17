package com.example.ishtag;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.multipart.MultipartEntity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class FabuTuPianActivity extends BaseActivity {

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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.fabutupian);
		
		SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
		UserID =mySharedPreferences.getString("UserID", ""); 

		
	 PATH =	getIntent().getExtras().getString("PATH");
	 mEt2=(EditText)this.findViewById(R.id.mEt2);
	 mBtnSure =(Button)this.findViewById(R.id.mBtnSure);
	 mBtnSure.setOnClickListener(listener);
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

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mIvre1:
				finish();
				break;
			case R.id.mBtnSure:
				if(!TextUtils.isEmpty(mEt2.getEditableText().toString())){
				initData();
				}else{
					Toast.makeText(getApplicationContext(), R.string.a103, 0).show();
				}
				break;
			default:
				break;
			}
		}


	};
	

	
	
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
