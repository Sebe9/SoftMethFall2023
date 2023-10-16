package src;
public class MoneyMarket extends Savings{
    private int withdrawal;
    private static final double DEFAULT_MONTHLY_FEE = 25.0;
    private static final double DEFAULT_MONTHLY_INTEREST = 0.00375;
    private static final double LOYAL_MONTHLY_FEE = 0;
    private static final double LOYAL_MONTHLY_INTEREST = 0.00396;
    protected boolean isLoyal;
    @Override public double monthlyInterest(){
        if (isLoyal)
            return LOYAL_MONTHLY_INTEREST;
        else
            return DEFAULT_MONTHLY_INTEREST;
    }
    @Override public double monthlyFee(){
        double fee;
        if (isLoyal)
            fee = LOYAL_MONTHLY_FEE;
        else
            fee = DEFAULT_MONTHLY_FEE;
        if (withdrawal >3)
            fee+=10;
        return fee;
    }
    public MoneyMarket(Profile accountProfile, double newBalance, boolean loyaltyStatus, int withdrawal){
        super(accountProfile,newBalance,loyaltyStatus);
        this.withdrawal = withdrawal;
    }
    public MoneyMarket(Profile holder){
        super(holder);
    }
    public MoneyMarket(Profile holder, double newBalance){
        super(holder,newBalance);
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