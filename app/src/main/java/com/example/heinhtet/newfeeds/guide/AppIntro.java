package com.example.heinhtet.newfeeds.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.example.heinhtet.newfeeds.MainActivity;
import com.example.heinhtet.newfeeds.R;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by heinhtet on 2/24/17.
 */

public class AppIntro extends com.github.paolorotolo.appintro.AppIntro {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Slide 1","This is slide 1",R.drawable.book, ContextCompat.getColor(getApplicationContext(),R.color.bg_screen3)));
        addSlide(AppIntroFragment.newInstance("Slide 2","This is slide 2",R.drawable.book, ContextCompat.getColor(getApplicationContext(),R.color.bg_screen2)));
        addSlide(AppIntroFragment.newInstance("Slide 3","This is slide 3",R.drawable.book, ContextCompat.getColor(getApplicationContext(),R.color.bg_screen1)));

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent main = new Intent(AppIntro.this, MainActivity.class);
        startActivity(main);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }
}
