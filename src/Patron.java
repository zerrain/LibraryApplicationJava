public class Patron {

    private String name;

    public Patron (String name){
        this.name = name;
    }

    public void showRecord() {

    }

    public void showFavourites() {

    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                '}';
    }
}
