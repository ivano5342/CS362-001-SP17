package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	//Tests the CalDay constructor, iterator, CalDay, validity,
	//and set and get methods.
	
	 @Test
	  public void test01()  throws Throwable  {
		 
		 //assertions before the creations of an appointment/calendar day
		 CalDay day = new CalDay();
		 assertFalse(day.isValid());
		 assertEquals(null, day.iterator());
		 assertEquals("", day.toString());
 
		 int startHour=24;
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


		 GregorianCalendar cal = new GregorianCalendar();
	
		 cal.set(cal.DAY_OF_MONTH, 2);
		 cal.set(cal.MONTH, 6);
		 cal.set(cal.YEAR, 2017);
		 
		 CalDay calday = new CalDay(cal);
		 calday.addAppt(appt);
		 
		 
		 
		 //assertions after creation of appointment
		 assertTrue(calday.isValid());
		 assertTrue(calday.getSizeAppts() == 0);
		 assertEquals(2, calday.getDay());
		 assertEquals(6, calday.getMonth());
		 assertEquals(2017, calday.getYear());
		 assertFalse(calday.iterator() == null);
		 assertFalse(calday.toString() == null);
		 //System.out.println(calday.iterator());
		 //System.out.println(calday.getSizeAppts());
		 //System.out.println(calday.toString());


		 
		 
		 
		 
	 }
	
}
