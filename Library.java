import java.util.Scanner;

class book {

    private int bookId;
    private String bookTitle;
    private int yearOfPublication;
    private String authorname;
    private String publisherName;
    private int numberOfAvailableCopies;
    private int totalCopies;

    book(int copies) {
        totalCopies = copies;
    }

    public int checkid(int id) {
        if (id == bookId) {
            return 1;
        }
        return 0;
    }

    public void setDetails(int id, String title, int year, String author, String publisher, int count) {

        bookId = id;
        bookTitle = title;
        yearOfPublication = year;
        authorname = author;
        publisherName = publisher;
        numberOfAvailableCopies = count;

    }

    public void getDetails(int id) {
        if (id == bookId) {
            System.out.println("**********************************************");
            System.out.println("\tId : " + bookId);
            System.out.println("\tTitle : " + bookTitle);
            System.out.println("\tYear : " + yearOfPublication);
            System.out.println("\tAuthor : " + authorname);
            System.out.println("\tPublisher : " + publisherName);
            System.out.println("\tAvailable copies : " + numberOfAvailableCopies);
            System.out.println("\tTotalCopies : " + totalCopies);
            System.out.println("***********************************************");
        }
    }

    public void issue(int id) {
        if (id == bookId) {
            if (numberOfAvailableCopies > 0) {

                numberOfAvailableCopies--;
                System.out.println("Issued -- Available copies : " + numberOfAvailableCopies);
            } else {
                System.out.println("Can't Issue as the copy is Not available at the moment!");
            }
        }
    }

    public void returning(int id) {
        if (id == bookId) {
            if (numberOfAvailableCopies != totalCopies) {

                numberOfAvailableCopies++;
                System.out.println("Returned -- Available copies : " + numberOfAvailableCopies);
            } else {
                System.out.println("Can't Return as ( Available copies = Total copies )");
            }
        }
    }

}

public class library {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        book[] arr;
        arr = new book[5];
        int i = 0;
        while (true) {
            System.out.println("\t ---------------- ");
            System.out.println("\t|1 - setDetails()|");
            System.out.println("\t|2 - getDetails()|");
            System.out.println("\t|3 - issue()     |");
            System.out.println("\t|4 - Return()    |");
            System.out.println("\t|5 - Exit()      |");
            System.out.println("\t ---------------- ");

            System.out.println("******************");
            System.out.println("Enter your choice");
            System.out.println("******************");
            int choice = input.nextInt();

            if (choice == 1) {

                System.out.println("Enter details for book " + (i + 1));
                System.out.println("Enter Total Copies");
                int x = input.nextInt();
                arr[i] = new book(x);

                System.out.println("Enter Id");
                int id = input.nextInt();
                input.nextLine();

                System.out.println("Enter Title");
                String title = input.nextLine();

                System.out.println("Enter Year");
                int year = input.nextInt();

                System.out.println("Enter Author");
                input.nextLine();
                String author = input.nextLine();

                System.out.println("Enter Publisher");
                String publisher = input.nextLine();

                System.out.println("Enter Count");
                int count = input.nextInt();
                int flag = 0;

                for (int j = 0; j < i; j++) {
                    flag = arr[j].checkid(id);
                    if (flag == 1) {
                        break;
                    }
                }
                if (flag == 0) {
                    arr[i].setDetails(id, title, year, author, publisher, count);
                    i++;
                } else {
                    System.out.println("I'd already exist!");
                }

            } else if (choice == 2) {
                System.out.println("Enter id To Get the details of any book");
                int id1 = input.nextInt();
                for (int j = 0; j < i; j++) {
                    arr[j].getDetails(id1);
                }

            } else if (choice == 3) {
                System.out.println("Enter id to issue book");
                int id1 = input.nextInt();
                for (int j = 0; j < i; j++) {
                    arr[j].issue(id1);
                }

            } else if (choice == 4) {
                System.out.println("Enter id to return book");
                int id1 = input.nextInt();
                for (int j = 0; j < i; j++) {
                    arr[j].returning(id1);
                }
            }

            else if (choice == 5) {
                break;
            }
        }

        input.close();
    }
}
