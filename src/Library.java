import java.util.ArrayList;

public class Library {

    /*
        This class/object can be used for adding a new book to the library, display the list of available books,
        borrow a book, and return a book.
    */
    private ArrayList<Book> bookList = new ArrayList<>();

    public Library() {
    }

    public void addNewBook(Book b) {
        if (b == null) {
            System.out.println("Invalid book");
        } else {
            bookList.add(b);
            System.out.println("Success.");
        }
    }

    public void displayAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (Book b : bookList) {
                System.out.println("===============");
                System.out.println(b);
            }
        }
    }

    public void borrowBook(String bookTitle) {
        boolean doesExist = false;

        for (Book b : bookList) {
            if (bookTitle.equalsIgnoreCase(b.getBookTitle()) && b.isAvailable()) {
                b.setAvailable(false);
                doesExist = true;
                System.out.println("Success.");
                break;
            }else if(bookTitle.equalsIgnoreCase(b.getBookTitle()) && !b.isAvailable()) {
                doesExist = true;
                System.out.println("You cannot borrow this book.");
                break;
            }
        }
        if (!doesExist) {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String bookTitle) {
        boolean doesExists = false;

        for (Book b : bookList) {
            if (bookTitle.equalsIgnoreCase(b.getBookTitle()) && !b.isAvailable()) {
                doesExists = true;
                b.setAvailable(true);
                System.out.println("Success.");
                break;
            }else if(bookTitle.equalsIgnoreCase(b.getBookTitle()) && b.isAvailable()) {
                doesExists = true;
                System.out.println("You cannot return this book.");
                break;
            }
        }
        if (!doesExists) {
            System.out.println("Book not found.");
        }
    }
}
