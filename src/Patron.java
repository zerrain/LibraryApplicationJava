import java.io.Serializable;
import java.util.LinkedList;

public class Patron implements Serializable {

    private String name;
    private LinkedList<Book> borrowed = new LinkedList<>();
    private LinkedList<Book> favourites = new LinkedList<>();

    public Patron() {
    }

    public Patron(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        borrowed.add(book);
        System.out.println("The book " + book + " is now borrowed by the patron " + name);
    }

    public void returnBook(Book book) {
        borrowed.remove(book);
        System.out.println("The book " + book + " has been returned by the patron " + name);
    }

    public void favouriteBook(Book book) {
        favourites.add(book);
        System.out.println("The book " + book + " is now favourited by the patron " + name);
    }

    public LinkedList<Book> getBorrowed() {
        return borrowed;
    }

    public LinkedList<Book> getFavourites() {
        return favourites;
    }

    public void showBorrowed() {
        if (borrowed.isEmpty())
            System.out.println("The patron " + name + " has no borrowed books");
        else
            for (Book book : borrowed)
                System.out.println(book);
    }

    public void showFavourites() {
        if (favourites.isEmpty())
            System.out.println("The patron " + name + " has no favourite books");
        else
            for (Book book : favourites)
                System.out.println(book);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
