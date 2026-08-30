class LibraryBook {

    String title;
    String isbn;

    LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    LibraryBook(String title) {
        this(title, "PENDING");
    }

    void display() {
        System.out.println(title + " | " + isbn +
                " | Catalogued: true");
    }
}

public class LibraryBookCatalogue {

    public static void main(String[] args) {

        LibraryBook b1 =
                new LibraryBook("Clean Code",
                        "978-0132350884");

        LibraryBook b2 =
                new LibraryBook("Untitled Draft");

        b1.display();
        b2.display();
    }
}
