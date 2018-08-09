import java.io.Serializable;

public class Book implements Serializable {

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

    public String getBookName() {
        return this.bookName;
    }

    public String getAuthorName() {
        return this.authorName.getAuthorName();
    }

    public Author getAuthor() {
        return this.authorName;
    }

    public String getGenreName() {
        return this.genreName.getGenreName();
    }

    public Genre getGenre() {
        return this.genreName;
    }

    @Override
    public String toString() {
        return "Name: " + this.bookName + "\tAuthor: " + this.authorName + "\tGenre: " + this.genreName;
    }
}
