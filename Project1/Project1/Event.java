package project1;
import java.util.Calendar;

public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes
    //Compares two events based off of their date. If the dates are the same it will compare timeslots
    public int compareTo(Event event2){
        int dateCompare = date.compareTo(event2.date);
        if (dateCompare != 0){
            return dateCompare;
        }
        else{
            return this.startTime.compareTo(event2.startTime);
        }
    }
    //Returns a textual representation of an event     add end time
    @Override public String toString(Event event1){
       return "[Event Date: " + date + "] " + "[Start: " + timeslot.getTime() + "] " + "@" + location + " " + "(" + location.getLocation() + ") " + "[Contact: " +  contact.getDepartment() + ", " + contact.getEmail() + "]";
    }
    
    //Returns true if two dates, timeslots, and locations are equal
    @Override public bool equals(Object event2){
    if(event2 == null){
        return false;
    }
    Event event = (Event) event2;
    return date.equals(event2.date) && timeslot == event2.timeslot && location == event2.location;
    }

    }
