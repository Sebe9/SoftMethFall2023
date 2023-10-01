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
        return email.contains("@rutgers.edu") && department.getName() = "Computer Science" || "Electrical Engineering" || "Information Technology and Informatics" || "Mathematics" || "Business Analytics and Information Technology";
    }
}