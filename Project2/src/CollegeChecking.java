public class CollegeChecking extends Checking{
    private Campus campus;
    private static final double MONTHLY_FEE = 12.0;
    private static final double MONTHLY_INTEREST = 0.83;
    
    public CollegeChecking(Profile accountProfile, double newBalance, Campus campusCode){
        super(accountProfile,newBalance);
        this.campus = campusCode;
    }
    public double monthlyInterest(){
        return MONTHLY_FEE;
    }
    public double monthlyFee(){
        return MONTHLY_INTEREST;
    }
    @Override public int compareTo(Account otherAcc){
        return Double.compare(this.balance, otherAcc.balance); 
     }
}  