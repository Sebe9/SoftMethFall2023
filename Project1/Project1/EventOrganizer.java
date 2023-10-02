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
            else if (inputArray[0].equals("R")){
                System.out.println("R command was called");
                rCommand();
            }
            else if (inputArray[0].equals("P") ){
                System.out.println("P command was called");
            }
            else if (inputArray[0].equals("PE")){
                System.out.println("PE command was called");
            }
            else if (inputArray[0].equals("PC")){
                System.out.println("PC command was called");
            }
            else if (inputArray[0].equals("PD")){
                System.out.println("PD command was called");
            }
            else if (inputArray[0].equals("Q")){
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
    private void rCommand(String[] event){
        Date date = new Date(event[1]);
        Timeslot timeslot = Timeslot.valueOf(event[2]);
        Location location = Location.valueOf(event[3]);
        Department department = Department.valueOf(event[4]);
        String email = event[5];
        int duration = Integer.parseInt(event[6]);
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