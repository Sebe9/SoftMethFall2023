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
    public int compareTo(Account otherAcc){
        if (otherAcc instanceof MoneyMarket){
            return this.getProfile().compareTo(otherAcc.getProfile());
        } 
        else{
            return -1;
        }
    }
    @Override public boolean equals(Account otherAccount){
        if(otherAccount instanceof MoneyMarket){
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