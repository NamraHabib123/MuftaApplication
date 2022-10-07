package com.example.muftaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    ImageView image;
    TextView textView;
    Animation top, bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this line is for the full screen display
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        //action bar ko remove karny ka dosra way themes main ja kar (parent="Theme.MaterialComponents.DayNight.DarkActionBar) is main action bar remove kar do

        getSupportActionBar().hide();

        image=findViewById(R.id.logo);
        textView=findViewById(R.id.tvtext);

        top= AnimationUtils.loadAnimation(this,R.anim.top);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottom);

        image.setAnimation(top);
        textView.setAnimation(bottom);


        int secondsDelayed = 2;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splashscreen.this, signupactivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}