import java.util.*;

class User {
    protected String name;
    protected int birthYear;
    protected String userId;

    public void setDetails() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Name : ");
        String name = input.nextLine();

        System.out.print("Enter Birth-Year : ");
        int birthYear = input.nextInt();
        input.nextLine();

        System.out.print("Enter User-Id : ");
        String userId = input.nextLine();
        this.name = name;
        this.birthYear = birthYear;
        this.userId = userId;
    }

    public void showDetails(int birthYear) {
        if (this.birthYear == birthYear) {
            System.out.println("\tName : " + name);
            System.out.println("\tBirth-Year : " + birthYear);
            System.out.println("\tUser-Id : " + userId);
        }
    }
}

class Student extends User {
    private int rollno;
    private int semester;
    private float cpi;

    Student() {

    }

    Student(String name, int birthYear, String userId, int rollno, int semester, float cpi) {
        this.name = name;
        this.birthYear = birthYear;
        this.userId = userId;
        this.rollno = rollno;
        this.semester = semester;
        this.cpi = cpi;
    }

    public void setDetails() {
        Scanner input = new Scanner(System.in);
        super.setDetails();

        System.out.print("Enter Roll-No : ");
        int rollno = input.nextInt();
        input.nextLine();

        System.out.print("Enter Semester : ");
        int semester = input.nextInt();
        input.nextLine();

        System.out.print("Enter CPI : ");
        float cpi = input.nextFloat();
        input.nextLine();

        this.rollno = rollno;
        this.semester = semester;
        this.cpi = cpi;
    }

    public void showDetails(int birthYear) {
        if (this.birthYear == birthYear) {
            System.out.println("--------------------------------------------------------------");
            super.showDetails(birthYear);
            System.out.println("\tRoll-No : " + rollno);
            System.out.println("\tSemester : " + semester);
            System.out.println("\tCPI : " + cpi);
            System.out.println("--------------------------------------------------------------");

        }

    }

    public void displayDetails(String userId, int rollno, int birthYear) {
        if (this.userId.equals(userId) && this.rollno == rollno && this.birthYear == birthYear) {
            System.out.println("--------------------------------------------------------------");
            super.showDetails(birthYear);
            System.out.println("\tRoll-No : " + rollno);
            System.out.println("\tSemester : " + semester);
            System.out.println("\tCPI : " + cpi);
            System.out.println("--------------------------------------------------------------");
        }
    }

}

class Faculty extends User {
    private String employeeId;
    private String departmentName;
    private int noOfPublications;

    Faculty() {

    }

    Faculty(String name, int birthYear, String userId, String employeeId, String departmentName, int noOfPublications) {
        this.name = name;
        this.birthYear = birthYear;
        this.userId = userId;
        this.employeeId = employeeId;
        this.departmentName = departmentName;
        this.noOfPublications = noOfPublications;
    }

    public Boolean checkUserId(String userId) {
        if (this.userId == userId) {
            return false;
        }
        return true;
    }

    public Boolean checkEmployeeId(String employeeId) {
        if (this.employeeId == employeeId) {
            return false;
        }
        return true;
    }

    public void setDetails() {
        Scanner input = new Scanner(System.in);
        super.setDetails();
        System.out.print("Enter Employee-Id : ");
        String employeeId = input.nextLine();

        System.out.print("Enter DepartmentName : ");
        String departmentName = input.nextLine();

        System.out.print("Enter NoOfPublications : ");
        int noOfPublications = input.nextInt();
        input.nextLine();

        this.employeeId = employeeId;
        this.departmentName = departmentName;
        this.noOfPublications = noOfPublications;

    }

    public void showDetails(int birthYear) {
        if (this.birthYear == birthYear) {
            System.out.println("--------------------------------------------------------------");
            super.showDetails(birthYear);
            System.out.println("\tEmployee-ID : " + employeeId);
            System.out.println("\tDepartmentName : " + departmentName);
            System.out.println("\tNoOfPublications  : " + noOfPublications);
            System.out.println("--------------------------------------------------------------");

        }

    }

    public void displayDetails(String userId, String employeeId, int birthYear) {
        if (this.userId.equals(userId) && this.employeeId.equals(employeeId) && this.birthYear == birthYear) {
            System.out.println("--------------------------------------------------------------");
            super.showDetails(birthYear);
            System.out.println("\tEmployeeID : " + employeeId);
            System.out.println("\tDepartmentName : " + departmentName);
            System.out.println("\tNoOfPublications  : " + noOfPublications);
            System.out.println("--------------------------------------------------------------");
        }
    }

    public String getuserId() {
        return this.userId;
    }

    public void checkDepartment(Faculty f1, Faculty f2) {
        if (f1.departmentName.equals(f2.departmentName)) {
            System.out.println("Same department!");
        } else {
            System.out.println("Different department!");
        }
    }

}

class Staff extends User {
    private String employeeId;
    private String sectionName;
    private String designation;

