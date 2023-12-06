package com.example.qlct_n3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.qlct_n3.View.ViewPagerAdapter;
import com.example.qlct_n3.base.DataBaseManager;
import com.example.qlct_n3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (binding == null) {
            binding = ActivityMainBinding.inflate(getLayoutInflater());
        }
        setContentView(binding.getRoot());

        DataBaseManager database = DataBaseManager.getInstance(getApplicationContext());
        binding.meowbottomnavigation.add(new MeowBottomNavigation.Model(0, R.drawable.pencil));
        binding.meowbottomnavigation.add(new MeowBottomNavigation.Model(1, R.drawable.lich));
        binding.meowbottomnavigation.add(new MeowBottomNavigation.Model(2, R.drawable.bao_cao_icon));
        binding.meowbottomnavigation.add(new MeowBottomNavigation.Model(3, R.drawable.menu_icon));
        meownavigation();
    }

    private void meownavigation() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        binding.viewpager.setAdapter(adapter);
        binding.meowbottomnavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                binding.viewpager.setCurrentItem(item.getId());
            }
        });
        binding.meowbottomnavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
            }
        });
        binding.meowbottomnavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
            }
        });
        binding.meowbottomnavigation.show(0, true);
        binding.viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.meowbottomnavigation.show(position, true);
            }
        });
    }

}