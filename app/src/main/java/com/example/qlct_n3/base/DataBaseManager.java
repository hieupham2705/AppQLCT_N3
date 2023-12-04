package com.example.qlct_n3.base;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.qlct_n3.Dao.Dao;
import com.example.qlct_n3.Model.DanhMuc;
import com.example.qlct_n3.Model.GiaoDich;
import com.example.qlct_n3.Model.HoaDon;
import com.example.qlct_n3.Model.NguoiDung;

@Database(entities = {DanhMuc.class, GiaoDich.class, HoaDon.class, NguoiDung.class}, version = 1, exportSchema = false)
public abstract class DataBaseManager extends RoomDatabase {
    public abstract Dao getItemDAO();

    private static volatile DataBaseManager INSTANCE;

    public static DataBaseManager getInstance(Context context) {
        DataBaseManager tempInstance = INSTANCE;
        if (tempInstance != null) {
            return tempInstance;
        }
        synchronized(DataBaseManager.class) {
            DataBaseManager instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DataBaseManager.class,
                    "data"
            ).fallbackToDestructiveMigration().build();
            INSTANCE = instance;
            return instance;
        }
    }
}