    Staff() {

    }

    Staff(String name, int birthYear, String userId, String employeeId, String sectionName, String designation) {
        this.name = name;
        this.userId = userId;
        this.birthYear = birthYear;
        this.employeeId = employeeId;
        this.sectionName = sectionName;
        this.designation = designation;
    }

    public void setDetails() {
        Scanner input = new Scanner(System.in);
        super.setDetails();

        System.out.print("Enter EmployeeId : ");
        String employeeId = input.nextLine();

        System.out.print("Enter SectionName : ");
        String sectionName = input.nextLine();

        System.out.print("Enter Designation : ");
        String designation = input.nextLine();

        this.employeeId = employeeId;
        this.sectionName = sectionName;
        this.designation = designation;
    }

    public void showDetails(int birthYear) {
        if (this.birthYear == birthYear) {
            System.out.println("--------------------------------------------------------------");
            super.showDetails(birthYear);
            System.out.println("\tEmployeeID : " + employeeId);
            System.out.println("\tSectionName : " + sectionName);
            System.out.println("\tDesignation  : " + designation);
            System.out.println("--------------------------------------------------------------");

        }

    }

    public void displayDetails(String userId, String employeeId, int birthYear) {
        if (this.userId.equals(userId) && this.employeeId.equals(employeeId) && this.birthYear == birthYear) {
            System.out.println("--------------------------------------------------------------");
            super.showDetails(birthYear);
            System.out.println("\tEmployeeID : " + employeeId);
            System.out.println("\tSectionName : " + sectionName);
            System.out.println("\tDesignation  : " + designation);
            System.out.println("--------------------------------------------------------------");

        }
    }

    public String getuserId() {
        return this.userId;
    }

    public void checkDesignation(Staff s1, Staff s2) {
        if (s1.designation.equals(s2.designation)) {
            System.out.println("Same Designation!");
        } else {
            System.out.println("Different Designation!");
        }
    }

}

