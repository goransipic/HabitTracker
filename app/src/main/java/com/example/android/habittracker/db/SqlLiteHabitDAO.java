package com.example.android.habittracker.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;


import com.example.android.habittracker.model.Habit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by goransi on 30.6.2016..
 */
public class SqlLiteHabitDAO implements HabitDAO {

    SQLiteOpenHelper mSqLiteOpenHelper;

    /**
     * @param sqLiteOpenHelper
     */
    public SqlLiteHabitDAO(@NonNull SQLiteOpenHelper sqLiteOpenHelper) {

        mSqLiteOpenHelper = sqLiteOpenHelper;

    }

    /**
     * @param habit
     */
    @Override
    public long insertHabit(Habit habit) {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();

        contentValues.put(HabitContract.HabitTracker.COLUMN_HABIT_TYPE, habit.getHabitType());
        contentValues.put(HabitContract.HabitTracker.COLUMN_HABIT_COUNTER, habit.getHabitCounter());

        return db.insert(HabitContract.HabitTracker.TABLE_NAME, null, contentValues);
    }

    /**
     *
     *
     */
    @Override
    public List<Habit> findAll() {

        SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();
        List<Habit> habitList = new ArrayList<>();


        String[] procjection = {
                HabitContract.HabitTracker._ID,
                HabitContract.HabitTracker.COLUMN_HABIT_TYPE,
                HabitContract.HabitTracker.COLUMN_HABIT_COUNTER
        };

        String sortOrder = HabitContract.HabitTracker.COLUMN_HABIT_TYPE + " DESC";

        Cursor cursor = db.query(HabitContract.HabitTracker.TABLE_NAME, procjection, null, null, null, null, sortOrder);

        cursor.moveToFirst();

        try {
            while (cursor.moveToNext()) {

                Habit habitTemp = new Habit(null, 0);

                String habitType = cursor.getString(cursor.getColumnIndex(HabitContract.HabitTracker.COLUMN_HABIT_TYPE));
                int habitCounter = cursor.getInt(cursor.getColumnIndex(HabitContract.HabitTracker.COLUMN_HABIT_COUNTER));

                habitTemp.setHabitType(habitType);
                habitTemp.setHabitCounter(habitCounter);

                habitList.add(habitTemp);
            }
        } finally { // prevent leaking cursor
            cursor.close();
        }

        return habitList;

    }

    /**
     * @return
     */
    @Override
    public boolean deleteAllHabits() {

        final SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();


        int row = db.delete(HabitContract.HabitTracker.TABLE_NAME,
                null, null);


        return row != -1;
    }

    /**
     * @param oldhabit
     * @param newhabit
     * @return
     */
    @Override
    public boolean updateHabit(Habit oldhabit, Habit newhabit) {

        final SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitContract.HabitTracker.COLUMN_HABIT_TYPE, newhabit.getHabitType());
        contentValues.put(HabitContract.HabitTracker.COLUMN_HABIT_COUNTER, newhabit.getHabitCounter());

        int row = db.update(HabitContract.HabitTracker.TABLE_NAME, contentValues, HabitContract.HabitTracker.COLUMN_HABIT_TYPE +
                "=?" + " AND " + HabitContract.HabitTracker.COLUMN_HABIT_COUNTER +
                "=?", new String[]{oldhabit.getHabitType(), Integer.toString(oldhabit.getHabitCounter())});


        return row != 1;

    }


}
