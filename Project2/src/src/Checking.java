package src;
public class Checking extends Account {
    private static final double MONTHLY_FEE = 12.0;
    private static final double MONTHLY_INTEREST = (0.01/12);
    private static final double REDUCED_MONTHLY_FEE = 0;
    /**
     * Retrieves the data for MONTHLY_FEE.
     * @return the value of MONTHLY_FREE.
     */
    public double monthlyInterest(){
        return MONTHLY_INTEREST;
    }
    /**
     * Retrieves the data for MONTHLY_INTEREST.
     * @return the value of MONTHLY_INTEREST.
     */
    public double monthlyFee(){
        if (getBalance()>=1000)
            return REDUCED_MONTHLY_FEE;
        else
            return MONTHLY_FEE;
    }
    /**
     *  Initializes the information for the checking account.
     * @param accountProfile the profile that will attach to the account.
     * @param newBalance the balance that will attached to the account.
     */
    public Checking(Profile accountProfile, double newBalance){
        super(accountProfile, newBalance);
    }
    public Checking(Profile holder){
        super(holder);
    }
    public int compareTo(Account otherAcc){
        if (otherAcc instanceof Checking||otherAcc instanceof CollegeChecking){
            return this.getProfile().compareTo(otherAcc.getProfile());
        } 
        else{
            return -1;
        }
    }

    public boolean equals(Account otherAccount){
        if(otherAccount instanceof Checking || otherAccount instanceof CollegeChecking){
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

}
