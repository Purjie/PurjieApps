package com.purnamaadjie.myapplication;
// 1 Maret 2019 10116079 Purnama Adjie AKB-2

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    Button btn_next;
    int position = 0;
    Button btnGetStarted;
    TabLayout tab_indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        //hide bar
        getSupportActionBar().hide();

        //variable
        btn_next = findViewById(R.id.button);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        tab_indicator = findViewById(R.id.tab_indicator);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Daily Activity", "Pada halaman ini pengguna dapat melihat aktivitas keseharian saya", R.drawable.wall_daily));
        mList.add(new ScreenItem("Gallery", "Pada halaman ini pengguna dapat melihat gallery foto saya", R.drawable.wall_gallery));
        mList.add(new ScreenItem("Profil", "Pada halaman ini pengguna dapat melihat profil saya", R.drawable.wall_profile));

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        tab_indicator.setupWithViewPager(screenPager);

        //btn intent

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, NavbarActivity.class);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if (position == mList.size()){

                    //TODO : show the GETSTARTED Button and hide the indicator and the next button

                    loadLastScreen ();
                }
            }
        });

    }

    private void loadLastScreen() {
        btn_next.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tab_indicator.setVisibility(View.VISIBLE);
    }
}
