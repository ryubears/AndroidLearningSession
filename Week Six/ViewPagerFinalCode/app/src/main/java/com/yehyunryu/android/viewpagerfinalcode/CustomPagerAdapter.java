package com.yehyunryu.android.viewpagerfinalcode;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Yehyun Ryu on 11/10/2017.
 */

public class CustomPagerAdapter extends FragmentPagerAdapter{

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new NewsFragment();
            case 1:
                return new VideoFragment();
            case 2:
                return new MarketPlaceFragment();
            case 3:
                return new NotificationsFragment();
            default:
                return new SettingsFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    /*
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "News";
            case 1:
                return "Videos";
            case 2:
                return "MarketPlace";
            case 3:
                return "Notifications";
            default:
                return "Settings";
        }
    }
    */
}
