package project1;
public enum Timeslot {
    morning("10:30am"), 
    afternoon("2:00pm"), 
    evening("6:30pm");
    
    private String time;
    /**
     * Assigns the timeslot to the object.
     * @param time The time you want the object to hold.
     */
    Timeslot(String time){
        this.time = time;
    }
    /**
     * Retrives the data of the event's timeslot.
     * @return the value of the time.
     */
    public String getTime(){
        return time;
    }
}
