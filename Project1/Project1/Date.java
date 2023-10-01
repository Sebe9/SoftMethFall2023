package project1;
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

    //check if the date is a valid calendar date 
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
    
    private boolean isLongMonth(){
        /**
        Determines whether or not this objects month has 31 days
        @return true if month is one of the months with 31 days 
        */
        if (this.month == JAN || this.month == MAR || this.month == MAY || this.month == JUL || this.month == AUG || this.month == OCT || this.month == DEC){
            return true; } 
        else 
            return false;
    }

    public int compareTo(Date date2){

    }

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
}