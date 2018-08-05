import java.util.LinkedList;
import java.util.Scanner;

public class Library {

    public Scanner sc = new Scanner(System.in);
    private Catalogue catalogue;
    private Patron patron;
    LinkedList<Patron> patrons = new LinkedList<>();

    public Library() {
        System.out.println("Welcome to the Library!");
        catalogue = new Catalogue();
    }

    public static void main(String[] args) {
        new Library().mainMenu();
    }

    private void mainMenu() {
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

        while (selection != 'x') {

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
                    System.out.println("Welcome to the administration menu!");
                    adminMenu();
                    break;
                case 'x':
                    System.exit(0);
                default:
                    System.out.print("Please enter a valid input: ");
                    mainSelection();
                    break;
            }
            mainMenu();
            mainSelection();
        }
    }

    private void adminMenu() {
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
                addPatron();
                break;
            case '2':
                removePatron();
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

    private void addPatron() {
        patrons.add(new Patron(sc.nextLine()));
    }

    private void removePatron() {
        if (patrons.isEmpty()) {
            System.out.println("There are no patrons in the system. ");
        }
        else {
            String patronToRemove = sc.nextLine();

            if (patrons.contains(patronToRemove))
                patrons.remove(patronToRemove);
            else
                System.out.println("This patron does not exist in the system. ");
        }
    }
}
