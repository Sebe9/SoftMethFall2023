package project1; 

/**
 * Contains information, including the name, of the department. 
 * @author Matthew Chan
 */
public enum Department{
    CS("Computer Science"), 
    EE("Electrical Engineering"),
    MATH("Mathematics"),
    BAIT("Business Analytics and Information Technology"),
    ITI("Information Technology and Informatics");

    private String name; //changes with input

    /**
     * Assigns the full name to the object.
     * @param name The name of department you want the object to hold.
     */
    Department(String name){
        this.name = name; //department object's name now becomes the parameter
    }

    /**
     * Retrieves the data of the department's name.
     * @return the value of the name.
     */
    public String getName(){
        return name;
    }

    
}
