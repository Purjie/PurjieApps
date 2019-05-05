package com.purnamaadjie.myapplication;
// 28 April 2019 10116079 Purnama Adjie AKB-2

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Space;

public class SplashActivity extends Activity {
    Button walltrought;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread() {
            public void run () {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }

}
