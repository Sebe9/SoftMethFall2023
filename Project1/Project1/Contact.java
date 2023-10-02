package project1;
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
        return email.contains("@rutgers.edu") && (department.getName().equals("Computer Science")|| department.getName().equals("Electrical Engineering") || department.getName().equals("Information Technology and Informatics") || department.getName().equals("Mathematics") || department.getName().equals("Business Analytics and Information Technology"));
    }
}