package com.jahanshahi.itime.history;

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
import com.jahanshahi.itime.models.Item;

import java.util.ArrayList;
import java.util.List;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.HistoryRecyclerViewViewHolder> {

    private Context context;
    private List<HistoryItem> items = new ArrayList<>();
    private Typeface font;
    public HistoryRecyclerViewAdapter(Context context ) {
        this.context = context;
        font = Typeface.createFromAsset(context.getAssets(),"fonts/vazir.ttf");
    }

    private void addItem(HistoryItem item){
        items.add(item);
        notifyDataSetChanged();
    }

    public List<HistoryItem> getItems() {
        return items;
    }

    public void setItems(List<HistoryItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HistoryRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_history,parent,false);
        return new HistoryRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryRecyclerViewViewHolder holder, int position) {
        HistoryItem item = items.get(position);
        holder.icon.setImageDrawable(item.getIcon());
        holder.date.setText(item.getDate());
        holder.start.setText(item.getStartTime());
        holder.end.setText(item.getEndTime());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class HistoryRecyclerViewViewHolder extends RecyclerView.ViewHolder{
        private ImageView icon , remove, edit;
        private TextView date , start , end;
        public HistoryRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.main_item_icon);
            remove = itemView.findViewById(R.id.history_remove);
            edit = itemView.findViewById(R.id.history_edit);
            date = itemView.findViewById(R.id.history_date);
            start = itemView.findViewById(R.id.history_start_time);
            end = itemView.findViewById(R.id.history_end_time);
            date.setTypeface(font);
            start.setTypeface(font);
            end.setTypeface(font);
        }
    }
}
