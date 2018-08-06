import java.util.LinkedList;

public class Catalogue {

    private Library library;
    private static LinkedList<Book> availableBooks = new LinkedList<>();
    private static LinkedList<Book> borrowedBooks = new LinkedList<>();
    private static LinkedList<Book> books = new LinkedList<>();
    private static LinkedList<Genre> genres = new LinkedList<>();
    private static LinkedList<Author> authors = new LinkedList<>();

    public Catalogue() {

    }

    public Catalogue(Library library) {
        this.library = library;
    }

    public void catalogueMenu() {
        System.out.println("\n\nWelcome to the Catalogue!");
        System.out.println("Please make a selection from the menu: ");
        System.out.println("\n1. Display all books");
        System.out.println("2. Display all available books");
        System.out.println("3. Display all genres");
        System.out.println("4. Display books in a genre");
        System.out.println("5. Display all authors");
        System.out.println("6. Display all books by an author");
        System.out.println("7. Borrow a book");
        System.out.println("8. Return a book");
        System.out.println("9. Place a hold");
        System.out.println("R. Return to previous menu");
        System.out.print("\nEnter a choice: ");

        catalogueSelection();
    }

    private void catalogueSelection() {
        char selection = Library.sc.nextLine().toLowerCase().charAt(0);

        while (selection != 'r') {
            switch (selection) {
                case '1':
                    displayBooks();
                    break;
                case '2':
                    displayAvailableBooks();
                    break;
                case '3':
                    displayGenres();
                    break;
                case '4':
                    displayBooksInGenre();
                    break;
                case '5':
                    displayAuthors();
                    break;
                case '6':
                    displayBooksByAuthor();
                    break;
                case '7':
                    //TODO borrowBook();
                    break;
                case '8':
                    //TODO returnBook();
                    break;
                case '9':
                    //TODO holdBook();
                    break;
                default:
                    System.out.print("Please enter a valid input: ");
                    catalogueSelection();
                    break;
            }
            catalogueMenu();
        }

        library.mainMenu();
    }



    private void displayBooks() {
        for (Book book : books)
            System.out.println(book);
    }

    private void displayAvailableBooks() {
        for (Book book : availableBooks)
            System.out.println(book);
    }

    private void displayGenres() {
        for (Genre genre : genres)
            System.out.println(genre);
    }

    private void displayBooksInGenre() {
        if (genres.isEmpty())
            System.out.println("There are no genres in the systen");
        else {
            System.out.print("Enter a genre: ");
            String selectedGenre = Library.sc.nextLine().toLowerCase();
            for (Book book : books)
                if (book.getGenreName().toLowerCase().equals(selectedGenre))
                    System.out.println(book);
        }
    }

    private void displayAuthors() {
        for (Author author: authors)
            System.out.println(author);
    }

    private void displayBooksByAuthor() {
        if (authors.isEmpty())
            System.out.println("There are no authors in the systen");
        else {
            System.out.print("Enter an author: ");
            String selectedAuthor = Library.sc.nextLine().toLowerCase();
            for (Book book : books)
                if (book.getAuthorName().toLowerCase().equals(selectedAuthor))
                    System.out.println(book);
        }
    }

    private void borrowBook() {

    }

    private void returnBook() {

    }

    private void holdBook() {

    }

    public void addBook() {
        System.out.print("Enter the book name: ");
        String bookName = Library.sc.nextLine();

        System.out.print("Enter the author: ");
        Author newAuthor = new Author(Library.sc.nextLine());
        authors.add(newAuthor);

        System.out.print("Enter the genre: ");
        Genre newGenre = new Genre(Library.sc.nextLine());
        genres.add(newGenre);

        Book newBook = new Book(bookName, newAuthor, newGenre);
        books.add(newBook);
        availableBooks.add(newBook);

        System.out.println("The book " + newBook + " was added to the booklist.");

        System.out.println("The current list of books are: ");
        for (Book book : books)
            System.out.println(book);
    }

    public void removeBook() {
        boolean bookExists = false;
        if (books.isEmpty()) {
            System.out.println("There are no books in the system. ");
        } else {
            System.out.print("Enter the book name to be removed: ");
            String bookToRemove = Library.sc.nextLine();

            for (Book book : books)
                if (book.getBookName().equals(bookToRemove)) {
                    books.remove(book);
                    authors.remove(book.getAuthor());
                    genres.remove(book.getGenre());
                    System.out.println("Book " + bookToRemove + " has been removed!");
                    bookExists = true;
                }
            if (!bookExists)
                System.out.println("This book does not exist in the system. ");
        }
    }
}
