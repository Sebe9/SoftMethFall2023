public class Contact {
    private Department department;
    private String email;

public Department getDepartment() {
    return department;
}

public String getEmail(){
    return email;
}

    public boolean isValid(){
        return email.matches("@rutgers.edu");
    }
}