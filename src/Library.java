import java.util.LinkedList;
import java.util.Scanner;

public class Library {

    public static final Scanner sc = new Scanner(System.in);
    private Catalogue catalogue;
    private static LinkedList<Patron> patrons = new LinkedList<>();

    public Library() {
        System.out.println("Welcome to the Library!");
        catalogue = new Catalogue(this);
    }

    public static void main(String[] args) {
        new Library().mainMenu();
    }

    public void mainMenu() {
        System.out.println("\nPlease make a selection from the menu: ");
        System.out.println("\n1. Explore the catalogue");
        System.out.println("2. View your patron record");
        System.out.println("3. Show your favourite books");
        System.out.println("4. Enter Admin mode");
        System.out.println("X. Exit the system");
        System.out.print("\nEnter a choice: ");

        mainSelection();
    }

    private void mainSelection() {

        char selection = sc.nextLine().toLowerCase().charAt(0);

        while (selection != 'x') {

            switch (selection) {
                case '1':
                    catalogue.catalogueMenu();
                    break;
                case '2':
                    //TODO patron.showRecord();
                    break;
                case '3':
                    //TODO patron.showFavourites();
                    break;
                case '4':
                    System.out.println("Welcome to the administration menu!");
                    adminMenu();
                default:
                    System.out.print("Please enter a valid input: ");
                    mainSelection();
                    break;
            }
            mainMenu();
            mainSelection();
        }

        System.exit(0);
    }

    private void adminMenu() {
        System.out.println("\nPlease make a selection from the menu: ");
        System.out.println("\n1. Add a patron");
        System.out.println("2. Remove a patron");
        System.out.println("3. Add a book to the catalogue");
        System.out.println("4. Remove a book from the catalogue");
        System.out.println("R. Return to the previous menu");
        System.out.print("\nEnter a choice: ");

        adminSelection();
    }

    private void adminSelection() {
        char selection = sc.nextLine().toLowerCase().charAt(0);

        while (selection != 'r') {
            switch (selection) {
                case '1':
                    addPatron();
                    break;
                case '2':
                    removePatron();
                    break;
                case '3':
                    catalogue.addBook();
                    break;
                case '4':
                    catalogue.removeBook();
                    break;
                default:
                    System.out.print("Please enter a valid input: ");
                    break;
            }
            adminMenu();
        }

        mainMenu();
    }

    private void addPatron() {
        System.out.print("Enter the patron name to be added: ");
        Patron newPatron = new Patron(sc.nextLine());
        patrons.add(newPatron);


        System.out.println(newPatron + " added");
    }

    private void removePatron() {
        boolean patronExists = false;
        if (patrons.isEmpty()) {
            System.out.println("There are no patrons in the system. ");
        }
        else {
            System.out.print("Enter the patron name to be removed: ");
            String patronToRemove = sc.nextLine();

            for (Patron patron : patrons)
                if (patron.getName().equals(patronToRemove)) {
                    patrons.remove(patron);
                    System.out.println("Patron " + patronToRemove + " has been removed!");
                    patronExists = true;
                }

            if (!patronExists)
                System.out.println("This patron does not exist in the system. ");
        }
    }


}
