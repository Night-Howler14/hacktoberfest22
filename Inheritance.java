import java.util.*;

class College {
    protected String name;
    protected int age;
    protected String username;
    protected String password;
    protected int mobileno;

}

class Student extends College {
    private int rollno;
    private int roomno;
    static int studentcount;

    Student() {
        studentcount++;
    }

    public void setDetails(String name, int age, String username, String password, int mobileno, int rollno,
            int roomno) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.mobileno = mobileno;
        this.rollno = rollno;
        this.roomno = roomno;
    }

    public void getDetails(String password) {
        if (this.password.equals(password)) {
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
            System.out.println("Username : " + username);
            System.out.println("Mobile-No : " + mobileno);
            System.out.println("Roll-No : " + rollno);
            System.out.println("Room-No : " + roomno);
        }

    }

    static void count() {
        System.out.println("Total number of students are : " + studentcount);
    }

}

class Faculty extends College {
    private int Facultyno;
    private int cabinno;
    static int facultycount;

    Faculty() {
        facultycount++;
    }

    public void setDetails(String name, int age, String username, String password, int mobileno, int Facultyno,
            int cabinno) {

        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.mobileno = mobileno;
        this.Facultyno = Facultyno;
        this.cabinno = cabinno;
    }

    public void getDetails(String password) {
        if (this.password.equals(password)) {
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
            System.out.println("Username : " + username);
            System.out.println("Mobile-No : " + mobileno);
            System.out.println("Faculty-No : " + Facultyno);
            System.out.println("Cabin-No : " + cabinno);
        }

    }

    static void count() {
        System.out.println("Total number of Faculty are : " + facultycount);
    }

}

public class Inheritance {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Student[] student = new Student[100];
        Faculty[] faculty = new Faculty[100];

        int i = 0, k = 0;
        System.out.println("In this program you can enter and print details for faculty and students");
        while (true) {
            System.out.println("1 - Faculty");
            System.out.println("2 - Student");
            System.out.println("3 - Exit");
            System.out.println("Enter Your Choice");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 2) {
                System.out.println("1 - setDetails()");
                System.out.println("2 - getDetails()");
                System.out.println("3 - studentCount()");
                System.out.println("Enter Your Choice");
                int choice1 = input.nextInt();
                input.nextLine();

                if (choice1 == 1) {
                    System.out.println("Enter Name");
                    String name = input.nextLine();

                    System.out.println("Enter Age");
                    int age = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Username");
                    String username = input.nextLine();

                    System.out.println("Enter Password");
                    String password = input.nextLine();

                    System.out.println("Enter Mobile-No");
                    int mobileno = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Rollno");
                    int rollno = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Roomno");
                    int roomno = input.nextInt();

                    Student object = new Student();

                    student[i] = object;
                    student[i].setDetails(name, age, username, password, mobileno, rollno, roomno);

                    i++;
                } else if (choice1 == 2) {
                    System.out.println("Enter the password to get the details");
                    String pass = input.nextLine();
                    for (int j = 0; j < i; j++) {
                        student[j].getDetails(pass);
                    }
                } else if (choice1 == 3) {
                    Student.count();
                } else {
                    System.out.println("Invalid Choice");
                }

            } else if (choice == 1) {
                System.out.println("1 - setDetails()");
                System.out.println("2 - getDetails()");
                System.out.println("3 - studentCount()");
                System.out.println("Enter Your Choice");
                int choice1 = input.nextInt();
                input.nextLine();

                if (choice1 == 1) {
                    System.out.println("Enter Name");
                    String name = input.nextLine();

                    System.out.println("Enter Age");
                    int age = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Username");
                    String username = input.nextLine();

                    System.out.println("Enter Password");
                    String password = input.nextLine();

                    System.out.println("Enter Mobile-No");
                    int mobileno = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Facultyno");
                    int facultyno = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Cabinno");
                    int cabinno = input.nextInt();

                    Faculty object = new Faculty();

                    faculty[k] = object;
                    faculty[k].setDetails(name, age, username, password, mobileno, facultyno, cabinno);

                    k++;
                } else if (choice1 == 2) {
                    System.out.println("Enter the password to get the details");
                    String pass = input.nextLine();
                    for (int j = 0; j < k; j++) {
                        faculty[j].getDetails(pass);
                    }
                } else if (choice1 == 3) {
                    Faculty.count();
                } else {
                    System.out.println("Invalid Choice");
                }

            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
        input.close();
    }
}
