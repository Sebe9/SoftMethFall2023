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
    
    public Event(Date date, Timeslot timeslot, Location location, Contact contact, int duration){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }
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
    public Timeslot getTimeslot(){
        return startTime;
    }
    /**
     * Gets the contact object associated with this event
     * @return Contact Returns the contact object associated with this event
     */
    public Contact getContact(){
        return contact;
    }
    /**
     * Returns the location object associated with this event.
     * @return Location returns the location object associated with this event
     */
    public Location getLocation(){
        return location;
    }
    /**
     * Method to find the end time of the event
     */
    public String getEndTime(Timeslot startTime, int duration){
        String time = startTime.getTime();
        String[] timeSplit = time.split(":");
        int hours = Integer.parseInt(timeSplit[0]);
        int minutes = Integer.parseInt(timeSplit[1].substring(0,2));
        String amPm = timeSplit[1].substring(2).trim();
        if(amPm.equalsIgnoreCase("pm") && hours != 12){
            hours += 12;
        } else if(amPm.equalsIgnoreCase("am") && hours == 12){
            hours = 0;
        }
        int totalMin = hours * 60 + minutes + duration;
        int newHour = totalMin/60;
        int newMin = totalMin%60;
        String newAmPm = (newHour >= 12) ? "pm" : "am";
        if(newHour > 12){
            newHour -= 12;
        } else if (newHour == 0){
            newHour = 12;
        }
        String newTime = String.format("%02d:%02d %s", newHour, newMin, newAmPm);
    }
    //Returns a textual representation of an event     
    public String toString(Event event1){
       return "[Event Date: " + event1.date + "] " + "[Start: " + event1.startTime.getTime() + "] " + "[End: " + event1.getEndTime(startTime, duration)+ "] "+ "@" + event1.location + " " + "(" + event1.location.getLocation() + ") " + "[Contact: " +  event1.contact.getDepartment() + ", " + event1.contact.getEmail() + "]";
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
    /**
     * Main class for testing equals();
     * @param args
     */
    public static void main(String[] args){
        testSameEvent();
        testDifferentEvent();
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
     * Tests to see if events with the same information are considered equal.
     */
    private static void testSameEvent(){
        Date date = new Date("10/10/2010");
        Timeslot timeslot = Timeslot.valueOf("morning");
        Location location = Location.valueOf("arc103");
        Department department = Department.valueOf("EE");
        String email = "ee@rutgers.edu";
        int duration = 60;
        Contact newContact = new Contact(department, email);
        Event testEvent = new Event(date, timeslot, location, newContact, duration);
        Date dateTwo = new Date("10/10/2010");
        Timeslot timeslotTwo = Timeslot.valueOf("morning");
        Location locationTwo = Location.valueOf("arc103");
        Department departmentTwo = Department.valueOf("EE");
        String emailTwo = "ee@rutgers.edu";
        int durationTwo = 60;
        Contact newContactTwo = new Contact(departmentTwo, emailTwo);
        Event testEventTwo = new Event(dateTwo, timeslotTwo, locationTwo, newContactTwo, durationTwo);
        boolean expectedOutput = true;
        boolean actualOutput = testEvent.equals(testEventTwo);
        System.out.println("Test Case #1: Two events with the same information are equal");
    }
    /**
     * Test case #2
     * Tests to see if two events with different information are considered equal.
     */
    private static void testDifferentEvent(){
        Date date = new Date("10/10/2010");
        Timeslot timeslot = Timeslot.valueOf("morning");
        Location location = Location.valueOf("arc103");
        Department department = Department.valueOf("EE");
        String email = "ee@rutgers.edu";
        int duration = 60;
        Contact newContact = new Contact(department, email);
        Event testEvent = new Event(date, timeslot, location, newContact, duration);
        Date dateTwo = new Date("10/12/2010");
        Timeslot timeslotTwo = Timeslot.valueOf("afternoon");
        Location locationTwo = Location.valueOf("arc103");
        Department departmentTwo = Department.valueOf("ITI");
        String emailTwo = "iti@rutgers.edu";
        int durationTwo = 30;
        Contact newContactTwo = new Contact(departmentTwo, emailTwo);
        Event testEventTwo = new Event(dateTwo, timeslotTwo, locationTwo, newContactTwo, durationTwo);
        boolean expectedOutput = false;
        boolean actualOutput = testEvent.equals(testEventTwo);
        System.out.println("Test Case #2: Two events with different information are not the same");
    }

}
