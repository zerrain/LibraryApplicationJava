import java.util.LinkedList;
import java.util.Scanner;

public class Library {

    public Scanner sc = new Scanner(System.in);
    private Catalogue catalogue;
    private Patron patron;
    LinkedList<Patron> patrons = new LinkedList<>();

    public Library() {
        catalogue = new Catalogue();
    }

    public static void main(String[] args) {
        new Library().mainMenu();
    }

    private void mainMenu() {
        System.out.println("Welcome to the Library!");
        System.out.println("Please make a selection from the menu: ");
        System.out.println("\n1. Explore the catalogue");
        System.out.println("2. View your patron record");
        System.out.println("3. Show your favourite books");
        System.out.println("4. Enter Admin mode");
        System.out.println("X. Exit the system");
        System.out.print("Enter a choice: ");

        mainSelection();
    }

    private void mainSelection() {

        char selection = sc.nextLine().toLowerCase().charAt(0);

        switch (selection) {
            case '1':
                catalogue.catalogueMenu();
                break;
            case '2':
                patron.showRecord();
                break;
            case '3':
                patron.showFavourites();
                break;
            case '4':
                adminMenu();
                break;
            case 'x':
                System.exit(0);
            default:
                System.out.print("Please enter a valid input: ");
                mainSelection();
                break;
        }
    }

    private void adminMenu() {
        System.out.println("Welcome to the administration menu!");
        System.out.println("Please make a selection from the menu: ");
        System.out.println("\n1. Add a patron");
        System.out.println("2. Remove a patron");
        System.out.println("3. Add a book to the catalogue");
        System.out.println("4. Remove a book from the catalogue");
        System.out.println("R. Return to the previous menu");
        System.out.print("Enter a choice: ");

        adminSelection();
    }

    private void adminSelection() {
        char selection = sc.nextLine().toLowerCase().charAt(0);

        switch (selection) {
            case '1':
                patrons.add(new Patron(sc.nextLine()));
                break;
            case '2':
                patron.showRecord();
                break;
            case '3':
                patron.showFavourites();
                break;
            case '4':
                adminMenu();
                break;
            case 'x':
                System.exit(0);
            default:
                System.out.print("Please enter a valid input: ");
                mainSelection();
                break;
        }
    }

}
