package com.jahanshahi.itime.activities;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.jahanshahi.itime.R;

import java.util.Calendar;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class PickTime extends AppCompatActivity {
    private PersianDatePickerDialog picker;
    private Typeface font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initial(this);
        setContentView(R.layout.activity_pick_time);
        showTimePickerDialog(this);
    }

    private void initial(Activity activity){
        //Hide StatusBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Set Font
        font = Typeface.createFromAsset(activity.getAssets(),"fonts/vazir.ttf");
    }

    private void showTimePickerDialog(final Activity activity) {
        PersianCalendar initDate = new PersianCalendar();
        initDate.setPersianDate(1378, 3, 22);
        picker = new PersianDatePickerDialog(this)
                .setPositiveButtonString("تایید")
                .setNegativeButton("انصراف")
                .setTodayButton("بیا به امروز")
                .setTodayButtonVisible(true)
                .setInitDate(initDate)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setMinYear(1300)
                .setActionTextColor(ContextCompat.getColor(activity,R.color.colorPrimary))
                .setTypeFace(font)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        Toast.makeText(activity, persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed() {
                        Toast.makeText(activity, "Dismiss!", Toast.LENGTH_SHORT).show();
                    }
                });

        picker.show();
    }

}
