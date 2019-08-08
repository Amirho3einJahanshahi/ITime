package com.jahanshahi.itime.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jahanshahi.itime.models.Item;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    void insert(Item... items);
    @Update
    void update(Item... items);
    @Delete
    void delete(Item... items);
    @Query("SELECT * FROM times")
    List<Item> getItems();
//    @Query("SELECT * FROM items WHERE id = :id")
//    Item getItemById(Long id);
}
