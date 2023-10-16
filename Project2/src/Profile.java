/**
 * Contains all profile information such as first and last name along with date of birth.
 * @author Matthew Chan
 */
public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;
    /**
     * Compares current profile to another profile.
     * @param otherProfile the other profile you want to compare to. 
     * @return 
     */
    public int compareTo(Profile otherProfile){
        int compareLastName = this.lname.compareTo(otherProfile.lname);
        int compareFirstName = this.fname.compareTo(otherProfile.fname);
        if (compareLastName != 0){
            return compareLastName;
        }
        else{
            return compareFirstName;
        }
    }
    /**
     * Initializes the information needed to create a profile.
     * @param firstName first name of person.
     * @param lastName last name of person.
     * @param dateOfBirth the date of birth of the person.
     */
    public Profile(String firstName, String lastName, Date dateOfBirth){
        this.fname = firstName;
        this.lname = lastName;
        this.dob = dateOfBirth;
    }
    /**
     * Retrieves the data of fname.
     * @return the value of fname.
     */
    private String getFName(){
        return fname;
    }
    /**
     * Retrieves the data of lname.
     * @return the value of lname.
     */
    private String getLName(){
        return lname;
    }
    /**
     * Retrieves the data of dob.
     * @return the value of dob.
     */
    private Date getDob(){
        return dob;
    }
}
