import java.io.*;
import java.util.LinkedList;

public class Catalogue implements Serializable {

    private Library library;
    private static LinkedList<Book> availableBooks = new LinkedList<>();
    private static LinkedList<Book> borrowedBooks = new LinkedList<>();
    private static LinkedList<Book> books = new LinkedList<>();
    private static LinkedList<Genre> genres = new LinkedList<>();
    private static LinkedList<Author> authors = new LinkedList<>();
    private ObjectInputStream oisAvailableBooks;
    private ObjectInputStream oisBorrowedBooks;
    private ObjectInputStream oisBooks;
    private ObjectInputStream oisGenres;
    private ObjectInputStream oisAuthors;
    private ObjectOutputStream ousAvailableBooks;
    private ObjectOutputStream ousBorrowedBooks;
    private ObjectOutputStream ousBooks;
    private ObjectOutputStream ousGenres;
    private ObjectOutputStream ousAuthors;

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
        System.out.println("9. Favourite a book");
        System.out.println("R. Return to previous menu");
        System.out.print("\nEnter a choice: ");

        catalogueSelection();
    }

    private void catalogueSelection() {

        char selection = ' ';

        try {
            selection = Library.sc.nextLine().toLowerCase().charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.print("Please enter a valid input: ");
            catalogueMenu();
        }

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
                    borrowBook();
                    break;
                case '8':
                    returnBook();
                    break;
                case '9':
                    favouriteBook();
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
        if (books.isEmpty())
            System.out.println("There are no books in the system");
        else
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
            String selectedGenre = Library.sc.nextLine();
            for (Book book : books)
                if (book.getGenreName().equalsIgnoreCase(selectedGenre))
                    System.out.println(book);
        }
    }

    private void displayAuthors() {
        for (Author author : authors)
            System.out.println(author);
    }

    private void displayBooksByAuthor() {
        if (authors.isEmpty())
            System.out.println("There are no authors in the systen");
        else {
            System.out.print("Enter an author: ");
            String selectedAuthor = Library.sc.nextLine();
            for (Book book : books)
                if (book.getAuthorName().equalsIgnoreCase(selectedAuthor))
                    System.out.println(book);
        }
    }

    private void borrowBook() {
        if (Library.getSelectedPatron() == null)
            System.out.println("No patron has been selected");
        else if (availableBooks.isEmpty())
            System.out.println("There are no available books to borrow");
        else {
            System.out.println("Select the book to borrowed by the patron " + Library.getSelectedPatron().getName());
            for (Book book : availableBooks)
                System.out.println(book);
            System.out.print("Enter the book name: ");
            String selectedBook = Library.sc.nextLine();
            for (Book book : availableBooks)
                if (book.getBookName().equalsIgnoreCase(selectedBook)) {
                    availableBooks.remove(book);
                    borrowedBooks.add(book);
                    Library.getSelectedPatron().borrowBook(book);
                    library.writeToFile();
                }
        }
    }

    private void returnBook() {
        if (Library.getSelectedPatron() == null)
            System.out.println("No patron has been selected");
        else if (Library.getSelectedPatron().getBorrowed().isEmpty())
            System.out.println("The patron " + Library.getSelectedPatron().getName() + " has no borrowed books to return");
        else {
            System.out.println("Select the book to be returned by the patron " + Library.getSelectedPatron().getName());
            for (Book book : Library.getSelectedPatron().getBorrowed())
                System.out.println(book);
            System.out.print("Enter the book name: ");
            String selectedBook = Library.sc.nextLine();
            for (Book book : Library.getSelectedPatron().getBorrowed())
                if (book.getBookName().equalsIgnoreCase(selectedBook)) {
                    borrowedBooks.remove(book);
                    availableBooks.add(book);
                    Library.getSelectedPatron().returnBook(book);
                    library.writeToFile();
                }
        }
    }

    private void favouriteBook() {
        if (Library.getSelectedPatron() == null)
            System.out.println("No patron has been selected");
        else if (books.isEmpty())
            System.out.println("There are no books in the system available to favourite");
        else {
            System.out.println("Select the book to be favourited by the patron " + Library.getSelectedPatron().getName());
            for (Book book : books)
                System.out.println(book);
            System.out.print("Enter the book name: ");
            String selectedBook = Library.sc.nextLine();
            for (Book book : books)
                if (book.getBookName().equalsIgnoreCase(selectedBook)) {
                    Library.getSelectedPatron().favouriteBook(book);
                    library.writeToFile();
                }
        }
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
        library.writeToFile();

        System.out.println("The book " + newBook + " was added to the booklist.");
    }

    public void removeBook() {
        boolean bookExists = false;
        if (availableBooks.isEmpty()) {
            System.out.println("There are no available books in the system. ");
        } else {
            System.out.println("The current list of available books are: ");
            for (Book book : availableBooks)
                System.out.println(book);
            System.out.print("Enter the book name to be removed: ");
            String bookToRemove = Library.sc.nextLine();

            for (Book book : availableBooks)
                if (book.getBookName().equalsIgnoreCase(bookToRemove)) {
                    books.remove(book);
                    availableBooks.remove(book);
                    authors.remove(book.getAuthor());
                    genres.remove(book.getGenre());
                    library.writeToFile();
                    System.out.println("Book " + bookToRemove + " has been removed!");
                    bookExists = true;
                }
            if (!bookExists)
                System.out.println("This book does not exist in the system. ");
        }
    }

    public void readCatalogueFromFile() throws IOException{

        ObjectInputStream[] inputStreams = {oisAuthors, oisGenres, oisGenres, oisBorrowedBooks, oisBooks};
        String[] fileNames = {"authors.ser", "genres.ser", "availablebooks.ser", "borrowedbooks.ser", "books.ser"};
        LinkedList[] linkedLists = {authors, genres, availableBooks, borrowedBooks, books};

        for (int i = 0; i < inputStreams.length; i++) {

            try {
                inputStreams[i] = new ObjectInputStream(new FileInputStream(fileNames[i]));
            } catch (Exception e) {
            }
            try {
                linkedLists[i] = (LinkedList) inputStreams[i].readObject();
            } catch (Exception e) {
                new File(fileNames[i]).createNewFile();
            }
        }
    }

    public void writeCatalogueToFile() {
        ObjectOutputStream[] outputStreams = {ousAuthors, ousGenres, ousAvailableBooks, ousBorrowedBooks, ousBooks};
        String[] fileNames = {"authors.ser", "genres.ser", "availablebooks.ser", "borrowedbooks.ser", "books.ser"};
        LinkedList[] linkedLists = {authors, genres, availableBooks, borrowedBooks, books};

        for (int i = 0; i < outputStreams.length; i++) {

            try {
                outputStreams[i] = new ObjectOutputStream(new FileOutputStream(fileNames[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                outputStreams[i].writeObject(linkedLists[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
