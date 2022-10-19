import java.util.Scanner;

public class accounts {
   Scanner sc = new Scanner(System.in);
   private int accountx_number;
   private String accountx_type;
   private String servicex_branch_ifsc;
   private float minimumx_balace;
   private float availablex_balance;
   private int customerx_id;
   private String customerx_name;
   static int total_account_created = 0;

   accounts() {
   }

   static void initalize(int size) {
      total_account_created = total_account_created + size;
   }

   void setdetails(int account_number, String account_type, String service_branch_ifsc, float minimum_balance,
         float available_balance, int customer_id, String customer_name) {
      total_account_created++;
      accountx_number = account_number;
      accountx_type = account_type;
      servicex_branch_ifsc = service_branch_ifsc;
      minimumx_balace = minimum_balance;
      availablex_balance = available_balance;
      customerx_id = customer_id;
      customerx_name = customer_name;
   }

   void update_details() {
      System.out.println(
            "what do you want to update?\n1.account type\n2.service branch ifsc\n3.minimum balace\n4.customer id\n5.customer name\n");
      int ch = sc.nextInt();
      sc.nextLine();
      switch (ch) {
         case 1: {
            System.out.println("Enter new value");
            String new_ = sc.nextLine();
            accountx_type = new_;
            break;
         }
         case 2: {
            System.out.println("Enter new value");
            String new_ = sc.nextLine();
            servicex_branch_ifsc = new_;
            break;
         }
         case 3: {
            System.out.println("Enter new value");
            float new_x = sc.nextInt();
            minimumx_balace = new_x;
            break;
         }
         case 4: {
            System.out.println("Enter new value");
            int new_x = sc.nextInt();
            customerx_id = new_x;
            break;
         }
         case 5: {
            System.out.println("Enter new value");
            String new_ = sc.nextLine();
            customerx_name = new_;
            break;
         }

      }

   }

   int get_account_number() {
      return accountx_number;
   }

   int get_customerid_number() {
      return customerx_id;
   }

   void get_details() {
      System.out.println("account number=" + accountx_number);
      System.out.println("account type:" + accountx_type);
      System.out.println("service branch ifsc=" + servicex_branch_ifsc);
      System.out.println("minimum balace= " + minimumx_balace);
      System.out.println("available balance=" + availablex_balance);
      System.out.println("customer id=" + customerx_id);
      System.out.println("customer name:" + customerx_name);
   }

   void deposit() {
      System.out.println("Enter the amount you want to deposit");
      int amount = sc.nextInt();
      availablex_balance += amount;
   }

   float get_minimum_balance() {
      return minimumx_balace;
   }

   void withdrwal() {
      System.out.println("Enter the amount you want to withdrawl");
      int amount = sc.nextInt();
      if (availablex_balance < amount) {
         System.out.println("Insufficient Funds");
      } else if (availablex_balance - amount < get_minimum_balance()) {
         System.out.println("Insufficient Funds");
      } else {
         availablex_balance -= amount;
      }
   }

   void get_balance() {
      System.out.println("total balance in your account=" + availablex_balance);
   }

   float get_current_bal() {
      return availablex_balance;
   }

   public static void main(String[] args) {

      accounts bank_acc[];
      bank_acc = new accounts[100];
      Scanner sc = new Scanner(System.in);
      int currentcount = 0;

      while (true) {
         System.out.println(
               "1.open an account\n2.get details \n3.update deatails \n4.deposit money \n5.withdrwal money \n6.total balance \n7.total accounts in the bank right now \n8.terminate right now\n");
         // System.out.println("Open an accout First!!");
         int choice;
         choice = sc.nextInt();
         switch (choice) {
            case 1: {
               System.out.println("Enter the number of accounts");
               int size = sc.nextInt();
               if (currentcount < 100) {
                  // accounts.initalize(size);
                  // accounts.total_account_created +=size;
                  while (size > 0) {
                     System.out.println("Enter account_number");
                     int account_number = sc.nextInt();
                     sc.nextLine();
                     System.out.println("Enter account_type");
                     String account_type = sc.nextLine();
                     System.out.println("Enter service_branch_ifsc");
                     String service_branch_ifsc = sc.nextLine();
                     System.out.println("Enter minimum_balance");
                     float minimum_balance = sc.nextFloat();
                     // System.out.println("Enter available_balance");
                     float available_balance = minimum_balance;
                     System.out.println("Enter customer_id");
                     int customer_id = sc.nextInt();
                     sc.nextLine();
                     System.out.println("Enter customer_name");
                     String customer_name = sc.nextLine();
                     int flag = 0;
                     for (int j = 0; j < currentcount; j++) {

                        if (account_number == bank_acc[j].get_account_number()) {
                           System.out.println("Sorry this account already exists!!");
                           flag = 1;
                        }
                        if (customer_id == bank_acc[j].get_customerid_number()) {
                           System.out.println("Sorry this account already exists!!");
                           flag = 1;
                        }
                     }
                     if (flag == 1) {
                        continue;
                     }
                     bank_acc[currentcount] = new accounts();
                     bank_acc[currentcount].setdetails(account_number, account_type, service_branch_ifsc,
                           minimum_balance, available_balance, customer_id, customer_name);
                     size--;
                     currentcount++;
                  }
               } else {
                  System.out.println("Bank is currently full!!");
               }
               break;
            }

            case 2: {
               System.out.println("Enter the account number: ");
               int account_number_ = sc.nextInt();

               for (int i = 0; i < currentcount; i++) {
                  if (account_number_ == bank_acc[i].get_account_number()) {
                     bank_acc[i].get_details();
                  }
               }
               break;
            }
            case 3: {
               System.out.println("Enter the account number: ");
               int account_number_ = sc.nextInt();
               for (int i = 0; i < currentcount; i++) {
                  if (account_number_ == bank_acc[i].get_account_number()) {
                     bank_acc[i].update_details();
                  }
               }
               break;
            }
            case 4: {
               System.out.println("Enter the account number: ");
               int account_number_ = sc.nextInt();
               for (int i = 0; i < currentcount; i++) {
                  if (account_number_ == bank_acc[i].get_account_number()) {
                     bank_acc[i].deposit();
                  }
               }
               break;
            }
            case 5: {
               System.out.println("Enter the account number: ");
               int account_number_ = sc.nextInt();
               for (int i = 0; i < currentcount; i++) {
                  if (account_number_ == bank_acc[i].get_account_number()) {
                     bank_acc[i].withdrwal();
                  }
               }
               break;
            }
            case 6: {
               System.out.println("Enter the account number: ");
               int account_number_ = sc.nextInt();
               for (int i = 0; i < currentcount; i++) {
                  if (account_number_ == bank_acc[i].get_account_number()) {
                     bank_acc[i].get_balance();
                  }
               }
               break;
            }
            case 7: {
               System.out.println("total accounts in the bank are=" + accounts.total_account_created);
               break;
            }
            case 8: {
               return;
            }

         }

      }

   }
}