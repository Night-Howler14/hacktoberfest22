import java.util.*;
import java.io.*;
class account {
    int accountNumber= 0;
    String accountType = "";
    String serviceBranchIFSC = "";
     float availableBalance=0;
    float minimumBalance = 0;
    int  customerID=0;
    String cusstomerName ="";
    int totalAccountCreated = 0;
}

class q1_lab4 {
    static Scanner sc = new Scanner(System.in);

    static void setDetails(account obj1) {
        System.out.println("Enter the Account Number");
        obj1.accountNumber = sc.nextInt();
        System.out.println("Enter the accountType");
        obj1.accountType = sc.nextLine();

        obj1.accountType = sc.nextLine();
        System.out.println("Enter the serviceBranchIFSC");
        obj1.serviceBranchIFSC = sc.nextLine();
        System.out.println("Enter the minimumBalance");
        obj1.minimumBalance = sc.nextFloat();
        System.out.println("Enter the availableBalance");
        obj1.availableBalance = sc.nextFloat();
        System.out.println("Enter the customerID");
        obj1.customerID = sc.nextInt();
        System.out.println("Enter the  customerName");
        obj1.cusstomerName = sc.nextLine();
        obj1.cusstomerName = sc.nextLine();
    }

    static int search(account obj1[], int x, int y) {
        int len = obj1.length;
        int o = 0;
        for (int i = 0; i < len; i++) {
            if (obj1[i].accountNumber == x) {
                if (y == 1)
                    print(obj1[i]);
                o = 1;
                return i;
            }
        }
        if (o == 0) {
            System.out.println("We don't have that account");
            return 0;
        }
        return 0;
    }

    static void getDetails(account obj1[], int x, int y) {

        search(obj1,x, y);
    }

