package com.example.ishtag;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.ishtag1.TZ5_2Activity;
import com.example.utils.AppManager;
import com.example.utils.TypeFace;
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
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Register1Activity extends BaseActivity {

	private Button mBtnRegister;
	private EditText mEt1;
	private EditText mEt1a;
	private EditText mEt2;
	private EditText mEt3;
	private EditText mEt4;
	private EditText mEt5;
	private ProgressBar progressBar_sale;
	
    private TextView m1,m2,m3,m4,m5,m6;
    
	private TextView tt1[]=new TextView[]{m1,m2,m3,m4,m5,m6};
    int id[] = new int[] { R.id.mty1, R.id.mty2, R.id.mty3, R.id.mty4, R.id.mty5, R.id.mty6 };

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.register1);
		
		initView();
		

	        for (int i = 0; i < tt1.length; i++) {
	        	tt1[i] = (TextView) this.findViewById(id[i]);
	        	tt1[i] .setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
	        }
	    }

	

	private void initView() {
		mBtnRegister =(Button)this.findViewById(R.id.mBtnRegister);
		mBtnRegister.setOnClickListener(listener);
		progressBar_sale =(ProgressBar)this.findViewById(R.id.progressBar_sale);
		progressBar_sale.setVisibility(View.GONE);

		mEt1=(EditText)this.findViewById(R.id.mEt1);
		mEt1a=(EditText)this.findViewById(R.id.mEt1a);
		mEt2=(EditText)this.findViewById(R.id.mEt2);
		mEt3=(EditText)this.findViewById(R.id.mEt3);
		mEt4=(EditText)this.findViewById(R.id.mEt4);
		mEt5=(EditText)this.findViewById(R.id.mEt5);
		
		final int mMaxLenth = 31;//mMaxLenth可以动态改变
		final int mMaxLenth1 = 21;//mMaxLenth可以动态改变

		InputFilter[] FilterArray = new InputFilter[1];
		FilterArray[0] = new InputFilter() {
		@Override
		public CharSequence filter (CharSequence source, int start, int end, 
		Spanned dest, int dstart, int dend){
		boolean bInvlid = false;
		int sourceLen = source.toString().length();
		int destLen = dest.toString().length();
		if (sourceLen + destLen > mMaxLenth) {
		return ""; }
		return source;
		}
		};
		InputFilter[] FilterArray1 = new InputFilter[1];
		FilterArray1[0] = new InputFilter() {
		@Override
		public CharSequence filter (CharSequence source, int start, int end, 
		Spanned dest, int dstart, int dend){
		boolean bInvlid = false;
		int sourceLen = source.toString().length();
		int destLen = dest.toString().length();
		if (sourceLen + destLen > mMaxLenth1) {
		return ""; }
		return source;
		}
		};
		mEt1.setFilters(FilterArray);
		mEt4.setFilters(FilterArray1);
		mEt5.setFilters(FilterArray1);

		
		mEt1.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		mEt1a.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		mEt2.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		mEt3.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		mEt4.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		mEt5.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		mBtnRegister.setTypeface (new TypeFace().getTypeFace2(getApplicationContext()));
		
	}
	public static boolean isEmail(String email){     
	     String str="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
	        Pattern p = Pattern.compile(str);     
	        Matcher m = p.matcher(email);     
	        return m.matches();     
	    }

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mBtnRegister:
				//startActivity(new Intent(getApplicationContext(), TZ4_2Activity.class));
				if(TextUtils.isEmpty(mEt1.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a90a, 0).show();
				}else if(TextUtils.isEmpty(mEt2.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a91, 0).show();
				}else if(TextUtils.isEmpty(mEt3.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a94, 0).show();
				}else if(TextUtils.isEmpty(mEt4.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a95, 0).show();
				}else if(TextUtils.isEmpty(mEt5.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a96, 0).show();
				}else if(TextUtils.isEmpty(mEt1a.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a98, 0).show();
				}else if(!mEt2.getEditableText().toString().equals(mEt3.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a92, 0).show();
				}else if(!mEt4.getEditableText().toString().equals(mEt5.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a93, 0).show();
				}else if(!isEmail(mEt2.getEditableText().toString())){
					Toast.makeText(getApplicationContext(), R.string.a951a, 0).show();
				}else if(mEt4.getEditableText().toString().length()<6){
					Toast.makeText(getApplicationContext(), R.string.a112, 0).show();
				}else{
					initData();
				}

				
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
   nameValuePairs.add(new BasicNameValuePair("UserPwd", mEt2.getEditableText().toString()));
   nameValuePairs.add(new BasicNameValuePair("UserEmail", mEt3.getEditableText().toString()));
   nameValuePairs.add(new BasicNameValuePair("UserBranch",mEt1a.getEditableText().toString()));
   
   params.addBodyParameter(nameValuePairs);
   HttpUtils http = new HttpUtils();
   http.send(HttpRequest.HttpMethod.POST,
  		 "http://josie.i3.com.hk/dishtag/json/r_reg.php",
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
							 Toast.makeText(getApplicationContext(), R.string.a111, 1).show();
								progressBar_sale.setVisibility(View.GONE);
								
								String UserID = array.getString("UserID");
								String UserName = array.getString("UserName");
								String UserType = array.getString("UserType");
								String UserEmail = array.getString("UserEmail");
								String UserBranch = array.getString("UserBranch");
								
								SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
										SharedPreferences.Editor editor = mySharedPreferences.edit(); 
										editor.putString("UserID", UserID); 
										editor.putString("UserName",UserName); 
										editor.putString("UserType",UserType); 
										editor.putString("UserEmail",UserEmail); 
										editor.putString("UserBranch",UserBranch); 
										editor.commit(); 
											startActivity(new Intent(getApplicationContext(), TZ5_2Activity.class));
                                AppManager.getAppManager().finishActivityJob3();
								
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
}
