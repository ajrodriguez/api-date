package com.ajrodriguez.oca.api.date;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
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
		Instant instant = Instant.ofEpochSecond(120);
		Instant epoch = Instant.EPOCH;
		Instant.now();
		Instant.now(new Clock() {
			
			@Override
			public Clock withZone(ZoneId zone) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Instant instant() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ZoneId getZone() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		// Duration & Period
		LocalTime localTime01 = LocalTime.of(12, 25);
		LocalTime localTime02 = LocalTime.of(17, 35);
		Duration duration = Duration.between(localTime01, localTime02);
		
		Duration oneDayDuration1 = Duration.of(1, ChronoUnit.DAYS);
		Duration oneDayDuration2 = Duration.ofDays(1);
		
		LocalDate localDate01 = LocalDate.of(2016, Month.JULY, 18);
		LocalDate localDate02 = LocalDate.of(2016, Month.JULY, 20);
		Period period = Period.between(localDate01, localDate02);
		
		Period period01 = Period.of(1, 2, 3);
		
		Period period02 = Period.ofYears(1);
		
		
		// TemporalAdjusters
		// https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjusters.html
		LocalDateTime localDateAndTime = LocalDateTime.now();
		
		LocalDateTime dateTime1 = localDateAndTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		LocalDateTime dateTime2 = localDateAndTime.with(TemporalAdjusters.firstDayOfNextMonth());
		LocalDateTime dateTime3 = localDateAndTime.with(TemporalAdjusters.lastDayOfMonth());
		
		System.out.println(dateTime1);
		System.out.println(dateTime2);
		System.out.println(dateTime3);
		
		TemporalAdjuster TWO_DAYS_LATER =
			       TemporalAdjusters.ofDateAdjuster(date -> date.plusDays(2));
		
		// Temporal
		// https://docs.oracle.com/javase/8/docs/api/java/time/temporal/Temporal.html
		
		// Formatters
		LocalDateTime dateTime = LocalDateTime.of(2016, Month.JULY, 25, 15, 30);
		OffsetDateTime offsetDateTime = dateTime.atOffset(ZoneOffset.ofHours(-5));
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		                                  .appendText(ChronoField.DAY_OF_MONTH)
		                                  .appendLiteral(" ")
		                                  .appendText(ChronoField.MONTH_OF_YEAR)
		                                  .appendLiteral(" ")
		                                  .appendText(ChronoField.YEAR)
		                                  .appendOffsetId()
		                                  .toFormatter();
		offsetDateTime.format(formatter);
		formatter.format(offsetDateTime);
		
	}

}
