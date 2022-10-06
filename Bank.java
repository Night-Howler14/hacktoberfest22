package lab5;
import java.util.Scanner;
class Account {
    private int accountNumber;
    private String accountType;
    private String serviceBranchIFSC;
    private float minimumBalance;
    private float availableBalance;
    private int customerID;
    private String customerName;
    private static int totalAccountCreated = 0;
    
    
    Account() {	
        totalAccountCreated++;	
    }
    
    public void setDetails(int accno, float avaibal, int cusID, String cusname, String accType, String ifsc) {
        accountNumber = accno;
        customerID = cusID;
        minimumBalance = 1000;
        availableBalance = avaibal;
        accountType = accType;
        serviceBranchIFSC = ifsc;
        customerName = cusname;
    }
    
    public String getDetails(int accNo) {
        if (accountNumber == accNo) {
            return ("Account number : " + accountNumber
                    + "\nService Branch IFSC : " + serviceBranchIFSC
                    + "\nMinimum Balance : " + minimumBalance
                    + "\nAvailable Balance : " + availableBalance
                    + "\nCustomer ID : " + customerID
                    + "\nCustomer Name : " + customerName
                    + "\nTotal number of Account  : " + totalAccountCreated);
        } else {

            return ("invalid account number");
        }

    }

    int cusID;
    float minBal, avaibal;
    String ifsc, acctype, cusName;

    public float getBalance(int accno) {
        if (accountNumber == accno)
            return availableBalance;
        else
            return 0;
    }

    public void updateDetails(int accNo) {
        if (accountNumber == accNo) {
            Scanner input = new Scanner(System.in);
            System.out.print("1 : account type \n2 : minimum balance" +
                    "\n3 : Customer Id\n4 : Customer Name" +
                    "\n5 : Service Branch IFSC\nEnter your choice: ");
            int c = input.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Enter new account type :");
                    acctype = input.nextLine();
                    acctype = input.nextLine();
                    accountType = acctype;
                    break;

                case 2:
                    System.out.println("Enter  Minimum balance :");
                    minBal = input.nextInt();
                    minimumBalance = minBal;
                    break;

                case 3:
                    System.out.println("Enter new customer ID :");
                    cusID = input.nextInt();
                    customerID = cusID;
                    break;

                case 4:
                    System.out.println("Enter new customer Name :");
                    cusName = input.nextLine();
                    cusName = input.nextLine();
                    customerName = cusName;
                    break;

                case 5:
                    System.out.println("Enter new Service Branch IFSC :");
                    ifsc = input.nextLine();
                    ifsc = input.nextLine();
                    serviceBranchIFSC = ifsc;
                    break;

                default:
                    System.out.println("Invalid input");
                    break;

            }
             
        } else {
            System.out.println("Invalid account number ");
        }

    }

    public void deposit(int accNo, float depo) {
        if (accountNumber == accNo) {
            availableBalance += depo;
            System.out.println("Amount Deposited.");
        }
    }

    public void withdraw(int accNo, float with) {
        if (accountNumber == accNo) {
            if (availableBalance - with > minimumBalance) {

                availableBalance = availableBalance -with;
                System.out.println("Available balance = " + availableBalance);
            } else {
                System.out.println("Can't be withdraw as the amount is less than the minimum balance");
            }
        } else {
            System.out.println("Invalid Account number ");
        }
    }

    public void compare(Account account1, Account account2) {

        float ac1 = account1.getBalance(account1.accountnum());
        float ac2 = account2.getBalance(account2.accountnum());
        if (ac1 == ac2) {
            System.out.println("Both the account has same balance");
        } else if (ac1 > ac2) {
            System.out.println("Account number 1  has more balance");
        } else
            System.out.println("Account number 2 has more balance");
    }

    
    int accountnum() {
        return accountNumber;
    }
     
}

public class Bank{
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the maximum number of account available in the Bank :");
        int p = input.nextInt();
        Account[] acc = new Account[p];
        int accno, cusId;
        float avaibal;
        String ifsc, acctype, cusName;
        int k = 0;
        while (true) {
            System.out.print("0 : Create account\n1 : Update Details \n2 : Get Details" +
                    "\n3 : Deposit\n4 : Withdraw\n5 : Compare two account\n6 : EXIT \nEnter your choice : ");
            int ch = input.nextInt();
            switch (ch) {
                case 0:
                    if (k < p) {
                        System.out.println("Enter the account number :");
                        accno = input.nextInt();
                        System.out.println("Enter account type :");
                        acctype = input.nextLine();
                        acctype = input.nextLine();
                        System.out.println("Enter Available balance :");
                        avaibal = input.nextFloat();
                        System.out.println("Enter Service Branch IFSC :");
                        ifsc = input.nextLine();
                        ifsc = input.nextLine();
                        System.out.println("Enter customer ID :");
                        cusId = input.nextInt();
                        System.out.println("Enter customer Name  :");
                        cusName = input.nextLine();
                        cusName = input.nextLine();
                        acc[k] = new Account();
                        acc[k].setDetails(accno, avaibal, cusId, cusName, acctype, ifsc);
                        k++;
                        break;
                    } else {
                        System.out.println("Maximum Number of accounts present in the bank Exceeded\n");
                    }
                    break;

                case 1:
                    System.out.println("Enter the account number to update the details :");
                    accno = input.nextInt();
                    for (int i = 0; i < k; i++)
                        acc[i].updateDetails(accno);
                    break;

                case 2:
                    System.out.println("Enter the account number :");
                    accno = input.nextInt();
                    for (int i = 0; i < k; i++)
                        System.out.println(acc[i].getDetails(accno));
                    break;

                case 3:
                    System.out.println("Enter the account number :");
                    accno = input.nextInt();
                    System.out.println("Enter the amount to deposit :");
                    float dep = input.nextFloat();
                    for (int i = 0; i < k; i++)
                        acc[i].deposit(accno, dep);
                    break;

                case 4:
                    System.out.println("Enter the account number :");
                    accno = input.nextInt();
                    System.out.println("Enter the amount to withdraw :");
                    float with = input.nextFloat();
                    for (int i = 0; i < k; i++)
                        acc[i].withdraw(accno, with);
                    break;

                case 5:
                    System.out.println("Enter the first account index number :");
                    int acc1 = input.nextInt();
                    System.out.println("Enter the second account index number :");
                    int acc2 = input.nextInt();
                    acc[0].compare(acc[acc1], acc[acc2]);
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid Input.");
                    break;

            }
     
     }
        

    }
}