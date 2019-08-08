package com.jahanshahi.itime.dbUtil;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.jahanshahi.itime.dao.ItemDAO;
import com.jahanshahi.itime.models.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO getItemDAO();
}
