public class Checking extends Account {
    private static final double MONTHLY_FEE = 12.0;
    private static final double MONTHLY_INTEREST = 0.83;
    public double monthlyInterest(){
        return MONTHLY_FEE;
    }
    public double monthlyFee(){
        return MONTHLY_INTEREST;
    }
    public Checking(Profile accountProfile, double newBalance){
        super(accountProfile, newBalance);
    }
    public int compareTo(Account otherAcc){
        if (otherAcc instanceof Checking||otherAcc instanceof CollegeChecking){
            return this.getProfile().compareTo(otherAcc.getProfile());
        } 
        else{
            return -1;
        }
    }

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

}
