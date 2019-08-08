package com.jahanshahi.itime.main;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jahanshahi.itime.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainRecyclerViewAdapter mainRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initial
        initial(this);
        setContentView(R.layout.activity_main);
        //Setup Views
        setupViews(this);
    }

    private void setupViews(Activity activity) {
        recyclerView = activity.findViewById(R.id.main_recycler_view);
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(activity, getItems(activity));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(mainRecyclerViewAdapter);
    }

    private List<MainItem> getItems(Activity activity) {
        List<MainItem> items = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            MainItem item = new MainItem();
            item.setTitle("عنوان");
            item.setDescription("توضیحات");
            switch (i) {
                case 0:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.clock_ic));
                    break;
                case 1:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.clock_cal_ic));
                    break;
                case 2:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.pdf_ic));
                    break;
                case 3:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.excel_ic));
                    break;
            }
            items.add(item);
        }
        return items;
    }

    private void initial(Activity activity) {
        //Hide StatusBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
