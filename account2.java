import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;

//import org.jcp.xml.dsig.internal.SignerOutputStream;

public class account2
{
    Scanner sc=new Scanner(System.in);
    private int  accountx_number;
    private String accountx_type;
    private String servicex_branch_ifsc;
    private float minimumx_balace;
    private float availablex_balance;
    private int customerx_id;
    private String customerx_name;
    private int deposit=0;
    private int withdraw=0;
    //____________________________________________//
    static int total_account_created;

    
    account2()
    {
    }

    static void initalize(int size)
    {
      total_account_created=size;
    }

    void withdraw(int x)
    {
        withdraw=x;
    }

    void deposit(int x)
    {
        deposit=x;
    }

    int get_withdraw_amount()
    {
        return withdraw;
    }
    int get_deposit_amount()
    {
        return deposit;
    }
    



    account2( int  account_number, String account_type, String service_branch_ifsc,float minimum_balance,float available_balance, int customer_id,String customer_name)
    {
    total_account_created++;
    accountx_number=account_number;
    accountx_type=account_type;
    servicex_branch_ifsc=service_branch_ifsc;
    minimumx_balace=minimum_balance;
    availablex_balance=available_balance;
    customerx_id=customer_id;
    customerx_name=customer_name;
    }

    void update_details()
    {
        System.out.println("what do you want to update?\n1.account type\n2.service branch ifsc\n3.minimum balace\n4.customer id\n5.customer name\n");
        int ch=sc.nextInt();
        sc.nextLine();
        switch(ch)
        {
            case 1:
            {
             System.out.println("Enter new value");   
             String new_=sc.nextLine();
             accountx_type=new_;
             break;
            }
            case 2:
            {
             System.out.println("Enter new value"); 
             String new_=sc.nextLine();  
             servicex_branch_ifsc=new_;
             break;
            }
            case 3:
            {
             System.out.println("Enter new value");
             float new_x=sc.nextInt();   
             minimumx_balace=new_x;
             break;
            }
            case 4:
            {
             System.out.println("Enter new value");  
             int new_x=sc.nextInt(); 
             customerx_id=new_x; 
             break;  
            }
            case 5:
            {
             System.out.println("Enter new value");
             String new_=sc.nextLine();  
             customerx_name=new_; 
             break;
            }

        }
        
        

    }

    int get_account_number()
    {
       return accountx_number;
    }

    int get_customerid_number()
    {
       return customerx_id;
    }

    


    void get_details()
    {
    System.out.println("account number="+accountx_number);
    System.out.println("account type:"+accountx_type);
    System.out.println("service branch ifsc="+servicex_branch_ifsc);
    System.out.println("minimum balace= "+minimumx_balace);
    System.out.println("available balance="+availablex_balance);
    System.out.println("customer id="+customerx_id);
    System.out.println("customer name:"+customerx_name);
    }

    void deposit()
    {
        System.out.println("Enter the amount you want to deposit");
        int amount=sc.nextInt();
        availablex_balance+=amount;
        deposit(amount);
    }

    float  get_minimum_balance()
    {
      return minimumx_balace;
    }

    void withdrwal()
    {
       System.out.println("Enter the amount you want to withdrawl");
       int amount=sc.nextInt();
       if(availablex_balance<amount )
       {
        System.out.println("Sorry..!!,you can't withdraw this much amount,balance is not enough ");
       }
       else if(availablex_balance-amount<get_minimum_balance())
       {
       System.out.println("you are withdrwing more than your minimum balance,can't deduct");
       }
       else
       {
        availablex_balance-=amount;
        withdraw(amount);
       }
    }

    void get_balance()
    {
        System.out.println("total balance in your account="+availablex_balance);
    }


    float  get_current_bal()
    {
       return availablex_balance;
    }





