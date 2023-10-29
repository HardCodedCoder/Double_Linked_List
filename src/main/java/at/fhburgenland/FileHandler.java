package at.fhburgenland;

import at.fhburgenland.interfaces.MyListADT;

import java.io.*;

public class FileHandler {

    public static MyListADT<Integer> readFile(String fileName) throws IOException,
                                                            IllegalArgumentException {
        MyListADT<Integer> myList = new MyList<Integer>();
        boolean first = true;
        Integer previousValue = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Integer number = Integer.parseInt(line);
                    if (first) {
                        myList.insertFirst(number);
                        first = false;
                    } else {
                        myList.insertAfter(number, previousValue);
                    }

                    previousValue = number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        return myList;
    }


    public static MyListADT<Integer> readFileSorted(String fileName) throws IOException,
                                                                IllegalArgumentException
    {
       MyListADT<Integer> result = readFile(fileName);
       result.sort();
       return result;
    }
}
