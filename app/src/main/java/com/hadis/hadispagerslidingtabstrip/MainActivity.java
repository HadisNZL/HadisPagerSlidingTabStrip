package com.hadis.hadispagerslidingtabstrip;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import com.hadis.hadispagerslidingtabstrip.tabutil.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        tabs.setViewPager(pager);
        tabs.setIndicatorColorResource(R.color.line_color);//下滑条颜色
        tabs.setTextSize(45);//字体大小
        tabs.setTextColorResource(R.color.white);//字体颜色
        tabs.setUnderlineHeight(2);//下滑条背景槽
        tabs.setIndicatorHeight(10);//下滑条粗细大小
        //tabs.setDividerColorResource(R.color.mycolor);//竖直分割线颜色
        tabs.setBackgroundResource(R.color.background);
        tabs.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL), Typeface.NORMAL);//字体类型
        tabs.setSelectedTextColorResource(R.color.black);//选中字体颜色值
        tabs.setSelectedTabTextSize(45);//选中字体的大小
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        private final String[] TITLES = {"Hadis", "没有理由不爱你", "价值", "核心", "生活", "公益", "能量"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 1) {
                return SecendFrgament.newInstance(position);
            }
            return HomeFragment.newInstance(position);
        }

    }
}
