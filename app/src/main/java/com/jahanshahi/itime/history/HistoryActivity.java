package com.jahanshahi.itime.history;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.jahanshahi.itime.R;

public class HistoryActivity extends AppCompatActivity {
    private Typeface font;
    private RecyclerView recyclerView;
    private HistoryRecyclerViewAdapter historyRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initial(this);
        setContentView(R.layout.activity_history);
        //Setup Views
        setupViews(this);
    }

    private void setupViews(Activity activity) {
        recyclerView = findViewById(R.id.history_recycler_view);
        historyRecyclerViewAdapter = new HistoryRecyclerViewAdapter(activity,null);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(historyRecyclerViewAdapter);
    }

    private void initial(Activity activity){
        //Hide StatusBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Set Font
        font = Typeface.createFromAsset(activity.getAssets(),"");
    }
}
