package com.example.heinhtet.newfeeds.Splash_Intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.example.heinhtet.newfeeds.R;

/**
 * Created by heinhtet on 2/18/17.
 */

public class Splash_Screen extends AppCompatActivity {
    public static final int SPLASH_DURATION = 2000;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent appIntro = new Intent(Splash_Screen.this,Wellcome_Activity.class);
                startActivity(appIntro);
            }
        },SPLASH_DURATION);
    }


}

