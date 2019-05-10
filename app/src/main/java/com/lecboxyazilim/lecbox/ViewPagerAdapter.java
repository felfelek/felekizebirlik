package com.lecboxyazilim.lecbox;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment selectedFragment = new Fragment();
        switch (i){
            case 0:
                selectedFragment =izmir_to_manisa.newInstance();
                break;
            case 1:
                selectedFragment=manisa_to_izmir.newInstnc();
                break;
                default:return null;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence charSequence;
        switch (position){
            case 0:
                charSequence= "İzmir'den Manisa'ya";
                break;
            case 1:
                charSequence="Manisa'dan İzmir'e";
                break;
                default: return null;

        }
        return charSequence;
    }
}

