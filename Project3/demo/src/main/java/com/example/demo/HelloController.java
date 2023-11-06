package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
    private RadioButton checkingButton;
    @FXML
    private RadioButton collegeCheckingButton;
    @FXML
    private RadioButton savingsButton;
    @FXML
    private RadioButton moneyMarketButton;
    @FXML
    private RadioButton nbButton;
    @FXML
    private RadioButton newarkButton;
    @FXML
    private RadioButton camdenButton;
    @FXML
    private TextField lastNameOC;
    @FXML
    private TextField firstNameOC;
    @FXML
    private TextField amountOC;
    @FXML
    private DatePicker dobOC;
    @FXML
    private CheckBox loyaltyStatus;
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
            mainTextArea.appendText("DOB invalid: "+inputArray[4]+ " not a valid calendar date!\n");
            return false;
        }
        if(newlyOpenedAccount.getProfile().getDob().isFuture()==true){
            mainTextArea.appendText("DOB invalid: "+inputArray[4]+ " cannot be today or a future day.\n");
            return false;
        }
        if(newlyOpenedAccount.getProfile().getDob().atLeastSixteenYearsOld()==false){
            mainTextArea.appendText("DOB invalid: "+inputArray[4]+ " under 16.\n");
            return false;
        }

        if(newlyOpenedAccount.getBalance()<=0){
            mainTextArea.appendText("Initial deposit cannot be 0 or negative.\n");
            return false;

        }
        if (newlyOpenedAccount instanceof CollegeChecking){
            CollegeChecking tempCollegeCheckingAcc = (CollegeChecking) newlyOpenedAccount;
            if(tempCollegeCheckingAcc.getCampus().getCampusCode().equals("0")==false && tempCollegeCheckingAcc.getCampus().getCampusCode().equals("1")==false&&tempCollegeCheckingAcc.getCampus().getCampusCode().equals("2")==false){
                mainTextArea.appendText("Invalid campus code.");
                return false;
            }
            if(newlyOpenedAccount.getProfile().getDob().underTwentyFour()==false){
                mainTextArea.appendText("DOB invalid: "+inputArray[4]+ " over 24.");
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
    protected String[] buttonInfo(){
        String[] info = new String[7];
        info[0] = "1";
        if(checkingButton.isSelected()){
            info[1] = "C";
        }
        else if(collegeCheckingButton.isSelected()){
            info[1] = "CC";
            if (nbButton.isSelected()){
                info[6] = "0";
            }
            else if(newarkButton.isSelected()){
                info[6] = "1";
            }
            else if(camdenButton.isSelected()){
                info[6] = "2";
            }
            else{
                info[0] = "-1";
            }
        }
        else if(savingsButton.isSelected()){
            info[1] = "S";
            if(loyaltyStatus.isSelected()){
                info[6] = "1";
            }
            else{
                info[6] = "0";
            }
        }
        else if(moneyMarketButton.isSelected()){
            info[1] = "MM";
        }
        else{
            info[0] = "-1";
        }
        return info;
    }
    @FXML
    protected String[] getinfo(){
        String[] info = buttonInfo();
        if (info[0].equals("-1")){
            return info;
        }
        if(firstNameOC.getText().isBlank()||lastNameOC.getText().isBlank()||dobOC.getValue()==null||amountOC.getText().isBlank()){
            info[0] = "-1";
            return info;
        }
        info[2] = firstNameOC.getText();
        info[3] = lastNameOC.getText();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        info[4] = dobOC.getValue().format(pattern);
        info[5] = amountOC.getText();
        return info;
    }
    @FXML
    protected void openAccount(){
        mainTextArea.appendText("Opened an Account!\n");
        String[] inputArray= getinfo();

        if(inputArray[0].equals("-1")){
            mainTextArea.appendText("Please make sure all required fields are populated with valid values\n");
            return;
        }
        Account newlyOpenedAccount;
        try{
            newlyOpenedAccount = makeAccount(inputArray);
        }catch (IndexOutOfBoundsException e){
            //System.out.println("Missing data for opening an account.");
            mainTextArea.appendText("Missing data for opening an account.\n");
            return;
        }catch(NumberFormatException e){
            //System.out.println("Not a valid amount.");
            mainTextArea.appendText("Not a valid amount.\n");
            return;
        }
        if (oCommandTests(newlyOpenedAccount,inputArray)==false){
            return;
        }
        if(myAccountDatabase.contains(newlyOpenedAccount)==true){
            //System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is already in the database.");
            mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is already in the database.\n");
            return;
        }
        myAccountDatabase.open(newlyOpenedAccount);
        //System.out.println(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" opened.");
        mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" opened.");
    }

    @FXML
    protected void closeAccount(){
        mainTextArea.appendText("Closed an Account!\n");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("M/d/yyyy");
        String test = dobOC.getValue().format(pattern);
        mainTextArea.appendText(test+"\n");

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