public class assn6 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Student[] student = new Student[100];
        Faculty[] faculty = new Faculty[100];
        Staff[] staff = new Staff[100];
        System.out.println("\t Welcome Sir! to IIITG DataBase");

        int i = 0, k = 0, l = 0;
        while (true) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("\t\t1 - Faculty");
            System.out.println("\t\t2 - Student");
            System.out.println("\t\t3 - Staff");
            System.out.println("\t\t4 - Exit");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Enter Your Choice : ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("\t\t0 - setvaluesByConstructor()");
                System.out.println("\t\t1 - setDetails()");
                System.out.println("\t\t2 - ShowDetails()");
                System.out.println("\t\t3 - displayDetails()");
                System.out.println("\t\t4 - compareDepartment()");
                System.out.println("--------------------------------------------------------------");

                System.out.print("Enter Your Choice : ");
                int choice1 = input.nextInt();
                input.nextLine();
                if (choice1 == 0) {
                    System.out.print("Enter Name : ");
                    String name = input.nextLine();

                    System.out.print("Enter Birth-Year : ");
                    int birthYear = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter User-Id : ");
                    String userId = input.nextLine();

                    System.out.print("Enter EmployeeId : ");
                    String employeeId = input.nextLine();

                    System.out.print("Enter DepartmentName : ");
                    String departmentName = input.nextLine();

                    System.out.print("Enter NoOfPublications : ");
                    int noOfPublications = input.nextInt();
                    input.nextLine();
                    Faculty object = new Faculty(name, birthYear, userId, employeeId, departmentName, noOfPublications);
                    faculty[k] = object;
                    k++;
                } else if (choice1 == 1) {
                    Faculty object = new Faculty();
                    faculty[k] = object;
                    faculty[k].setDetails();
                    k++;
                } else if (choice1 == 2) {
                    System.out.print("Enter the Birth-Year to get the details : ");
                    int year = input.nextInt();
                    input.nextLine();

                    for (int j = 0; j < k; j++) {
                        faculty[j].showDetails(year);
                    }

                } else if (choice1 == 3) {
                    System.out.println("Enter User-Id,Employee-Id,Birth-Year to display the detials");
                    String userId = input.nextLine();
                    String employeeId = input.nextLine();
                    int birthYear = input.nextInt();
                    input.nextLine();
                    for (int j = 0; j < k; j++) {
                        faculty[j].displayDetails(userId, employeeId, birthYear);
                    }
                } else if (choice1 == 4) {
                    System.out.print("Enter User-Id of User 1 : ");
                    String id1 = input.nextLine();
                    System.out.print("Enter User-Id of User 2 : ");
                    String id2 = input.nextLine();

                    Faculty f1 = null, f2 = null;

                    for (int j = 0; j < k; j++) {
                        if (faculty[j] == null) {
                            continue;
                        }
                        if (id1.equals(faculty[j].getuserId())) {
                            f1 = faculty[j];
                        }
                    }
                    for (int j = 0; j < k; j++) {
                        if (faculty[j] == null) {
                            continue;
                        }

                        if (id2.equals(faculty[j].getuserId())) {
                            f2 = faculty[j];
                        }
                    }
                    if (f1 != null && f2 != null) {
                        f1.checkDepartment(f1, f2);
                    }

                } else {
                    System.out.println("Invalid Choice!");
                }

            } else if (choice == 2) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("\t\t0 - setvaluesByConstructor()");
                System.out.println("\t\t1 - setDetails()");
                System.out.println("\t\t2 - showDetails()");
                System.out.println("\t\t3 - displayDetails()");
                System.out.println("--------------------------------------------------------------");

                System.out.print("Enter Your Choice : ");
                int choice1 = input.nextInt();
                input.nextLine();
                if (choice1 == 0) {

                    System.out.print("Enter Name : ");
                    String name = input.nextLine();

                    System.out.print("Enter Birth-Year : ");
                    int birthYear = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter User-Id : ");
                    String userId = input.nextLine();

                    System.out.print("Enter Roll-No : ");
                    int rollno = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Semester : ");
                    int semester = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter CPI : ");
                    float cpi = input.nextFloat();
                    input.nextLine();
                    Student object = new Student(name, birthYear, userId, rollno, semester, cpi);
                    student[i] = object;
                    i++;
                } else if (choice1 == 1) {
                    Student object = new Student();
                    student[i] = object;
                    student[i].setDetails();

                    i++;
                } else if (choice1 == 2) {
                    System.out.print("Enter the Birth-Year to get the details : ");
                    int year = input.nextInt();
                    for (int j = 0; j < i; j++) {
                        student[j].showDetails(year);
                    }

                } else if (choice1 == 3) {
                    System.out.println("Enter User-Id,Roll-No,Birth-Year to display the detials");
                    String userId = input.nextLine();
                    int rollno = input.nextInt();
                    int birthYear = input.nextInt();
                    input.nextLine();
                    for (int j = 0; j < i; j++) {
                        student[j].displayDetails(userId, rollno, birthYear);
                    }
                } else {
                    System.out.println("Invalid Choice!");
                }

            } else if (choice == 3) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("\t\t0 - setvaluesByConstructor()");
                System.out.println("\t\t1 - setDetails()");
                System.out.println("\t\t2 - ShowDetails()");
                System.out.println("\t\t3 - displayDetails()");
                System.out.println("\t\t4 - compareDesignation()");
                System.out.println("--------------------------------------------------------------");

                System.out.print("Enter Your Choice : ");
                int choice1 = input.nextInt();
                input.nextLine();
                if (choice1 == 0) {
                    System.out.print("Enter Name : ");
                    String name = input.nextLine();

                    System.out.print("Enter Birth-Year : ");
                    int birthYear = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter User-Id : ");
                    String userId = input.nextLine();

                    System.out.print("Enter Employee-Id : ");
                    String employeeId = input.nextLine();

                    System.out.print("Enter SectionName : ");
                    String sectionName = input.nextLine();

                    System.out.print("Enter Designation : ");
                    String designation = input.nextLine();

                    Staff object = new Staff(name, birthYear, userId, employeeId, sectionName, designation);
                    staff[l] = object;
                    l++;
                } else if (choice1 == 1) {
                    Staff object = new Staff();

                    staff[l] = object;
                    staff[l].setDetails();
                    l++;
                } else if (choice1 == 2) {
                    System.out.print("Enter the Birth-Year to get the details : ");
                    int year = input.nextInt();
                    input.nextLine();
                    for (int j = 0; j < l; j++) {
                        staff[j].showDetails(year);
                    }
                } else if (choice1 == 3) {
                    System.out.println("Enter User-Id,Employee-Id,Birth-Year to display the detials");
                    String userId = input.nextLine();
                    String employeeId = input.nextLine();
                    int birthYear = input.nextInt();
                    input.nextLine();
                    for (int j = 0; j < l; j++) {
                        staff[j].displayDetails(userId, employeeId, birthYear);
                    }
                } else if (choice1 == 4) {
                    System.out.print("Enter UserId of user 1 : ");
                    String id1 = input.nextLine();
                    System.out.print("Enter UserId of user 2 : ");
                    String id2 = input.nextLine();
                    Staff s1 = null, s2 = null;

                    for (int j = 0; j < l; j++) {
                        if (staff[j] == null) {
                            continue;
                        }
                        if (id1.equals(staff[j].getuserId())) {
                            s1 = staff[j];
                        }
                    }
                    for (int j = 0; j < l; j++) {
                        if (staff[j] == null) {
                            continue;
                        }

                        if (id2.equals(staff[j].getuserId())) {
                            s2 = staff[j];
                        }
                    }
                    if (s1 != null && s2 != null) {
                        s1.checkDesignation(s1, s2);
                    }

                }

                else {
                    System.out.println("Invalid Choice!");
                }
            }

            else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }
        input.close();
    }
}
