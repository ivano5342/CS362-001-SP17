package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	//Tests class constructor, getApptRange and deleteAppt
	
	 @Test
	  public void test01()  throws Throwable  {
		 
		 TimeTable timetable = new TimeTable();
		 GregorianCalendar firstDay = new GregorianCalendar();
		 GregorianCalendar lastDay = new GregorianCalendar();
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				 
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=3;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 
		 startHour=14;
		 startMinute=35;
		 startDay=01;
		 startMonth=6;
		 title="Birthday Party 2";
		 description="This is my friends birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		 
		 firstDay.set(2017, 04, 10);
		 CalDay today = new CalDay(firstDay);
		 
		 appts.add(appt);			
		 appts.add(appt2);
		 
		try{ calDays = timetable.getApptRange(appts, firstDay, lastDay); //tests Argument Exception
	 }
		catch (IllegalArgumentException e){
			assertEquals("Second date specified is not before the first date specified.", e.getMessage());
		}
		
		 lastDay.set(2017, 04, 20);
		 CalDay nextWeek = new CalDay(lastDay);
		
		 //Adding appointments
		 today.addAppt(appt);
		 nextWeek.addAppt(appt2);
		 
		 //Adding Calendar Days
		 calDays.add(today);
		 calDays.add(nextWeek);
		 
				
		timetable.deleteAppt(appts, appt2);		//tests deleteAppt
		timetable.deleteAppt(appts, null);
		timetable.deleteAppt(null, null);
		assertEquals(null, timetable.deleteAppt(appts, appt2));
		assertTrue(appts.size() == 1);			//tests appts.size
		//System.out.println(appts.size());



	 }
	 
}
