public class test {
    public static boolean testFunction(Account testAccount){
        return true;
    } 
    public static void main(String[] args){
        /* 
        Profile testProfile = new Profile(null, null, null);
        Checking testChecking = new Checking(testProfile,10);

        Profile testProfile2 = new Profile("hi", null, null);
        Campus testCampus = new Campus();
        CollegeChecking testCollegeChecking = new CollegeChecking(testProfile2,100,testCampus);
        
        System.out.println(testCollegeChecking instanceof Checking);
*/  
        int x;
        try{
            int[] arr = {1,2,3};
            x = testy(arr);
        }catch (IndexOutOfBoundsException e){
            System.out.println("hi");
        }
        System.out.println(x);



    }
    public static int testy(int[] dummyArray){
        return dummyArray[2];
    }
}
