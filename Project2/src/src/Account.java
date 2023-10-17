package src;
/**
 * Contains information of an account such as the holder and the balance inside the account.
 * @author SebastianHanna, Matthew Chan
 */
public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
    public abstract boolean equals(Account otherAccount);
    /**
     * Initializes account object with holder and balance.
     * @param holder Person attached to account.
     * @param balance Balance attached to account.
     */
    public Account(Profile holder, double balance){
        this.holder = holder;
        this.balance = balance;
    }
    /**
     * Initializes account object with holder.
     * @param holder Person attached to account.
     */
    public Account(Profile holder){
        this.holder = holder;  
    }
    /**
     * Compares the current account to another account.
     * @param otherAcc the other account you wish to compare this account to
     * @return int Returns a negative int, 0, or a positive int if the compared Account is less than, equal to, or greater than 
     */
    /* 
    @Override public int compareTo(Account otherAcc){
        if ((this.getClass().getSimpleName().compareTo(otherAcc.getClass().getSimpleName()))==0){
            return this.getProfile().compareTo(otherAcc.getProfile());
        }
        else{
            return (this.getClass().getSimpleName().compareTo(otherAcc.getClass().getSimpleName()));
        }
    }
    */
    /**
     * Getter method for the holder.
     * @return the data for holder.
     */
    public Profile getProfile(){
        return holder;
    }
    /**
     * Getter method for the balance.
     * @return the data of the balance.
     */
    public double getBalance(){
        return balance;
    }
    /**
     * Setter method to mutate the balance.
     * @param newBalance the new balance of the account.
     */
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }

    public String toString(Account account){
        if(account instanceof Checking){
            return "Checking::" + account.getProfile().getFName() + " " + account.getProfile().getLName() + " " + account.getProfile().getDob() + " ::Balance $" + account.getBalance();
        }
        if(account instanceof CollegeChecking){
            CollegeChecking temp = (CollegeChecking) account; 
            return "College Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + temp.getBalance() + "::" + temp.getCampus().getCampusName();
        }
        if(account instanceof MoneyMarket){
            MoneyMarket temp = (MoneyMarket) account;
            return "Money Market::Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + temp.getBalance() + temp.getLoyalty() + "::withdrawal: " + temp.getWithdrawal();
        }
        else{
            Savings temp = (Savings) account;
            return "Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + temp.getBalance() + temp.getLoyalty() ;
        }
    }

    public String toStringPI(Account account){
        if(account instanceof Checking){
            Checking temp = (Checking) account;
            return "Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + temp.getBalance() + "::fee $" + temp.monthlyFeeFormat() + "::monthly interest $" + temp.interestFormat();
        }
        if(account instanceof CollegeChecking){
            CollegeChecking temp = (CollegeChecking) account; 
            return "College Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + temp.getBalance() + "::" + temp.getCampus().getCampusName() + "::fee $" + temp.monthlyFeeFormat() + "::monthly interest $" + temp.interestFormat();
        }
        if(account instanceof MoneyMarket){
            MoneyMarket temp = (MoneyMarket) account;
            return "Money Market::Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + temp.getBalance() + temp.getLoyalty() + "::withdrawal: " + temp.getWithdrawal() + "::fee $" + temp.feeFormat() + "::monthly interest $" + temp.interestFormat();
        }
        else{
            Savings temp = (Savings) account;
            return "Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + temp.getBalance() + temp.getLoyalty() + "::fee $" + temp.feeFormat() + "::monthly interest $" + temp.interestFormat();
        }
    }

    public String toStringUB(Account account){
        if(account instanceof Checking){
            // subtract fees add interest to balance
            Checking temp = (Checking) account;
            return "Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + ((temp.getBalance()-temp.monthlyFee()) + temp.monthlyInterest());
        }
        if(account instanceof CollegeChecking){
            CollegeChecking temp = (CollegeChecking) account; 
            return "College Checking::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + ((temp.getBalance()-temp.monthlyFee()) + temp.monthlyInterest()) + "::" + temp.getCampus().getCampusName();
        }
        if(account instanceof MoneyMarket){
            MoneyMarket temp = (MoneyMarket) account;
            return "Money Market::Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + ((temp.getBalance()-temp.monthlyFee()) + temp.monthlyInterest()) + temp.getLoyalty() + "::withdrawal: " + temp.getWithdrawal();
        }
        else{
            Savings temp = (Savings) account;
            return "Savings::" + temp.getProfile().getFName() + " " + temp.getProfile().getLName() + " " + temp.getProfile().getDob() + " ::Balance $" + ((temp.getBalance()-temp.monthlyFee()) + temp.monthlyInterest()) + temp.getLoyalty() ;
        }
    }
   
}

