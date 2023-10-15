public class AccountDatabase {
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private static final int NOT_FOUND = -1;
    /**
     * This method finds out if an account is in the account array.
     * @param event takes the account that is being searched for.
     * @return int returns the index of the account if found. Returns -1 if the account is not in the array.
     */
    private int find(Account account) { 
        for (int i = 0; i < numAcct; i++){
            if(account.compareTo(accounts[i])==0){
                return i;
            }
        }
        return NOT_FOUND;
    }
    /**
     * Grows the length of the event calendar array by 4.
     */
    private void grow(){ 
        int oldLength = accounts.length;

        Account[] newEventArray = new Account[oldLength + 4];
        for(int i = 0; i < oldLength; i++){
            newEventArray[i] = accounts[i];
        }
        accounts = newEventArray;
    }

    /**
     * This method finds out whether or not an object is contained in the array.
     * @return boolean Returns true is the object is contained in the array. Returns false if it is not.
     * @param account the object you want to find
     */
    public boolean contains(Account account) {
        int foundIndex = find(account);
        if (foundIndex == NOT_FOUND){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * Opens a new account
     * @param event The account you want to open.
     * @return boolean Returns true if account is successfully opened.
     */
    public boolean open(Account account){
        accounts[numAcct] = account;
        numAcct++;
        if(accounts.length == numAcct){
            grow();
        }
        return true;
    } 
    public boolean close(Account account){
        int indexToBeRemoved = find(account);
        if (indexToBeRemoved == NOT_FOUND){
            return false;
        }
        for (int j = indexToBeRemoved; j < numAcct; j++){
            accounts[j] = accounts[j+1]; 
        }
        numAcct--;
        return true;
    } //remove the given account
    public boolean withdraw(Account account){} //false if insufficient fund
    public void deposit(Account account){}
    public void printSorted(){

    } //sort by account type and profile
    public void printFeesAndInterests(){} //calculate interests/fees
    public void printUpdatedBalances(){} //apply the interests/fees
    }