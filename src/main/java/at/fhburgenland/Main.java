package at.fhburgenland;

import at.fhburgenland.interfaces.MyListADT;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    // Was ist eine double Linked List? Theorie

    // Ein Beispiel theoretisch (Draw.IO)

    // Code erklären.
    public static void main(String[] args) {
        MyListADT<Integer> myList = null;
        try {
            myList = FileHandler.readFile(Paths.get("src/main/resources/numbers.txt").toAbsolutePath().toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.print("Unsorted List: ");
        myList.printList();

        try {
            myList = FileHandler.readFileSorted(Paths.get("src/main/resources/numbers.txt").toAbsolutePath().toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.print("Sorted List: ");
        myList.printList();
    }
}
