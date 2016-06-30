package com.example.android.habittracker;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;


import com.example.android.habittracker.db.HabitContract;
import com.example.android.habittracker.db.HabitDatabase;
import com.example.android.habittracker.db.SqlLiteHabitDAO;
import com.example.android.habittracker.model.Habit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by goransi on 30.6.2016..
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class DatabaseTest {

    private static final String TAG = DatabaseTest.class.getSimpleName();
    private Context mContext;
    private SqlLiteHabitDAO mSqlLiteHabitDAO;

    @Before
    public void deleteTheDatabase() {
        mContext = InstrumentationRegistry.getTargetContext();
        mSqlLiteHabitDAO = new SqlLiteHabitDAO(new HabitDatabase(mContext));

        mContext.deleteDatabase(HabitDatabase.DATABASE_NAME);
    }

    @Test
    public void test_insert() {

        insertDummyData();
    }

    @Test
    public void test_data_reading() {

        insertDummyData();

        List<Habit> habitList = mSqlLiteHabitDAO.findAll();

        Log.d(TAG, "test_data_reading: " + habitList.toString());

    }

    @Test
    public void test_deletion() {
        insertDummyData();

        mSqlLiteHabitDAO.deleteAllHabits();

    }

    @Test
    public void test_updating() {

        Habit habitEnglish = new Habit("learning english", 3);
        mSqlLiteHabitDAO.insertHabit(habitEnglish);

        mSqlLiteHabitDAO.updateHabit(habitEnglish,new Habit("learning polo",3));
    }


    public void insertDummyData() {
        Habit habitEnglish = new Habit("learning english", 3);
        Habit habitRunning = new Habit("running", 6);

        // insert some value
        mSqlLiteHabitDAO.insertHabit(habitEnglish);
        mSqlLiteHabitDAO.insertHabit(habitRunning);
    }


}
