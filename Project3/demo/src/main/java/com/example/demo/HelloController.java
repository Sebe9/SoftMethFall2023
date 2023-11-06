package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class HelloController {
    private AccountDatabase myAccountDatabase;
    @FXML
    private TextArea mainTextArea;
    /**
     * Creates a new instance of an account database.
     * Substitutes for a constructor
     */
    @FXML
    public void initialize(){
        myAccountDatabase = new AccountDatabase();
        welcomeText.setText("hi");
    }
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton checkingButton, collegeCheckingButton, savingsButton, moneyMarketButton;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("hi");
    }
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
    @FXML
    protected String[] getinfo(){

        String[] info = new String{};
    }
    @FXML
    protected void openAccount(){
        mainTextArea.appendText("Opened an Account!\n");
        String[] inputArray = getinfo();
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

    @FXML
    protected void closeAccount(){
        mainTextArea.appendText("Closed an Account!\n");
    }
    @FXML
    protected void clearFields(){
        mainTextArea.appendText("Cleared Fields!\n");
    }
    @FXML
    protected void deposit(){
        mainTextArea.appendText("Deposited Money!\n");
    }
    @FXML
    protected void withdraw(){
        mainTextArea.appendText("Withdrew Money!\n");
    }
    @FXML
    protected void printAccounts(){
        mainTextArea.appendText("Printed All Accounts!\n");
    }
    @FXML
    protected void loadAccountsFromFile(){
        mainTextArea.appendText("Loaded Accounts!\n");
    }
    @FXML
    protected void printIandF(){
        mainTextArea.appendText("Printed Interests and Fees\n");
    }
    @FXML
    protected void updateIandF(){
        mainTextArea.appendText("Updated Accounts with Interests and Fees!\n");
    }
}