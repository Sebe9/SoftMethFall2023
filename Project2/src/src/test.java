package src;

public class test {
    public static void main(String[] args){
        Date testDate = new Date("01/01/2000");
        Profile testProfile = new Profile("hi", "hi", testDate);
        Checking testChecking = new Checking(testProfile,100);
        CollegeChecking testCollegeChecking = new CollegeChecking(testProfile, 0);
        Checking testChecking2 = new Checking(testProfile,100);
        System.out.println(testChecking.getClass()==testCollegeChecking.getClass());
        System.out.println(testChecking.getClass()==testChecking2.getClass());
    }
}
