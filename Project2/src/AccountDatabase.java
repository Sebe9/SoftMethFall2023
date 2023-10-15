public class AccountDatabase {
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private static final int NOT_FOUND = -1;
    public AccountDatabase(){
        this.accounts = new Account[4];
        numAcct = 0;
    }
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
    private void swapAccts(int index1, int index2){
        Account tempAcc = accounts[index1];
        accounts[index1] = accounts[index2];
        accounts[index2] = tempAcc;

    }
    public void printSorted(){
        boolean unsorted = true; 
        while(unsorted == true){
            unsorted = false;
            for (int j = 0; j < numAcct-1; j++){
                //swap Events if event[j] has an later date than event[j+1]
                if (accounts[j].compareTo(accounts[j+1]) < 0){
                    swapAccts(j,j+1);
                    unsorted = true;
                }
            }
        }
        for (int i = 0; i <numAcct; i++){
            System.out.println(accounts[i].toString(accounts[i]));
        }
    }
     //sort by account type and profile
    public void printFeesAndInterests(){
        for (int i = 0; i <numAcct; i++){
            System.out.println(accounts[i].toString(accounts[i]));
        }
    } //calculate interests/fees
    public void printUpdatedBalances(){
        for (int i = 0; i <numAcct; i++){
            System.out.println(accounts[i].toString(accounts[i]));
        }
    } //apply the interests/fees
    /**
     * Main class for testing close().
     * @param args Strings passed onto the main function.
     */
    public static void main(Strings[] args){
        testValidAccount();
        testInvalidAccount();
    }
    /**
     * Method that compares the expected value to the actual value. Prints out the result.
     * @param expected The value that is expected to return from executing close().
     * @param actual The value that is returned from executing close().
     */
    private static void testResult(boolean expected, boolean actual){
        System.out.print("The expected output is: "+expected+" and the actual result is: "+actual);
        if(expected==actual){
            System.out.println(" -- This test case passes!");
        }
        else{
            System.out.println(" -- This test case does NOT PASS!!");
        }
        System.out.println();
    }
    /**
     * Test Case #1
     * Tests to see if the account exists in the account array before it is removed.
     */
    private static void testValidAccount(){
        Account newAccount = new Account();
        AccountDatabase testAccount = new AccountDatabase();
        boolean expectedOutput = true;
        boolean actualOutput = testAccount.close(testAccount);
        System.out.println("Test case #1: Accounts found in the array will be removed.");
        testResult(expectedOutput, actualOutput);
    }
    /**
     * Test case #2
     * Tests to see if 
     */
    private static void testInvalidAccount(){

    }
}