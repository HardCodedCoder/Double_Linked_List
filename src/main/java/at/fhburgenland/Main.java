package at.fhburgenland;

import at.fhburgenland.interfaces.MyListADT;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConsoleIOHandler ioHandler = new ConsoleIOHandler();
        MyListADT<Integer> myList = null;

        boolean quit = false;

        while (!quit) {
            List<String> mainMenuOptions = List.of("Einlesen unsortiert", "Einlesen sortiert", "Beenden");
            int choice = ioHandler.displayMenu("Double Linked List Main Menu", mainMenuOptions);
            switch (choice) {
                case 1 -> {
                    try {
                        myList = FileHandler.readFile(Paths.get("src/main/resources/numbers.txt").toAbsolutePath().toString());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    System.out.print("Unsorted List: ");
                    myList.printList();
                }
                case 2 -> {
                    try {
                        myList = FileHandler.readFileSorted(Paths.get("src/main/resources/numbers.txt").toAbsolutePath().toString());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    System.out.print("Sorted List: ");
                    myList.printList();
                }
                case 3 -> quit = true;
            }
        }
    }
}
