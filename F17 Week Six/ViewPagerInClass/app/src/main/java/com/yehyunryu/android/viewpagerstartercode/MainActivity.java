package com.yehyunryu.android.viewpagerstartercode;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private CustomPagerAdapter mAdapter;

    //TODO 6. Create News Fragment
    //TODO 7. Create Video Fragment
    //TODO 8. Create MarketPlace Fragment
    //TODO 9. Create Notifications Fragment
    //TODO 10. Create Settings Fragment

    //TODO 11. Inside each of the fragment layout files
        //Change view group to ConstraintLayout
        //Delete TextView and Add ImageView

    //TODO 12. Create ViewPager adapter class
    //TODO 13. Extend FragmentPagerAdapter
    //TODO 14. Override getItem(), getCount(), and getPageTitle()
    //TODO 15. Add constructor which takes in a FragmentManager

    //TODO 16. Bind TabLayout and ViewPager
    //TODO 17. Initialize CustomPagerAdapter and set it as the adapter to viewpager
    //TODO 18. Set view pager of tab layout

    //TODO 19. Change color resources
    //TODO 20. Add icons in the drawable folder
    //TODO 21. Delete getPageTitle()
    //TODO 22. Add icons to each tab
    //TODO 23. Add tab selected listener


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTablayout = (TabLayout) findViewById(R.id.main_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        for(int i = 0; i < mTablayout.getTabCount(); i++) {
            mTablayout.getTabAt(i).setIcon(R.mipmap.ic_launcher);
        }
    }
}
