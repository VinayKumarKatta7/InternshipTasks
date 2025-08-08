
package Internship_Tasks;

import java.util.ArrayList;
import java.util.Scanner;
    
    

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

// User Class
class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }
}

// Library Class
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void showBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void issueBook(int bookIndex, User user) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book b = books.get(bookIndex);
            if (!b.isIssued()) {
                b.setIssued(true);
                System.out.println("Book issued to " + user.getName());
            } else {
                System.out.println("Book already issued!");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void returnBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book b = books.get(bookIndex);
            if (b.isIssued()) {
                b.setIssued(false);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book was not issued.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
}

// Main Class
public class Task_3_Library_Management_SyStem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Python Crash Course", "Eric Matthes"));
        library.addBook(new Book("Data Structures", "Robert Lafore"));

        User user = new User("Vinay", 101);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    library.showBooks();
                    System.out.print("Enter book number to issue: ");
                    int issueIndex = sc.nextInt() - 1;
                    library.issueBook(issueIndex, user);
                    break;
                case 3:
                    library.showBooks();
                    System.out.print("Enter book number to return: ");
                    int returnIndex = sc.nextInt() - 1;
                    library.returnBook(returnIndex);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
