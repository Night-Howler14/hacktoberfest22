import java.util.*;
abstract class user {
    String name;
    int UserID;
    int dateOfBirth;
    Scanner sc = new Scanner(System.in);

    user() {
        name = "";
        UserID = 0;
        dateOfBirth = 0;
    }

    user(String name1, int UserID1, int dateOfBirth1) {
        name = name1;
        UserID = UserID1;
        dateOfBirth = dateOfBirth1;
    }

    void setDetails() {
    }

    void showDetails(int BirthYear, ArrayList<Student> list1, ArrayList<Staff> list2, ArrayList<Faculty> list3) {
        Student obj = new Student();
        Staff obj1 = new Staff();
        Faculty obj2 = new Faculty();
        System.out.println("---------Student Having Same Date of Birth-----------");
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).dateOfBirth == BirthYear) {
                obj.print1(list1.get(i));
            }
        }
        System.out.println("---------Staff Having Same Date of Birth-----------");
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).dateOfBirth == BirthYear) {
                obj1.print2(list2.get(i));
            }
        }
        System.out.println("---------Faculty Having Same Date of Birth-----------");
        for (int i = 0; i < list3.size(); i++) {
            if (list3.get(i).dateOfBirth == BirthYear) {
                obj2.print3(list3.get(i));
            }
        }
    }

    int search1(ArrayList<Staff> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).UserID == id) {
                return i;
            }
        }
        return -1;
    }

    int search2(ArrayList<Student> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).UserID == id) {
                return i;
            }
        }
        return -1;
    }

    int search3(ArrayList<Faculty> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).UserID == id) {
                return i;
            }
        }
        return -1;
    }
}

class Student extends user {
    int rollNumber;
    String semester;
    int cpi;

    Student() {
        rollNumber = 0;
        semester = "";
        cpi = 0;
    }

    Student(int n1, String sem, int cpi1) {
        rollNumber = n1;
        semester = sem;
        cpi = cpi1;

    }

    void setDetails() {
        System.out.println("Enter the name");
        name = sc.nextLine();
        System.out.println("Enter the User ID");
        UserID = sc.nextInt();
        System.out.println("Enter the Birth Year");
        dateOfBirth = sc.nextInt();
        System.out.println("Enter the roll Number");
        rollNumber = sc.nextInt();
        System.out.println("Enter the semster");
        semester = sc.nextLine();
        semester = sc.nextLine();
        System.out.println("Enter the Cumulative Performance Index");
        cpi = sc.nextInt();
    }

    void print1(Student obj1) {
        System.out.println("the name:=" + obj1.name);
        System.out.println("the User Id:=" + obj1.UserID);
        System.out.println("the Birth Year:=" + obj1.dateOfBirth);
        System.out.println("the roll Number:=" + obj1.rollNumber);
        System.out.println("the semster:=" + obj1.semester);
        System.out.println("the Cumulative Performance Index:=" + obj1.cpi);
    }
}

class Staff extends user {
    int employeeID;
    String sectionName;
    String designation;

    Staff() {
        employeeID = 0;
        sectionName = "";
        designation = "";
    }

    Staff(int n1, String str, String str1) {
        employeeID = n1;
        sectionName = str;
        designation = str1;
    }

    void setDetails() {
        System.out.println("Enter the name");
        name = sc.nextLine();
        System.out.println("Enter the User Id");
        UserID = sc.nextInt();
        System.out.println("Enter the Birth Year");
        dateOfBirth = sc.nextInt();
        System.out.println("Enter the employee ID");
        employeeID = sc.nextInt();
        System.out.println("Enter the section Name");
        sectionName = sc.nextLine();
        sectionName = sc.nextLine();
        System.out.println("Enter the designation");
        designation = sc.nextLine();
    }

    void check(ArrayList<Staff> list, int n1, int n2) {

        int i1 = search1(list, n1);
        int i2 = search1(list, n2);
        if (i1 != -1 && i2 != -1) {
            if (list.get(i1).designation.compareToIgnoreCase(list.get(i2).designation) == 0) {
                System.out.println("The designation of both is same");
            } else {
                System.out.println("The designation of both not same");
            }
        } else {
            System.out.println("Anyone/both do not exsist");
        }

    }

    void print2(Staff obj1) {
        System.out.println("Name:=" + obj1.name);
        System.out.println("User ID:=" + obj1.UserID);
        System.out.println("Birth Year:=" + obj1.dateOfBirth);
        System.out.println("employee ID:=" + obj1.employeeID);
        System.out.println("section Name:=" + obj1.sectionName);
        System.out.println("designation:=" + obj1.designation);
    }
}

class Faculty extends user {
    int employeeID = 0;
    String departmentName;
    int noOfPublications;

