package src;

public class AccountDatabase{
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private static final int NOT_FOUND = -1;
    public AccountDatabase(){
        this.accounts = new Account[4];
        numAcct = 0;
    }
    public int getnumAcct(){
        return numAcct;
    }
    /**
     * This method finds out if an account is in the account array.
     * @param event takes the account that is being searched for.
     * @return int returns the index of the account if found. Returns -1 if the account is not in the array.
     */
    private int find(Account account) { 
        for (int i = 0; i < numAcct; i++){
            if(account.equals(accounts[i])){
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
    //For when the class has to be exactly the same
    public boolean containsExactly(Account account){
        int foundIndex = findExactly(account);
        if (foundIndex == NOT_FOUND){
            return false;
        }
        else{
            return true;
        }
    }
    private int findExactly(Account account) { 
        for (int i = 0; i < numAcct; i++){
            if(account.equals(accounts[i])){
                boolean bothChecking = (account instanceof Checking && accounts[i] instanceof Checking);
                boolean bothCollegeChecking = (account instanceof CollegeChecking && accounts[i] instanceof CollegeChecking);
                boolean bothSavings = (account instanceof Savings && accounts[i] instanceof Savings);
                boolean bothMoneyMarket = (account instanceof MoneyMarket && accounts[i] instanceof MoneyMarket);
                if(bothChecking||bothCollegeChecking||bothSavings||bothMoneyMarket){
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }
    /**
     * Opens a new account
     * @param event The account you want to open.
     * @return boolean Returns true if account is successfully opened.
     */
    public boolean open(Account account) {
        int newAccIndex = numAcct;
        for (int i = 0; i < numAcct; i++) {
            if (account.getClass().getSimpleName().compareTo(accounts[i].getClass().getSimpleName()) < 0) {
                newAccIndex = i;
                break;
            } else if (account.getClass().getSimpleName().equals(accounts[i].getClass().getSimpleName())) {
                if (account.getProfile().compareTo(accounts[i].getProfile()) > 0) {
                    newAccIndex = i;
                    break;
                }
            }
        }
        for (int i = numAcct; i > newAccIndex; i--) {
            accounts[i] = accounts[i - 1];
        }
        accounts[newAccIndex] = account;
        numAcct++;
        if(numAcct==accounts.length){
            grow();
        }
        return true;
    }

    public boolean close(Account account){
        int indexToBeRemoved = findExactly(account);
        if (indexToBeRemoved == NOT_FOUND){
            return false;
        }
        for (int j = indexToBeRemoved; j < numAcct; j++){
            accounts[j] = accounts[j+1]; 
        }
        numAcct--;
        return true;
    } //remove the given account
    public boolean withdraw(Account account){
        int accIndex = findExactly(account);
        if(account.getBalance() > accounts[accIndex].getBalance() ){
            return false;
        }
        else{
            accounts[accIndex].setBalance(accounts[accIndex].getBalance()-account.getBalance());
            return true;
        }
    } 
    
    public void deposit(Account account){
        int accIndex = findExactly(account);
        accounts[accIndex].setBalance(accounts[accIndex].getBalance()+account.getBalance());
    }
    
    public void printSorted(){
        for (int i = 0; i <numAcct; i++){
            //System.out.println(accounts[i].toString(accounts[i]));
        }
    }
     //sort by account type and profile
    public void printFeesAndInterests(){
        for (int i = 0; i <numAcct; i++){
            //System.out.println(accounts[i].toString(accounts[i]));
        }
    } //calculate interests/fees
    public void printUpdatedBalances(){
        for (int i = 0; i <numAcct; i++){
            //System.out.println(accounts[i].toString(accounts[i]));
        }
    } //apply the interests/fees
    /**
     * Main class for testing close().
     * @param args Strings passed onto the main function.
     */
    public static void main(String[] args){
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
        Date testDate = new Date("02/19/2000");
        Profile testProfile = new Profile("Bob", "Sam", testDate);
        Checking newAccount = new Checking(testProfile, 10);
        AccountDatabase testAccount = new AccountDatabase();
        testAccount.open(newAccount);
        boolean expectedOutput = true;
        boolean actualOutput = testAccount.close(newAccount);
        System.out.println("Test case #1: Accounts found in the array will be removed.");
        testResult(expectedOutput, actualOutput);
    }
    /**
     * Test case #2
     * Tests to see if the method will succesfully remove an account that was not in the account array.
     */
    private static void testInvalidAccount(){
        Date testDate = new Date("02/19/2000");
        Profile testProfile = new Profile("Bob", "Sam", testDate);
        Checking newAccount = new Checking(testProfile, 10);
        AccountDatabase testAccount = new AccountDatabase();
        boolean expectedOutput = false;
        boolean actualOutput = testAccount.close(newAccount);
        System.out.println("Test case #2: Accounts not even in the array cannot be succesfully removed.");
        testResult(expectedOutput, actualOutput);
    }
}