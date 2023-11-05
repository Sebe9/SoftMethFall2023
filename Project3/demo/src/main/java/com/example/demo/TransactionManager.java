package com.example.demo;
import java.util.Scanner;
/**
 * User interface class that processes the transactions entered through the terminal. This class also determines handles all input/output.
 * @author Sebastian Hanna
 */
public class TransactionManager {
    private AccountDatabase myAccountDatabase;
    /**
     * Creates a new instance of an account database.
     */
    public TransactionManager(){
        myAccountDatabase = new AccountDatabase();
    }


    /**
     * Runs the program and accepts commands.
     */
    public void run(){
        System.out.println("Transaction Manager is running.");
        Scanner scannerObj = new Scanner(System.in);
        while(true){
            String nextLine  = scannerObj.nextLine();
            String[] inputArray = nextLine.split("\\s+");
            if (nextLine.isBlank()){
                continue;
            }
            else if (inputArray[0].equals("O")){
                oCommand(inputArray);}
            else if (inputArray[0].equals("C")){
                cCommand(inputArray);}
            else if (inputArray[0].equals("D")){
                dCommand(inputArray);}
            else if (inputArray[0].equals("W")){
                wCommand(inputArray);}
            else if (inputArray[0].equals("P")){
                pCommand();}
            else if (inputArray[0].equals("PI")){
                piCommand();}
            else if (inputArray[0].equals("UB")){
                ubCommand();}
            else if (inputArray[0].equals("Q")){
                break;}
            else{
                System.out.println("Invalid command!");}
        }
        System.out.println("Transaction Manager is terminated.");
        scannerObj.close();
    }
    /** 
     * Method used to create different types of account depending on the input array.
     * @param inputArray The string array containing information needed to setup an account.
     * @return new account created.
     * @throws IndexOutofBoundsException
     * @throws NumberFormatException
     */
    private Account makeAccount(String[] inputArray) throws IndexOutOfBoundsException, NumberFormatException{
        Account newAccount;
        Date newDate = new Date(inputArray[4]);
        Profile newProfile = new Profile(inputArray[2], inputArray[3], newDate);
        double newBalance = Double.parseDouble(inputArray[5]);
        if (inputArray[1].equals("CC")){
            Campus newCampus = new Campus(inputArray[6]);
            newAccount = new CollegeChecking(newProfile, newBalance, newCampus);
            return newAccount;
        }
        else if(inputArray[1].equals("C")){
            newAccount = new Checking(newProfile, newBalance);
            return newAccount;
        }
        else if(inputArray[1].equals("S")){
            Boolean loyaltyStatus;
            if(inputArray[6]=="1"){loyaltyStatus = true;}
            else {loyaltyStatus =false;} 
            newAccount = new Savings(newProfile, newBalance, loyaltyStatus);
            return newAccount;
        }
        else{
            newAccount = new MoneyMarket(newProfile, newBalance, true, 0);
            return newAccount;
        }
    }
    /**
     * Method used to create different types of account depending on input array.
     * @param inputArray String array containing information on the type of account.
     * @return new account created.
     * @throws IndexOutOfBoundsException
     * @throws NumberFormatException
     */
    private Account makeAccountDepositWithdraw(String[] inputArray) throws IndexOutOfBoundsException, NumberFormatException{
        Account newAccount;
        Date newDate = new Date(inputArray[4]);
        Profile newProfile = new Profile(inputArray[2], inputArray[3], newDate);
        double newBalance = Double.parseDouble(inputArray[5]);
        if (inputArray[1].equals("CC")){
            newAccount = new CollegeChecking(newProfile, newBalance);
            return newAccount;
        }
        else if(inputArray[1].equals("C")){
            newAccount = new Checking(newProfile, newBalance);
            return newAccount;
        }
        else if(inputArray[1].equals("S")){ 
            newAccount = new Savings(newProfile, newBalance);
            return newAccount;
        }
        else{
            newAccount = new MoneyMarket(newProfile, newBalance, true, 0);
            return newAccount;
        }
        
    }
    /**
     * Handles all tests for the o command.
     * @param newlyOpenedAccount Account being checked for tests.
     * @param inputArray String array containing account information.
     * @return false in all cases in which the account has invalid information. Return true otherwise.
     */
    private boolean oCommandTests(Account newlyOpenedAccount, String[] inputArray){
        if(newlyOpenedAccount.getProfile().getDob().isValid()==false){
            System.out.println("DOB invalid: "+inputArray[4]+ " not a valid calendar date!");
            return false;
        }
        if(newlyOpenedAccount.getProfile().getDob().isFuture()==true){
            System.out.println("DOB invalid: "+inputArray[4]+ " cannot be today or a future day.");
            return false;
        }
        if(newlyOpenedAccount.getProfile().getDob().atLeastSixteenYearsOld()==false){
            System.out.println("DOB invalid: "+inputArray[4]+ " under 16.");
            return false;
        }
        
        if(newlyOpenedAccount.getBalance()<=0){
            System.out.println("Initial deposit cannot be 0 or negative.");
            return false;
            
        }
        if (newlyOpenedAccount instanceof CollegeChecking){
            CollegeChecking tempCollegeCheckingAcc = (CollegeChecking) newlyOpenedAccount;
            if(tempCollegeCheckingAcc.getCampus().getCampusCode().equals("0")==false && tempCollegeCheckingAcc.getCampus().getCampusCode().equals("1")==false&&tempCollegeCheckingAcc.getCampus().getCampusCode().equals("2")==false){
                System.out.println("Invalid campus code.");
                return false;
            }
            if(newlyOpenedAccount.getProfile().getDob().underTwentyFour()==false){
            System.out.println("DOB invalid: "+inputArray[4]+ " over 24.");
            return false;
        }
        }
        if (newlyOpenedAccount instanceof MoneyMarket){
            MoneyMarket tempMoneyMarketAcc = (MoneyMarket) newlyOpenedAccount;
            if(tempMoneyMarketAcc.getBalance() < 2000){
                System.out.println("Minimum of $2000 to open a Money Market account.");
                return false;
            }
        }
        return true;
    }
    /**
     * Handles the o command.
     * @param inputArray String array containing information for opening an account.
     * @return no value.
     */
    private void oCommand(String[] inputArray){
        Account newlyOpenedAccount;
        try{
            newlyOpenedAccount = makeAccount(inputArray);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Missing data for opening an account.");
            return;
        }catch(NumberFormatException e){
            System.out.println("Not a valid amount.");
            return;
        }
        if (oCommandTests(newlyOpenedAccount,inputArray)==false){
            return;
        }
        if(myAccountDatabase.contains(newlyOpenedAccount)==true){
            System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is already in the database.");
            return;
        }
        myAccountDatabase.open(newlyOpenedAccount);
        System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" opened.");
    }
    /**
     * Handles the c command. 
     * @param inputArray String array containing information to close an account.
     * @return no value.
     */
    private void cCommand(String[] inputArray){
        Account accountToBeClosed;
        try{
            Date newDate = new Date(inputArray[4]);
            Profile newProfile = new Profile(inputArray[2], inputArray[3], newDate);
            if (inputArray[1].equals("CC")){
                accountToBeClosed = new CollegeChecking(newProfile);
            }
            else if(inputArray[1].equals("C")){
                accountToBeClosed = new Checking(newProfile);
            }
            else if(inputArray[1].equals("S")){
                accountToBeClosed = new Savings(newProfile);
            }
            else{
               accountToBeClosed = new MoneyMarket(newProfile); 
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Missing data for closing an account.");
            return;
        }

        if(accountToBeClosed.getProfile().getDob().isValid()==false){System.out.println("DOB invalid: "+inputArray[4]+ " not a valid calendar date!");return;}
        if(accountToBeClosed.getProfile().getDob().isFuture()==true){System.out.println("DOB invalid: "+inputArray[4]+ " cannot be today or a future day.");return;}
        if(myAccountDatabase.containsExactly(accountToBeClosed)==false){
            System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is not in the database");
            return;
        }
        myAccountDatabase.close(accountToBeClosed);
        System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" has been closed");
    }
    /**
     * Handles the d command.
     * @param inputArray String array containing information to add money.
     * @return no value.
     */
    private void dCommand(String[] inputArray){
        //not in database
        //amount cannot be 0 or negative
        Account depositAccount;
        try{
            depositAccount = makeAccountDepositWithdraw(inputArray);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Missing data for deposit.");
            return;
        }catch(NumberFormatException e){
            System.out.println("Not a valid amount.");
            return;
        }
        if(myAccountDatabase.containsExactly(depositAccount)==false){
           System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is not in the database");
           return;
        }
        if(depositAccount.getBalance()<=0){
            System.out.println("Deposit - amount cannot be 0 or negative.");
            return;
        }
        myAccountDatabase.deposit(depositAccount);
        System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" Deposit - balance updated.");
    }
    /**
     * Handles the w command.
     * @param inputArray String array containing information for withdrawing.
     * @return no value.
     */
    private void wCommand(String[] inputArray){
        Account withdrawalAccount;
        //insufficient fund
        
        try{
            withdrawalAccount = makeAccountDepositWithdraw(inputArray);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Missing data for deposit.");
            return;
        }catch(NumberFormatException e){
            System.out.println("Not a valid amount.");
            return;
        }
        if(myAccountDatabase.containsExactly(withdrawalAccount)==false){
           System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is not in the database");
           return;
        }
        if(withdrawalAccount.getBalance()<=0){
            System.out.println("Withdraw - amount cannot be 0 or negative.");
            return;
        }
        if(myAccountDatabase.withdraw(withdrawalAccount)==false){
            System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" Withdraw - insufficient fund.");
            return;
        }
        else
            System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" Withdraw  - balance updated.");
    }
    /**
     * Calls method to display all accounts in a sorted order.
     * @return no value.
     */
    private void pCommand(){
        if(myAccountDatabase.getnumAcct()==0){
            System.out.println("Account Database is empty!");
            return;
        }
        else
            myAccountDatabase.printSorted();
    }
    /**
     * Calls methods to display all accounts in the database along with their interests and fees.
     * @return no value.
     */
    private void piCommand(){
        if(myAccountDatabase.getnumAcct()==0){
            System.out.println("Account Database is empty!");
            return;
        }
        else
            myAccountDatabase.printFeesAndInterests();
    }
    /**
     * Calls method to update account balances for all accounts by applying fees and interest.
     * @return no value.
     */
    private void ubCommand(){
        if(myAccountDatabase.getnumAcct()==0){
            System.out.println("Account Database is empty!");
            return;
        }
        else
            myAccountDatabase.printUpdatedBalances();
    }

}

