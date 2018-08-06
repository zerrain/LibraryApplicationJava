import java.util.LinkedList;

public class Patron {

    private String name;
    private LinkedList<Book> borrowed = new LinkedList<Book>();
    private LinkedList<Book> favourites = new LinkedList<Book>();

    public Patron() {

    }

    public Patron(String name) {
        this.name = name;
    }

    public void showRecord() {
        for (Book book : borrowed)
            System.out.println(book);
    }

    public void showFavourites() {
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
