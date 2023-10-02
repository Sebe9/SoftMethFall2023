package project1;
public enum Location {
    ARC103("Allison Road Classroom, Busch"),
    HLL114("Hill Center, Busch"), 
    AB2225("Academic Building, College Avenue"),
    MU302("Murray Hall, College Avenue"),
    BE_AUD("Beck Hall, Livingston"),
    TIL232("Tillet Hall, Livingston");
    

    private String roomLocation;

    Location(String roomLocation){
        this.roomLocation = roomLocation;
    }

    public String getLocation() {
        return roomLocation;
    }
}
