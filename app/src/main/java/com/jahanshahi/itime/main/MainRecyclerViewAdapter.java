package com.jahanshahi.itime.main;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jahanshahi.itime.R;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {
    private Context context;
    private List<MainItem> items;
    private Typeface font;
    public MainRecyclerViewAdapter(Context context,List<MainItem> items){
        this.context = context;
        this.items = items;
        font = Typeface.createFromAsset(context.getAssets(),"fonts/vazir.ttf");
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainItem item = items.get(position);
        holder.background.setImageDrawable(item.getBackground());
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView background;
        TextView title;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.item_main_bg);
            title = itemView.findViewById(R.id.item_main_title);
            title.setTypeface(font);
        }
    }
}
