package project1;
import java.util.Calendar;
/**
 * Contains all information for an event and implements Comparable<Event> to compare other events.
 * 
 * @author Matthew Chan
 */
public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes
    
    //Compares two events based off of their date. If the dates are the same it will compare timeslots
    /**
     * Compares the current event object with another event based off of their dates and timeslots.
     * @return dataCompare if the dates of the two events are the same. If the times are equals, it will return an integer after comparing the timeslots.
     */
    public int compareTo(Event event2){
        int dateCompare = date.compareTo(event2.date);
        if (dateCompare != 0){
            return dateCompare;
        }
        else{
            return this.startTime.compareTo(event2.startTime);
        }
    }
    //Returns a textual representation of an event 
    /**
     * Builds a string that includes all the information of an event.
     * @return a string representation of an event's information.
     */
    @Override public String toString(){
       return "[Event Date: " + date + "] " + "[Start: " + startTime.getTime() + "] " + "@" + location + " " + "(" + location.getLocation() + ") " + "[Contact: " +  contact.getDepartment() + ", " + contact.getEmail() + "]";
    }
    //Returns true if two dates, timeslots, and locations are equal
    /**
     * Determines if the current event has the same information.
     * @return true if both events have the same values. Else, return false.
     */
    @Override public boolean equals(Object event2){
        Event event = (Event) event2;
        return date.equals(event.date) && startTime == event.startTime && location == event.location;
    }

}
