import java.util.*;

public class l_m_s{
    static class Book{

        private int bookId=-1;
        private String bookTitle;
        private int yearOfPublication;
        private String authorName;
        private String publisherName;
        private int numberOfAvailableCopies;
        private int totalCopies;
        Book(){
    
        }
        Book(int Copies){
            totalCopies = Copies;
        }
        public void setDetails (int id, String  title, int year, String author, String publisher, int count){
            bookId = id;
            bookTitle = title;
            yearOfPublication = year;
            authorName = author;
            publisherName = publisher;
            numberOfAvailableCopies = count;
            totalCopies = count;
            
        }
        public void getDetails (int id){
            System.out.println("Book Id: " + bookId);
            System.out.println("Book Title: " + bookTitle);
            System.out.println("Year of Publication: " + yearOfPublication);
            System.out.println("Autor name: " + authorName);
            System.out.println("Publisher Name" + publisherName);
            System.out.println("Number of available copies: " + numberOfAvailableCopies);
            System.out.println("Total copies: " + totalCopies);
        }
        public void issue(int id){
            if(bookId==id){
                numberOfAvailableCopies--;
            }
            else System.out.println("NA");
        }
        public void Return(int id){
            if(bookId==id){
                numberOfAvailableCopies++;
            }
            else System.out.println("NA");
        }
        public int getId(){
            return bookId;
        }
    }
    static void addBook(Book[] books, int id, Scanner input) {
        int i = 0;
        //System.out.println(books.length);
        for (i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getId() == id) {
                System.out.println("Book already present in library!");
                return;
            }
            if (books[i].getId() == -1) {
                break;
            }
        }
        books[i] = new Book();
        input.nextLine();
        System.out.print("Enter Book Name:");
        String title = input.nextLine();
        System.out.println("Enter Book year:");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Enter author Name:");
        String author = input.nextLine();
        System.out.println("Enter publisher Name:");
        String publisher = input.nextLine();
        System.out.println("Enter no. of books:");
        int count = input.nextInt();
        input.nextLine();
        books[i].setDetails(id, title, year, author, publisher, count);
    }

    static void issueBook(Book[] books, int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                books[i].issue(id);
                return;
            }
        }
        System.out.println("Book not in library!");
    }

    static void getBookDetails(Book[] books, int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                books[i].getDetails(id);
                return;
            }
        }
        System.out.println("Book not in library!");
    }

    static void returnBook(Book[] books, int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                books[i].Return(id);
                return;
            }
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Book[] books = new Book[5];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();
        }
        while (true) {
            System.out.printf(
                    "\n\n1. Set Details\n2. Get Details\n3. Issue \n4. Return\n5. Exit\n\n");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Book id:");
                    addBook(books, input.nextInt(), input);
                    break;
                case 2:
                    System.out.println("Enter Book id:");
                    getBookDetails(books, input.nextInt());
                    break;
                case 3:
                    System.out.println("Enter Book id:");
                    issueBook(books, input.nextInt());
                    break;
                case 4:
                    System.out.println("Enter Book id:");
                    returnBook(books, input.nextInt());
                    break;
                default:
                    break;
            }
        }

    }
}