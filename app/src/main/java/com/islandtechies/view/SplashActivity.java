package com.islandtechies.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import com.islandtechies.R;
import com.islandtechies.view.adapter.SlideFragmentAdapter;
import com.islandtechies.view.impl.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends Activity implements ViewPager.OnTouchListener {

    @Bind(R.id.pager)
    ViewPager viewPager;

    float xTouch;
    private String MY_PREF = "preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        viewPager.setAdapter(new SlideFragmentAdapter(getFragmentManager(), getBaseContext()));
        viewPager.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xTouch = x;
                break;
            case MotionEvent.ACTION_MOVE:
                if (xTouch > x && viewPager.getCurrentItem() == (viewPager.getAdapter().getCount() - 1)) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    SplashActivity.this.finish();
                    SharedPreferences settings = getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("endedSlide", true);
                    editor.commit();
                }
                break;
        }
        return false;
    }
}
