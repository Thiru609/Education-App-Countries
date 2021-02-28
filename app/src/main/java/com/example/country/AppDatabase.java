package com.example.country;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;


@Database(entities = {CountriesDetail.class}, version = 1, exportSchema = false)
    @TypeConverters(BorderTypeConverters.class)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract DetailDao userDao();
    }

