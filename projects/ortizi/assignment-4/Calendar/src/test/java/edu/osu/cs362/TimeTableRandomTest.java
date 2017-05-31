package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 
		 System.out.println("Start testing...");

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis();
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 TimeTable timetable = new TimeTable();
				 TimeTable nulltable = new TimeTable();
				
				 int startHour=13;
				 int startMinute=30;
				 int startDay=10;
				 int startMonth=4;
				 int startYear=2017;
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 
				 GregorianCalendar cal = new GregorianCalendar(startYear,startMonth,startDay);
				 CalDay calday = new CalDay(cal);
				 LinkedList<Appt> appts = new LinkedList<Appt>();
				 LinkedList<Appt> nullappts = new LinkedList<Appt>();
				 
				 nullappts = null;
				 
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
				 
				 startYear=2018;

				 //Construct a new Appointment object with the initial data	 
				 Appt appt2 = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
				 
				 //Construct a null Appointment object with the initial data	 
				 Appt nullappt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
				 nullappt = null;
					for (int i = 0; i < NUM_TESTS; i++) {
						   
						int newHour =(int) ValuesGenerator.getRandomIntBetween(random, -1, 24);
						int newMinute =(int) ValuesGenerator.getRandomIntBetween(random, -5, 70);
						int newDay =(int) ValuesGenerator.getRandomIntBetween(random, -5, 42);
						int newMonth =(int) ValuesGenerator.getRandomIntBetween(random, -1, 13);
						int newYear =(int) ValuesGenerator.getRandomIntBetween(random, 2000, 2020);
						int randnum = (int) ValuesGenerator.getRandomIntBetween(random, 0, 4);

						
						appt.setStartHour(newHour);
						appt.setStartMinute(newMinute);
						appt.setStartDay(newDay);
						appt.setStartMonth(newMonth);
						appt.setStartYear(newYear);
						
						appts.add(appt);
						
						newHour =(int) ValuesGenerator.getRandomIntBetween(random, -1, 24);
						newMinute =(int) ValuesGenerator.getRandomIntBetween(random, -5, 70);
						newDay =(int) ValuesGenerator.getRandomIntBetween(random, -5, 42);
						newMonth =(int) ValuesGenerator.getRandomIntBetween(random, -1, 13);
						newYear =(int) ValuesGenerator.getRandomIntBetween(random, 2000, 2020);
						
						appt2.setStartHour(newHour);
						appt2.setStartMinute(newMinute);
						appt2.setStartDay(newDay);
						appt2.setStartMonth(newMonth);
						appt2.setStartYear(newYear);
						
						appts.add(appt2);
						
						if(randnum == 0){
							timetable.deleteAppt(appts, appt);
							timetable.deleteAppt(appts, appt2);
						}
						if(randnum == 1){
							timetable.deleteAppt(appts, appt);
							timetable.deleteAppt(appts, appt);
						}
						if(randnum == 2){
							timetable.deleteAppt(appts, appt2);
							timetable.deleteAppt(appts, appt2);
						}
						if(randnum == 3){
							timetable.deleteAppt(appts, nullappt);
						}
						if(randnum == 4){
							nulltable.deleteAppt(nullappts, appt);
						}

					}

					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						if((iteration%10000)==0 && iteration!=0 )
							System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

				}


				System.out.println("Done testing...");


	 	}



}

	
