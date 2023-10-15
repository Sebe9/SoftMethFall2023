public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;
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
    public Profile(String firstName, String lastName, Date dateOfBirth){
        this.fname = firstName;
        this.lname = lastName;
        this.dob = dateOfBirth;
    }
    private String getFName(){
        return fname;
    }
    private String getLName(){
        return lname;
    }
    private Date getDob(){
        return dob;
    }
}
