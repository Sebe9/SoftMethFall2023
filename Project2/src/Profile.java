public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;
    public int compareTo(Profile otherProfile){
        return -1;
    }
    Profile(String firstName, String lastName, Date dateOfBirth){
        this.fname = firstName;
        this.lname = lastName;
        this.dob = dateOfBirth;
    }
}
