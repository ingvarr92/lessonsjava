package dateTime;

import oct_nov.lesson7.local.Local;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

// time Api

public class TstDate {

    public static void main(String[] args) throws InterruptedException {


//        Date date1 = new Date();
//        System.out.println(date1);
//
//
//        Thread.sleep(3000);
//
//        Date date2 = new Date();
//        System.out.println(date2);
//
//
//        System.out.println(date1.before(date2));
//        System.out.println(date1.after(date2));
//        System.out.println(date1.equals(date2));
//
//       Calendar calendar = new GregorianCalendar(2018,0,12);
//        System.out.println(calendar);
//        Date date3 = calendar.getTime();
//
//        System.out.println(date3);
//
//        calendar.set(Calendar.YEAR, 2018);
//        calendar.set(Calendar.MONTH, 11);
//        calendar.set(Calendar.DAY_OF_MONTH, 23);
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 34);
//        calendar.get(Calendar.YEAR);
//
//        System.out.println(calendar.getTime());
//        calendar.add(Calendar.MONTH,3);// крутит и месяц и год и дальше...
//        calendar.add(Calendar.MONTH,-3);
//        calendar.roll(Calendar.MONTH,3);// метод roll крутит только то что мы указываем, остальное не изменно
//        System.out.println(calendar.getTime());
//
//        DateFormat dateFormat = new SimpleDateFormat("dd MM yy HH:mm");
//
//        System.out.println(dateFormat.format(calendar.getTime()));



/////////////time Api


        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2018,1,13);
        LocalDate localDate2 = LocalDate.parse("2018-11-10");
        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println(localDate2);


        LocalDate plusDay = localDate.plusDays(21);
        System.out.println(plusDay);

        LocalDate minus = localDate.minus(1, ChronoUnit.MONTHS);
        System.out.println(minus);

        boolean after = localDate.isAfter(localDate1);
        System.out.println(after);
        boolean before = localDate.isBefore(localDate1);
        System.out.println(before);


        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(23,1);
        LocalTime localTime2 = LocalTime.parse("13:20");
        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);

        System.out.println(localDate.getEra());
        System.out.println(localTime.getNano());


        LocalDate now = LocalDate.now();
        LocalDate nowPlus7 = now.plus(Period.ofDays(7));
        System.out.println(now);
        System.out.println(nowPlus7);

        System.out.println(Period.between(localDate,localDate1).getDays());


        System.out.println(ChronoUnit.DAYS.between(now,nowPlus7));

        LocalTime nowTime = LocalTime.now();
        LocalTime nowPlus = nowTime.plus(Duration.ofMinutes(20));
        System.out.println(Duration.between(nowTime,nowPlus).getSeconds());
        System.out.println(ChronoUnit.MINUTES.between(nowTime,nowPlus));


        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(allZoneIds);

        ZoneId zoneId = ZoneId.of("Africa/Nairobi");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
    }
}
