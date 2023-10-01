package Project1;
import java.util.Calendar;

public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes
    //Compares two events based off of their date. If the dates are the same it will compare timeslots
    public int compareTo(Event event2){
        return 1;
    }
    //Returns a textual representation of an event
    @Override public String toString(Event event1){
        StringBuilder stb = new StringBuilder();
        stb.append("[Event Date: ").append(date).append("] ");
        stb.append("[Start: ").append().append(" ")
        stb.append("");
        stb.append("[Contact: ").append(contact.getDepartment()).append(", ").append(contact.getEmail());
        return stb.toString();
    }
    //Returns true if two dates, timeslots, and locations are equal
    @Override public bool equals(){

    }

    }
