public class Genre {

    private String genreName;

    public Genre() {

    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return this.genreName;
    }
}
