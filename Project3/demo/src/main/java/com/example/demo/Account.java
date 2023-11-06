package com.example.demo;
import  java.text.DecimalFormat;
/**
 * Contains information of an account such as the holder and the balance inside the account.
 * @author SebastianHanna, Matthew Chan
 */
public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
    public abstract boolean equals(Account otherAccount);
    /**
     * Initializes account object with holder and balance.
     * @param holder Person attached to account.
     * @param balance Balance attached to account.
     */
    public Account(Profile holder, double balance){
        this.holder = holder;
        this.balance = balance;
    }
    /**
     * Initializes account object with holder.
     * @param holder Person attached to account.
     */
    public Account(Profile holder){
        this.holder = holder;
    }
    /**
     * Compares the current account to another account.
     * @param otherAcc the other account you wish to compare this account to
     * @return int Returns a negative int, 0, or a positive int if the compared Account is less than, equal to, or greater than
     */
    /*
    @Override public int compareTo(Account otherAcc){
        if ((this.getClass().getSimpleName().compareTo(otherAcc.getClass().getSimpleName()))==0){
            return this.getProfile().compareTo(otherAcc.getProfile());
        }
        else{
            return (this.getClass().getSimpleName().compareTo(otherAcc.getClass().getSimpleName()));
        }
    }
    */
    /**
     * Getter method for the holder.
     * @return the data for holder.
     */
    public Profile getProfile(){
        return holder;
    }
    /**
     * Getter method for the balance.
     * @return the data of the balance.
     */
    public double getBalance(){
        return balance;
    }
    /**
     * Putting balance in the right format.
     * @return newNum
     */
    public String getBalanceFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String newNum = decimalFormat.format(balance);
        return newNum;
    }
    /**
     * Setter method to mutate the balance.
     * @param newBalance the new balance of the account.
     */
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
    /**
     * Representing the object as a string.
     * @param account Account being represented.
     * @return textual representation of the account information.
     */
    public String toString(Account account){
        if(account instanceof Checking && !(account instanceof CollegeChecking)){
            return "Checking::" + account.getProfile().getFName() + " " + account.getProfile().getLName() + " " + account.getProfile().getDob().getMonth() + "/" + account.getProfile().getDob().getDay() + "/" + account. getProfile().getDob().getYear() + "::Balance $" + account.getBalanceFormat();
        }
        if(account instanceof CollegeChecking){
            CollegeChecking temp = (CollegeChecking) account;
            return "College Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getBalanceFormat() + "::" + temp.getCampus().getCampusName();
        }
        if(account instanceof MoneyMarket){
            MoneyMarket temp = (MoneyMarket) account;
            return "Money Market::Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getBalanceFormat() + temp.getLoyalty() + "::withdrawal: " + temp.getWithdrawal();
        }
        else{
            Savings temp = (Savings) account;
            return "Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getBalanceFormat() + temp.getLoyalty() ;
        }
    }
    /**
     * Representing the account object as a string.
     * @param account Account being represented.
     * @return textual representation of the accunt information.
     */
    public String toStringPI(Account account){
        if(account instanceof Checking && !(account instanceof CollegeChecking)){
            Checking temp = (Checking) account;
            return "Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getBalanceFormat() + "::fee $" + temp.monthlyFeeFormat() + "::monthly interest $" + temp.interestFormat();
        }
        if(account instanceof CollegeChecking){
            CollegeChecking temp = (CollegeChecking) account;
            return "College Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getBalanceFormat() + "::" + temp.getCampus().getCampusName() + "::fee $" + temp.monthlyFeeFormat() + "::monthly interest $" + temp.interestFormat();
        }
        if(account instanceof MoneyMarket){
            MoneyMarket temp = (MoneyMarket) account;
            return "Money Market::Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getBalanceFormat() + temp.getLoyalty() + "::withdrawal: " + temp.getWithdrawal() + "::fee $" + temp.feeFormat() + "::monthly interest $" + temp.interestFormat();
        }
        else{
            Savings temp = (Savings) account;
            return "Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getBalanceFormat() + temp.getLoyalty() + "::fee $" + temp.feeFormat() + "::monthly interest $" + temp.interestFormat();
        }
    }
    /**
     * Representing the account object as a string.
     * @param account Account being represented.
     * @return textual representation of the account information.
     */
    public String toStringUB(Account account){
        if(account instanceof Checking && !(account instanceof CollegeChecking)){
            // subtract fees add interest to balance
            Checking temp = (Checking) account;
            return "Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getNewBalanceFormat();
        }
        if(account instanceof CollegeChecking){
            account.setBalance((account.getBalance()-account.monthlyFee()) + account.monthlyInterest());
            CollegeChecking temp = (CollegeChecking) account;
            return "College Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getNewBalanceFormat() + "::" + temp.getCampus().getCampusName();
        }
        if(account instanceof MoneyMarket){
            account.setBalance((account.getBalance()-account.monthlyFee()) + account.monthlyInterest());
            MoneyMarket temp = (MoneyMarket) account;
            return "Money Market::Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getNewBalanceFormat() + temp.getLoyalty() + "::withdrawal: " + temp.getWithdrawal();
        }
        else{
            account.setBalance((account.getBalance()-account.monthlyFee()) + account.monthlyInterest());
            Savings temp = (Savings) account;
            return "Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob().getMonth() + "/" + temp.getProfile().getDob().getDay() + "/" + temp.getProfile().getDob().getYear() + "::Balance $" + temp.getNewBalanceFormat() + temp.getLoyalty() ;
        }
    }

}

/**
 * compareTo, equals(), and toString in all Account types
 * --compareTo is only to be used in the add method
 * ----This method ends up being kind of pointless.(we only really need one in the Account class)
 * ----Each compareTo will also compare class names
 *
 * --equals methods will be used in the contains and find methods
 * ----Checking and CollegeCheckings don't both need this, only checking
 *
 *
 */