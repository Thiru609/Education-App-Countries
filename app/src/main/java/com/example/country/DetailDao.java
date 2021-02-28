package com.example.country;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DetailDao {
    @Insert
    void insertAll(CountriesDetail... users);
    @Query("SELECT * FROM country")
    List<CountriesDetail> getAll();
    @Query("DELETE FROM country")
    void nukeTable();
}
