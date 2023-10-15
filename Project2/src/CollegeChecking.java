/**
 * Contains information for setting up a college checking account.
 * @author Matthew Chan
 */
public class CollegeChecking extends Checking{
    private Campus campus;
    private static final double MONTHLY_FEE = 12.0;
    private static final double MONTHLY_INTEREST = 0.83;
    /**
     * Initializes the information needed to set up a college checking account.
     * @param accountProfile Profile that will attach to the account.
     * @param newBalance Balance that will attach to the account.
     * @param campusCode Code that required to open account.
     */
    public CollegeChecking(Profile accountProfile, double newBalance, Campus campusCode){
        super(accountProfile,newBalance);
        this.campus = campusCode;
    }
    /**
     * Retrieves the data for MONTHLY_FEE.
     * @return the value of MONTHLY_FEE.
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
     * Compares the current cc account with another cc account.
     * @return 
     */
    @Override public int compareTo(Account otherAcc){
        return Double.compare(this.balance, otherAcc.balance); 
     }
}  