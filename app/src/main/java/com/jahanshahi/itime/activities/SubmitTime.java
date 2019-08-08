package com.jahanshahi.itime.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jahanshahi.itime.R;

import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class SubmitTime extends AppCompatActivity {
    private PersianCalendar persianCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_time);
        persianCalendar = new PersianCalendar();
//        Toast.makeText(this, persianCalendar.getPersianYear()+"/"+persianCalendar.getPersianMonth()+"/"+persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, persianCalendar.getPersianShortDateTime(), Toast.LENGTH_LONG).show();
//        Toast.makeText(this, persianCalendar.getPersianShortDateTime().substring(11,19), Toast.LENGTH_SHORT).show();
    }
}
