package edu.osu.cs362;


import org.junit.Test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


/**
 * Random Test Generator for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"addAppt"};// method to be tested
    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
    
    
    /**
     * Generate Random Tests that tests CalDay Class.
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
				

				 int startHour=13;
				 int startMinute=30;
				 int startDay=10;
				 int startMonth=4;
				 int startYear=2017;
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 
				 GregorianCalendar cal = new GregorianCalendar(startYear,startMonth,startDay);
				 CalDay calday = new CalDay(cal);
				 
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
					for (int i = 0; i < NUM_TESTS; i++) {
							   							   
							   int newHour =(int) ValuesGenerator.getRandomIntBetween(random, -1, 24);
							   int newMinute =(int) ValuesGenerator.getRandomIntBetween(random, -5, 70);
							   int newDay =(int) ValuesGenerator.getRandomIntBetween(random, -5, 42);
							   int newMonth =(int) ValuesGenerator.getRandomIntBetween(random, -1, 13);
							   int newYear =(int) ValuesGenerator.getRandomIntBetween(random, 2000, 2020);

							   appt.setStartHour(newHour);
							   appt.setStartMinute(newMinute);
							   appt.setStartDay(newDay);
							   appt.setStartMonth(newMonth);
							   appt.setStartYear(newYear);
							   
							   calday.addAppt(appt);
							   
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
							   
							   calday.addAppt(appt2);

						
					}
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
		 
		 
			 System.out.println("Done testing...");
		 
		 
	 }


	
}
