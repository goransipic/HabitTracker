package com.example.android.habittracker.model;

/**
 * Created by goransi on 30.6.2016..
 */
public class Habit {

    private String mHabitType;

    private int mHabitCounter;

    public Habit(String habitType, int habitCounter) {
        this.mHabitType = habitType;
        this.mHabitCounter = habitCounter;
    }

    public String getHabitType() {
        return mHabitType;
    }

    public void setHabitType(String habitType) {
        this.mHabitType = habitType;
    }

    public int getHabitCounter() {
        return mHabitCounter;
    }

    public void setHabitCounter(int habitCounter) {
        this.mHabitCounter = habitCounter;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Habit)) return false;

        Habit habit = (Habit) obj;

        if (this.mHabitType.equals(habit.getHabitType()) && this.mHabitCounter == habit.getHabitCounter()) {
            return true;
        }else {
            return false;
        }

    }
}
