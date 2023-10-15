public class MoneyMarket extends Savings{
    private int withdrawal;
    private static final double DEFAULT_MONTHLY_FEE = 25.0;
    private static final double MONTHLY_INTEREST = 0.375;
    protected boolean isLoyal;
    @Override public double monthlyInterest(){
        return MONTHLY_INTEREST;
    }
    @Override public double monthlyFee(){
        return DEFAULT_MONTHLY_FEE;
    }
    public MoneyMarket(Profile accountProfile, double newBalance, boolean loyaltyStatus, int withdrawal){
        super(accountProfile,newBalance,loyaltyStatus);
        this.withdrawal = withdrawal;
    }
}