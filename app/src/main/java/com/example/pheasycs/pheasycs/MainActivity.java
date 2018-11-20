package com.example.pheasycs.pheasycs;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

// This is the main activity
public class MainActivity extends AppCompatActivity {

    // This function is called when the activity is created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The activity_main layout is set.
        setContentView(R.layout.activity_main);

        // The toolbar is set.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // The tablayout is set.
        TabLayout tabLayout = findViewById(R.id.tabs);

        // The listener for page and tab changer is instantiated.
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        // If the global variable fragmentValue is different than -1, the tab selected is the last.
        // That is for when the app is restarted it doesnt take you to the start.
        if(MyProperties.getInstance().fragmentValue != -1) {
            tabLayout.getTabAt(2).select();
        }
    }

    // Restart the app to change the XML layout of the third fragment.
    public void Restart(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    // This is the adapter for the fragments.
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // This sets the actual fragment to the selected item.
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new HomeFragment();
                case 1:
                    return new TopicsFragment();
                case 2:
                    return new FormulasFragment();
                default:
                    return null;
            }
        }

        // The number of tabs is returned
        @Override
        public int getCount() {
            return 3;
        }
    }
}
