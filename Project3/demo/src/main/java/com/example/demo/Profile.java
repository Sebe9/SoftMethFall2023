package com.example.demo;
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
        int compareLastName = this.lname.toLowerCase().compareTo(otherProfile.lname.toLowerCase());
        int compareFirstName = this.fname.toLowerCase().compareTo(otherProfile.fname.toLowerCase());
        int compareDate = this.dob.compareTo(otherProfile.getDob());
        if (compareLastName != 0){
            return compareLastName;
        }
        else if (compareFirstName!=0){
            return compareFirstName;
        }
        else{
            return compareDate;
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
    public String getFName(){
        return fname;
    }
    /**
     * Retrieves the data of lname.
     * @return the value of lname.
     */
    public String getLName(){
        return lname;
    }
    /**
     * Retrieves the data of dob.
     * @return the value of dob.
     */
    public Date getDob(){
        return dob;
    }
}
