import java.util.Scanner;
// import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.Date;
import java.util.Comparator;

class User{
    private String firstName;
    private String lastName;
    private String PAN;
    private int PIN;
    private String DateofBirth;
    private String emailID;
    
    User(){}
    
    public User(String firstName, String lastName, String pAN, int pIN, String dateofBirth, String emailID) {
        this.firstName = firstName;
        this.lastName = lastName;
        PAN = pAN;
        PIN = pIN;
        DateofBirth = dateofBirth;
        this.emailID = emailID;

    }
    public String getDateofBirth() {
        return DateofBirth;
    }
    
    public int getBirthYear() {
        return Integer.parseInt(DateofBirth.substring(4,8));
    }
    
    public void display(){
        System.out.println("Name: " + firstName + " " +  lastName );
        System.out.println("PAN: " + PAN);
        System.out.println("PIN: " + PIN);
        System.out.println("DOB: " + DateofBirth);
        System.out.println("emailID: " + emailID);
    }
}

class Student extends User{
    private int rollNo;

    public int getRollNo() {
        return rollNo;
    }
    public Student() {}
    public Student(String firstName, String lastName, String pAN, int pIN, String dateofBirth, int rollNo, String emailID) {
        super(firstName, lastName, pAN, pIN, dateofBirth, emailID);
        this.rollNo = rollNo;
    }

    public void display(){
        super.display();
        System.out.println("Roll no: " + rollNo);
    }

}

class Faculty extends User{
    private int employeeID;

    public int getEmployeeID() {
        return employeeID;
    }
    public Faculty() {}
    public Faculty(String firstName, String lastName, String pAN, int pIN, String dateofBirth, int employeeID,
            String emailID) {
        super(firstName, lastName, pAN, pIN, dateofBirth, emailID);
        this.employeeID = employeeID;
    }

    public void display() {
        super.display();
        System.out.println("employee ID: " + employeeID);
    }
}

class Staff extends User{
    private int staffID;
    
    public int getStaffID() {
        return staffID;
    }

    public Staff() {}

    public Staff(String firstName, String lastName, String pAN, int pIN, String dateofBirth, String emailID,
            int staffID) {
        super(firstName, lastName, pAN, pIN, dateofBirth, emailID);
        this.staffID = staffID;
    }
    
    public void display() {
        super.display();
        System.out.println("Staff ID: " + staffID);
    }

}

class BirthYearComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        return u1.getBirthYear() - u2.getBirthYear();
    }
}

class RollNoComparator implements Comparator<Student> {
    public int compare(Student u1, Student u2) {
        return u1.getRollNo() - u2.getRollNo();
    }
}

class EmployeeIDComparator implements Comparator<Faculty> {
    public int compare(Faculty u1, Faculty u2) {
        return u1.getEmployeeID() - u2.getEmployeeID();
    }
}

class StaffIDComparator implements Comparator<Staff> {
    public int compare(Staff u1, Staff u2) {
        return u1.getStaffID() - u2.getStaffID();
    }
}

public class userDemo{
    public static boolean validateName(String str){
        return str.matches("[A-Z][a-z]*");
    }
    public static boolean validatePAN(String str){
        return str.matches("[0-9A-Z]*");
    }
    public static boolean validatePIN(int pin){
        return (pin/100000<=9 && pin / 100000 > 0);
    }
    public static boolean validateEmail(String str){
        return (str.contains("@") && str.contains("."));
    }
    public static boolean validateRollNo(ArrayList<Student> StudentList , int rno){
        for(Student s: StudentList){
            if(s.getRollNo()==rno) return false;
        }
        return true;
    }
    public static boolean validateEmployeeId(ArrayList<Faculty> FacultyList , int eid){
        for(Faculty f: FacultyList){
            if(f.getEmployeeID()==eid) return false;
        }
        return true;
    }
    public static boolean validateStaffId(ArrayList<Staff> StaffList , int sid){
        for(Staff st: StaffList){
            if(st.getStaffID()==sid) return false;
        }
        return true;
    }

