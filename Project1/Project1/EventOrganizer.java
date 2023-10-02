package project1;
import java.util.Scanner;
public class EventOrganizer{
    public static final int R_ASCII = 82;
    /**
     * Instantiaties the Event Organizer.
     * Also Creates a new EventCalendar object.
     */
    public EventOrganizer(){
        EventCalendar myCalendar = new EventCalendar();
        System.out.println("Event Organizer running....");
    }
    /**
     * 
     */
    public void run(){
        Scanner scannerObj = new Scanner(System.in);
        String nextLine  = "";
        while (scannerObj.hasNextLine()){}
        while(nextLine!="Q"){
            if (nextLine != ""){
                if (nextLine.charAt(0) == R_ASCII ){
                    System.out.println("R command was called");
                }
            }
            nextLine = scannerObj.nextLine();
        }
        System.out.println("Event Organizer terminated.");
    }


    private void rCommand(){

    }
    private void pCommand(){

    }
    private void peCommand(){

    }
    private void pcCommand(){

    }
    private void pdCommand(){

    }



}