public class Savings extends Account{
    private static final double MONTHLY_FEE = 25.0;
    private static final double MONTHLY_INTEREST = 0.33;
    protected boolean isLoyal;
    public double monthlyInterest(){
        return MONTHLY_INTEREST;
    }
    public double monthlyFee(){
        return MONTHLY_FEE;
    }
    Savings(Profile accountProfile, double newBalance, boolean loyaltyStatus){
        this.holder= accountProfile;
        this.balance = newBalance;
        this.isLoyal = loyaltyStatus;
    }
}
