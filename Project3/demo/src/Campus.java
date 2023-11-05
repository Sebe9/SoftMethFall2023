package src;
/**
 * Contains the campus code information.
 * @author Matthew Chan
 */
public class Campus {
    private String campusCode;
    /**
     * Initializes the information needed for recognizing the campus code.
     * @param campusCode The code indicating a campus required for opening a college checking account.
     */
    public Campus(String campusCode){
        this.campusCode = campusCode;
    }
    /**
     * Retrieves the data for the campus code.
     * @return the value of the campus code.
     */
    public String getCampusCode(){
        return campusCode;
    }
    /**
     * Method to acquire the string representation of the campus.
     * @return the string representation of the campus.
     */
    public String getCampusName(){
        if(campusCode.equals("0")){
            return "NEW_BRUNSWICK";
        }
        if(campusCode.equals("1")){
            return "NEWARK";
        }
        else{
            return "CAMDEN";
        }
    }

}
