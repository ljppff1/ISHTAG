package com.example.ishtag;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import HaoRan.ImageFilter.CleanGlassFilter;
import HaoRan.ImageFilter.ComicFilter;
import HaoRan.ImageFilter.FilmFilter;
import HaoRan.ImageFilter.FocusFilter;
import HaoRan.ImageFilter.Gradient;
import HaoRan.ImageFilter.HslModifyFilter;
import HaoRan.ImageFilter.IImageFilter;
import HaoRan.ImageFilter.Image;
import HaoRan.ImageFilter.InvertFilter;
import HaoRan.ImageFilter.LomoFilter;
import HaoRan.ImageFilter.PaintBorderFilter;
import HaoRan.ImageFilter.SceneFilter;
import HaoRan.ImageFilter.dialog.LoadingDialog;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.utils.TypeFace;

public class TZ4_1pActivity extends BaseActivity {

	

	private Gallery gallery;
	private ImageView mIvf2a1;
	private String PATH;
	private Bitmap bitmap;
	private ImageView mIvnext;
	private ImageView mIvt1;
	private ProgressBar progressBar_sale;
	private TextView mTvww1;
	public static String SDPATH = Environment.getExternalStorageDirectory()
			+ "/ISHTAG/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.t41p);
		mTvww1 =(TextView)this.findViewById(R.id.mTvww1);
		mTvww1.setTypeface(new TypeFace().getTypeFace1(getApplicationContext()) );

