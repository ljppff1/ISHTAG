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

public class TZ4_1iActivity extends Activity {


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
	private TextView mTvre6;
	private String UserGender;
	private String UserBirthday;
	private RadioGroup mRg1;
	private RadioButton mRb1;
	private RadioButton mRb2;
	private static final int TAKE_PICTURE = 0x000001;
	private boolean mFlag=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t41i);
		
		initView();
		
		
	}
	private int femailormail;
	private Button mBtnRegister;
	private ProgressBar progressBar_sale;
	private String UserID;

	private void initView() {
		progressBar_sale =(ProgressBar)this.findViewById(R.id.progressBar_sale);
		progressBar_sale.setVisibility(View.GONE);

		SharedPreferences mySharedPreferences= getSharedPreferences("USER", Activity.MODE_PRIVATE); 
		UserID=mySharedPreferences.getString("UserID",""); 
		UserName=mySharedPreferences.getString("UserName",""); 
		UserEmail=mySharedPreferences.getString("UserEmail",""); 
		UserGender=mySharedPreferences.getString("UserGender","1"); 
		UserBirthday=mySharedPreferences.getString("UserBirthday",""); 
		mBtnRegister =(Button)this.findViewById(R.id.mBtnRegister);
		mBtnRegister.setOnClickListener(listener);
		mEt1 =(EditText)this.findViewById(R.id.mEt1);
		mEt1.setText(UserName);
		mEt2 =(EditText)this.findViewById(R.id.mEt2);
		mEt2.setText(UserEmail);
		mTvre6 =(TextView)this.findViewById(R.id.mTvre6);
		mTvre6.setOnClickListener(listener);
		mTvre6.setText(UserBirthday);
		mRg1=(RadioGroup)findViewById(R.id.mRg1); 
		mRb1=(RadioButton)findViewById(R.id.mRb1); 
		mRb2=(RadioButton)findViewById(R.id.mRb2); 
		
	        //给RadioGroup设置事件监听 
		mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 


				@Override 
	            public void onCheckedChanged(RadioGroup group, int checkedId) { 
	                // TODO Auto-generated method stub 
	                if(checkedId==mRb1.getId()){ 
	                    femailormail =0;
	                }else if(checkedId==mRb2.getId()){ 
	                	femailormail =1;
	                } 
	            } 
	        }); 
		   if(UserGender.equals("0")){
			   mRb1.setChecked(true);
	           femailormail =0;
		   }
		   if(UserGender.equals("1")){
			   mRb2.setChecked(true);
	           femailormail =1;
		   }
		
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

	private void showDate() {
        View view = View.inflate(getApplicationContext(), R.layout.date, null);  
        final DatePicker datePicker = (DatePicker)view.findViewById(R.id.new_act_date_picker);  
        int year;  
        int month;  
        int day;  
        final Calendar c = Calendar.getInstance();  
        year = c.get(Calendar.YEAR);  
        month = c.get(Calendar.MONTH);  
        day = c.get(Calendar.DAY_OF_MONTH);  
        datePicker.init(year, month, day, null);  
        
        AlertDialog.Builder builder = new AlertDialog.Builder(TZ4_1iActivity.this);  
        builder.setView(view);  
        builder.setTitle(R.string.a88);  
        builder.setPositiveButton(R.string.a89, new DialogInterface.OnClickListener() {  
            @Override  
            public void onClick(DialogInterface dialog, int which) {  
                int arrive_year = datePicker.getYear();  
                int arrive_month = datePicker.getMonth();  
                int arrive_day = datePicker.getDayOfMonth();  
               // String dateStr = DateUtil.formatDate(arrive_year, arrive_month, arrive_day);  
                mTvre6.setText(""+arrive_month+"-"+arrive_day+"-"+arrive_year);  
                  
            }  
        });  
        builder.show();  
        
	}

	OnClickListener listener =new OnClickListener() {
		

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mTvre6:
		    	if(mFlag){
		    		showDate();
		    	}
		    	break;
			case R.id.mBtnRegister:
				if (mBtnRegister.getText().toString().equals(getResources().getString(R.string.a101))) {
					mEt1.setFocusable(true);
					mEt1.setFocusableInTouchMode(true);
					mFlag =true;
					mRg1.setClickable(true);
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


private void initData() {
	downloadsearch("0");
}
public void downloadsearch(String area11){
	progressBar_sale.setVisibility(View.VISIBLE);
	 RequestParams params = new RequestParams();
	 
   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);
	   nameValuePairs.add(new BasicNameValuePair("UserName", mEt1.getEditableText().toString()));
	   nameValuePairs.add(new BasicNameValuePair("UserID",  UserID));
   nameValuePairs.add(new BasicNameValuePair("UserGender", femailormail+""));
   nameValuePairs.add(new BasicNameValuePair("UserBirthday",mTvre6.getText().toString()));
   
   params.addBodyParameter(nameValuePairs);
   HttpUtils http = new HttpUtils();
   http.send(HttpRequest.HttpMethod.POST,
  		 "http://josie.i3.com.hk/dishtag/json/m_infoedit.php",
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
										editor.putString("UserBirthday",mTvre6.getText().toString()); 
										editor.putString("UserGender",femailormail+""); 
										editor.commit(); 
										mBtnRegister.setText(getResources().getString(
												R.string.a101));
										   mRg1.setClickable(false);
											mEt1.setFocusableInTouchMode(false);
											mEt1.setFocusable(false);
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
            Intent intent =new Intent(getApplicationContext(), TZ4_1pActivity.class);
            intent.putExtra("PATH", tempFile1.getPath());
            startActivity(intent);
		break;
	}
}
}
