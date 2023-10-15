public class Checking extends Account {
    private static final double MONTHLY_FEE = 12.0;
    private static final double MONTHLY_INTEREST = 0.83;
    /**
     * Retrieves the data for MONTHLY_FEE.
     * @return the value of MONTHLY_FREE.
     */
    public double monthlyInterest(){
        return MONTHLY_FEE;
    }
    /**
     * Retrieves the data for MONTHLY_INTEREST.
     * @return the value of MONTHLY_INTEREST.
     */
    public double monthlyFee(){
        return MONTHLY_INTEREST;
    }
    /**
     *  Initializes the information for the checking account.
     * @param accountProfile the profile that will attach to the account.
     * @param newBalance the balance that will attached to the account.
     */
    public Checking(Profile accountProfile, double newBalance){
        super(accountProfile, newBalance);
    }
    /**
     * Compares the current account to another account.
     * @param otherAcc the other account you wish to compare to the current account.
     * @return 
     */
    @Override public int compareTo(Account otherAcc){
        return Double.compare(this.balance, otherAcc.balance); 
     }
}
