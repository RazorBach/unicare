package com.example.unicare.activity;


import com.example.unicare.R;
import com.example.unicare.fragment.FunctionFragment;
import com.example.unicare.fragment.SettingFragment;
import com.example.unicare.fragment.StatisticsFragment;
import com.example.unicare.fragment.WorkBenchFragment;
import com.example.unicare.views.MyviewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/*
 * 工作台页面
 * @author ch
 */

public class MainActivity extends FragmentActivity {
	
	private MyviewPager viewPager;
	public static MainActivity instance;
	private WorkBenchFragment workBenchFragment;
	private StatisticsFragment statisticsFragment;
	private FunctionFragment functionFragment;
	private SettingFragment settingFragment;
	public static int currentTabIndex = 0;// 当前页面编码
	private LinearLayout mTab1, mTab2, mTab3, mTab4;
	private ImageView mTab_iv1, mTab_iv2, mTab_iv3, mTab_iv4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bottom);
		viewPager = (MyviewPager) findViewById(R.id.tabpager);
		mTab1 = (LinearLayout) findViewById(R.id.ll_workbench);
		mTab_iv1 = (ImageView) mTab1.findViewById(R.id.iv_workbench);
		// 默认工作台页是选中的
		mTab_iv1.setImageDrawable(getResources().getDrawable(
				R.drawable.tab_icon1_p));
		mTab2 = (LinearLayout) findViewById(R.id.ll_function);
		mTab_iv2 = (ImageView) mTab2.findViewById(R.id.iv_function);
		mTab3 = (LinearLayout) findViewById(R.id.ll_statistics);
		mTab_iv3 = (ImageView) mTab3.findViewById(R.id.iv_statistics);
		mTab4 = (LinearLayout) findViewById(R.id.ll_setting);
		mTab_iv4 = (ImageView) mTab4.findViewById(R.id.iv_setting);
		mTab1.setOnClickListener(new MyOnClickListener(0));
		mTab2.setOnClickListener(new MyOnClickListener(1));
		mTab3.setOnClickListener(new MyOnClickListener(2));
		mTab4.setOnClickListener(new MyOnClickListener(3));
		viewPager.setOnClickListener(new MyOnClickListener(0));
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
		viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), 4));
		viewPager.setOffscreenPageLimit(0);
		instance = MainActivity.this;
		
	}

	private class TabAdapter extends FragmentStatePagerAdapter {
		private int size;

		public TabAdapter(FragmentManager fm, int size) {
			super(fm);
			this.size = size;
		}

		@Override
		public Fragment getItem(int pos) {
			switch (pos) {
			case 0: {
				if (workBenchFragment == null)
					workBenchFragment = new WorkBenchFragment(MainActivity.this);
				return workBenchFragment;
			}
			case 1: {
				if (functionFragment == null)
					functionFragment = new FunctionFragment(MainActivity.this);
				return functionFragment;
			}
			case 2: {
				if (statisticsFragment == null)
					statisticsFragment = new StatisticsFragment(MainActivity.this);				
				return statisticsFragment;
			}
			case 3: 
				if (settingFragment == null)
					settingFragment = new SettingFragment(MainActivity.this);
				return settingFragment;
			}
			return null;
		}

		@Override
		public int getCount() {
			return size;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			Log.d("destroyItem", "position" + position);
			super.destroyItem(container, position, object);
		}

		@Override
		public Object instantiateItem(View container, int position) {
			Log.d("instantiateItem", "position" + position);
			return super.instantiateItem(container, position);

		}

	}
	
	/**
	 * ͷ��������
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			viewPager.setCurrentItem(index);
		}
	};
	
	/*
	 * 页卡切换监听(原作者:D.Winter)
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			// 首先将之前选中的tab的背景改为normal
			if (currentTabIndex == 0) {
				mTab_iv1.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon1_n));
			} else if (currentTabIndex == 1) {
				mTab_iv2.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon2_n));

			} else if (currentTabIndex == 2) {
				mTab_iv3.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon3_n));
			} else if (currentTabIndex == 3) {
				mTab_iv4.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon4_n));
			}
			// 将当前移动到的tab的背景改为press
			switch (arg0) {
			case 0:
				mTab_iv1.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon1_p));
				break;
			case 1:
				mTab_iv2.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon2_p));
				break;
			case 2:
				mTab_iv3.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon3_p));
				break;
			case 3:
				mTab_iv4.setImageDrawable(getResources().getDrawable(
						R.drawable.tab_icon4_p));
				break;
			}
			currentTabIndex = arg0;
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
	



}
