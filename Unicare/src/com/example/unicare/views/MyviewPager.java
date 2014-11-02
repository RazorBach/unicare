package com.example.unicare.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyviewPager extends ViewPager{
	
	public MyviewPager(Context context) {
		super(context);
	}
	


	public MyviewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	
	
	//以下两个方法的处理是为了禁止viewPager滑动翻页
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		return false;
	}
}
