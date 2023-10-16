import java.util.Scanner;

public class TransactionManager {
    public TransactionManager(){
        AccountDatabase myAccountDatabase = new AccountDatabase();
    }

/* 
    public void run(){
        System.out.println("Transaction Manager is running.");
        Scanner scannerObj = new Scanner(System.in);
        String nextLine  = scannerObj.nextLine();
        String[] inputArray = nextLine.split("\\s+");
        System.out.println(inputArray.length);
        System.out.println(inputArray[0]);
        System.out.println(inputArray[1]);
        System.out.println(inputArray[2]);
    }
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
                wCommand();}
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
        System.out.println("Event Organizer terminated.");
        scannerObj.close();
    }
    private Account makeAccount(String[] inputArray){
        Account newAccount;
        Profile newProfile = new Profile(inputArray[2], inputArray[3], inputArray[3]);
        if (inputArray[1]=="CC"){
            newAccount = new CollegeChecking(newProfile, inputArray[4], inputArray[5]);
        }
        else if(inputArray[1]=="C"){

        }
        else if(inputArray[1]=="S"){

        }
        else if(inputArray[1]=="MM"){

        }
        
    }
    private void oCommand(String[] inputArray){
        try{
            makeAccount(inputArray);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Missing data for opening an account.");
            return;
        }
    }
    private void cCommand(){

    }

    private void dCommand(){

    }

    private void wCommand(){

    }

    private void pCommand(){

    }

    private void piCommand(){

    }

    private void ubCommand(){

    }

}

