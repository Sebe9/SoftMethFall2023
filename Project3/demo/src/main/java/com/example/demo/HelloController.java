package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    private TextField firstNameDW;
    @FXML
    private TextField lastNameDW;
    @FXML
    private DatePicker dobDW;
    @FXML
    private TextField amountDW;
    @FXML
    private RadioButton checkingButtonDW;
    @FXML
    private RadioButton collegeCheckingButtonDW;
    @FXML
    private RadioButton savingsButtonDW;
    @FXML
    private RadioButton moneyMarketButtonDW;
    @FXML

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
                mainTextArea.appendText("Minimum of $2000 to open a Money Market account.\n");
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

        }
        else if(savingsButton.isSelected()){
            info[1] = "S";
        }
        else if(moneyMarketButton.isSelected()){
            info[1] = "MM";
        }
        else{
            info[0] = "-1";
        }
        return info;
    }

    protected String[] getinfo(){
        String[] info = buttonInfo();
        if (info[0].equals("-1")){
            return info;
        }
        if(info[1].equals("CC")){
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
        if(info[1].equals("S")){
            if(loyaltyStatus.isSelected()){
                info[6] = "1";
            }
            else{
                info[6] = "0";
            }
        }
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
        mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" opened.\n");
    }
    protected String[] getinfoClosing(){
        String[] info = buttonInfo();
        if (info[0].equals("-1")){
            return info;
        }
        if(firstNameOC.getText().isBlank()||lastNameOC.getText().isBlank()||dobOC.getValue()==null){
            info[0] = "-1";
            return info;
        }
        info[2] = firstNameOC.getText();
        info[3] = lastNameOC.getText();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("M/d/yyyy");
        info[4] = dobOC.getValue().format(pattern);

        return info;
    }
    @FXML
    protected void closeAccount(){
        String[] inputArray= getinfoClosing();
        if(inputArray[0].equals("-1")){
            mainTextArea.appendText("Please make sure all required fields are populated with valid values\n");
            return;
        }
        Account accountToBeClosed;
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
        if(accountToBeClosed.getProfile().getDob().isValid()==false){
            mainTextArea.appendText("DOB invalid: "+inputArray[4]+ " not a valid calendar date!\n");
            return;
        }
        if(accountToBeClosed.getProfile().getDob().isFuture()==true){
            mainTextArea.appendText("DOB invalid: "+inputArray[4]+ " cannot be today or a future day.\n");
            return;
        }
        if(myAccountDatabase.containsExactly(accountToBeClosed)==false){
            mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is not in the database\n");
            return;
        }
        myAccountDatabase.close(accountToBeClosed);
        mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" has been closed\n");
    }
    @FXML
    protected void clearFields(){
       // for(TextField tf : textFieldListOC){
         //   mainTextArea.appendText(tf.toString());
           // tf.setText("");
        //}
        lastNameOC.setText("");
        firstNameOC.setText("");
        amountOC.setText("");
        dobOC.setValue(null);
        mainTextArea.appendText("Cleared Fields!\n");
        checkingButton.setSelected(false);
        collegeCheckingButton.setSelected(false);
        savingsButton.setSelected(false);
        moneyMarketButton.setSelected(false);
        nbButton.setSelected(false);
        newarkButton.setSelected(false);
        camdenButton.setSelected(false);
        loyaltyStatus.setSelected(false);
        dobOC.setValue(null);
    }

    private String[] getinfoDW(){
        String[] info = new String[6];
        info[0] ="1";
        if(checkingButtonDW.isSelected()){
            info[1] = "C";
        }
        else if(collegeCheckingButtonDW.isSelected()){
            info[1] = "CC";

        }
        else if(savingsButtonDW.isSelected()){
            info[1] = "S";
        }
        else if(moneyMarketButtonDW.isSelected()){
            info[1] = "MM";
        }
        else{
            info[0] = "-1";
        }
        if(firstNameDW.getText().isBlank()||lastNameDW.getText().isBlank()||dobDW.getValue()==null||amountDW.getText().isBlank()){
            info[0] = "-1";
            return info;
        }
        info[2] = firstNameDW.getText();
        info[3] = lastNameDW.getText();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("M/d/yyyy");
        info[4] = dobDW.getValue().format(pattern);
        info[5] =  amountDW.getText();
        return info;
    }
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
    @FXML
    protected void deposit(){
        String[] inputArray = getinfoDW();
        if(inputArray[0].equals("-1")){
            mainTextArea.appendText("Please make sure all required fields are populated with valid values\n");
            return;
        }
        Account depositAccount;
        try{
            depositAccount = makeAccountDepositWithdraw(inputArray);
        }catch (IndexOutOfBoundsException e){
            mainTextArea.appendText("Missing data for deposit.\n");
            return;
        }catch(NumberFormatException e){
            mainTextArea.appendText("Not a valid amount.\n");
            return;
        }
        if(myAccountDatabase.containsExactly(depositAccount)==false){
            mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is not in the database\n");
            return;
        }
        if(depositAccount.getBalance()<=0){
            mainTextArea.appendText("Deposit - amount cannot be 0 or negative.\n");
            return;
        }
        myAccountDatabase.deposit(depositAccount);
        mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" Deposit - balance updated.\n");
    }
    @FXML
    protected void withdraw(){
        String[] inputArray = getinfoDW();
        if(inputArray[0].equals("-1")){
            mainTextArea.appendText("Please make sure all required fields are populated with valid values\n");
            return;
        }
        Account withdrawalAccount;
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
            mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is not in the database\n");
            return;
        }
        if(withdrawalAccount.getBalance()<=0){
            mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" is not in the database\n");
            return;
        }
        if(myAccountDatabase.withdraw(withdrawalAccount)==false){
            mainTextArea.appendText(inputArray[2]+" "+ inputArray[3]+" "+inputArray[4] + "("+inputArray[1]+")" +" Withdraw - insufficient fund.\n");
        }
        else {
            mainTextArea.appendText(inputArray[2] + " " + inputArray[3] + " " + inputArray[4] + "(" + inputArray[1] + ")" + " Withdraw  - balance updated.\n");
        }
    }

    @FXML
    protected void printAccounts(){
        if(myAccountDatabase.getnumAcct()==0){
            mainTextArea.appendText("Account Database is empty!\n");
        }
        else {
            for(int i = 0; i < myAccountDatabase.getnumAcct();i++) {
                mainTextArea.appendText(myAccountDatabase.printSorted(i)+"\n");
            }
        }
    }
    @FXML
    protected void loadAccountsFromFile(){
        mainTextArea.appendText("Loaded Accounts!\n");
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String file = fileChooser.getSelectedFile().getAbsolutePath();

        }
    }
    @FXML
    protected void printIandF(){
        if(myAccountDatabase.getnumAcct()==0){
            mainTextArea.appendText("Account Database is empty!\n");
        }
        else{
            for (int i = 0; i <myAccountDatabase.getnumAcct(); i++){
                mainTextArea.appendText(myAccountDatabase.printFeesAndInterests(i)+"\n");
            }
        }
    }
    @FXML
    protected void updateIandF(){
        if(myAccountDatabase.getnumAcct()==0){
            mainTextArea.appendText("Account Database is empty!\n");
        }
        else{
            for(int i = 0; i < myAccountDatabase.getnumAcct(); i++){
                mainTextArea.appendText(myAccountDatabase.printUpdatedBalances(i)+"\n");
            }
        }
    }
}