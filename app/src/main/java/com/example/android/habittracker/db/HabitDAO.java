package com.example.android.habittracker.db;

import com.example.android.habittracker.model.Habit;

import java.util.List;

/**
 * Created by goransi on 30.6.2016..
 */
public interface HabitDAO {

    long insertHabit(Habit habit);

    boolean deleteAllHabits();

    boolean updateHabit(Habit oldhabit, Habit newhabit);

    List<Habit> findAll();


}
