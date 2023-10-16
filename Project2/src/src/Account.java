package src;
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
     * Setter method to mutate the balance.
     * @param newBalance the new balance of the account.
     */
    public void setBalance(double newBalance){
        this.balance = newBalance;
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