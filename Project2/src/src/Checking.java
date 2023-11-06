package src;
import java.text.DecimalFormat;
/**
 * Contains information needed to open a checking account.
 * @author Matthew Chan
 */
public class Checking extends Account {
    private static final double MONTHLY_FEE = 12.0;
    private static final double MONTHLY_INTEREST = (.01/12);
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
    /**
     * Initializes the checking account with holder.
     * @param holder the person attached to the account.
     */
    public Checking(Profile holder){
        super(holder);
    }
    /**
     * Method that compares the current account to another account based on their profile.
     * @param otherAcc account being compared to.
     * @return Returns a value determining the comparison between both accounts. Return -1 if the accounts are not an instance of checking or college checking.
     */
    public int compareTo(Account otherAcc){
        if (otherAcc instanceof Checking||otherAcc instanceof CollegeChecking){
            return this.getProfile().compareTo(otherAcc.getProfile());
        } 
        else{
            return -1;
        }
    }
    /**
     * Method that checks if the profiles of two accounts are equal.
     * @param otherAccount Account being compared to the current account.
     * @return true if the otherAccount is an instance of checking and collegechecking and shares the same profile. Returns false otherwise.
     */
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
    /**
     * Putting monthlyFee in the right decimal format.
     * @return the String of newNum.
     */
    public String monthlyFeeFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (getBalance()>=1000){
            String newNum = decimalFormat.format(REDUCED_MONTHLY_FEE);
            return newNum;
        }
        else{
            String newNum = decimalFormat.format(MONTHLY_FEE);
            return newNum;
        }
    }
    /**
     * Putting interest in the right decimal format.
     * @return string of newNum.
     */
    public String interestFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String newNum = decimalFormat.format(balance*MONTHLY_INTEREST);
        return newNum;
    }
    /**
     * Putting balance in the right format.
     * @return newNum 
     */
    public String getNewBalanceFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String newNum = decimalFormat.format((getBalance()- monthlyFee())+ (getBalance()* monthlyInterest()));
        return newNum;
        }
    

}
