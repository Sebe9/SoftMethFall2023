package com.example.demo;

import static com.example.demo.Savings.REDUCED_MONTHLY_FEE;

import java.text.DecimalFormat;

/**
 * Contains information for setting up a Money Market account.
 * @author Sebastian Hanna
 */
public class MoneyMarket extends Savings{
    private int withdrawal;
    private static final double DEFAULT_MONTHLY_FEE = 25.0;
    private static final double DEFAULT_MONTHLY_INTEREST = 0.00375;
    private static final double LOYAL_MONTHLY_FEE = 0;
    private static final double LOYAL_MONTHLY_INTEREST = 0.00396;
    protected boolean isLoyal;
    /**
     * Determines the type of monthly interest for an account.
     * @return LOYAL_MONTHLY_INTEREST if they are loyal. Return DEFAULT_MONTHLY_INTEREST otherwise.
     */
    @Override public double monthlyInterest(){
        if (isLoyal)
            return LOYAL_MONTHLY_INTEREST;
        else
            return DEFAULT_MONTHLY_INTEREST;
    }
    /**
     * Calculates the monthly fee of an account depending on their loyalty status.
     * @return the fee needed for an account.
     */
    @Override public double monthlyFee(){
        double fee;
        if (isLoyal)
            fee = LOYAL_MONTHLY_FEE;
        else
            fee = DEFAULT_MONTHLY_FEE;
        if (withdrawal >3)
            fee+=10;
        return fee;
    }
    /**
     * Initializes the information needed to open a MoneyMarket account.
     * @param accountProfile Profile attached to account.
     * @param newBalance Balance attached to account.
     * @param loyaltyStatus Loyalty status of an account.
     * @param withdrawal Money to withdraw. 
     */
    public MoneyMarket(Profile accountProfile, double newBalance, boolean loyaltyStatus, int withdrawal){
        super(accountProfile,newBalance,loyaltyStatus);
        this.withdrawal = withdrawal;
    }
    /**
     * Initializes MoneyMarket through the profile.
     * @param holder Profile attached to account.
     */
    public MoneyMarket(Profile holder){
        super(holder);
    }
    /**
     * Initializes MoneyMarket through the holder and balance.
     * @param holder Profile attached to account.
     * @param newBalance Balance attached to account.
     */
    public MoneyMarket(Profile holder, double newBalance){
        super(holder,newBalance);
    }
    /**
     * Compares the profiles of the current account with a second account.
     * @return -1 if otherAcc is not an instance of MoneyMarket. Otherwise, return value of the comparison of the current account with the otherAcc.
     */
    @Override public int compareTo(Account otherAcc){
        if (otherAcc instanceof MoneyMarket){
            return this.getProfile().compareTo(otherAcc.getProfile());
        } 
        else{
            return -1;
        }
    }
    /**
     * Method to determine if two accounts are equal.
     * @return true if the otherAccount is an instance of MoneyMarket and shares the same profile. Returns false otherwise.
     */
    @Override public boolean equals(Account otherAccount){
        if(otherAccount instanceof MoneyMarket){
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

    @Override public String getLoyalty(){
        if(isLoyal){
            return "::is loyal";
        }
        else{
            return "";
        }
    }

    public int getWithdrawal(){
        return withdrawal;
    }

    @Override public String interestFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0:00");
        if (isLoyal){
            String newNum = decimalFormat.format(LOYAL_MONTHLY_INTEREST);
            return newNum;
        }
        else{
            String newNum = decimalFormat.format(DEFAULT_MONTHLY_INTEREST);
            return newNum;
        }
    }
    @Override public String feeFormat(){
        double fee;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (isLoyal)
            fee = LOYAL_MONTHLY_FEE;
        else
            fee = DEFAULT_MONTHLY_FEE;
        if (withdrawal >3)
            fee+=10;
        return decimalFormat.format(fee);
    }
    /**
     * Mutating the withdrawal integer.
     * @param newWD new withdrawal
     */
    public void setWithdrawal(int newWD){
        this.withdrawal = newWD;
    }
}