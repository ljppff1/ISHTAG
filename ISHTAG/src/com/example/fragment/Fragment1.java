package com.example.fragment;import com.example.ishtag.R;import android.annotation.SuppressLint;import android.os.Bundle;import android.support.annotation.Nullable;import android.support.v4.app.Fragment;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;@SuppressLint("NewApi")public class Fragment1 extends Fragment{	private View parentView;	@Override	@Nullable	public View onCreateView(LayoutInflater inflater,			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {		parentView = inflater.inflate(R.layout.fragment1, container, false);				return parentView;	}}