    public static void main(String[] args)
    {
      ArrayList<account2>bank_acc = new ArrayList<account2>();
      Scanner sc=new Scanner(System.in);
      int currentcount=0;
      
      while(true)
      {
        System.out.println("**************************************************************************");
        System.out.println("1.open an account and set details\n2.get details of my account\n3.update deatails of my accounts\n4.deposit money in my account\n5.withdrwal money from my account\n6.total balance in my account\n7.total accounts in the bank right now \n8.compare accouts\n9.Delete my account\n10.terminate program right now\n");
        System.out.println("**************************************************************************");
        System.out.println("what you want to do?...**You must have to set database of bank first so go with option 1 first");
        int choice;
        choice=sc.nextInt();
        switch(choice)
        {
         case 1:
         {
            System.out.println("Enter the number of accounts");
            int size=sc.nextInt();
            if(currentcount<100)
            {
            while(size>0)
            {
            System.out.println("Enter account_number");
            int account_number=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter account_type");
            String account_type=sc.nextLine();
            System.out.println("Enter service_branch_ifsc");
            String service_branch_ifsc=sc.nextLine();
            System.out.println("Enter minimum_balance");
            float minimum_balance=sc.nextFloat();
            System.out.println("Enter available_balance");
            float available_balance=sc.nextFloat();
            System.out.println("Enter customer_id");
            int customer_id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter customer_name");
            String customer_name=sc.nextLine();
            int flag=0;
            for(int j=0;j<currentcount;j++)
            {
                
            
               if(account_number==bank_acc.get(j).get_account_number())
               {
                   System.out.println("your account number matches with other's already existing account,so can't open account :(");
                   flag=1;
               }
               if(customer_id==bank_acc.get(j).get_account_number())
               {
                  System.out.println("your customer id matches with other's already existing account,so can't open account :(");
                  flag=1;
               }
            }
            if(flag==1)
            {
              continue;
            }
            //bank_acc[currentcount] = new account();
            // list.add(new Data(roll[i], name[i], marks[i],
            //                   phone[i]));
            bank_acc.add(new account2(account_number,account_type,service_branch_ifsc,minimum_balance,available_balance, customer_id,customer_name));
            

            size--;
            currentcount++;
            }
            }
                  else
                  {
                  System.out.println("not enough capacity in the bank");
                  }
                  break;
      }
     
         
         
         case 2:
         {
             System.out.println("Enter the account number of which you want to get details");
             int account_number_=sc.nextInt();
             if(currentcount==0)
             {
               System.out.println("No account exist in this bank");
             }
             else
             {
             for(int i=0;i<currentcount;i++)
             {
                if(account_number_==bank_acc.get(i).get_account_number())
                {
                 bank_acc.get(i).get_details();
                 break;
                }
                System.out.println("the account for which you are looking for does not exist");
             }  
             }
             break;
         }
         case 3:
         {
            System.out.println("Enter the account number of which you want to update details");
            int account_number_=sc.nextInt();
            for(int i=0;i<currentcount;i++)
            {
               if(account_number_==bank_acc.get(i).get_account_number())
               {
                bank_acc.get(i).update_details();
               }
            }  
            break;
         }
         case 4:
         {
            System.out.println("Enter the account number in which you want to deposit money");
            int account_number_=sc.nextInt();
            for(int i=0;i<currentcount;i++)
            {
               if(account_number_==bank_acc.get(i).get_account_number())
               {
                bank_acc.get(i).deposit();
                break;
               }
            }  
            break;
         }
         case 5:
         {
            System.out.println("Enter the account number from which you want to withdraw money");
            int account_number_=sc.nextInt();
            for(int i=0;i<currentcount;i++)
            {
               if(account_number_==bank_acc.get(i).get_account_number())
               {
                bank_acc.get(i).withdrwal();
                break;
               }
            }
            break;  
         }
         case 6:
         {
            System.out.println("Enter the account number of your account");
            int account_number_=sc.nextInt();
            for(int i=0;i<currentcount;i++)
            {
               if(account_number_==bank_acc.get(i).get_account_number())
               {
                bank_acc.get(i).get_balance();
                break;
               }
            }  
            break;
         }
         case 7:
         {
            System.out.println("total accounts in the bank are="+currentcount);
            break;
         }
         case 8:
         {
            System.out.println("on what basis you want to compare two accounts\n1.total available balance\n2.last withdraw amount\n3.last deposited amount\n");
            int input=sc.nextInt();
            switch(input)
            {
            case 1:
            {
           System.out.println("Enter two account numbers ");
           int acc1=sc.nextInt();
           int acc2=sc.nextInt();
           float balance1=0;
           float balance2=0;
           for(int i=0;i<currentcount;i++)
            {
               if(acc1==bank_acc.get(i).get_account_number())
               {
                balance1=bank_acc.get(i).get_current_bal();
                break;
               }
            }
            for(int i=0;i<currentcount;i++)
            {
               if(acc2==bank_acc.get(i).get_account_number())
               {
                balance2=bank_acc.get(i).get_current_bal();
                break;

               }
            }
            if(balance1>balance2)
            {
               for(int i=0;i<currentcount;i++)
              {
                if(acc1==bank_acc.get(i).get_account_number())
                {
                 bank_acc.get(i).get_details();
                 break;
                }
              }  
            }
            if(balance2>balance1)
            {
               for(int i=0;i<currentcount;i++)
              {
                if(acc2==bank_acc.get(i).get_account_number())
                {
                 bank_acc.get(i).get_details();
                 break;
                }
              }  
            }
            break;
        }
        case 2:
        {
         System.out.println("Enter two account numbers ");
         int acc1=sc.nextInt();
         int acc2=sc.nextInt();
         float withdraw1=0;
         float withdraw2=0;
         for(int i=0;i<currentcount;i++)
          {
             if(acc1==bank_acc.get(i).get_account_number())
             {
              withdraw1=bank_acc.get(i).get_withdraw_amount();
              break;
             }
          }
          for(int i=0;i<currentcount;i++)
          {
             if(acc2==bank_acc.get(i).get_account_number())
             {
              withdraw2=bank_acc.get(i).get_withdraw_amount();
              break;
             }
          }
          if(withdraw1>withdraw2)
          {
             for(int i=0;i<currentcount;i++)
            {
              if(acc1==bank_acc.get(i).get_account_number())
              {
               bank_acc.get(i).get_details();
               break;
              }
            }  
          }
          if(withdraw2>withdraw1)
          {
             for(int i=0;i<currentcount;i++)
            {
              if(acc2==bank_acc.get(i).get_account_number())
              {
               bank_acc.get(i).get_details();
               break;
              }
            }  
          }
          break;
      }
      case 3:
      {
       System.out.println("Enter two account numbers ");
       int acc1=sc.nextInt();
       int acc2=sc.nextInt();
       float deposit1=0;
       float deposit2=0;
       for(int i=0;i<currentcount;i++)
        {
           if(acc1==bank_acc.get(i).get_account_number())
           {
            deposit1=bank_acc.get(i).get_deposit_amount();
            break;
           }
        }
        for(int i=0;i<currentcount;i++)
        {
           if(acc2==bank_acc.get(i).get_account_number())
           {
            deposit2=bank_acc.get(i).get_deposit_amount();
            break;

           }
        }
        if(deposit1>deposit2)
        {
           for(int i=0;i<currentcount;i++)
          {
            if(acc1==bank_acc.get(i).get_account_number())
            {
             bank_acc.get(i).get_details();
             break;
            }
          }  
        }
        if(deposit2>deposit1)
        {
           for(int i=0;i<currentcount;i++)
          {
            if(acc2==bank_acc.get(i).get_account_number())
            {
             bank_acc.get(i).get_details();
             break;
            }
          }  
        }
        break;
          }

         }
         break;
        }
         case 9:
         {
           System.out.println("Enter your account number which you want to delete");
           int account_number_=sc.nextInt();
           for(int i=0;i<currentcount;i++)
           {
              if(account_number_==bank_acc.get(i).get_account_number())
              {
                currentcount--;
                bank_acc.remove(i);
                break;
              }
           }  
           break;
         }
         case 10:
         {
            return;
         }

        }

      }

    }
}