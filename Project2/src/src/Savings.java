package src;
public class Savings extends Account{
    private static final double MONTHLY_FEE = 25.0;
    private static final double MONTHLY_INTEREST = (0.04/12);
    private static final double REDUCED_MONTHLY_FEE = 0;
    private static final double LOYAL_MONTHLY_INTEREST = (0.0425/12);
    protected boolean isLoyal;
    public double monthlyInterest(){
        if(isLoyal)
            return LOYAL_MONTHLY_INTEREST;
        else
            return MONTHLY_INTEREST;
    }
    public double monthlyFee(){
        if (getBalance()>=500)
            return REDUCED_MONTHLY_FEE;
        else
            return MONTHLY_FEE;
    }
    public Savings(Profile accountProfile, double newBalance, boolean loyaltyStatus){
        super(accountProfile, newBalance);
        this.isLoyal = loyaltyStatus;
    }
    public Savings(Profile holder){
        super(holder);
    }
    public Savings(Profile holder, double newBalance){
        super(holder,newBalance);
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
