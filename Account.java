import java.util.*;

public class Account {

    private int accountNumber;
    private int customerID;
    private static int totalAccountCreated;
    private double minimumBalance;
    private double availableBalance;
    private String accountType, serviceBranchIFSC, customerName;

    Account() {
        totalAccountCreated++;

    }

    public int search(int accnum) {
        if (accountNumber == accnum) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setDetails(int acc, int cid, double d, double e, String acctype, String IFSC, String cusname) {
        accountNumber = acc;
        customerID = cid;
        minimumBalance = d;
        availableBalance = e;
        accountType = acctype;
        serviceBranchIFSC = IFSC;
        customerName = cusname;

    }

    public int getdetails(int accnum) {
        if (accnum == accountNumber) {
            System.out.println("Your customer Id is " + customerID);
            System.out.println("Minimum Balance of your account is " + minimumBalance);
            System.out.println("Available Balance of your account is " + availableBalance);
            System.out.println("Your Account type is " + accountType);
            System.out.println("IFSC " + serviceBranchIFSC);
            System.out.println("Customer's name is " + customerName);
            return 1;
        } else {
            return 0;
        }
    }

    public int updatedetails(int accnum) {
        System.out.println("Which details you have to update");
        System.out.println("1.Consumer Id");
        System.out.println("2.Minimum Balance");
        System.out.println("3.Account Type");
        System.out.println("4.IFSC");

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        switch (n) {
            case 1: {
                if (accnum == accountNumber) {
                    int cid;
                    System.out.println("Enter new ConsumerId ");
                    cid = sc.nextInt();
                    customerID = cid;
                    return 1;
                } else {
                    return 0;
                }

            }
            case 2: {
                if (accnum == accountNumber) {
                    float minbal;
                    System.out.println("Enter new Minimum Balance ");
                    minbal = sc.nextFloat();
                    minimumBalance = minbal;
                    return 1;
                } else {
                    return 0;
                }
            }
            case 3: {
                if (accnum == accountNumber) {
                    String type;
                    System.out.println("Enter new Account type ");
                    System.out.println("\n");
                    type = sc.nextLine();
                    accountType = type;
                    return 1;
                } else {
                    return 0;
                }
            }
            case 4: {
                if (accnum == accountNumber) {
                    String ifsc;
                    System.out.println("Enter new IFSC ");
                    System.out.println("\n");
                    ifsc = sc.nextLine();
                    serviceBranchIFSC = ifsc;
                    return 1;
                } else {
                    return 0;
                }
            }

        }
        return 0;
    }

    public int deposit(int accnum, float amt) {
        if (accnum == accountNumber) {
            availableBalance = availableBalance + amt;
            System.out.println("Amount successfully added to your Available balance");
            return 1;
        } else {
            return 0;
        }
    }

    public int withdraw(int accnum, float amt) {
        if (accnum == accountNumber) {
            availableBalance = availableBalance - amt;
            System.out.println("Amount  successfully deducted from your Available balance");
            return 1;
        } else {
            return 0;
        }
    }

    public static void totalaccount() {
        System.out.printf("The total Account saved %d", totalAccountCreated);
    }

    public static void compare(Account acc1, Account acc2) {

        if (acc1.availableBalance > acc2.availableBalance) {
            System.out.println("The Account with more available balanace is " + acc1.accountNumber);
        } else {
            System.out.println("The Account with more available balanace is " + acc1.accountNumber);
        }
    }

    /**
     * @param args
     */
    public static void main(String args[]) {
        Account[] acc = new Account[10];
        acc[0] = new Account();
        acc[1] = new Account();
        acc[2] = new Account();
        acc[3] = new Account();
        acc[4] = new Account();
        int k;
        k = 4;
        acc[0].setDetails(101, 32, 1000.00, 50000.00, "Saving", "SBIN00101", "Hari");

        acc[1].setDetails(102, 68, 12000.00, 60000.12, "Saving", "SBIN00123", "Mukesh");
        acc[2].setDetails(103, 50, 10000.00, 20020.23, "Current", "SBIN00236", "Ram");
        acc[3].setDetails(104, 25, 36000.00, 200500.00, "Saving", "SBIN00897", "Nirmala");
        acc[4].setDetails(105, 990, 10000.00, 200600.00, "Saving", "SBIN00987", "Navratan");
        System.out.printf("\nAvailable account numbers are 101, 102, 103, 104,105\n");
        Account.totalaccount();
        System.out.println("\n");

        Account.compare(acc[0], acc[1]);

        System.out.println("\n    Main menu     ");
        System.out.println("1. Update Details\n");
        System.out.println("2. Get Details\n");
        System.out.println("3. Deposit\n");
        System.out.println("4. Withdraw\n");
        System.out.println("5.Set Details\n");
        System.out.println("6.Compare\n");
        System.out.println("7. Exit\n");
        int x;
        System.out.println("Choose an option\n");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        while (x != 7) {
            switch (x) {
                case 1: {
                    int acc1;
                    System.out.println("Enter account number to be updated");
                    acc1 = sc.nextInt();
                    for (int i = 0; i <= k; i++) {
                        int m;
                        m = acc[i].updatedetails(acc1);
                        if (m == 1) {
                            break;
                        } else {
                            continue;
                        }
                    }

                    break;
                }
                case 2: {
                    int acc1;
                    System.out.println("Enter Account number");
                    acc1 = sc.nextInt();
                    for (int i = 0; i <= k; i++) {
                        int m;
                        m = acc[i].getdetails(acc1);
                        if (m == 1) {
                            break;
                        } else {
                            continue;
                        }
                    }

                    break;

                }
                case 3: {
                    int acc1;
                    float amt;
                    System.out.println("Enter  Account number and Amount to be deposited ");
                    acc1 = sc.nextInt();
                    amt = sc.nextFloat();

                    for (int i = 0; i <= k; i++) {
                        int m;
                        m = acc[i].deposit(acc1, amt);
                        if (m == 1) {
                            break;
                        } else {
                            continue;
                        }
                    }

                    break;
                }
                case 4: {
                    int acc1;
                    float amt;
                    System.out.println("Enter Account number and amount to be withdrawn ");
                    acc1 = sc.nextInt();
                    amt = sc.nextFloat();

                    for (int i = 0; i <= k; i++) {
                        int m;
                        m = acc[i].withdraw(acc1, amt);
                        if (m == 1) {
                            break;
                        } else {
                            continue;
                        }
                    }

                    break;
                }
                case 5: {

                    int acc1;
                    int cid;
                    Double d;
                    Double e;
                    String acctype;
                    String IFSC;
                    String cusname;
                    k++;
                    acc[k] = new Account();
                    Account a = new Account();
                    System.out.println("Enter account number");
                    acc1 = sc.nextInt();

                    System.out.println("Enter customer Id number");
                    cid = sc.nextInt();

                    System.out.println("Enter minimum balance");
                    d = sc.nextDouble();

                    System.out.println("Enter available number");
                    e = sc.nextDouble();

                    System.out.println("Enter account type");
                    acctype = sc.nextLine();
                    System.out.println("Enter IFSC");
                    IFSC = sc.nextLine();
                    System.out.println("Enter Customer Name");
                    cusname = sc.nextLine();
                    a.setDetails(acc1, cid, d, e, acctype, IFSC, cusname);
                    acc[k] = a;

                    break;

                }
                case 6: {
                    int accnum1;
                    int accnum2;
                    System.out.println("Enter Account number1 ");
                    accnum1 = sc.nextInt();
                    System.out.println("Enter Account number2 ");
                    accnum2 = sc.nextInt();
                    int m;
                    Account a = new Account();
                    Account b = new Account();
                    for (int i = 0; i <= k; i++) {
                        m = acc[i].search(accnum1);
                        if (m == 1) {
                            a = acc[i];
                            break;
                        }

                    }
                    for (int i = 0; i <= k; i++) {
                        m = acc[i].search(accnum2);
                        if (m == 1) {
                            b = acc[i];
                            break;
                        }

                    }
                    compare(a, b);

                    break;
                }
            }

            System.out.println("\n    Main menu     ");
            System.out.println("1. Update Details\n");
            System.out.println("2. Get Details\n");
            System.out.println("3. Deposit\n");
            System.out.println("4. Withdraw\n");
            System.out.println("5.Set Details\n");
            System.out.println("6. Compare\n");
            System.out.println("7. Exit\n");
            System.out.println("Enter your choice ");
            x = sc.nextInt();
        }

    }

}
