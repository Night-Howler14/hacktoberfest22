package Assignment; 
import java.util.*;

public class User {
    String name;
    String dateofbirth;
    int userID;

    User() {

    }

    User(String name1, String date, int userid) {
        name = name1;
        dateofbirth = date;
        userID = userid;

    }

    public void setdetails() {
        String name2;
        String dob;
        int uid;
        System.out.println("Enter name ");
        Scanner sc = new Scanner(System.in);
        name2 = sc.nextLine();
        System.out.println("Enter date of birth as dd-mm-yyyy");
        dob = sc.nextLine();
        System.out.println("Enter User ID");
        uid = sc.nextInt();

        name = name2;
        dateofbirth = dob;
        userID = uid;
        System.out.println("Details set");

    }

    public int showdetails(String yearofbirth) {

        String year;

        year = dateofbirth.substring(6);

        if (year.equals(yearofbirth)) {
            System.out.println("The name of user is " + name);
            System.out.printf("The Date of Birth of user is %s\n", dateofbirth);
            System.out.println("The UserId is " + userID);
            return 1;

        } else {
            return 0;
        }

    }

    public int displaydetails(int Userid) {
        if (Userid == userID) {
            System.out.println("The name of user is " + name);
            System.out.printf("The Date of Birth of user is %s\n", dateofbirth);
            System.out.println("The UserId is " + userID);
            return 1;
        } else {
            return 0;
        }
    }
    public void display() {
        System.out.println("The name of user is " + name);
        System.out.printf("The Date of Birth of user is %s\n", dateofbirth);
        System.out.println("The UserId is " + userID);
    }