    public static boolean validateDOB(String str){
        if(str.matches("[0-9]*") && str.length()==8){
            int year = Integer.parseInt(str.substring(4,8));
            int month = Integer.parseInt(str.substring(2,4));
            int day = Integer.parseInt(str.substring(0,2));
            if(year > 2022) return false;
            if(month > 12) return false;
            if(day > 30) return false;
            return true;  
        }
        return false;
    }
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        ArrayList<User> UserList = new ArrayList<User>();
        ArrayList<Student> StudentList = new ArrayList<Student>();
        ArrayList<Faculty> FacultyList = new ArrayList<Faculty>();
        ArrayList<Staff> StaffList = new ArrayList<Staff>();

        while(true){
            System.out.println("1. New User \n2. Display \n3.Exit");
            int C = input.nextInt();
            switch(C){
                case 1:
                    System.out.println("1. Student \n2. Faculty \n3. Staff");
                    int c = input.nextInt();
                    input.nextLine();
                    System.out.print ("First Name: ");
                    String fname = input.nextLine();
                    while(validateName(fname)==false){
                        System.out.println("try again!");
                        fname = input.nextLine();
                    }
            
                    System.out.print ("Last Name: ");
                    String lname = input.nextLine();
                    while(validateName(lname)==false){
                        System.out.println("try again!");
                        lname = input.nextLine();
                    }

                    System.out.print ("PAN (Alphanumeric): ");
                    String PAN = input.nextLine();
                    while(validatePAN(PAN)==false){
                        System.out.println("try again!");
                        PAN = input.nextLine();
                    }

                    System.out.print ("PIN: ");
                    int PIN = input.nextInt();
                    while(validatePIN(PIN)==false){
                        System.out.println("try again!");
                        PIN = input.nextInt();
                    }
                    input.nextLine();

                    System.out.print ("DOB: ");
                    String dob = input.nextLine();
                    while(validateDOB(dob)==false){
                        System.out.println("try again!");
                        dob = input.nextLine();
                    }

                    System.out.print ("Email: ");
                    String email = input.nextLine();
                    while(validateEmail(email)==false){
                        System.out.println("try again!");
                        email = input.nextLine();
                    }
                    
                    if(c==1){
                        System.out.print("Roll No: ");
                        int Rno = input.nextInt();
                        while(validateRollNo(StudentList, Rno)==false){
                            System.out.println("enter again!");
                            Rno = input.nextInt();
                        }
                        Student s = new Student(fname, lname, PAN, PIN, dob, Rno, email);
                        UserList.add(s);
                        StudentList.add(s);
                    }        
                    else if(c==2){
                        System.out.print("Employee ID: ");
                        int eID = input.nextInt();   
                        while (validateEmployeeId(FacultyList, eID) == false) {
                            System.out.println("enter again!");
                            eID = input.nextInt();
                        }
                        Faculty f = new Faculty(fname, lname, PAN, PIN, dob, eID, email);
                        UserList.add(f);
                        FacultyList.add(f);                    
                    }
                    else{
                        System.out.print("Staff ID: ");
                        int sID = input.nextInt();
                        while (validateStaffId(StaffList, sID) == false) {
                            System.out.println("enter again!");
                            sID = input.nextInt();
                        }
                        Staff st = new Staff(fname, lname, PAN, PIN, dob, email, sID);
                        UserList.add(st);
                        StaffList.add(st);
                    }   
                    break;
                case 2:
                    System.out.println("1. Acc. Birth year \n2. Acc. Roll No: \n3. Acc. Employee ID \n4. StaffID");
                    int x = input.nextInt();
                    if(x==1){
                        Collections.sort(UserList, new BirthYearComparator());
                        for (User u : UserList) {
                            u.display();
                            System.out.println();
                        }
                    }
                    else if(x==2){
                        Collections.sort(StudentList, new RollNoComparator());
                        for (User u : StudentList) {
                            u.display();
                            System.out.println();
                        }
                    }
                    else if(x==3){
                        Collections.sort(FacultyList, new EmployeeIDComparator());
                        for (User u : FacultyList) {
                            u.display();
                            System.out.println();
                        }
                    }
                    else{
                        Collections.sort(StaffList, new StaffIDComparator());
                        for (User u : StaffList) {
                            u.display();
                            System.out.println();
                        }
                    }
                    break;
                case 3: 
                    return;
                default:
                    System.out.println("INVALID!!");
                    break;
            }
            // input.close();
        }
    }
}