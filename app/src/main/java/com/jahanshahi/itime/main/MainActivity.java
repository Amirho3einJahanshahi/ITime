package com.jahanshahi.itime.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jahanshahi.itime.R;
import com.jahanshahi.itime.activities.ExportToCSV;
import com.jahanshahi.itime.activities.ExportToPDF;
import com.jahanshahi.itime.activities.PickTime;
import com.jahanshahi.itime.activities.SubmitTime;
import com.jahanshahi.itime.history.HistoryActivity;

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
        for (int i = 0; i < 5; i++) {
            MainItem item = new MainItem();
            switch (i) {
                case 0:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.clock_ic));
                    item.setTitle("ثبت زمان و تاریخ");
                    item.setDescription("زمان و تاریخ حضور را به صورت دستی وارد نمایید");
                    item.setDestination(PickTime.class);
                    break;
                case 1:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.clock_cal_ic));
                    item.setTitle("ثبت زمان و تاریخ");
                    item.setDescription("زمان و تاریخ حضور را وارد نمایید");
                    item.setDestination(SubmitTime.class);
                    break;
                case 2:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.history_ic));
                    item.setTitle("تاریخچه");
                    item.setDescription("تاریخچه زمان ها را مشاهده نمایید");
                    item.setDestination(HistoryActivity.class);
                    break;
                case 3:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.pdf_ic));
                    item.setTitle("خروجی PDF");
                    item.setDescription("از تاریخچه زمان ها خروجی pdf بگیرید");
                    item.setDestination(ExportToPDF.class);
                    break;
                case 4:
                    item.setBackground(ContextCompat.getDrawable(activity, R.drawable.excel_ic));
                    item.setTitle("خروجی EXCEL");
                    item.setDescription("از تارخچه زمان ها خروجی excel بگیرید");
                    item.setDestination(ExportToCSV.class);
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
