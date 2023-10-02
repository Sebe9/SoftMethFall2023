package project1;
import java.util.Scanner;
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
            else if (inputArray[0] == "R"){
                System.out.println("R command was called");
                rCommand(inputArray);
            }
            else if (inputArray[0] == "P"){
                System.out.println("P command was called");
            }
            else if (inputArray[0] == "PE"){
                System.out.println("PE command was called");
            }
            else if (inputArray[0] == "PC"){
                System.out.println("PC command was called");
            }
            else if (inputArray[0] == "PD"){
                System.out.println("PD command was called");
            }
            else if (inputArray[0] == "Q"){
                System.out.println("Q command was called");
                break;
            }
            else{
                System.out.println(nextLine.charAt(0)+" is an invalid command!");
            }

        }
        System.out.println("Event Organizer terminated.");
    }
    /**
     * Method in which the r command is processed and cancels an event.
     */
    private void rCommand(String[] eventInfo){
        Date date = new Date(eventInfo[1]);
        Timeslot timeslot = Timeslot.valueOf(eventInfo[2]);
        Location location = Location.valueOf(eventInfo[3]);
        Department department = Department.valueOf(eventInfo[4]);
        String email = eventInfo[5];
        int duration = Integer.parseInt(eventInfo[6]);
        Event event  = new Event(date, timeslot, location, new Contact(department, email));
        if (myCalendar.remove(event)) {
            System.out.println("Event removed successfully.");
        } else {
            System.out.println("Event not found or cannot be removed.");
        }
    }
    /**
     * Method in which the p command is processed and prints the event calendar.
     */
    private void pCommand(){
        myCalendar.print(); 
    }
    /**
     * Method in which the pe command is processed and displays the event calendar, sorted by event date and timeslot.
     */
    private void peCommand(){

    }
    /**
     * Method in which the pc command is processed and displays the event calendar, sorted by campus and building.
     */
    private void pcCommand(){

    }
    /**
     * Method in which the pd command is processed and displays the event calendar, sorted by the department and contact.
     */
    private void pdCommand(){

    }



}