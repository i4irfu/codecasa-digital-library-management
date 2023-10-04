import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void borrowBook(User user, int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(user.getName() + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("The book is not available for borrowing.");
        }
    }

    public void returnBook(User user, int bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println(user.getName() + " has returned the book: " + book.getTitle());
        } else {
            System.out.println("Invalid book ID or the book is already available.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books and users
        Book book1 = new Book(1, "Java Programming", "John Doe");
        Book book2 = new Book(2, "Data Structures", "Jane Smith");
        User user1 = new User(101, "Alice");
        User user2 = new User(102, "Bob");

        library.addBook(book1);
        library.addBook(book2);
        library.addUser(user1);
        library.addUser(user2);

        // Borrowing and returning books
        library.borrowBook(user1, 1);
        library.borrowBook(user2, 2);
        library.returnBook(user1, 1);
        library.returnBook(user2, 2);
    }
}
