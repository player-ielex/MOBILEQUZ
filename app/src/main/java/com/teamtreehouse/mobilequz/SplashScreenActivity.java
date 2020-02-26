package com.teamtreehouse.mobilequz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    public volatile boolean interrupt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread nest = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (!interrupt) {
                        Intent intent = new Intent(SplashScreenActivity.this, QuizActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        nest.start();
    }


    @Override
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
        interrupt = true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        interrupt = true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }


}



