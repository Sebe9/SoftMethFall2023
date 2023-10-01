package project1;
public enum Location {
    HLL114("Hill Center, Busch"), 
    ARC103("Allison Road Classroom, Busch"),
    BE_AUD("Beck Hall, Livingston"),
    TIL232("Tillet Hall, Livingston"),
    AB2225("Academic Building, College Avenue"),
    MU302("Murray Hall, College Avenue");

    private String roomLocation;

    Location(String roomLocation){
        this.roomLocation = roomLocation;
    }

    public String getLocation() {
        return roomLocation;
    }
}
