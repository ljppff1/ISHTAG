package com.example.ishtag;

import java.io.File;
import java.io.IOException;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TZ4_2Activity extends Activity {

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
	private ImageView mTIvt41i;
	private static final int TAKE_PICTURE = 0x000001;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t42);
		
		initView();
		
		
	}

	private void initView() {
		mTIvt41f =(ImageView)this.findViewById(R.id.mTIvt41f);
		mTIvt41f.setOnClickListener(listener);
		mTIvt41h1 =(ImageView)this.findViewById(R.id.mTIvt41h1);
		mTIvt41h1.setOnClickListener(listener);
		mTIvt41g =(ImageView)this.findViewById(R.id.mTIvt41g);
		mTIvt41g.setOnClickListener(listener);
		mTIvt41i =(ImageView)this.findViewById(R.id.mTIvt41i);
		mTIvt41i.setOnClickListener(listener);
		
		
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

	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mTIvt41i:
				startActivity(new Intent(getApplicationContext(), TZ4_2iActivity.class));
				break;
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
	private long exitTime=0;
/*	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK){
			if((System.currentTimeMillis() - exitTime) > 2000){
				Toast.makeText(getApplicationContext(), R.string.toast, 1).show();
				exitTime = System.currentTimeMillis();
				}else{
					finish();
					android.os.Process.killProcess(android.os.Process.myPid());
				}
			return true;
			}
		return super.dispatchKeyEvent(event);
	}

*/	private void photo() {
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
