package project1;
import java.util.Scanner;
public class EventOrganizer{
   


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
        while(true){
            String nextLine  = scannerObj.nextLine();
            String[] inputArray = nextLine.split(" ");
            System.out.println(inputArray[0]+ " -- INput command");
            System.out.println(inputArray[0]==" R");
            if (nextLine.isBlank()){
                continue;
            } 
            else if (inputArray[0] == "R"){
                System.out.println("R command was called");
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