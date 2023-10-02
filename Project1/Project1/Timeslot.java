package project1;
public enum Timeslot {
    morning("10:30am"), 
    afternoon("2:00pm"), 
    evening("6:30pm");
    
    private String time;

    Timeslot(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }
}
