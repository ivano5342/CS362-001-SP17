package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertEquals("\t4/10/2017 at 1:30pm ,Birthday Party, This is my birthday party.\n", appt.toString()); //tests the toString method
		 
		 appt.setStartHour(11);
		 assertEquals("\t4/10/2017 at 11:30am ,Birthday Party, This is my birthday party.\n", appt.toString()); //tests the toString method
		 
		 appt.setStartHour(24);
		 assertNull(appt.toString()); //test toString null

	 }			 


		   /**
		     * Test that minute is invalid at <59.
		     */
			 @Test
			  public void test03()  throws Throwable  {
				 int startHour=13;
				 int startMinute=61;
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
			// assertions
				 assertFalse(appt.getValid());
	         		
			 }
			 
			   /**
			     * Test that day is invalid.
			     */
				 @Test
				  public void test04()  throws Throwable  {
					 int startHour=13;
					 int startMinute=59;
					 int startDay=40;
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
				// assertions
					 assertFalse(appt.getValid());
		         		
				 }
				 
		   /**
		     * Test that month is invalid.
		     */
			 @Test
			  public void test05()  throws Throwable  {
				 int startHour=13;
				 int startMinute=50;
				 int startDay=10;
				 int startMonth=14;
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
			// assertions
				 assertFalse(appt.getValid());
	         		
			 }
			 
			   /**
			     * Test the hour conditional.
			     */
				 @Test
				  public void test06()  throws Throwable  {
					 int startHour=-1;
					 int startMinute=50;
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
				// assertions
					 assertFalse(appt.getValid());
		         		
				 }
				   /**
				     * Test the minute conditional <0.
				     */
					 @Test
					  public void test07()  throws Throwable  {
						 int startHour=10;
						 int startMinute=-1;
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
					// assertions
						 assertFalse(appt.getValid());
			         		
					 }
			   /**
			     * Test the day conditional.
			     */
				 @Test
				  public void test08()  throws Throwable  {
					 int startHour=5;
					 int startMinute=50;
					 int startDay=0;
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
				// assertions
					 assertFalse(appt.getValid());
		         		
				 }
			   /**
			     * Test the month conditional.
			     */
				 @Test
				  public void test09()  throws Throwable  {
					 int startHour=13;
					 int startMinute=40;
					 int startDay=10;
					 int startMonth=0;
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
				// assertions
					 assertFalse(appt.getValid());
		         		
				 }
					
				   /**
				     * Test that 24> hour is invalid.
				     */
					 @Test
					  public void test11()  throws Throwable  {
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
					// assertions
						 assertFalse(appt.getValid());
					 }
		 
		   /**
		     * Test the ==0 hour conditional boundary.
		     */
			 @Test
			  public void test12()  throws Throwable  {
				 int startHour=0;
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
			// assertions
				 assertTrue(appt.getValid());
	         		
			 }
			   /**
			     * Test the ==23 hour conditional boundary.
			     */
				 @Test
				  public void test13()  throws Throwable  {
					 int startHour=23;
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
				// assertions
					 assertTrue(appt.getValid());
		         		
				 }


		   /**
		     * Test that minute is invalid at <59.
		     */
			 @Test
			  public void test14()  throws Throwable  {
				 int startHour=13;
				 int startMinute=0;
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
			// assertions
				 assertTrue(appt.getValid());
	         		
			 }


			   /**
			     * Test that minute is invalid at <59.
			     */
				 @Test
				  public void test15()  throws Throwable  {
					 int startHour=13;
					 int startMinute=59;
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
				// assertions
					 assertTrue(appt.getValid());
		         		
				 }
				 
				   /**
				     * Test the day ==1 boundary.
				     */
					 @Test
					  public void test16()  throws Throwable  {
						 int startHour=13;
						 int startMinute=59;
						 int startDay=1;
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
					// assertions
						 assertTrue(appt.getValid());
			         		
					 }
			   /**
			     * Test the day ==31 boundary.
			     */
				 @Test
				  public void test17()  throws Throwable  {
					 int startHour=13;
					 int startMinute=59;
					 int startDay=31;
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
				// assertions
					 assertTrue(appt.getValid());
		         		
				 }
				 
				   /**
				     * Test the month ==1 boundary.
				     */
					 @Test
					  public void test18()  throws Throwable  {
						 int startHour=13;
						 int startMinute=50;
						 int startDay=10;
						 int startMonth=1;
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
					// assertions
						 assertTrue(appt.getValid());
			         		
					 }
					   /**
					     * Test the month ==12 boundary.
					     */
						 @Test
						  public void test19()  throws Throwable  {
							 int startHour=13;
							 int startMinute=50;
							 int startDay=10;
							 int startMonth=12;
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
						// assertions
							 assertTrue(appt.getValid());
				         		
						 }
   /**
		     * Test the void methods.
		     */
			 @Test
			  public void test20()  throws Throwable  {
				 int startHour=5;
				 int startMinute=40;
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
				 appt.setStartHour(13);
				 appt.setStartMinute(10);
				 appt.setStartDay(15);
				 appt.setStartMonth(5);
				 appt.setStartYear(2018);
				 appt.setTitle(null);
				 appt.setDescription(null);




			// assertions
	         	assertEquals(13, appt.getStartHour());	
	         	assertEquals(10, appt.getStartMinute());	
	         	assertEquals(15, appt.getStartDay());
	         	assertEquals(5, appt.getStartMonth());
	         	assertEquals(2018, appt.getStartYear());
	         	assertEquals("", appt.getTitle());
	         	assertEquals("", appt.getDescription());



			 }



	
}
