import java.util.LinkedList;
import java.util.Scanner;

public class Library {

    public static final Scanner sc = new Scanner(System.in);
    private Catalogue catalogue;
    private static LinkedList<Patron> patrons = new LinkedList<>();
    private static Patron selectedPatron;

    public Library() {
        System.out.println("Welcome to the Library!");
        catalogue = new Catalogue(this);
    }

    public static void main(String[] args) {
        new Library().mainMenu();
    }

    public void mainMenu() {
        System.out.println("\nPlease make a selection from the menu: ");
        System.out.println("\n1. Select the patron");
        System.out.println("2. Explore the catalogue");
        System.out.println("3. View the patron's borrowed books");
        System.out.println("4. View the patron's favourite books");
        System.out.println("5. Enter Admin mode");
        System.out.println("X. Exit the system");
        System.out.print("\nEnter a choice: ");

        mainSelection();
    }

    private void mainSelection() {

        char selection = sc.nextLine().toLowerCase().charAt(0);

        while (selection != 'x') {

            switch (selection) {
                case '1':
                    selectPatron();
                    break;
                case '2':
                    catalogue.catalogueMenu();
                    break;
                case '3':
                    showPatronBorrowed();
                    break;
                case '4':
                    showPatronFavourites();
                    break;
                case '5':
                    System.out.println("Welcome to the administration menu!");
                    adminMenu();
                default:
                    System.out.print("Please enter a valid input: ");
                    mainSelection();
                    break;
            }
            mainMenu();
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

    private void selectPatron() {
        if (patrons.isEmpty())
            System.out.println("There are no patrons in the system.");
        else {
            System.out.println("Select a patron from the list below: ");
            for (Patron patron : patrons)
                System.out.println(patron);
            boolean patronSelected = false;
            System.out.print("Enter your choice: ");
            String chosenPatron = sc.nextLine();
            for (Patron patron : patrons) {
                if (patron.getName().equalsIgnoreCase(chosenPatron)) {
                    selectedPatron = patron;
                    System.out.println("The patron " + chosenPatron + " is now selected");
                    patronSelected = true;
                    break;
                }
            }
            if (!patronSelected)
                System.out.println("The patron " + chosenPatron + " does not exist in the system.");
        }
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
        } else {
            System.out.print("Enter the patron name to be removed: ");
            String patronToRemove = sc.nextLine();
            for (Patron patron : patrons)
                if (patron.getName().equalsIgnoreCase(patronToRemove)) {
                    patrons.remove(patron);
                    System.out.println("Patron " + patronToRemove + " has been removed!");
                    patronExists = true;
                }
            if (!patronExists)
                System.out.println("This patron does not exist in the system. ");
        }
    }

    private void showPatronBorrowed() {
        if (selectedPatron == null)
            System.out.println("No patron has been selected");
        else
            selectedPatron.showBorrowed();
    }

    private void showPatronFavourites() {
        if (selectedPatron == null)
            System.out.println("No patron has been selected");
        else
            selectedPatron.showFavourites();
    }

    public static Patron getSelectedPatron() {
        return selectedPatron;
    }

}
