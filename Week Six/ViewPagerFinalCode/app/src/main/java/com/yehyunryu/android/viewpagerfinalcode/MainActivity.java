package com.yehyunryu.android.viewpagerfinalcode;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private CustomPagerAdapter mAdapter;

    private static int[] mBlueIcons = {
            R.drawable.news_blue,
            R.drawable.video_blue,
            R.drawable.marketplace_blue,
            R.drawable.notifications_blue,
            R.drawable.settings_blue
    };

    private static int[] mGrayIcons = {
            R.drawable.news_gray,
            R.drawable.video_gray,
            R.drawable.marketplace_gray,
            R.drawable.notifications_gray,
            R.drawable.settings_gray
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);

        mAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        for(int i = 0; i < mTabLayout.getTabCount(); i++) {
            if(i == 0) {
                mTabLayout.getTabAt(i).setIcon(R.drawable.news_blue);
            } else {
                mTabLayout.getTabAt(i).setIcon(mGrayIcons[i]);
            }
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(mBlueIcons[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(mGrayIcons[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.setIcon(mBlueIcons[tab.getPosition()]);
            }
        });
    }
}
