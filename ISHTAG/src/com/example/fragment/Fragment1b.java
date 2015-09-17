package com.example.fragment;import java.util.ArrayList;import java.util.List;import org.apache.http.NameValuePair;import org.apache.http.message.BasicNameValuePair;import org.json.JSONArray;import org.json.JSONException;import org.json.JSONObject;import com.example.ishtag.R;import com.example.ishtag.TZ4_1cActivity;import com.lidroid.xutils.HttpUtils;import com.lidroid.xutils.exception.HttpException;import com.lidroid.xutils.http.RequestParams;import com.lidroid.xutils.http.ResponseInfo;import com.lidroid.xutils.http.callback.RequestCallBack;import com.lidroid.xutils.http.client.HttpRequest;import com.nostra13.universalimageloader.core.DisplayImageOptions;import com.nostra13.universalimageloader.core.ImageLoader;import android.annotation.SuppressLint;import android.app.Activity;import android.content.SharedPreferences;import android.graphics.Bitmap;import android.os.Bundle;import android.support.annotation.Nullable;import android.support.v4.app.Fragment;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.view.View.OnClickListener;import android.widget.AdapterView;import android.widget.BaseAdapter;import android.widget.GridView;import android.widget.ImageView;import android.widget.ListView;import android.widget.ProgressBar;import android.widget.TextView;import android.widget.Toast;import android.widget.AdapterView.OnItemClickListener;public class Fragment1b extends Fragment  {private ListView mLv1;private Myadapter myadapter;private DisplayImageOptions options;private ArrayList<Data> mDataList_origin=new ArrayList<Fragment1b.Data>();private ArrayList<Data> mDataList=new ArrayList<Fragment1b.Data>();protected ImageLoader imageLoader = ImageLoader.getInstance();private ProgressBar progressBar_sale;private String UserID;@Override@Nullablepublic View onCreateView(LayoutInflater inflater,		@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {		View view =inflater.inflate(R.layout.fragment1b, container, false);		mLv1 =(ListView)view.findViewById(R.id.mLv1);		progressBar_sale =(ProgressBar)view.findViewById(R.id.progressBar_sale);		progressBar_sale.setVisibility(View.GONE);		SharedPreferences mySharedPreferences=getActivity(). getSharedPreferences("USER", Activity.MODE_PRIVATE); 		UserID=	mySharedPreferences.getString("UserID", ""); 	    initData();	    return view;}class Data{	String   ID;	String   Name;	String   StreetName;	String   AreaGross;	String   AreaNet;	String   SellingPrice;	String   RentPrice;	String   CoverPic;	@Override	public String toString() {		return "Data [ID=" + ID + ", Name=" + Name + ", StreetName="				+ StreetName + ", AreaGross=" + AreaGross + ", AreaNet="				+ AreaNet + ", SellingPrice=" + SellingPrice				+ ", RentPrice=" + RentPrice + ", CoverPic=" + CoverPic				+ "]";	}	}private void initData() {	progressBar_sale.setVisibility(View.VISIBLE);	downloadsearch("0");}public void downloadsearch(String area11){	 RequestParams params = new RequestParams();   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);   nameValuePairs.add(new BasicNameValuePair("UserType", 1+""));   params.addBodyParameter(nameValuePairs);   HttpUtils http = new HttpUtils();   http.send(HttpRequest.HttpMethod.POST,  		 "http://josie.i3.com.hk/dishtag/json/userlist.php",           params,           new RequestCallBack<String>() {				private String msg;				@Override				public void onFailure(HttpException arg0, String arg1) {					// TODO Auto-generated method stub									}				@Override				public void onSuccess(ResponseInfo<String> arg0) {					JSONObject jsonObject;					try {						jsonObject = new JSONObject(arg0.result);						String string_code = jsonObject.getString("code");						 msg = jsonObject.getString("msg");						 int  num_code=Integer.valueOf(string_code);						 if (num_code==1) {							 //保存到本地							 mDataList_origin.clear();							 JSONArray array = jsonObject.getJSONArray("data");							  for (int i = 0; i < array.length(); i++) {								  								  Data  data=new Data();								  								 JSONObject jsonObject2 = array.getJSONObject(i);								 data.ID= jsonObject2.getString("UserID");								 data.Name= jsonObject2.getString("UserName");								 mDataList_origin.add(data);								 		                          data.toString();						 							}							  mDataList.clear();							  mDataList.addAll(mDataList_origin);								progressBar_sale.setVisibility(View.GONE);							  initListView();						}						 else {							 Toast.makeText(getActivity(), msg, 0).show();								progressBar_sale.setVisibility(View.GONE);						}					} catch (JSONException e) {							 Toast.makeText(getActivity(), msg, 0).show();						e.printStackTrace();					}									}   });}private void initListView() {    myadapter = new Myadapter();    mLv1.setAdapter(myadapter);}class Holder{	TextView mTvw1;	ImageView mIv1,mIv2;}class  Myadapter extends   BaseAdapter{	@Override	public View getView(final int position, View convertView, ViewGroup parent) {		Holder holder = null;		if(convertView==null){			convertView = LayoutInflater.from(getActivity())					.inflate(R.layout.item_listview_41c, null);			holder = new Holder();/*			holder.mTvri10 =(TextView)convertView.findViewById(R.id.mTvri10);			holder.mTvri11 =(TextView)convertView.findViewById(R.id.mTvri11);			holder.mTvri12 =(TextView)convertView.findViewById(R.id.mTvri12);			holder.imageView =(ImageView)convertView.findViewById(R.id.iv_listview_rent_pic);*/								holder.mIv1 =(ImageView)convertView.findViewById(R.id.mIv1);	holder.mIv2 =(ImageView)convertView.findViewById(R.id.mIv2);	holder.mTvw1 =(TextView)convertView.findViewById(R.id.mTvw1);       				convertView.setTag(holder);		}else{			holder =(Holder)convertView.getTag();		}		holder.mIv2.setOnClickListener(new OnClickListener() {						@Override			public void onClick(View v) {				FriendID =mDataList.get(position).ID;				initData1();			}		});		holder.mTvw1.setText(mDataList.get(position).Name);	/*	holder.mTvri10.setText(mDataList.get(position).Name);		holder.mTvri11.setText(mDataList.get(position).StreetName);		initImageLoaderOptions();		imageLoader.displayImage(mDataList.get(position).CoverPic,				holder.imageView, options);		*/		if (position==0) {			holder.mIv1.setImageDrawable(getResources().getDrawable(R.drawable.t24));		}else{			holder.mIv1.setImageDrawable(getResources().getDrawable(R.drawable.t23));		}		if(position>8)		{			holder.mIv2.setImageDrawable(getResources().getDrawable(R.drawable.t21));		}else{			holder.mIv2.setImageDrawable(getResources().getDrawable(R.drawable.t20));		}		return convertView;	}	@Override	public int getCount() {		// TODO Auto-generated method stub		return mDataList.size();	}	@Override	public Object getItem(int position) {		// TODO Auto-generated method stub		return null;	}	@Override	public long getItemId(int position) {		// TODO Auto-generated method stub		return 0;	}}private String FriendID;/** * 关注用户 */private void initData1() {	progressBar_sale.setVisibility(View.VISIBLE);	downloadsearch1("0");}public void downloadsearch1(String area11){	 RequestParams params = new RequestParams();   List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(10);   nameValuePairs.add(new BasicNameValuePair("UserID", UserID));   nameValuePairs.add(new BasicNameValuePair("FriendID", FriendID));   params.addBodyParameter(nameValuePairs);   HttpUtils http = new HttpUtils();   http.send(HttpRequest.HttpMethod.POST,  		 "http://josie.i3.com.hk/dishtag/json/m_my_friends_add.php",           params,           new RequestCallBack<String>() {				private String msg;				@Override				public void onFailure(HttpException arg0, String arg1) {									}				@Override				public void onSuccess(ResponseInfo<String> arg0) {					JSONObject jsonObject;					try {						jsonObject = new JSONObject(arg0.result);						String string_code = jsonObject.getString("code");						 msg = jsonObject.getString("msg");						 int  num_code=Integer.valueOf(string_code);						 if (num_code==1) {							 Toast.makeText(getActivity(), msg, 0).show();								progressBar_sale.setVisibility(View.GONE);								for(int i=0;i<mDataList.size();i++){									if(FriendID.equals(mDataList.get(i).ID)){										mDataList.remove(i);									}								}								myadapter.notifyDataSetChanged();						}						 else {							 Toast.makeText(getActivity(), msg, 0).show();								progressBar_sale.setVisibility(View.GONE);						}					} catch (JSONException e) {						 Toast.makeText(getActivity(), msg, 0).show();						e.printStackTrace();					}									}   });}}