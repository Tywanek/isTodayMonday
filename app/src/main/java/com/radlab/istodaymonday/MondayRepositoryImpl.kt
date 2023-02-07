package com.radlab.istodaymonday

import android.util.Log
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.Year
import java.time.temporal.TemporalAdjusters
import java.util.Locale

class MondayRepositoryImpl : MondayRepository {

    private fun getToday(): LocalDate? {
        return LocalDate.now()
    }

    private fun getAllMondays(): ArrayList<LocalDate> {
        val allMondays: ArrayList<LocalDate> = ArrayList()
        val startDate: Month = Month.valueOf("January".uppercase(Locale.getDefault()))
        var endDate = LocalDate.ofYearDay(Year.now().value, 1).plusYears(1)
        var date: LocalDate =
            Year.now().atMonth(startDate).atDay(1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))
        while (date <= endDate) {
            allMondays.add(date)
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY))
        }
        return allMondays
    }

    override fun isTodayMonday(): Boolean {
        getAllMondays().forEach {
            if (it == getToday()) {
                Log.d("###", "I have found!!!")
                return true
            }
        }
        return false
    }
}