import java.util.Scanner;

public class Library {

    public Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
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


    }

    private char mainSelection (char selection) {
        return sc.nextLine().charAt(0);
    }

}
