package at.fhburgenland;

import java.util.List;
import java.util.Scanner;

public class ConsoleIOHandler {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Displays a menu to the console and returns the choice of the user.
     * @param title The title of the menu.
     * @param options The options of the menu.
     * @return The choice of the user.
     */
    public int displayMenu(String title, List<String> options) {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        int choice;
        while (true) {
            try {
                System.out.print("Bitte wählen Sie eine Option: ");
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= options.size()) {
                    break;
                } else {
                    System.out.println("Ungültige Option. Bitte geben Sie eine gültige Option ein.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }

        return choice;
    }
}
