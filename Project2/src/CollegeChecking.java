public class CollegeChecking extends Checking{
    private Campus campus;
    
    CollegeChecking(Profile accountProfile, double newBalance, Campus campusCode){
        super(accountProfile,newBalance);
        this.campus = campusCode;
    }
}  