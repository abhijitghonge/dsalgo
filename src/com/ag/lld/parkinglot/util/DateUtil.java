package com.ag.lld.parkinglot.util;

import com.ag.lld.parkinglot.model.enums.QueryType;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final int FINANCIAL_YEAR_FIRST_MONTH = 3;
    private static final int FINANCIAL_YEAR_END_MONTH = 2;

    public static void main(String[] args) {
        Pair<Date, Date> currentMonth = getDateRange(QueryType.CURRENT_MONTH);
        Pair<Date, Date> previousMonth = getDateRange(QueryType.PREVIOUS_MONTH);
        Pair<Date, Date> currentFY = getDateRange(QueryType.CURRENT_FY);
        Pair<Date, Date> previousFY = getDateRange(QueryType.PREVIOUS_FY);

        System.out.printf("Current Month is from %s to %s%n",format(currentMonth.getKey()), format(currentMonth.getValue()));
        System.out.printf("Previous Month is from %s to %s%n",format(previousMonth.getKey()), format(previousMonth.getValue()));

        System.out.printf("Current FY is from %s to %s%n",format(currentFY.getKey()), format(currentFY.getValue()));

        System.out.printf("Previous FY is from %s to %s%n",format(previousFY.getKey()), format(previousFY.getValue()));

    }

    public static String format(Date date){
        // Define the date format
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        // Format the date
        return dateFormatter.format(date);

    }

    public static Pair<Date, Date> getDateRange(QueryType queryType) {
        Date currentDate = getCurrentDate();
        int month = getMonthFor(currentDate);
        int year = getYearFor(currentDate);

        switch (queryType) {
            case CURRENT_MONTH:
                Date startDate = getStartOfMonth(month, year);
                Date endDate = getEndOfMonth(month, year);
                return new Pair<>(startDate, endDate);
            case PREVIOUS_MONTH:
                startDate = getStartOfMonth(month - 1, year);
                endDate = getEndOfMonth(month - 1, year);
                return new Pair<>(startDate, endDate);
            case CURRENT_FY:
                startDate = getStartOfFY(year);
                endDate = getEndOfFY(year);
                return new Pair<>(startDate, endDate);
            case PREVIOUS_FY:
                startDate = getStartOfFY(year - 1);
                endDate = getEndOfFY(year - 1);
                return new Pair<>(startDate, endDate);
            default:
                startDate = getStartOfMonth(month, year);
                endDate = getEndOfMonth(month, year);
                return new Pair<>(startDate, endDate);
        }
    }

    private static Date getEndOfFY(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, FINANCIAL_YEAR_END_MONTH);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.YEAR, year);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    private static Date getStartOfFY(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MONTH, FINANCIAL_YEAR_FIRST_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.YEAR, year - 1);
       // System.out.println(format(calendar.getTime()));
        return calendar.getTime();
    }

    private static Date getEndOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month + 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    private static Date getStartOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    private static int getMonthFor(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.MONTH);
    }

    private static int getYearFor(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    private static Date getCurrentDate() {
        return new Date();
    }


}
