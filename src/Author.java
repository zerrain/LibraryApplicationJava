import java.io.Serializable;

public class Author implements Serializable {

    private String authorName;

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    @Override
    public String toString() {
        return this.authorName;
    }
}
