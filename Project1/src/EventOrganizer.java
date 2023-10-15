package src;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/**
 * Contains all information for an event and implements Comparable Event to compare other events.
 * 
 * @author Matthew Chan
 * @author Sebastian Hanna
 */
public class EventOrganizer{
    private EventCalendar myCalendar;
    private Scanner scanner;
   
    /**
     * Instantiaties the Event Organizer.
     * Also Creates a new EventCalendar object.
     */
    public EventOrganizer(){
        myCalendar = new EventCalendar();
        System.out.println("Event Organizer running....");
    }
    /**
     * Method that continuously reads commands until it reaches a q command in which case the program is terminated.
     */
    public void run(){
        Scanner scannerObj = new Scanner(System.in);
        while(true){
            String nextLine  = scannerObj.nextLine();
            String[] inputArray = nextLine.split("\\s+");
            
            if (nextLine.isBlank()){
                continue;
            }
            else if (inputArray[0].equals("A")){
                aCommand(inputArray);
            }
            else if (inputArray[0].equals("R")){
                rCommand(inputArray);
            }
            else if (inputArray[0].equals("P")){
                pCommand();
            }
            else if (inputArray[0].equals("PE")){
                peCommand();
            }
            else if (inputArray[0].equals("PC")){
                pcCommand();
            }
            else if (inputArray[0].equals("PD")){
                pdCommand();
            }
            else if (inputArray[0].equals("Q")){
                break;
            }
            else{
                System.out.println(inputArray[0]+" is an invalid command!");
            }
        }
        System.out.println("Event Organizer terminated.");
        scannerObj.close();
    }
    /**
     * Adds an event to the calendar
     * @param eventInfo An array of strings with the info about the event
     */
    private void aCommand(String[] eventInfo){
        if(validTimeslot(eventInfo)==false){
            System.out.println("Invalid time slot!");
            return;
        }
        if(validLocation(eventInfo)==false){
            System.out.println("Invalid Location!");
            return;
        }
        if(validDepartmentName(eventInfo)==false){
            System.out.println("Invalid contact information!");
            return;
        }
        Date date = new Date(eventInfo[1]);
        Timeslot timeslot = Timeslot.valueOf(eventInfo[2].toLowerCase());
        Location location = Location.valueOf(eventInfo[3].toUpperCase());
        Department department = Department.valueOf(eventInfo[4].toUpperCase());
        String email = eventInfo[5];
        int duration = Integer.parseInt(eventInfo[6]);
        Contact newContact = new Contact(department, email);
        Event event  = new Event(date, timeslot, location, newContact, duration);
        if(checkErrors(event, eventInfo)==false){
            return;
        }
        if( duration > 120 || duration < 30 ){
            System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
            return;
        }
        if (myCalendar.contains(event)==true){
            System.out.println("The event is already on the calendar.");
            return;
        }
        myCalendar.add(event);
        System.out.println("Event added to the calendar");
        return;
    }
    /**
     * Method in which the r command is processed and cancels an event.
     * @param eventInfo A string of the information about the event you want removed
     */
    private void rCommand(String[] eventInfo){
        if(validTimeslot(eventInfo)==false){
            System.out.println("Invalid time slot!");
            return;
        }
        if(validLocation(eventInfo)==false){
            System.out.println("Invalid Location!");
            return;
        }
        Date date = new Date(eventInfo[1]);
        Timeslot timeslot = Timeslot.valueOf(eventInfo[2].toLowerCase());
        Location location = Location.valueOf(eventInfo[3].toUpperCase());
        //Department department = Department.valueOf(eventInfo[4]);
        //String email = eventInfo[5];
        //int duration = Integer.parseInt(eventInfo[6]);
        //Contact newContact = new Contact(department, email);
        Event event  = new Event(date, timeslot, location);
        if (checkRCommandErrors(event, eventInfo)==false){
            return;
        }
        
        if (myCalendar.remove(event)) {
            System.out.println("Event has been removed from the calendar!");
        } else {
            System.out.println("Cannot remove; event is not in the calendar!");
        }

    }
    /**
     * Method in which the p command is processed and prints the event calendar.
     */
    private void pCommand(){
        if(myCalendar.getNumEvents()==0){
            System.out.println("Event calendar is empty!");
            return;
        }
        System.out.println("*event calendar*");
        myCalendar.print(); 
        System.out.println("*end of event calendar*");
    }
    /**
     * Method in which the pe command is processed and displays the event calendar, sorted by event date and timeslot.
     */
    private void peCommand(){
        if(myCalendar.getNumEvents()==0){
            System.out.println("Event calendar is empty!");
            return;
        }
        System.out.println("*event calendar by event date and start time*");
        myCalendar.printByDate();
        System.out.println("*end of event calendar*");
    }
    /**
     * Method in which the pc command is processed and displays the event calendar, sorted by campus and building.
     */
    private void pcCommand(){
        if(myCalendar.getNumEvents()==0){
            System.out.println("Event calendar is empty!");
            return;
        }
        System.out.println("*event calendar by campus and building*");
        myCalendar.printByCampus();
        System.out.println("*end of event calendar*");
    }
    /**
     * Method in which the pd command is processed and displays the event calendar, sorted by the department and contact.
     */
    private void pdCommand(){
        if(myCalendar.getNumEvents()==0){
            System.out.println("Event calendar is empty!");
            return;
        }
        System.out.println("*event calendar by department*");
        myCalendar.printByDepartment();
        System.out.println("*end of event calendar*");
    }

