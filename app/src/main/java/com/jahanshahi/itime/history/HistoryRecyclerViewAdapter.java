package com.jahanshahi.itime.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jahanshahi.itime.R;
import com.jahanshahi.itime.models.Item;

import java.util.List;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.HistoryRecyclerViewViewHolder> {

    private Context context;
    private List<Item> items;

    public HistoryRecyclerViewAdapter(Context context , List<Item> items) {
        this.context = context;
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
        Item item = items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class HistoryRecyclerViewViewHolder extends RecyclerView.ViewHolder{

        public HistoryRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
