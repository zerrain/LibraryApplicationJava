public class Book {

    private Author authorName;
    private Genre genreName;
    private String bookName;

    public Book() {

    }

    public Book(String bookName, Author authorName, Genre genreName) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Name: " + this.bookName + "\nAuthor: " + this.authorName + "\nGenre: " + this.genreName;
    }
}
