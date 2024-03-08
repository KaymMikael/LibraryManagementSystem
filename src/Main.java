import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static boolean isAvailable = true;
    public static int bookId = 0;
    public static Library lib = new Library();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Library Management System");
        showOptions();
    }

    private static void showOptions() {
        System.out.println("""
                1. Add a new book to the library
                2. Display the list of all available books.
                3. Borrow a book.
                4. Return a book.
                5. Exit the application.""");
        try (Scanner sc = new Scanner(System.in)) {
            int choice = sc.nextInt();
            choose(choice);
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
            showOptions();
        }
    }

    private static void choose(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                displayAllBooks();
                break;
            case 3:
                borrowBook();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addBook() {
        System.out.print("Title: ");
        String bookTitle = sc.nextLine();
        System.out.print("Author: ");
        String bookAuthor = sc.nextLine();
        Book book = new Book(bookId, bookTitle, bookAuthor, isAvailable);
        lib.addNewBook(book);
        showOptions();
    }

    private static void displayAllBooks() {
        lib.displayAllBooks();
        showOptions();
    }

    private static void borrowBook() {
        System.out.print("Title: ");
        String bookTitle = sc.nextLine();
        lib.borrowBook(bookTitle);
        showOptions();
    }

    private static void returnBook() {
        System.out.print("Title: ");
        String bookTitle = sc.nextLine();
        lib.returnBook(bookTitle);
        showOptions();
    }
}