package com.example.android.habittracker.db;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by goransi on 30.6.2016..
 */
public class HabitContract {

    private HabitContract() {
    }

    /**
     * Columns supported by "entries" records.
     */
    public static class HabitTracker implements BaseColumns {
        /**
         * Table name where records are stored for "entry" resources.
         */
        public static final String TABLE_NAME = "habit_tracker";
        /**
         * Habit type
         */
        public static final String COLUMN_HABIT_TYPE = "habit";

        public static final String COLUMN_HABIT_COUNTER = "counter";
    }


}