    /**
     * Determines of a department name is valid
     * @param eventInfo Array of strings with info about the event
     * @return boolean Returns true if the department name is valid false if not
     */
    private boolean validDepartmentName(String[] eventInfo){
        if (eventInfo[4].equalsIgnoreCase("CS")){
            return true;
        }
        if (eventInfo[4].equalsIgnoreCase("EE")){
            return true;
        }
        if (eventInfo[4].equalsIgnoreCase("ITI")){
            return true;
        }
        if (eventInfo[4].equalsIgnoreCase("BAIT")){
            return true;
        }
        if (eventInfo[4].equalsIgnoreCase("MATH")){
            return true;
        }
        return false;
    }
    /**
     * Determines of a timslot is valid
     * @param eventinfo Array of strings with info about the event
     * @return boolean Returns true if the timslot is valid false if not
     */
    private boolean validTimeslot(String[] eventinfo){
        if(eventinfo[2].equalsIgnoreCase("afternoon")==false && eventinfo[2].equalsIgnoreCase("morning")==false && eventinfo[2].equalsIgnoreCase("evening")==false){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * Determines of a location is valid
     * @param eventinfo Array of strings with info about the event
     * @return boolean Returns true if the location is valid false if not
     */
    private boolean validLocation(String[] eventinfo){
        String locationString = eventinfo[3];
        if(locationString.equalsIgnoreCase("hll114")){
            return true;
        }
        if(locationString.equalsIgnoreCase("arc103")){
            return true;
        }
        if(locationString.equalsIgnoreCase("ab2225")){
            return true;
        }
        if(locationString.equalsIgnoreCase("mu302")){
            return true;
        }
        if(locationString.equalsIgnoreCase("be_aud")){
            return true;
        }
        if(locationString.equalsIgnoreCase("til232")){
            return true;
        }
        return false;
    }

    /**
     * Determines if there are errors in the event info
     * @param eventInfo Array of strings with info about the event
     * @param event The event object created by eventinfo
     * @return boolean Returns true if there are no errors
     */
    private boolean checkErrors(Event event, String[] eventInfo){
        //Checks if its a valid calendar date
        if(event.getDate().isValid()==false){
            System.out.println(eventInfo[1]+": Invalid calendar date!");
            return false;
        }
        //Checks if event is in future
        if(event.getDate().isFuture()==false){
            System.out.println(eventInfo[1]+": Event date must be a future date!");
            return false;
        }
        //Checks if event is within 6 months
        if(event.getDate().withinSixMonths()==false){
            System.out.println(eventInfo[1]+": Event date must be within 6 months!");
            return false;
        }
        //Checks if timeslot is valid
        if(validTimeslot(eventInfo)==false){
            System.out.println("Invalid time slot!");
            return false;
        }
        //Checks if location is one of the 6 listed
        if(validLocation(eventInfo) ==false){
            System.out.println("Invalid Location!");
            return false;
        }
        //Checks if the department name is one of the five departments listed and if the email address is invalid
        if(event.getContact().isValid()==false){
            System.out.println("Invalid conctact information!");
            return false;
        }
        return true;
    }

    /**
     * Determines if there is errors in the event info. This method is only meant to be used by the R command
     * @param eventInfo Array of strings with info about the event
     * @param event The event object created by eventinfo
     * @return boolean Returns true if there are no errors in the info
     */
    private boolean checkRCommandErrors(Event event, String[] eventInfo){
        //Checks if its a valid calendar date
        if(event.getDate().isValid()==false){
            System.out.println(eventInfo[1]+": Invalid calendar date!");
            return false;
        }
        //Checks if event is in future
        if(event.getDate().isFuture()==false){
            System.out.println(eventInfo[1]+": Event date must be a future date!");
            return false;
        }
        //Checks if event is within 6 months
        if(event.getDate().withinSixMonths()==false){
            System.out.println(eventInfo[1]+": Event date must be within 6 months!");
            return false;
        }
        //Checks if timeslot is valid
        if(validTimeslot(eventInfo)==false){
            System.out.println("Invalid time slot!");
            return false;
        }
        //Checks if location is one of the 6 listed
        if(validLocation(eventInfo) ==false){
            System.out.println("Invalid Location!");
            return false;
        }
        return true;
    }
    



}