package project1;

/**
 * Contains contact information for an event. Provides a method to validate the contact information.
 * 
 * @author Matthew Chan
 */
public class Contact {
    private Department department;
    private String email;
    /**
     * Initializes the contact information for an event.
     * @param department The department the contact object will hold.
     * @param email The email the object will hold.
     */
    public Contact(Department department, String email){
        this.department = department;
        this.email = email;
    }
    /** 
     * Retrieves the data for the department.
     * @return the value of the department.
     */
    public Department getDepartment() {
        return department;
    }
    /**
     * Retrieves the data for the email.
     * @return the value of the email.
     */
    public String getEmail(){
        return email;
    }
    /**
     * Determines if the contact information is valid.
     * @return true if the email has the domain of rutgers.edu and has an existing department and false if otherwise.
     */
    public boolean isValid(){
        return email.contains("@rutgers.edu") && (department.getName().equals("Computer Science")|| department.getName().equals("Electrical Engineering") || department.getName().equals("Information Technology and Informatics") || department.getName().equals("Mathematics") || department.getName().equals("Business Analytics and Information Technology"));
    }
}