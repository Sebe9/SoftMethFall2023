package com.example.demo;

import java.text.DecimalFormat;

/**
 * Contains all information attached to a savings account.
 * @author Matthew Chan
 */
public class Savings extends Account{
    private static final double MONTHLY_FEE = 25.0;
    private static final double MONTHLY_INTEREST = (0.04/12);
    public static final double REDUCED_MONTHLY_FEE = 0;
    private static final double LOYAL_MONTHLY_INTEREST = (0.0425/12);
    protected boolean isLoyal;
    /**
     * Determines the monthly interest of an account depending on its loyalty status.
     * @return LOYAL_MONTHLY_INTEREST if its a loyal account. Otherwise, return MONTHLY_INTEREST.
     */
    public double monthlyInterest(){
        if(isLoyal)
            return LOYAL_MONTHLY_INTEREST;
        else
            return MONTHLY_INTEREST;
    }
    /**
     * Determines the monthly interest of an account depending on its balance.
     * @return REDUCED_MONTHLY_FEE if the balance is greater than or equal to 500. Otherwise, return MONTHLY_FEE.
     */
    public double monthlyFee(){
        if (getBalance()>=500)
            return REDUCED_MONTHLY_FEE;
        else
            return MONTHLY_FEE;
    }
    /**
     * Initializes a Savings account through a profile, balance, and loyalty status.
     * @param accountProfile Profile attached to account.
     * @param newBalance Balance attached to an account.
     * @param loyaltyStatus Loyalty status of an account.
     */
    public Savings(Profile accountProfile, double newBalance, boolean loyaltyStatus){
        super(accountProfile, newBalance);
        this.isLoyal = loyaltyStatus;
    }
    /**
     * Initializes savings account through the holder.
     * @param holder Profile attached to account.
     */
    public Savings(Profile holder){
        super(holder);
    }
    /**
     * Initializes savings account through the holder and balance.
     * @param holder Profile attached to account.
     * @param newBalance Balance attached to an account.
     */
    public Savings(Profile holder, double newBalance){
        super(holder,newBalance);
    }
    /**
     * Compares two accounts based on their profiles.
     * @param otherAcc Account that will be compared to the current account.
     * @return value of compareTo if otherAcc is an instance of Savings and its profile matches the current account's. Otherwise, return -1.
     */
    public int compareTo(Account otherAcc){
        if (otherAcc instanceof Savings){
            return this.getProfile().compareTo(otherAcc.getProfile());
        } 
        else{
            return -1;
        }
    }
    /**
     * Determines if two accounts are equal.
     * @param otherAcc Account that will be compared to the current account.
     * @return true if otherAcc is an instance of Savings and matches the same profile. Otherwise, return false.
     */
    public boolean equals(Account otherAccount){
        if(otherAccount instanceof Savings){
            if(this.getProfile().compareTo(otherAccount.getProfile())==0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    /**
     * Getter method for loyalty status.
     * @return string determining loyalty.
     */
    public String getLoyalty(){
        if(isLoyal){
            return "::is loyal";
        }
        else{
            return "";
        }
    }
    /**
     * Putting interest in the correct format.
     * @return the String of newNum.
     */
    public String interestFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (isLoyal){
            String newNum = decimalFormat.format(LOYAL_MONTHLY_INTEREST);
            return newNum;
        }
        else{
            String newNum = decimalFormat.format(MONTHLY_INTEREST);
            return newNum;
        }
    }
    /**
     * Putting fee in the correct decimal format.
     * @return the String of newNum.
     */
    public String feeFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (getBalance()>=500){
            String newNum = decimalFormat.format(REDUCED_MONTHLY_FEE);
            return newNum;
        }
        else{
            String newNum = decimalFormat.format(MONTHLY_FEE);
            return newNum;
        }
    }
        
}
