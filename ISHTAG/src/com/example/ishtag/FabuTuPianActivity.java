package com.example.ishtag;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.Spinner;

public class FabuTuPianActivity extends Activity {

	private String PATH;
	private ImageView mIvfbp;
	private ImageView mIvre1;
	private Spinner spinner;
	private ArrayList<String> data_list;
	private ArrayAdapter<String> arr_adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.fabutupian);
	 PATH =	getIntent().getExtras().getString("PATH");

		initView();
		
		
	}

	private void initView() {
        spinner = (Spinner) findViewById(R.id.spinner);
        //����
        data_list = new ArrayList<String>();
        data_list.add("JOPPERSSATA PICCANTE");
        data_list.add("JOPPERSSATA PICCANTE1");
        data_list.add("JOPPERSSATA PICCANTE");
        data_list.add("JOPPERSSATA PICCANTE");
        

		// �ڶ�����Ϊ�����б���һ����������������õ���ǰ�涨���list��
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.myspinner, data_list);
		// ��������Ϊ���������������б�����ʱ�Ĳ˵���ʽ�� simple_spinner_item
		adapter.setDropDownViewResource(R.layout.myspinnertheme);
		// ���Ĳ�������������ӵ������б���
		
		spinner.setAdapter(adapter);
		// ���岽��Ϊ�����б����ø����¼�����Ӧ���������Ӧ�˵���ѡ��
        spinner
		.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				/* ����ѡmySpinner ��ֵ����myTextView �� */
				arg0.setVisibility(View.VISIBLE);
				spinner.setSelection(position);
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				arg0.setVisibility(View.VISIBLE);
			}
		});
/* �����˵�����������ѡ����¼����� */
        spinner.setOnTouchListener(new Spinner.OnTouchListener() {
	public boolean onTouch(View v, MotionEvent event) {
		return false;
	}
	
});
        spinner.setVisibility(View.VISIBLE);
/* �����˵�����������ѡ���ı��¼����� */
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
			default:
				break;
			}
		}
	};
}
