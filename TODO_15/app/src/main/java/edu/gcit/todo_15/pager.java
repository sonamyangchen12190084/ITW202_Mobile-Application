package edu.gcit.todo_15;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pager extends FragmentPagerAdapter{
    int numofTabs;

    public pager(@NonNull FragmentManager fm, int behavior){
        super(fm,behavior);
        numofTabs = behavior;

    }
    @NonNull
    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                return new TapFragment1();

            case 1:
                return new TapFragment2();

            case 2:
                return new TapFragment3();

            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return numofTabs;
    }
}
