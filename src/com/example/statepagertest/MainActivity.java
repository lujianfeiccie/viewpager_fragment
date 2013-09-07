package com.example.statepagertest;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity
{
	String tag = getClass().getSimpleName();
	// 每个页面的Fragment
	List<Fragment> fragments = new ArrayList<Fragment>();
	// 每个Fragment对应的title
	List<String> fragmentTtile = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_pager);

		ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
		fragments.add(new MyFragment1());
		fragments.add(new MyFragment2());

		fragmentTtile.add("常联系的人");
		fragmentTtile.add("陌生人");

		viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments, fragmentTtile));
		viewPager.setOnPageChangeListener(new OnPageChangeListener(){
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			//	log("onPageScrollStateChanged "+arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			//	log("onPageScrolled "+arg0+ " "+arg1+" "+arg2);
			}

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				log("onPageSelected "+arg0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	class MyFragmentAdapter extends FragmentPagerAdapter
	{
		List<Fragment> frags;
		List<String> fragTitles;

		public MyFragmentAdapter(FragmentManager fm, List<Fragment> frag, List<String> title)
		{
			super(fm);
			this.frags = frag;
			this.fragTitles = title;
		}

		@Override
		public Fragment getItem(int arg0)
		{
			return frags.get(arg0);
		}

		@Override
		public int getCount()
		{
			return frags.size();
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			return fragTitles.get(position);
		}
		
	}

	public class MyFragment1 extends Fragment
	{
		/**
		 * 覆盖此函数，先通过inflater inflate函数得到view最后返回
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
			View v = inflater.inflate(R.layout.view_pager_fragment_demo1, container, false);
			return v;
		}
	}
	public class MyFragment2 extends Fragment
	{
		/**
		 * 覆盖此函数，先通过inflater inflate函数得到view最后返回
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
			View v = inflater.inflate(R.layout.view_pager_fragment_demo2, container, false);
			return v;
		}
	}
	void log(String msg){
		Log.d(tag, msg);
	}
}
