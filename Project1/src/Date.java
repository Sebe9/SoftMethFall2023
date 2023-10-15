package src;

import java.util.Calendar;

/**
* Contains information and methods for a specific date.
* @author SebastianHanna
*/
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //will move these to another class at some point (I think we are supposed to make an enum class)
    public static final int MIN_MONTH = 1; 
    public static final int MAX_MONTH = 12;
    public static final int MIN_YEAR = 0;
    public static final int MIN_DAY = 0;

    public static final int FEB_NOLEAP = 28;
    public static final int FEB_LEAP = 29;

    public static final int SHORT_MONTH = 30;
    public static final int LONG_MONTH = 31;

    public static final int JAN = 1;
    public static final int FEB = 2;
    public static final int MAR = 3;
    public static final int APR = 4;
    public static final int MAY = 5;
    public static final int JUN = 6;
    public static final int JUL = 7;
    public static final int AUG = 8;
    public static final int SEP = 9;
    public static final int OCT = 10;
    public static final int NOV = 11;
    public static final int DEC = 12; 
    
    /**
     * Getter method for the month of a date
     * @return int Returns the month
     */
    public int getMonth(){
        return month;
    }
    /**
     * Getter method for the day of a date
     * @return int Returns the day
     */
    public int getDay(){
        return day;
    }
    /**
     * Getter method for the year of a date
     * @return int Returns the year
     */
    public int getYear(){
        return this.year;
    }

    /**
     * Determines if this.year is a leap year.
     * @return true is this Date object's year is a leap year and false if it is not
     */
    private boolean isLeap(){
        if (this.year %4 != 0)
            return false;
        if (this.year % 100 == 0){
            if (this.year % 400 == 0)
                return false;
            else
                return true;
        }
        else 
            return true;
    } 
    /**
     * Checks if the date is in the future.
     * @return boolean. Returns true if the date is in the future.
     */
    public boolean isFuture(){
        Calendar today = Calendar.getInstance();
        Calendar eventDate = Calendar.getInstance();
        eventDate.set(getYear(), getMonth(), getDay());
        return today.before(eventDate);
        
    }
    /**
     * Checks if the date is less than six months away
     * @return boolean Returns true if the date is less than 6 months away
     */
    public boolean withinSixMonths(){
        Calendar sixMonthsAway = Calendar.getInstance();
        sixMonthsAway.add(Calendar.MONTH, 6);
        
        Calendar eventDate = Calendar.getInstance();
        eventDate.set(getYear(),getMonth(),getMonth());
        return eventDate.before(sixMonthsAway);
        
    }

    /**
     * Determines if this object has a valid date.
     * @return true is this object hold a valid date and false if does not hold a valid date
     */
    public boolean isValid(){

        if (this.month < MIN_MONTH || this.month > MAX_MONTH )
            return false; 
        else if (this.year < MIN_YEAR)
            return false; 
        else if (this.day < MIN_DAY || this.day > LONG_MONTH)
            return false; 
        else if (this.day == 31 && isLongMonth() == false )
            return false;
        else if (this.day == 30 && this.month == FEB)
            return false;
        else if (this.day == 29 && this.month == FEB && isLeap()==false)
            return false;
        else 
            return true;
    }
    /**
    *Determines whether or not this objects month has 31 days
    *@return true if month is one of the months with 31 days 
    */   
    private boolean isLongMonth(){
        
        if (this.month == JAN || this.month == MAR || this.month == MAY || this.month == JUL || this.month == AUG || this.month == OCT || this.month == DEC){
            return true; } 
        else 
            return false;
    }
    /**
     * Compare this objects date with anothers.
     * @param date2 The date object that you want to compare this object's data to.
     * @return int 0 if the dates are equal. If this objects date is before the parameter's date it will return a positive integer. 
     * If this date is after the parameter's it will return a negative number
     */
    @Override public int compareTo(Date date2){
        if (this.year!=date2.year){
            return date2.year-this.year;
        }
        else if(this.month!=date2.month){
            return date2.month-this.month;
        }
        else if(this.day!=date2.day){
            return date2.day-this.day;
        }
        else
            return 0;
    }
    /**
     * Constructs a Date object with 3 int inputs
     * @param month The month you want this object to hold
     * @param day The day you want this object to hold
     * @param year The year you want this object to hold
     */
    public Date(int month, int day, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Creates a date object using a string 
     * @param dateString A string that represents the date you want to use to create an object
     */
    public Date(String dateString){
        String[] splitDate = dateString.split("/");
        month = Integer.parseInt(splitDate[0]);
        day = Integer.parseInt(splitDate[1]);
        year = Integer.parseInt(splitDate[2]);
    }

    /**
     * Main class for testing isValid().
     * @param args
     */
    public static void main(String[] args){
    
        testDaysinFeb_noLeap();
         
        testDaysinFeb_yesLeap();
         
        testMonthsOutofRange();
 
        testDaysOutofRange();

        testYearsOutofRange();

        testNormalDay();

        testThirtyDayMonth();

        String inputString = "ARC103";

        Location testLocation = Location.valueOf(inputString);

        System.out.println(testLocation);
    
    }
    /**
     * Method that compares the expected value to the actual value. Prints out the result.
     * @param expected The value that is expected to return from executing equals().
     * @param actual The value that is returned from executing equals().
     */
    private static void testResult(boolean expected, boolean actual){
        System.out.print("The expected output is: "+expected+" and the actual result is: "+actual);
        if(expected==actual){
            System.out.println(" -- This test case passes!");
        }
        else{
            System.out.println(" -- This test case does NOT PASS!!");
        }
        System.out.println();
    }
    /**
     * Test case #1
     * Tests if the number of days in feb is correct in a non leap year 
     */
    private static void testDaysinFeb_noLeap(){
        Date testDate = new Date("2/29/2011");
        boolean expectedOutput = false;
        boolean actualOutput = testDate.isValid();
        System.out.println("Test case #1: The nubmer of days in Feb in a non leap year is 28:");
        testResult(expectedOutput, actualOutput);
        
    }
    /**
     * Test case #2
     * Tests to see if the number of days in Feb is correct in a leap year
     */
    private static void testDaysinFeb_yesLeap(){
        Date testDate = new Date("2/29/2004");
        boolean expectedOutput = true;
        boolean actualOutput = testDate.isValid();
        System.out.println("Test case #2: The number of days in Feb in a leap year is 29");
        testResult(expectedOutput, actualOutput);
    }

    /**
     * Test case #3
     * Tests to see if there is correctly only 12 months
     */
    private static void testMonthsOutofRange(){
        Date testDate = new Date("13/01/2000");
        boolean expectedOutput = false;
        boolean actualOutput = testDate.isValid();
        System.out.println("Test case #3: There is only 12 months");
        testResult(expectedOutput, actualOutput);
    }
    /**
     * Test case #4
     * Tests to see if a month with 32 days will be considered valid or not
     */
 
    private static void testDaysOutofRange(){
        Date testDate = new Date("01/32/2000");
        boolean expectedOutput = false;
        boolean actualOutput = testDate.isValid();
        System.out.println("Test case #4: There is no month with 32 or more days");
        testResult(expectedOutput, actualOutput);
    }
    /**
     * Test case #5
     * Tests to see if  a negative year will be valid
     */

    private static void testYearsOutofRange(){
        Date testDate = new Date("01/01/-1");
        boolean expectedOutput = false;
        boolean actualOutput = testDate.isValid();
        System.out.println("Test case #5: There cannot be a date with a year less than 0");
        testResult(expectedOutput, actualOutput);
    }

    /**
     * Test case #6
     * Tests to see if a normal date is considered valid
     */
    private static void testNormalDay(){
        Date testDate = new Date("05/14/2003");
        boolean expectedOutput = true;
        boolean actualOutput = testDate.isValid();
        System.out.println("Test case #6: Normal date");
        testResult(expectedOutput, actualOutput);
    }
    /**
     * Test case #7
     * Tests to see if a month that should only contain 30 days will be considered valid if entered with 31 days
     */
    private static void testThirtyDayMonth(){
        Date testDate = new Date("06/31/2000");
        boolean expectedOutput = false;
        boolean actualOutput = testDate.isValid();
        System.out.println("Test case #7: Some months can only have 30 days");
        testResult(expectedOutput, actualOutput);
    }
}