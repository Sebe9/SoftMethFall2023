package project1;
public class EventCalendar {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public static final int NOT_FOUND = -1;    
    /**
     * Constructs the EventCalendar Object. 
     * Takes no arguments. Initializes the events array to an empty array and sets numEvents to 0
     */
    public EventCalendar(){
        this.events = new Event[4];
        numEvents = 0;
    }
    /**
     * This method finds out if an event is in the events array.
     * @param event takes the event that is being searched for
     * @return int returns the index of the event if found. Returns -1 if the event is not in the array
     */
    private int find(Event event) { 
        for (int i = 0; i < numEvents; i++){
            if(event.equals(events[i])){
                return i;
            }
        }
        return NOT_FOUND;
    } //search an event in the list
    
    /**
     * Grows the length of the event calendar array by 4.
     */
    private void grow(){ 
        int oldLength = events.length;

        Event[] newEventArray = new Event[oldLength + 4];
        for(int i = 0; i < oldLength; i++){
            newEventArray[i] = events[i];
        }
        events = newEventArray;
    } 
    
    /**
     * Adds an event to the end of the event array.
     * @param event The even you want to add to EventCalendar
     * @return boolean Returns true if event is successfully added
     */
    public boolean add(Event event) {
        
        events[numEvents] = event;
        numEvents++;
        if(events.length == numEvents){
            grow();
        }
        return true;
     }
    /**
     * This method removes an event from the EventCalendar
     * @return boolean Returns true if event was successfully removed. Returns false if the event could not be found and removed
     * @param event The Event that should be removed
     */
    public boolean remove(Event event) { 
        int indexToBeRemoved = find(event);
        if (indexToBeRemoved == NOT_FOUND){
            return false;
        }
        for (int j = indexToBeRemoved; j < numEvents; j++){
            events[j] = events[j+1]; 
        }
        numEvents--;
        return true;
        
    }
    /**
     * This method finds out whether or not an event is contained in the EventCalendar.
     * @return boolean Returns true is the event is contained in the EventCalendar array. Returns false if it is not.
     * @param event The event you want to see if EventCalendar contains
     */
    public boolean contains(Event event) {
        int foundIndex = find(event);
        if (foundIndex == NOT_FOUND){
            return false;
        }
        else{
            return true;
        }
    }

    /*
     * This method prints the array in the order it is currently in
     */
    public void print() {
        for (int i = 0; i <numEvents; i++){
            System.out.println(events[i]);
        }

    }
    /**
     * This method swaps two events in the EventCalendar array
     * @param int the index of the first Event object
     * @param int the index of the second Event object
     */
    private void swapEvents(int index1, int index2){
        Event tempEvent = events[index1];
        events[index1] = events[index2];
        events[index2] = tempEvent;

    }
    /**
     * This method prints the array by date and timeslot
     */
    public void printByDate() {
        boolean unsorted = true; 
        while(unsorted == true){
            unsorted = false;
            for (int j = 0; j < numEvents-1; j++){
                //swap Events if event[j] has an later date than event[j+1]
                if (events[j].getDate().compareTo(events[j+1].getDate()) < 0){
                    swapEvents(j,j+1);
                    unsorted = true;
                }
                //If the dates are the same swap if event[j] has an later timeslot than event[j+1] 
                else if(events[j].getDate().compareTo(events[j+1].getDate())==0 ){
                    if(events[j].getTimeslot().compareTo(events[j+1].getTimeslot()) > 0){
                        swapEvents(j,j+1);
                        unsorted = true;
                    }
                    
                }
            }
        }
        print();
    } 
    public void printByCampus() { 
        boolean unsorted = true; 
        while(unsorted == true){
            unsorted = false;
            for (int j = 0; j < numEvents-1; j++){
                String location1 = events[j].getLocation().getLocation();
                String location2 = events[j+1].getLocation().getLocation();
                String[] location1Parsed = location1.split(",");
                String[] location2Parsed = location2.split(",");
                String location1Campus = location1Parsed[1];
                String location2Campus = location2Parsed[1];
                String location1Building = location1Parsed[0];
                String location2Building = location2Parsed[0];
                if (location1Campus.compareTo(location2Campus) > 0){
                    swapEvents(j,j+1);
                    unsorted = true;
                }
                else if(location1Campus.compareTo(location2Campus) == 0 ){
                    if(location1Building.compareTo(location2Building) > 0){
                        swapEvents(j,j+1);
                        unsorted = true;
                    }
                }
            }
        }
        print();
    } 
    /**
     * Retusn the number of events in the calendar.
     * @return int returns the number of events
     */
    public int getNumEvents(){
        return numEvents;
    }
    /**
     * Sorts the array by Department name (Alphabetically) the prints it.
     */
    public void printByDepartment(){ 
        boolean unsorted = true; 
        while(unsorted == true){
            unsorted = false;
            for (int j = 0; j < numEvents-1; j++){
                //swap Events if event[j] has an later date than event[j+1]
                if (events[j].getContact().getDepartment().getName().compareTo(events[j+1].getContact().getDepartment().getName()) > 0){
                    swapEvents(j,j+1);
                    unsorted = true;
                }   
            }
        }
        print();
    }


}