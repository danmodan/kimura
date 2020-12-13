package com.danilove.kimura.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.danilove.kimura.dao.TvShowDao;
import com.danilove.kimura.models.TvShow;

@Database(entities = TvShow.class, version = 1, exportSchema = false)
public abstract class TvShowDatabase extends RoomDatabase {

    private static TvShowDatabase tvShowDatabase;

    public static synchronized TvShowDatabase getTvShowDatabase(Context context) {

        if (tvShowDatabase == null) {
            tvShowDatabase = Room.databaseBuilder(
                    context,
                    TvShowDatabase.class,
                    "tv_shows_db"
            ).build();
        }
        return tvShowDatabase;
    }

    public abstract TvShowDao tvShowDao();
}
