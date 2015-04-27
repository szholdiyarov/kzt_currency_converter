package com.zholdiyarov.convertyourtenge.helpers;

/**
 * Created by szholdiyarov on 4/21/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zholdiyarov.convertyourtenge.framents.CalculatorFragment;
import com.zholdiyarov.convertyourtenge.framents.ContactsFragment;
import com.zholdiyarov.convertyourtenge.framents.MainFragments;
import com.zholdiyarov.convertyourtenge.framents.RatesFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragement for Android Tab
                return new MainFragments();
            case 1:
                //Fragment for Ios Tab
                return new CalculatorFragment();
            case 2:
                //Fragment for Windows Tab
                return new ContactsFragment();

        }
        return null;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3; //No of Tabs
    }

}
