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
    public Savings(Profile accountProfile, double newBalance, boolean loyaltyStatus){
        super(accountProfile, newBalance);
        this.isLoyal = loyaltyStatus;
    }
    public int compareTo(Account otherAcc){
        if (otherAcc instanceof Savings){
            return this.getProfile().compareTo(otherAcc.getProfile());
        } 
        else{
            return -1;
        }
    }

    public boolean equals(Account otherAccount){
        if(otherAccount instanceof Savings){
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
