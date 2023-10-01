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
    public static final int MAX_DAY = 31;

    //check if the date is a valid calendar date 
    public boolean isValid(){

        if (month < MIN_MONTH || month > MAX_MONTH ){
            return false; }
        else if (year < MIN_YEAR){
            return false; }
        else if (day < MIN_DAY || day > MAX_DAY){
            return false; }
       

        
        
        return true;
    }

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
}