package com.jahanshahi.itime.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.jahanshahi.itime.R;

public class MainActivity extends AppCompatActivity {
    private Typeface font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initial
        initial(this);
        setContentView(R.layout.activity_main);
        //Setup Views
        setupViews();
    }

    private void setupViews() {

    }

    private void initial(Activity activity){
        //Hide StatusBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Set Font
        font = Typeface.createFromAsset(activity.getAssets(),"fonts/vazir.ttf");
    }


}
