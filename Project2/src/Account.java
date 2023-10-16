public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
    public abstract boolean equals(Account otherAccount);
    public Account(Profile holder, double balance){
        this.holder = holder;
        this.balance = balance;
    }
    /**
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
    public Profile getProfile(){
        return holder;
    }
    public double getBalance(){
        return balance;
    }
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