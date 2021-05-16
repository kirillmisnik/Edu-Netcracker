package ru.netcracker.tasks.basics.collections.calendar;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Проверочный класс для CalendarDate.
 */
class CalendarDateTest {
    private final CalendarDate date1 = new CalendarDate("19990930 1320");
    private final CalendarDate date2 = new CalendarDate("20011114 1615");
    private final CalendarDate date3 = new CalendarDate("19871212 1645");

    @org.junit.jupiter.api.Test
    void getAsDate() {
        List<Date> expected = new ArrayList<Date>();
        expected.add(new Date(99, Calendar.SEPTEMBER, 30, 13, 20));
        expected.add(new Date(101, Calendar.NOVEMBER, 14, 16, 15));
        expected.add(new Date(87, Calendar.DECEMBER, 12, 16, 45));

        List<Date> actual = new ArrayList<Date>();
        actual.add(date1.getAsDate());
        actual.add(date2.getAsDate());
        actual.add(date3.getAsDate());

        assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void getDateAsCalendar() {
        List<Calendar> expected = new ArrayList<Calendar>();
        Calendar calDate1 = Calendar.getInstance();
        Calendar calDate2 = Calendar.getInstance();
        Calendar calDate3 = Calendar.getInstance();
        calDate1.setTime(new Date(99, Calendar.SEPTEMBER, 30, 13, 20));
        calDate2.setTime(new Date(101, Calendar.NOVEMBER, 14, 16, 15));
        calDate3.setTime(new Date(87, Calendar.DECEMBER, 12, 16, 45));
        expected.add(calDate1);
        expected.add(calDate2);
        expected.add(calDate3);

        List<Calendar> actual = new ArrayList<Calendar>();
        actual.add(date1.getAsCalendar());
        actual.add(date2.getAsCalendar());
        actual.add(date3.getAsCalendar());

        assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void getDateAsCalendarException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CalendarDate("1999-30-09 13:20");
        });

        String expectedMessage = "Неверный формат даты";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}