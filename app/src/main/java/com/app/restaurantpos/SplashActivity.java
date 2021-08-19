package com.app.restaurantpos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import com.app.restaurantpos.login.LoginActivity;
import com.ncorti.slidetoact.SlideToActView;

public class SplashActivity extends AppCompatActivity{


  public static int splashTimeOut = 1000;
  SlideToActView swipe_btn;
  ConstraintLayout root_layout;

  @Override
  protected void onResume() {
    swipe_btn.resetSlider();
    super.onResume();
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    swipe_btn = findViewById(R.id.swipe_btn);
    root_layout = findViewById(R.id.root_layout);
    swipe_btn.resetSlider();
    swipe_btn.setOnSlideToActAnimationEventListener(new SlideToActView.OnSlideToActAnimationEventListener() {
      @Override
      public void onSlideCompleteAnimationStarted(SlideToActView slideToActView, float v) {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(0, R.anim.swipe_up);
        swipe_btn.resetSlider();
      }

      @Override
      public void onSlideCompleteAnimationEnded(SlideToActView slideToActView) {

      }

      @Override
      public void onSlideResetAnimationStarted(SlideToActView slideToActView) {

      }

      @Override
      public void onSlideResetAnimationEnded(SlideToActView slideToActView) {

      }
    });

/*
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/
/*
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, splashTimeOut);*/
  }
}

