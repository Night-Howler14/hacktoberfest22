package lab3;
import java.util.Scanner;
class book{
    private int bookid;
    private String bookTitle;
    private int yearOfPublication;
    private String authorName;
    private String publisherName;
    private int numberOfAvailableCopies;
    public void setDetails(int id,String title, int year,String author, String publisher, int count){
        bookid=id;
        bookTitle=title;
        yearOfPublication=year;
        authorName=author;
        publisherName=publisher;
        numberOfAvailableCopies=count;
    }
    public void getDetails(int id){
        bookid=id;
    System.out.println("Book Name: "+bookTitle + ", "+"Publication Year: "+yearOfPublication+ ",  "+"Author: "+authorName+",  "+"Publisher: "+publisherName+",  "+"Available Copies: "+numberOfAvailableCopies);
    }
    public int check(){
        return bookid; 
    }
    public void issue(int id){
        bookid=id;
        numberOfAvailableCopies--;
    }
    public void Return(int id){
        bookid=id;
        numberOfAvailableCopies++;
    }
}
public class Library{
    public static void main(String args[]){
        book arr[];
        int y=5;
        arr=new book[10];
        arr[0]=new book();
        arr[1]=new book();
        arr[2]=new book();
        arr[3]=new book();
        arr[4]=new book();
        
        arr[0].setDetails(01,"Adventures of Tom Sawyer",2001," Mark Twain","Time magazine",5);
        arr[1].setDetails(02,"Agni Veena",2003,"xyz","time of india",6);
        arr[2].setDetails(03,"gfg",2004,"abc","hindustan",2);
        arr[3].setDetails(04,"harry potter",2021,"qwers","Flowthorn",9);
        arr[4].setDetails(05,"Twilight",1999,"Stephanie Meyer","Beauxbatons",4);

        Scanner input=new Scanner(System.in);
        int option=0;
        while(option!=5){
            System.out.println("Enter 1 to set details");
            System.out.println("Enter 2 to get details");
            System.out.println("Enter 3 to issue book");
            System.out.println("Enter 4 to return book");
            System.out.println("Enter 5 to exit");
            option=input.nextInt();
            switch(option){
                case 1: 
                System.out.println("Enter the BookId: ");
                int id=input.nextInt();
                System.out.println("Enter the   Book Name: ");
                String name=input.nextLine();
                name=input.nextLine();
                System.out.println("Enter the year: ");
                int year=input.nextInt();
                System.out.println("Enter the author: ");
                String author=input.nextLine();
                author=input.nextLine();
                System.out.println("Enter the publisher: ");
                String publisher=input.nextLine();
                System.out.println("Enter the copy count: ");
                int count=input.nextInt();
                arr[y]=new book();
                arr[y].setDetails(id,name,year,author,publisher,count);
                y++;
                break;
    
                case 2: 
                System.out.println("Enter the id: ");
                id=input.nextInt();
                for(int i=0;i<10;i++){
                    if(arr[i].check()==id){
                        arr[i].getDetails(id);
                        break;
                    }
                    else{
                        continue;
                    }
                }
                break;
    
                case 3: 
                System.out.println("Enter the id of the issued book: ");
                id=input.nextInt();
                for(int i=0;i<10;i++){
                    if(arr[i].check()==id){
                        arr[i].issue(id);
                        break;
                    }
                    else{
                       continue;
                    }
                }
                break;
    
                case 4: 
                System.out.println("Enter the id of the returned book: ");
                id=input.nextInt();
                for(int i=0;i<10;i++){
                    if(arr[i].check()==id){
                       arr[i].Return(id);
                        break;
                    }
                    else{
                        continue;
                    }
                }
                break;
    
                default:
                	System.out.println("The entered option is invalid.... Please Re-enter the option :");
                
            } 
        }  
        input.close();
    }
    
  
}