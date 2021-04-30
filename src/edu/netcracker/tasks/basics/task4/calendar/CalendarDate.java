package edu.netcracker.tasks.task4.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Формирует объекты Date и Calendar по следующим данным, вводимым пользователем:
 * <Год><Месяц><Число> <Часы><минуты>, <Часы> вводятся в 24-х часовом формате.
 */
public class CalendarDate {
    private Date date;

    public CalendarDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hhmm");
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Неверный формат даты");
        }
    }

    /**
     * Возвращает дату в формате Date.
     * @return дата в формате Date
     */
    public Date getAsDate() {
        return date;
    }

    /**
     * Возвращает дату в формате Calendar.
     * @return дата в формате Calendar
     */
    public Calendar getAsCalendar() {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(getAsDate());
        return calendarDate;
    }
}
