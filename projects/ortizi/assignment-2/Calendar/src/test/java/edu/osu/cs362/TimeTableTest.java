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
		 
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
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
		 
		 int startHour2=14;
		 int startMinute2=35;
		 int startDay2=01;
		 int startMonth2=5;
		 String title2="Birthday Party 2";
		 String description2="This is my friends birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt2 = new Appt(startHour2,
		          startMinute2 ,
		          startDay2 ,
		          startMonth2 ,
		          startYear ,
		          title2,
		         description2);
		 
		 GregorianCalendar firstDay = new GregorianCalendar();
		 GregorianCalendar lastDay = new GregorianCalendar();
		 
		 firstDay.set(2017, 04, 30);
		 
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 
		 appts.add(appt);			
		 appts.add(appt2);
		 
		try{ timetable.getApptRange(appts, firstDay, lastDay); //tests Argument Exception
	 }
		catch (IllegalArgumentException e){
			assertEquals("Second date specified is not before the first date specified.", e.getMessage());
		}
				
		timetable.deleteAppt(appts, appt2);		//tests deleteAppt
		timetable.deleteAppt(appts, null);
		timetable.deleteAppt(null, null);
		assertEquals(null, timetable.deleteAppt(appts, appt2));
		assertTrue(appts.size() == 1);			//tests appts.size
		//System.out.println(appts.size());



	 }
	 
}
