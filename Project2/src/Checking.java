public class Checking extends Account {
    private static final double MONTHLY_FEE = 12.0;
    private static final double MONTHLY_INTEREST = 0.83;
    public double monthlyInterest(){
        return MONTHLY_FEE;
    }
    public double monthlyFee(){
        return MONTHLY_INTEREST;
    }
    Checking(Profile accountProfile, double newBalance){
        this.holder = accountProfile;
        this.balance = newBalance;
    }
    
}
