package src;
/**
 * Contains information for setting up a college checking account.
 * @author Matthew Chan
 */
public class CollegeChecking extends Checking{
    private Campus campus;
    private static final double MONTHLY_FEE = 0;
    private static final double MONTHLY_INTEREST = (0.01/12);
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
     * Initializes the information needed to setup a college checking account.
     * @param holder Profile attached to account.
     */
    public CollegeChecking(Profile holder){
        super(holder);
    }
    /**
     * Initializes the information needed to setup a college checking account.
     * @param holder Profile attached to account.
     * @param newBalance Balance attached to the account.
     */
    public CollegeChecking(Profile holder, double newBalance){
        super(holder,newBalance);
    }
    /**
     * Retrieves the data for MONTHLY_FEE.
     * @return the value of MONTHLY_FEE.
     */
    @Override public double monthlyInterest(){
        return MONTHLY_FEE;
    }
    /**
     * Retrieves the data for MONTHLY_INTEREST.
     * @return the value of MONTHLY_INTEREST.
     */
    @Override public double monthlyFee(){
        return MONTHLY_INTEREST;
    }
    /**
     * Retrieves the data for campus.
     * @return the value of campus.
     */
    public Campus getCampus(){
        return campus;
    }
}  