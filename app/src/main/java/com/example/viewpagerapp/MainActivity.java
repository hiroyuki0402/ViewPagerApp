package com.example.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        tabLayout = findViewById(R.id.tablayout);

        myViewPagerAdapter = new MyViewPagerAdapter(
        getSupportFragmentManager(),
        getLifecycle());

        // アダプタークラスのリストにフラグメントを追加する
        myViewPagerAdapter.addFragment(new Fragment1());
        myViewPagerAdapter.addFragment(new Fragment2());
        myViewPagerAdapter.addFragment(new Fragment3());

        // 初期化
        viewPager2 = findViewById(R.id.ViewPager2);

        // ViewPagerの方向
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        viewPager2.setAdapter(myViewPagerAdapter);

        new TabLayoutMediator(
                tabLayout,
                viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("Fragment " +(position +1));
                    }
                }
        ).attach();


    }
}
