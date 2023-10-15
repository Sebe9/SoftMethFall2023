public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
    /**
     * @param otherAcc the other account you wish to compare this account to
     * @return int Returns a negative int, 0, or a positive int if the compared Account is less than, equal to, or greater than 
     */
    public abstract int compareTo();
    
    private Profile getProfile(){
        return holder;
    }
   /**
 * 4 different contains functions, each for a different type of Account
 * --They will each loop through the array
 * --Use InstanceOf. If False dont call compareTo, if true call compareTo
 * 
 * compareTo in each Account subclass
 * --Will only be used to compare of the same type
 * 
 * When adding an account to the array use an enum class to sort the checking account nicknames
 * --This is also
 * 
 * 
 * 
 * 
 * I am supposed to overload contains() AND have a compareTo in each Account type
 * possibility 1 -- contains() variation for every combination of account types 
 */
}