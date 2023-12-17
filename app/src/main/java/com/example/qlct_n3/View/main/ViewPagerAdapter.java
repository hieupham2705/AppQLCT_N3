package com.example.qlct_n3.View.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.qlct_n3.View.calendar.CalendarFragment;
import com.example.qlct_n3.View.chart.ChartFragment;
import com.example.qlct_n3.View.home.HomeFragment;
import com.example.qlct_n3.View.menu.MenuFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new CalendarFragment();
            case 2:
                return new ChartFragment();
            case 3:
                return new MenuFragment();
            default:
                return new MenuFragment();
        }
    }
}


