package project1;
import java.util.Scanner;

/**
 * 
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
            String[] inputArray = nextLine.split(" ");
            System.out.println(inputArray[0]+ " -- INput command");
            System.out.println(inputArray[0].equalsIgnoreCase("R"));
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
                System.out.println(nextLine.charAt(0)+" is an invalid command!");
            }
        }
        System.out.println("Event Organizer terminated.");
        scannerObj.close();
    }

    private void aCommand(String[] eventInfo){
        Date date = new Date(eventInfo[1]);
        Timeslot timeslot = Timeslot.valueOf(eventInfo[2]);
        Location location = Location.valueOf(eventInfo[3]);
        Department department = Department.valueOf(eventInfo[4]);
        String email = eventInfo[5];
        int duration = Integer.parseInt(eventInfo[6]);
        Contact newContact = new Contact(department, email);
        Event event  = new Event(date, timeslot, location, newContact, duration);
        if(checkErrors(event, eventInfo)==false){
            return;
        }
        if( duration > 120 || duration < 30 ){
            System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
        }
        if (myCalendar.contains(event)==true){
            System.out.println("The event is already on the calendar.");
            return;
        }
        myCalendar.add(event);
        return;
    }
    /**
     * Method in which the r command is processed and cancels an event.
     * @param String[] EventInfo. A string of the information about the event you want removed
     */
    private void rCommand(String[] eventInfo){
        Date date = new Date(eventInfo[1]);
        Timeslot timeslot = Timeslot.valueOf(eventInfo[2]);
        Location location = Location.valueOf(eventInfo[3]);
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
        myCalendar.print(); 
    }
    /**
     * Method in which the pe command is processed and displays the event calendar, sorted by event date and timeslot.
     */
    private void peCommand(){
        if(myCalendar.getNumEvents()==0){
            System.out.println("Event calendar is empty!");
            return;
        }
        myCalendar.printByDate();
    }
    /**
     * Method in which the pc command is processed and displays the event calendar, sorted by campus and building.
     */
    private void pcCommand(){
        if(myCalendar.getNumEvents()==0){
            System.out.println("Event calendar is empty!");
            return;
        }
        myCalendar.printByCampus();
    }
    /**
     * Method in which the pd command is processed and displays the event calendar, sorted by the department and contact.
     */
    private void pdCommand(){
        if(myCalendar.getNumEvents()==0){
            System.out.println("Event calendar is empty!");
            return;
        }
        myCalendar.printByDepartment();
    }



    private boolean validTimeslot(String[] eventinfo){
        if(eventinfo[2].equalsIgnoreCase("afternoon")==false && eventinfo[2].equalsIgnoreCase("morning")==false && 
        eventinfo[3].equalsIgnoreCase("evening")==false){
            return false;
        }
        else{
            return true;
        }
    }
    private boolean validLocation(String[] eventinfo){
        String locationString = eventinfo[3];
        if(locationString.equalsIgnoreCase("hlll4")){
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