package com.example.ishtag;

import java.io.File;
import java.util.ArrayList;
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

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

	private Button mBtnLogin;
	private Button mBtnLogin1;
	private ImageView mIvwhat;
	private Button mBtnLogin2;
	private ProgressBar progressBar_sale;
	private EditText mEt1;
	private EditText mEt2;
	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		 makeRootDirectory(SDPATH);
		initView();
		
		
	}
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {

        }
}

	private void initView() {
		progressBar_sale =(ProgressBar)this.findViewById(R.id.progressBar_sale);
		progressBar_sale.setVisibility(View.GONE);
		SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
		String UserEmail = mySharedPreferences.getString("UserEmail",""); 

		
		mEt1 =(EditText)this.findViewById(R.id.mEt1);
		mEt2 =(EditText)this.findViewById(R.id.mEt2);
		mEt1.setText(UserEmail);
		mBtnLogin =(Button)this.findViewById(R.id.mBtnLogin);
		mBtnLogin.setOnClickListener(listener);
		mBtnLogin1 =(Button)this.findViewById(R.id.mBtnLogin1);
		mBtnLogin1.setOnClickListener(listener);
		mBtnLogin2 =(Button)this.findViewById(R.id.mBtnLogin2);
		mBtnLogin2.setOnClickListener(listener);
		

	}
	
	private void initData() {
		downloadsearch("0");
	}
	public void downloadsearch(String area11){
		progressBar_sale.setVisibility(View.VISIBLE);
		 RequestParams params = new RequestParams();
	   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);
	   nameValuePairs.add(new BasicNameValuePair("UserEmail", mEt1.getEditableText().toString()));
	   nameValuePairs.add(new BasicNameValuePair("UserPwd", mEt2.getEditableText().toString()));
	   
	   params.addBodyParameter(nameValuePairs);
	   HttpUtils http = new HttpUtils();
	   http.send(HttpRequest.HttpMethod.POST,
	  		 "http://josie.i3.com.hk/dishtag/json/login.php",
	           params,
	           new RequestCallBack<String>() {

					private String msg;
					private String UserGender;
					private String UserBirthday;

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
			//{"data":{"UserType":2,"UserContacts":null,"UserOpening":null,"UserAddress":"","UserID":"18","UserName":"hdd","TypeName":null,"UserEmail":
									//"dd","TypeID":"0","UserBranch":"ddd","UserReservations":null},"msg":"Login success","code":"1"}						
									/**
									 * {"UserType":2,"UserContacts":null,"UserOpening":null,"UserAddress":nu
									 * ll,"UserID":"23","UserName":"b","TypeName":null,"UserEmail":"b","TypeID":"0","UserBranch":"b","UserReservations":null}
									 */
									String UserID = array.getString("UserID");
									String UserName = array.getString("UserName");
									String UserType = array.getString("UserType");
									String UserEmail = array.getString("UserEmail");
									if(UserType.equals("1")){
									 UserGender = array.getString("UserGender");
									 UserBirthday = array.getString("UserBirthday");
									}else{
										 UserGender = array.getString("UserBranch");
										 UserBirthday = array.getString("TypeID");

									}
									SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
											SharedPreferences.Editor editor = mySharedPreferences.edit(); 
											editor.putString("UserID", UserID); 
											editor.putString("UserName",UserName); 
											editor.putString("UserType",UserType); 
											editor.putString("UserEmail",UserEmail); 
											editor.putString("UserGender",UserGender); 
											editor.putString("UserBirthday",UserBirthday); 
											editor.commit(); 
											
											if(UserType.equals("1")){
												startActivity(new Intent(getApplicationContext(), TZ4_1Activity.class));

											}else {
												startActivity(new Intent(getApplicationContext(), TZ4_2Activity.class));
											}
			                                AppManager.getAppManager().finishActivity();

	
									
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

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mBtnLogin:
				if(TextUtils.isEmpty(mEt1.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a90, 0).show();
				}else if(TextUtils.isEmpty(mEt2.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a951, 0).show();
				}else{
					initData();
				}
				
				//startActivity(new Intent(getApplicationContext(), TZ4_1Activity.class));

				break;
			case R.id.mBtnLogin1:
				startActivity(new Intent(getApplicationContext(), ChoiceWhat2Activity.class));
				break;
			case R.id.mBtnLogin2:
				startActivity(new Intent(getApplicationContext(), TZ4_2Activity.class));
				break;

			default:
				break;
			}
		}
	};
}
