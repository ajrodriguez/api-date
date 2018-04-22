package com.ajrodriguez.oca.api.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

public class Main {

	public static void main(String[] args) {

//		LocalDate wrongDate = LocalDate.of(2018, 13, 1);

		LocalDate okDate = LocalDate.of(2018, Month.valueOf("JANUARY"), 1);
		System.out.println(okDate);

		LocalDate okDate2 = LocalDate.of(2018, Month.valueOf("JANUARY"), 4);
		System.out.println(okDate2);

		// Up an hour or Exception?
//		LocalTime localTime = LocalTime.of(10, 70);
//		System.out.println(localTime);
		
		// Up a minute or Exception?
		// Minutes start in ZERO
//		LocalTime localTime1 = LocalTime.of(10, 9, 70);
//		System.out.println(localTime1);
		
		LocalTime localTime2 = LocalTime.of(10, 9, 59);
		System.out.println(localTime2);
		
		// Combine
		LocalDateTime localDandT = LocalDateTime.of(okDate2, localTime2);
		System.out.println(localDandT);
		
		// Exception, plus month...?
		localDandT.plusDays(40);
		System.out.println(localDandT);
		
		localDandT = localDandT.plusDays(40);
		System.out.println(localDandT);
		
		// Instant (from 1970/01/01)
		
		// Duration & Period
		
		// Temporal
		LocalDateTime localDateAndTime = LocalDateTime.now();
		
		LocalDateTime dateTime1 = localDateAndTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		LocalDateTime dateTime2 = localDateAndTime.with(TemporalAdjusters.firstDayOfNextMonth());
		LocalDateTime dateTime3 = localDateAndTime.with(TemporalAdjusters.lastDayOfMonth());
		
		System.out.println(dateTime1);
		System.out.println(dateTime2);
		System.out.println(dateTime3);
		
	}

}
