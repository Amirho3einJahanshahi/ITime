package com.jahanshahi.itime.activities;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.jahanshahi.itime.R;

import java.util.Calendar;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class PickTimeActivity extends AppCompatActivity {
    private PersianDatePickerDialog picker;
    private Typeface font;
    private Button enter_date, enter_start_time, enter_end_time, enter;
    private TextView enter_date_text, enter_start_time_text, enter_end_time_text;
    private boolean isFirstStart = true;
    private boolean isFirstEnd = true;
    private boolean isDateDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initial(this);
        setContentView(R.layout.activity_pick_time);
        setupViews(this);
    }

    private void setupViews(final Activity activity) {
        final Time today = new Time(Time.getCurrentTimezone());
        enter_date = activity.findViewById(R.id.enter_date);
        enter_start_time = activity.findViewById(R.id.enter_start_time);
        enter_end_time = activity.findViewById(R.id.enter_end_time);
        enter = activity.findViewById(R.id.enter);
        enter_date_text = activity.findViewById(R.id.enter_date_text);
        enter_start_time_text = activity.findViewById(R.id.enter_start_time_text);
        enter_end_time_text = activity.findViewById(R.id.enter_end_time_text);
        enter_date.setTypeface(font);
        enter_start_time.setTypeface(font);
        enter_end_time.setTypeface(font);
        enter.setTypeface(font);
        enter_date_text.setTypeface(font);
        enter_start_time_text.setTypeface(font);
        enter_end_time_text.setTypeface(font);
        enter_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(PickTimeActivity.this);
            }
        });
        enter_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(activity,enter_start_time_text,"ساعت شروع : ");
            }
        });
        enter_end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(activity,enter_end_time_text,"ساعت پایان : ");
            }
        });
    }

    private void initial(Activity activity) {
        //Hide StatusBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Set Font
        font = Typeface.createFromAsset(activity.getAssets(), "fonts/vazir.ttf");
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
                .setActionTextColor(ContextCompat.getColor(activity, R.color.colorPrimary))
                .setTypeFace(font)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        enter_date_text.setText(enter_date_text.getText() + " " + persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay());
                    }

                    @Override
                    public void onDismissed() {
                        Toast.makeText(activity, "Dismiss!", Toast.LENGTH_SHORT).show();
                    }
                });

        picker.show();
    }
    private void showTimeDialog(Activity activity, final TextView textView, final String text){
        textView.setText("");
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                textView.setText(text+" "+selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("انتخاب زمان");
        mTimePicker.show();
    }
}