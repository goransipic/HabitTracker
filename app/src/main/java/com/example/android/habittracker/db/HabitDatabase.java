package com.example.android.habittracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by goransi on 30.6.2016..
 */
public class HabitDatabase extends SQLiteOpenHelper {

    /**
     * Schema version.
     */
    public static final int DATABASE_VERSION = 1;
    /**
     * Filename for SQLite file.
     */
    public static final String DATABASE_NAME = "HabitTracker.db";

    private static final String TYPE_TEXT = " TEXT";
    private static final String TYPE_INTEGER = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String UNIQUE = "UNIQUE";
    /**
     * SQL statement to create "HABIT TRACKER" table.
     */
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HabitContract.HabitTracker.TABLE_NAME + " (" +
                    HabitContract.HabitTracker._ID + " INTEGER PRIMARY KEY," +
                    HabitContract.HabitTracker.COLUMN_HABIT_TYPE + TYPE_TEXT + UNIQUE + COMMA_SEP +
                    HabitContract.HabitTracker.COLUMN_HABIT_COUNTER + TYPE_INTEGER + ")";

    /**
     * SQL statement to drop "entry" table.
     */
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HabitContract.HabitTracker.TABLE_NAME;

    public HabitDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }



}
