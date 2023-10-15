public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
    /**
     * @param otherAcc the other account you wish to compare this account to
     * @return int Returns a negative int, 0, or a positive int if the compared Account is less than, equal to, or greater than 
     */
    public int compareTo(Account otherAcc){
        //Need to use InstanceOf in order to see if they are same type of acc
        return 1;
    }
   
}