    static void updateDetails(account obj1) {
        int c = 1;
        int s;
        int h;
        String s1;
        while (c > 0) {
            System.out.println(
                    "Enter 1 to update account type\nEnter 2 to change branch code\nEnter 3 to customer name\nEnter 4 to change minimum balance\nEnter 5 to change customer ID");
            s = sc.nextInt();
            switch (s) {
                case 1:
                    System.out.println("Enter the new account type");
                    s1 = sc.nextLine();
                    s1 = sc.nextLine();
                    obj1.accountType = s1;
                    break;
                case 2:
                    System.out.println("Enter the new branch code");
                    s1 = sc.nextLine();
                    s1 = sc.nextLine();
                    obj1.serviceBranchIFSC = s1;
                    break;
                case 3:
                    System.out.println("Enter the new customer");
                    s1 = sc.nextLine();
                    s1 = sc.nextLine();
                    obj1.cusstomerName = s1;
                    break;
                case 4:
                    System.out.println("Enter the new minimum balance");
                    h = sc.nextInt();
                    obj1.minimumBalance = h;
                    break;
                case 5:
                    System.out.println("Enter the new customer ID");
                    h = sc.nextInt();
                    obj1.customerID = h;
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.println("\nEnter 0 to exit and 1 to change more details\n");
            c=sc.nextInt();
        }
    }

    static void getBalance(account obj1[], int x, int y) {
        int o = 0;
        for (int i = 0; i < y; i++) {
            if (obj1[i].accountNumber == x) {
                System.out.println("The Aaviable Amount is:=" + obj1[i].availableBalance);
                o = 1;
                break;
            }
        }
        if (o == 0) {
            System.out.println("Account cannot be found");
        }
    }

    static void deposit(account obj1[], int x, int y) {
        int d;
        System.out.println("Enter the amount you want to enter");
        d = sc.nextInt();
        int o = 0;
        for (int i = 0; i < y; i++) {
            if (obj1[i].accountNumber == x) {
                obj1[i].availableBalance = obj1[i].availableBalance + d;
                o = 1;
            }
        }
        if (o == 0) {
            System.out.println("Account cannot be found");
        }
    }

    static void withdraw(account obj1[], int x, int y) {
        int d;
        System.out.println("Enter the amount you want to take out");
        d = sc.nextInt();
        int o = 0;
        for (int i = 0; i < y; i++) {
            if (obj1[i].accountNumber == x) {
                if (obj1[i].availableBalance >= obj1[i].minimumBalance) {
                    obj1[i].availableBalance = obj1[i].availableBalance - d;
                    o = 1;
                } else {
                    System.out.println("Minumum balance reached");
                    o = 1;
                }
            }
        }
        if (o == 0) {
            System.out.println("Account cannot be found");
        }
    }

    static void print(account obj1) {
        System.out.println("Enter the Account Number:=" + obj1.accountNumber);
        System.out.println("Enter the accountType:=" + obj1.accountType);
        System.out.println("Enter the serviceBranchIFSC:=" + obj1.serviceBranchIFSC);
        System.out.println("Enter the minimumBalance:=" + obj1.minimumBalance);
        System.out.println("Enter the availableBalance:=" + obj1.availableBalance);
        System.out.println("Enter the customerID:=" + obj1.customerID);
        System.out.println("Enter the  customerName:=" + obj1.cusstomerName);
    }

    static void totalAccount(account obj1[]) {
        int length = obj1.length;
        System.out.println("The total account avaible are:=" + length);
    }

    static void compare(account obj1, account obj2) {
        if (obj1.availableBalance > obj2.availableBalance) {
            print(obj1);
        } else if (obj1.availableBalance < obj2.availableBalance) {
            print(obj2);
        } else {
            System.out.println(obj1.availableBalance + " " + obj2.availableBalance + " both has same balance");
        }
    }

    public static void main(String args[]) {
        int s;
        System.out.println("Enter the number account of you want open");
        s = sc.nextInt();
        account obj1[] = new account[s];
        for (int i = 0; i < s; i++) {
            obj1[i] = new account();
        }
        int x = 1;
        int c = 0;
        int i = 0;
        int u = 0;
        while (x == 1) {
            System.out.println("Enter 1 to set details\nEnter 2 to print details");
            System.out.println(
                    "Enter 3 to upadate details\nEnter 4 to getBlance\nEnter 5 to deposit\nEnter 6 to withdraw\nEnter 7 to compare two account\nEnter 8 to know total Account");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Enter Not Accutal account number you want set details");
                    i = sc.nextInt();
                    i--;
                    if (i <= (s - 1))
                        setDetails(obj1[i]);
                    else
                        System.out.println("We don't have that account");
                    break;
                case 2:
                    System.out.println("Enter Accutal account number you want get details");
                    i = sc.nextInt();
                    getDetails(obj1, i, 1);
                    break;
                case 3:
                    System.out.println("Enter   Not Accutal account number you want Update details");
                    i = sc.nextInt();
                    i--;
                    if (i <= (s - 1))
                        updateDetails(obj1[i]);
                    else
                        System.out.println("We don't have that account");
                    break;
                case 4:
                    System.out.println("Enter  Accutal account number you want get Balance");
                    i = sc.nextInt();
                    getBalance(obj1, i, s);
                    break;
                case 5:
                    System.out.println("Enter  Accutal account number you want deposit");
                    i = sc.nextInt();
                    deposit(obj1, i, s);
                    break;
                case 6:
                    System.out.println("Enter  Accutal account number you want withdraw");
                    i = sc.nextInt();
                    withdraw(obj1, i, s);
                    break;
                case 7:
                    System.out.println("Enter Not Accutal 1st account you want compare");
                    i = sc.nextInt();
                    if (i <= (s - 1)) {
                        i--;
                    } else
                        System.out.println("We don't have that account");
                    System.out.println("Enter Not Accutal 2st account you want compare");
                    if (u <= (s - 1)) {
                        u = sc.nextInt();
                        u--;
                    } else
                        System.out.println("We don't have that account");
                    compare(obj1[i], obj1[u]);
                    break;
                case 8:
                    totalAccount(obj1);
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.println("\nEnter 1 to continue\nEnter 0 to exit");
            x = sc.nextInt();
        }
    }
}
