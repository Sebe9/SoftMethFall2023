package project1;
public enum Location {
    /**
     * Contains information for the location of an event.
     * 
     * @author Matthew Chan
     */
    HLL114("Hill Center, Busch"), 
    ARC103("Allison Road Classroom, Busch"),
    BE_AUD("Beck Hall, Livingston"),
    TIL232("Tillet Hall, Livingston"),
    AB2225("Academic Building, College Avenue"),
    MU302("Murray Hall, College Avenue");

    private String roomLocation;

    /**
     * Assigns the address of the event to the object.
     * @param roomLocation The location the object will hold.
     */
    Location(String roomLocation){
        this.roomLocation = roomLocation;
    }
    /**
     * Retrievies the data of the event's location.
     * @return the value of the location.
     */
    public String getLocation() {
        return roomLocation;
    }
}