    public static void main(String args[]) {

        ArrayList<User> user = new ArrayList<User>();
        ArrayList<Student> stu = new ArrayList<Student>();
        ArrayList<Staff> staff = new ArrayList<Staff>();
        ArrayList<Faculty> fac1 = new ArrayList<Faculty>();

        System.out.println("        Menu       ");
        System.out.println("        1.Student  ");
        System.out.println("        2.Staff    ");
        System.out.println("        3.Faculty  ");
        System.out.println("        4.Exit     ");

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while (n != 4) {
            switch (n) {
                case 1: {

                    System.out.println("       Menu    ");
                    System.out.println("    1. Set Details  ");
                    System.out.println("    2. Show Details ");

                    int t;
                    System.out.println("Enter your choice ");
                    t = sc.nextInt();

                    switch (t) {
                        case 1: {
                            Student stu1 = new Student();
                            stu1.setdetails();
                            user.add(stu1);
                            stu.add(stu1);

                            break;
                        }
                        case 2: {
                            System.out.println("  Menu    ");
                            System.out.println("What do you remeber ");
                            System.out.println("    1.Year of Birth ");
                            System.out.println("    2.User Id ");
                            int c;
                            c = sc.nextInt();

                            switch (c) {

                                case 1: {
                                    int yob;

                                    System.out.println("Enter year of birth");

                                    yob = sc.nextInt();

                                    String yobs = Integer.toString(yob);
                                    for (int i = 0; i < stu.size(); i++) {
                                        if ((stu.get(i)).showdetails(yobs) == 1) {
                                            continue;
                                        }
                                    }
                                    break;
                                }

                                case 2: {
                                    int uid;
                                    System.out.println("Enter User Id ");
                                    uid = sc.nextInt();
                                    for (int i = 0; i < stu.size(); i++) {
                                        if ((stu.get(i)).displaydetails(uid) == 1) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                    }
                                    break;
                                }

                            }
                            break;

                        }

                    }
                    break;

                }	

                case 2: {
                    System.out.println("       Menu    ");
                    System.out.println("    1. Set Details  ");
                    System.out.println("    2. Show Details ");
                    System.out.println("    3. Compare designation ");

                    int t;
                    System.out.println("Enter your choice ");
                    t = sc.nextInt();

                    switch (t) {
                        case 1: {
                            Staff staff1 = new Staff();
                            staff1.setdetails();
                            user.add(staff1);
                            staff.add(staff1);
                            break;
                        }
                        case 2: {
                            System.out.println("  Menu    ");
                            System.out.println("What do you remeber ");
                            System.out.println("    1.Year of Birth ");
                            System.out.println("    2.User Id ");
                            System.out.println("    3.Employee Id ");

                            int c;
                            c = sc.nextInt();

                            switch (c) {

                                case 1: {
                                    int yob;

                                    System.out.println("Enter year of birth");

                                    yob = sc.nextInt();

                                    String yobs = Integer.toString(yob);
                                    for (int i = 0; i < staff.size(); i++) {
                                        if ((staff.get(i)).showdetails(yobs) == 1) {
                                            continue;
                                        }
                                    }
                                    break;
                                }

                                case 2: {
                                    int uid;
                                    System.out.println("Enter User Id ");
                                    uid = sc.nextInt();
                                    for (int i = 0; i < staff.size(); i++) {
                                        if ((staff.get(i)).displaydetails(uid) == 1) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                    }
                                    break;
                                }
                                case 3: {
                                    int eid;
                                    System.out.println("Enter Employee Id ");
                                    eid = sc.nextInt();
                                    for (int i = 0; i < staff.size(); i++) {
                                        if ((staff.get(i)).displaybyeid(eid) == 1) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                    }
                                    break;
                                }

                            }
                            break;
                        }

                        case 3: {
                            System.out.println("Enter the Employee id 1");
                            int eid1;
                            eid1 = sc.nextInt();
                            System.out.println("Enter the Employee id 2");
                            int eid2;
                            eid2 = sc.nextInt();
                            int j = 0;
                            int k = 0;
                            for (int i = 0; i < staff.size(); i++) {
                                if ((staff.get(i)).search(eid1) == 1) {
                                    j = i;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            for (int i = 0; i < staff.size(); i++) {
                                if ((staff.get(i)).search(eid2) == 1) {
                                    k = i;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            Staff.Compare(staff.get(j), staff.get(k));
                            break;

                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("       Menu    ");
                    System.out.println("    1. Set Details  ");
                    System.out.println("    2. Show Details ");
                    System.out.println("    3. Compare designation ");

                    int t;
                    System.out.println("Enter your choice ");
                    t = sc.nextInt();

                    switch (t) {
                        case 1: {
                            Faculty faculty = new Faculty();
                            faculty.setdetails();
                            user.add(faculty);
                            fac1.add(faculty);
                            break;
                        }
                        case 2: {
                            System.out.println("  Menu    ");
                            System.out.println("What do you remeber ");
                            System.out.println("    1.Year of Birth ");
                            System.out.println("    2.User Id ");
                            System.out.println("    3.Employee Id ");

                            int c;
                            c = sc.nextInt();

                            switch (c) {

                                case 1: {
                                    int yob;

                                    System.out.println("Enter year of birth");

                                    yob = sc.nextInt();

                                    String yobs = Integer.toString(yob);
                                    for (int i = 0; i < fac1.size(); i++) {
                                        if ((fac1.get(i)).showdetails(yobs) == 1) {
                                            continue;
                                        }
                                    }
                                    break;
                                }

                                case 2: {
                                    int uid;
                                    System.out.println("Enter User Id ");
                                    uid = sc.nextInt();
                                    for (int i = 0; i < fac1.size(); i++) {
                                        if ((fac1.get(i)).displaydetails(uid) == 1) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                    }
                                    break;
                                }
                                case 3: {
                                    int eid;
                                    System.out.println("Enter Employee Id ");
                                    eid = sc.nextInt();
                                    for (int i = 0; i < fac1.size(); i++) {
                                        if ((fac1.get(i)).displaybyeid(eid) == 1) {
                                            System.out.print("\n");
                                            break;
                                        } else {
                                            continue;
                                        }
                                    }
                                    break;
                                }

                            }
                            break;
                        }

                        case 3: {
                            System.out.println("Enter the Employee id 1");
                            int eid1;
                            eid1 = sc.nextInt();
                            System.out.println("Enter the Employee id 2");
                            int eid2;
                            eid2 = sc.nextInt();
                            int j = 0;
                            int k = 0;
                            for (int i = 0; i < fac1.size(); i++) {
                                if ((fac1.get(i)).search(eid1) == 1) {
                                    j = i;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            for (int i = 0; i < fac1.size(); i++) {
                                if ((fac1.get(i)).search(eid2) == 1) {
                                    k = i;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            Staff.Compare(staff.get(j), staff.get(k));
                            break;

                        }
                    }

                }
            }

            System.out.println("        Menu       ");
            System.out.println("        1.Student  ");
            System.out.println("        2.Staff    ");
            System.out.println("        3.Faculty  ");
            System.out.println("        4.Exit     ");
            System.out.println("Enter your choice ");
            n = sc.nextInt();
        }
        sc.close();
        }
    

}

class Student extends User {

    int rollno;
    int sem;
    int cpi;

    Student() {
        super();
    }

    Student(String name1, String date, int userid, int roll, int semester, int cpi1) {

        super(name1, date, userid);
        rollno = roll;
        sem = semester;
        cpi = cpi1;
    }

    public void setdetails() {
        super.setdetails();
        int rno;
        int sem1;
        int cpi1;

        System.out.println("Enter roll no ");
        Scanner sc = new Scanner(System.in);
        rno = sc.nextInt();
        rollno = rno;
        System.out.println("Enter Semester ");
        sem1 = sc.nextInt();
        sem = sem1;
        System.out.println("Enter CPI ");
        cpi1 = sc.nextInt();
        cpi = cpi1;

        System.out.println("Details set");

    }

    public int showdetails(String yop) {
        if (super.showdetails(yop) == 1) {
            System.out.println("The Rollno " + rollno);
            System.out.printf("The Semester is %d\n", sem);
            System.out.println("The CPI is " + cpi);
            return 1;

        } else {
            return 0;
        }

    }

    public int displaydetails(int userid) {
        if (super.displaydetails(userid) == 1) {
            System.out.println("The Rollno " + rollno);
            System.out.printf("The Semester is %d\n", sem);
            System.out.println("The CPI is " + cpi);
            return 1;
        } else {
            return 0;
        }
    }

}

class Staff extends User {

    int employeeid;
    String secname;
    String designation;

    Staff() {
        super();
    }

    Staff(int eid, String sname, String degi, String name1, String date, int userid) {
        super(name1, date, userid);
        employeeid = eid;
        secname = sname;
        designation = degi;
    }

    int search(int eid) {
        if (eid == employeeid) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setdetails() {
        super.setdetails();
        int eid;
        String sname;
        String desig;

        System.out.println("Enter employee id ");
        Scanner sc = new Scanner(System.in);
        eid = sc.nextInt();
        System.out.println("Enter Section name ");
        sc.next();
        sname = sc.nextLine();
        System.out.println("Enter Designation ");
        desig = sc.nextLine();
        employeeid = eid;
        secname = sname;
        designation = desig;

        System.out.println("Details set");

    }

    public static void Compare(Staff fac1, Staff fac2) {
        if (fac1.designation == fac2.designation) {
            System.out.println("Yes they have same designation");
        } else {
            System.out.println("They have different designation");
        }
    }

    public int showdetails(String yop) {
        if (super.showdetails(yop) == 1) {
            System.out.println("Employee Id " + employeeid);
            System.out.printf("The Section name is %s\n", secname);
            System.out.printf("The designation is %s", designation);
            return 1;

        } else {
            return 0;
        }

    }

    public int displaydetails(int userid) {
        if (super.displaydetails(userid) == 1) {
            System.out.println("Employee Id " + employeeid);
            System.out.printf("The Section name is %s\n", secname);
            System.out.printf("The designation is %s", designation);
            return 1;
        } else {
            return 0;
        }
    }

    public int displaybyeid(int eid) {
        if (search(eid) == 1) {
            super.display();
            System.out.println("Employee Id " + employeeid);
            System.out.printf("The Section name is %s\n", secname);
            System.out.printf("The designation is %s", designation);
            return 1;

        } else {
            return 0;
        }
    }

}

class Faculty extends User {
    int employeeID;
    String departmentName;
    int noOfPublications;

    Faculty() {
        super();
    }

    Faculty(int eid, String dname, int nop) {
        employeeID = eid;
        departmentName = dname;
        noOfPublications = nop;

    }

    int search(int eid) {
        if (eid == employeeID) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setdetails() {
        super.setdetails();
        int eid;
        String dname;
        int nop;

        System.out.println("Enter employee id ");
        Scanner sc = new Scanner(System.in);
        eid = sc.nextInt();
        System.out.println("Enter Department name ");
        sc.next();
        dname = sc.nextLine();
        System.out.println("Enter number of publications ");
        nop = sc.nextInt();
        employeeID = eid;
        departmentName = dname;
        noOfPublications = nop;
        System.out.println("Details set");

    }

    public void Compare(Faculty fac1, Faculty fac2) {
        if (fac1.departmentName == fac2.departmentName) {
            System.out.println("Yes they have same department");
        } else {
            System.out.println("They have different department");
        }
    }

    public int showdetails(String yop) {
        if (super.showdetails(yop) == 1) {
            System.out.println("Employee Id " + employeeID);
            System.out.printf("The Departmentname is %s\n", departmentName);
            System.out.printf("The Number oof publication are %d", noOfPublications);
            return 1;

        } else {
            return 0;
        }

    }

    public int displaybyeid(int eid) {
        if (search(eid) == 1) {
            super.display();
            System.out.println("Employee Id " + employeeID);
            System.out.printf("The Departmentname is %s\n", departmentName);
            System.out.printf("The Number oof publication are %d", noOfPublications);
            return 1;

        } else {
            return 0;
        }
        
    }
    
}
