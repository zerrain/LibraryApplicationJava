public class Author {

    private String authorName;

    public Author() {

    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return this.authorName;
    }
}
