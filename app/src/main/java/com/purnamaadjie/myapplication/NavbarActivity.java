package com.purnamaadjie.myapplication;
// 30 April 2019 10116079 Purnama Adjie AKB-2

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

 public class NavbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar_main);

        BottomNavigationView navigationView = findViewById(R.id.button_nav);

        final HomeFragment homeFragment = new HomeFragment();
        final DailyFragment dailyFragment = new DailyFragment();
        final GalleryFragment galleryFragment = new GalleryFragment();
        final MusicFragment musicFragment = new MusicFragment();
        final ProfilFragment profilFragment = new ProfilFragment();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home){
                    setFragment(homeFragment);
                    return true;
                } else if (id == R.id.daily){
                    setFragment(dailyFragment);
                    return true;
                } else if (id == R.id.gallery){
                    setFragment(galleryFragment);
                    return true;
                } else if (id == R.id.music){
                    setFragment(musicFragment);
                    return true;
                } else if (id == R.id.profil){
                    setFragment(profilFragment);
                    return true;
                }
                return false;
            }
        });

        navigationView.setSelectedItemId(R.id.home);

    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}
