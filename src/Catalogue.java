import java.util.LinkedList;

public class Catalogue {

    private Library library;
    private LinkedList<Book> books = new LinkedList<Book>();
    private LinkedList<Genre> genres = new LinkedList<Genre>();
    private LinkedList<Author> authors = new LinkedList<Author>();

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

                    break;
                case '2':

                    break;
                case '3':

                    break;
                case '4':

                    break;
                default:
                    System.out.print("Please enter a valid input: ");
                    catalogueSelection();
                    break;
            }
        }

        library.mainMenu();
    }

    public void addBook() {
        System.out.print("Enter the book name: ");
        String bookName = Library.sc.nextLine();

        System.out.print("Enter the author: ");
        Author newAuthor = new Author(Library.sc.nextLine());
        authors.add(newAuthor);

        System.out.print("Enter the genre: ");
        Genre newGenre = new Genre(Library.sc.nextLine());

        Book newBook = new Book(bookName, newAuthor, newGenre);

        System.out.println("The book " + newBook + " was added to the booklist.");
    }

    public void removeBook() {

    }
}