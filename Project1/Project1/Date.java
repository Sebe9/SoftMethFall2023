package project1;

/**
Contains information and methods for a specific date.

@author SebastianHanna
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
    Determines whether or not this objects month has 31 days
    @return true if month is one of the months with 31 days 
    */   
    private boolean isLongMonth(){
        
        if (this.month == JAN || this.month == MAR || this.month == MAY || this.month == JUL || this.month == AUG || this.month == OCT || this.month == DEC){
            return true; } 
        else 
            return false;
    }
    /**
     * Compare this objects date with anothers.
     * @param Date The date object that you want to compare this object's data to.
     * @return 0 if the dates are equal. If the dates are not equal it will return a positive or negative integer
     */
    @Override public int compareTo(Date date2){
        return this.day-date2.day+this.month-date2.month+this.year-date2.year;
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
        this.month = Integer.parseInt(splitDate[0]);
        this.day = Integer.parseInt(splitDate[1]);
        this.year = Integer.parseInt(splitDate[2]);
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

    }

    private static void testDaysinFeb_noLeap(){
        Date date = new Date("2/29/2011");
    }

}