package project1; 

public enum Department{
CS("Computer Science"), 
EE("Electrical Engineering"),
MATH("Mathematics"),
BAIT("Business Analytics and Information Technology"),
ITI("Information Technology and Informatics");


private String name; //changes with input

Department(String name){
    this.name = name; //department object's name now becomes the parameter
}

public String getName(){
    return name;
}

  
}
