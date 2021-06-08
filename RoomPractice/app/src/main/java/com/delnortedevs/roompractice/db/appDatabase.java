package com.delnortedevs.roompractice.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TvShow.class}, version = 1)
public abstract class appDatabase extends RoomDatabase {

    // definir el DAO y como accederlo
    public abstract TvShowDao getTvShowDao();

    private static appDatabase INSTANCE;

    public static synchronized  appDatabase getInstance(Context context){

        if (INSTANCE == null){
            INSTANCE = buildDatabaseInstance(context);
        }

        return INSTANCE;
    }

    private static appDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,appDatabase.class, "tvshowsDB.db").allowMainThreadQueries().build();
    }

}
