import java.io.Serializable;

public class Genre implements Serializable {

    private String genreName;

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return this.genreName;
    }

    @Override
    public String toString() {
        return this.genreName;
    }
}