		PATH =getIntent().getExtras().getString("PATH");
		//Toast.makeText(getApplicationContext(), PATH, 1).show();
		initView();		
	}
	
	private void initView() {
		progressBar_sale =(ProgressBar)this.findViewById(R.id.progressBar_sale);
		progressBar_sale.setVisibility(View.GONE);

		mIvnext =(ImageView)this.findViewById(R.id.mIvnext);
		mIvnext.setOnClickListener(listener);
		mIvt1 =(ImageView)this.findViewById(R.id.mIvt1);
		mIvt1.setOnClickListener(listener);
		 gallery = (Gallery) this.findViewById(R.id.galleryFilter);
		 mIvf2a1 =(ImageView)this.findViewById(R.id.mIvwhatp);
		
		 new backup().execute();
			LoadImageFilter();

	}
	private Bitmap bitmap11;
	public class backup extends AsyncTask<Void, Void, Void>{
       @Override
    protected void onPreExecute() {
   		progressBar_sale.setVisibility(View.VISIBLE);
    	super.onPreExecute();
    }
		@Override
		protected Void doInBackground(Void... params) {
			Bitmap  bitmap1 = BitmapFactory.decodeFile(PATH);
			  bitmap11 =comp(bitmap1);
			  resultBitMap =bitmap11;
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			  mIvf2a1.setImageBitmap(bitmap11);
				progressBar_sale.setVisibility(View.GONE);
				findViewById(R.id.mRr1).setVisibility(View.GONE);

			super.onPostExecute(result);
		}
		
	}


	private void LoadImageFilter() {
		final ImageFilterAdapter filterAdapter = new ImageFilterAdapter(getApplicationContext());
		//AseoZdpAseo.initTimer(this);
		gallery.setAdapter(new ImageFilterAdapter(getApplicationContext()));
		gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				IImageFilter filter = (IImageFilter) filterAdapter.getItem(position);
				new processImageTask(TZ4_1pActivity.this, filter).execute();
			}
		});
	}

	private Bitmap resultBitMap;
	private LoadingDialog dialog1;

	public class processImageTask extends AsyncTask<Void, Void, Bitmap> {
		private IImageFilter filter;
        private Activity activity = null;
		private LoadingDialog dialog;
		public processImageTask(Activity activity, IImageFilter imageFilter) {
			this.filter = imageFilter;
			this.activity = activity;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new LoadingDialog(TZ4_1pActivity.this, "In rendering...");
			dialog.show();
		}

		public Bitmap doInBackground(Void... params) {
			Image img = null;
			try
	    	{
				//Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.aa8);
				img = new Image(bitmap11);
				if (filter != null) {
					img = filter.process(img);
					img.copyPixelsFromBuffer();
				}
				return img.getImage();
	    	}
			catch(Exception e){
				if (img != null && img.destImage.isRecycled()) {
					img.destImage.recycle();
					img.destImage = null;
					System.gc(); // 提醒系统及时回收
				}
			}
			finally{
				if (img != null && img.image.isRecycled()) {
					img.image.recycle();
					img.image = null;
					System.gc(); // 提醒系统及时回收
				}
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			if(result != null){
				super.onPostExecute(result);
				resultBitMap = result;
				mIvf2a1.setImageBitmap(result);	
			}
			dialog.dismiss();
		}
	}
	private Bitmap comp(Bitmap image) {  
	      
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();         
	    image.compress(Bitmap.CompressFormat.JPEG, 100, baos);  
	    if( baos.toByteArray().length / 1024>1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出    
	        baos.reset();//重置baos即清空baos  
	        image.compress(Bitmap.CompressFormat.JPEG, 50, baos);//这里压缩50%，把压缩后的数据存放到baos中  
	    }  
	    ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());  
	    BitmapFactory.Options newOpts = new BitmapFactory.Options();  
	    //开始读入图片，此时把options.inJustDecodeBounds 设回true了  
	    newOpts.inJustDecodeBounds = true;  
	    Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);  
	    newOpts.inJustDecodeBounds = false;  
	    int w = newOpts.outWidth;  
	    int h = newOpts.outHeight;  
	    //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为  
	    float hh = 800f;//这里设置高度为800f  
	    float ww = 480f;//这里设置宽度为480f  
	    //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可  
	    int be = 1;//be=1表示不缩放  
	    if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放  
	        be = (int) (newOpts.outWidth / ww);  
	    } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放  
	        be = (int) (newOpts.outHeight / hh);  
	    }  
	    if (be <= 0)  
	        be = 1;  
	    newOpts.inSampleSize = be;//设置缩放比例  
	    //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了  
	    isBm = new ByteArrayInputStream(baos.toByteArray());  
	    bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);  
	    return compressImage(bitmap);//压缩好比例大小后再进行质量压缩  
	}  
	private Bitmap compressImage(Bitmap image) {  
		  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中  
        int options = 100;  
        while ( baos.toByteArray().length / 1024>500) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩         
            baos.reset();//重置baos即清空baos  
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中  
            options -= 10;//每次都减少10  
        }  
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中  
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片  
        return bitmap;  
    }  
	public void save(View view){

		SaveBitmap(resultBitMap);
	}
	
	//保存到本地  
    public void SaveBitmap(Bitmap bmp) {  
    	  Date date = new Date();
    	  SimpleDateFormat format = new SimpleDateFormat("hh-mm-ss");
    	  String newDate = format.format(date);
    	  String path = "/sdcard/namecard";
/*    	  if (!destDir.exists()) {
    	   destDir.mkdirs();
    	  }
*/    	  makeRootDirectory(SDPATH);
    	  File f = new File(SDPATH+"pic"+newDate+".png");
    	  try {
	    	   FileOutputStream out = new FileOutputStream(f);
	    	   bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
	    	   out.flush();
	    	   out.close();
	    	 //  Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
	    	   Intent intent =new Intent(getApplicationContext(),FabuTuPianActivity.class);
	    	   intent.putExtra("PATH", SDPATH+"pic"+newDate+".png");
	    	   startActivity(intent);
    	  } catch (FileNotFoundException e) {
    	       e.printStackTrace();

    	    //   Toast.makeText(getApplicationContext(), "保存失败1", Toast.LENGTH_SHORT).show();
    	  } catch (IOException e) {
   	     //  Toast.makeText(getApplicationContext(), "保存失败2", Toast.LENGTH_SHORT).show();
    	       e.printStackTrace();
    	  }
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

	
	public class ImageFilterAdapter extends BaseAdapter {
		private class FilterInfo {
			public int filterID;
			public IImageFilter filter;

			public FilterInfo(int filterID, IImageFilter filter) {
				this.filterID = filterID;
				this.filter = filter;
			}
		}

		private Context mContext;
		private List<FilterInfo> filterArray = new ArrayList<FilterInfo>();

		public ImageFilterAdapter(Context c) {
			mContext = c;
			filterArray.add(new FilterInfo(R.drawable.rr1, new HslModifyFilter(40f)));
			filterArray.add(new FilterInfo(R.drawable.rr2, new HslModifyFilter(60f)));
			filterArray.add(new FilterInfo(R.drawable.rr3, new HslModifyFilter(80f)));
			filterArray.add(new FilterInfo(R.drawable.rr4, new HslModifyFilter(100f)));
			filterArray.add(new FilterInfo(R.drawable.rr5, new HslModifyFilter(150f)));
			filterArray.add(new FilterInfo(R.drawable.rr6, new HslModifyFilter(200f)));
			filterArray.add(new FilterInfo(R.drawable.rr7, new HslModifyFilter(250f)));
			filterArray.add(new FilterInfo(R.drawable.rr8, new HslModifyFilter(300f)));
			filterArray.add(new FilterInfo(R.drawable.ra1, new ComicFilter()));
			filterArray.add(new FilterInfo(R.drawable.ra2, new SceneFilter(5f, Gradient.Scene())));//green
			filterArray.add(new FilterInfo(R.drawable.ra3, new SceneFilter(5f, Gradient.Scene1())));//purple
			filterArray.add(new FilterInfo(R.drawable.ra4, new SceneFilter(5f, Gradient.Scene2())));//blue
			filterArray.add(new FilterInfo(R.drawable.ra5, new SceneFilter(5f, Gradient.Scene3())));
			filterArray.add(new FilterInfo(R.drawable.ra6, new FilmFilter(80f)));
			filterArray.add(new FilterInfo(R.drawable.ra7, new FocusFilter()));
			filterArray.add(new FilterInfo(R.drawable.ra8, new CleanGlassFilter()));
			filterArray.add(new FilterInfo(R.drawable.ra9, new PaintBorderFilter(0x00FF00)));//green
			filterArray.add(new FilterInfo(R.drawable.ra10, new PaintBorderFilter(0x00FFFF)));//yellow
			filterArray.add(new FilterInfo(R.drawable.ra11, new PaintBorderFilter(0xFF0000)));//blue
			filterArray.add(new FilterInfo(R.drawable.ra12, new LomoFilter()));
			filterArray.add(new FilterInfo(R.drawable.ra13, new InvertFilter()));

		}

		public int getCount() {
			return filterArray.size();
		}

		public Object getItem(int position) {
			return position < filterArray.size() ? filterArray.get(position).filter
					: null;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			Bitmap bmImg = BitmapFactory
					.decodeResource(mContext.getResources(),
							filterArray.get(position).filterID);
			int width = 200;// bmImg.getWidth();
			int height = 200;// bmImg.getHeight();
			bmImg.recycle();
			ImageView imageview = new ImageView(mContext);
			imageview.setImageResource(filterArray.get(position).filterID);
			imageview.setLayoutParams(new Gallery.LayoutParams(width, height));
			imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);// 设置显示比例类型
			return imageview;
		}
	};
	@Override
	protected void onResume() {
 	   if(dialog1!=null)
 	   dialog1.cancel();
 	   dialog1=null;
		super.onResume();
	}
	
	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mIvnext:
				if(resultBitMap!=null&&dialog1==null){
					dialog1 = new LoadingDialog(TZ4_1pActivity.this, "Saving pictures...");

					dialog1.show();

				SaveBitmap(resultBitMap);
				}else{
			    	// //  Intent intent =new Intent(getApplicationContext(),FabuTuPianActivity.class);
			    	//   intent.putExtra("PATH",PATH);
			    	//   startActivity(intent);

				}
				break;
			case R.id.mIvt1:
				finish();
				break;

			}
		}

	};

}
