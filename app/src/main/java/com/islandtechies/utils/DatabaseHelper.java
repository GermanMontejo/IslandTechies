package com.islandtechies.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "island_techies_db";
    private static final String TABLE_USERS = "users";
    private static final String TABLE_NEWS = "news";
    private static final int DATABASE_VERSION = 1;
    private DatabaseHelper databaseHelper = null;

    private DatabaseHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    public DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context);
        }

        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