    Faculty() {
        employeeID = 0;
        noOfPublications = 0;
        departmentName = "";
    }

    Faculty(int n1, String s, int n2) {
        employeeID = n1;
        departmentName = s;
        noOfPublications = n2;
    }

    void setDetails() {
        System.out.println("Enter the name");
        name = sc.nextLine();
        System.out.println("Enter the User Id");
        UserID = sc.nextInt();
        System.out.println("Enter the Birth Year");
        dateOfBirth = sc.nextInt();
        System.out.println("Enter the employee ID");
        employeeID = sc.nextInt();
        System.out.println("Enter the department Name");
        departmentName = sc.nextLine();
        departmentName = sc.nextLine();
        System.out.println("Enter the number Of Publication");
        noOfPublications = sc.nextInt();
    }

    void check(ArrayList<Faculty> list, int n1, int n2) {
        int i1 = search3(list, n1);
        int i2 = search3(list, n2);
        if (i1 != -1 && i2 != -1) {
            if (list.get(i1).departmentName.compareToIgnoreCase(list.get(i2).departmentName) == 0) {
                System.out.println("The department of both is same");
            } else {
                System.out.println("The department of both not same");
            }
        } else {
            System.out.println("Anyone/both do not exsist");
        }
    }

    void print3(Faculty obj1) {
        System.out.println("Name:=" + obj1.name);
        System.out.println("User ID:=" + obj1.UserID);
        System.out.println("Birth Year:=" + obj1.dateOfBirth);
        System.out.println("Employee ID:=" + obj1.employeeID);
        System.out.println("Department Name:=" + obj1.departmentName);
        System.out.println("The number Of Publication:=" + obj1.noOfPublications);
    }
}

public class q1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        ArrayList<Student> list1 = new ArrayList<>();
        ArrayList<Staff> list2 = new ArrayList<>();
        ArrayList<Faculty> list3 = new ArrayList<>();
        int x = 1;
        int y;
        int u1;
        int u2;
        while (x == 1) {
            System.out.println("Enter 1 to Student menu\nEnter 2 to Staff\nEnter 3 to Faculty Menu");
            y = sc.nextInt();
            switch (y) {
                case 1:
                    while (x == 1) {
                        System.out.println("Enter 1 to set Details\nEnter 2 to print details");
                        Student obj1 = new Student();
                        y = sc.nextInt();
                        switch (y) {
                            case 1:
                                obj1.setDetails();
                                list1.add(obj1);
                                break;
                            case 2:
                                System.out.println("Enter the birthYear");
                                x = sc.nextInt();
                                obj1.showDetails(x, list1, list2, list3);
                                break;
                            default:
                                System.out.println("wrong choice");
                                break;
                        }
                        System.out.println("Enter 1 to continue\nEnter 0 to exit");
                        x = sc.nextInt();
                    }
                    x = 1;
                    break;
                case 2:
                    while (x == 1) {
                        System.out.println(
                                "Enter 1 to set Details\nEnter 2 to print details\nEnter 3 to check designation");
                        Staff obj1 = new Staff();
                        y = sc.nextInt();
                        switch (y) {
                            case 1:
                                obj1.setDetails();
                                list2.add(obj1);
                                break;
                            case 2:
                                System.out.println("Enter the birthYear");
                                x = sc.nextInt();
                                obj1.showDetails(x, list1, list2, list3);
                                break;
                            case 3:
                                System.out.println("Enter the userId Of First");
                                u1 = sc.nextInt();
                                System.out.println("Enter the userId Of second");
                                u2 = sc.nextInt();
                                obj1.check(list2, u1, u2);
                                break;
                            default:
                                System.out.println("wrong choice");
                                break;
                        }
                        System.out.println("Enter 1 to continue\nEnter 0 to exit");
                        x = sc.nextInt();
                    }
                    x = 1;
                    break;
                case 3:
                    while (x == 1) {
                        System.out.println("Enter 1 to set Details\nEnter 2 to print details\nEnter 3 to check department Name");
                        Faculty obj1 = new Faculty();
                        y = sc.nextInt();
                        switch (y) {
                            case 1:
                                obj1.setDetails();
                                list3.add(obj1);
                                break;
                            case 2:
                                System.out.println("Enter the birthYear");
                                x = sc.nextInt();
                                obj1.showDetails(x, list1, list2, list3);
                                break;
                            case 3:
                                System.out.println("Enter the userId Of First");
                                u1 = sc.nextInt();
                                System.out.println("Enter the userId Of second");
                                u2 = sc.nextInt();
                                obj1.check(list3, u1, u2);
                            default:
                                System.out.println("wrong choice");
                                break;
                        }
                        System.out.println("Enter 1 to continue\nEnter 0 to exit");
                        x = sc.nextInt();
                    }
                    x = 1;
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
