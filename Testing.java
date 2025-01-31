import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testing {
    public static void testLocationKeyValue(){
        long startTime = System.nanoTime();

        System.out.println("Beginning testing of LocationKeyValue...");

        DataHandling paris = new DataHandling("Paris");

        paris.addLocationKeyValue("Population",2103000);
        paris.addLocationKeyValue("Area",40.7);
        paris.addLocationKeyValue("Currency","Euro");

        System.out.println("\n--- Print All Key Value pairs ---\n");
        paris.printKeyValues();

        System.out.println("\n--- Remove Currency ---\n");
        paris.removeLocationKeyValue("Currency");
        paris.printKeyValues();

        System.out.println("\n--- Add Currency and Remove Area ---\n");
        paris.addLocationKeyValue("Currency","Euro");
        paris.removeLocationKeyValue("Area");
        paris.printKeyValues();

        System.out.println("\n--- Remove Nonexistent Key ---\n");
        boolean test = paris.removeLocationKeyValue("NonexistentKey");
        System.out.println("Removed nonexistent key: " + test);

        System.out.println("\n--- Bulk Location Test ---\n");
        String[] names = {"Paris", "London", "New York", "Tokyo"};
        Object[][] info = {
                {"Population", 2103000, "Area", 40.7, "Currency", "Euro"},
                {"Population", 8866000, "Area", 607, "Currency", "Pound"},
                {"Population", 8258000, "Area", 302.6, "Currency", "Dollar"},
                {"Population", 14180000, "Area", 5233.87, "Currency", "Yen"}
        };
        List<DataHandling> locations = new ArrayList<>();
        for (int  i = 0; i < names.length; ++i){
            DataHandling location = new DataHandling(names[i]);
            for (int j = 0; j < info[i].length; j += 2) {
                String key = (String) info[i][j];
                Object value = info[i][j + 1];
                location.addLocationKeyValue(key, value);
            }
            locations.add(location);
        }
        for (DataHandling location : locations) {
            location.printKeyValues();
            System.out.println();
        }

        System.out.println("\n--- Print All Key Value pairs ---\n");
        paris.printKeyValues();

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000000000.0 + " Seconds");
    }
    public static void testLocationKeyValueExtraBulk(){
        long startTime = System.nanoTime();

        List<DataHandling> locations = new ArrayList<>();
        for (int i = 1; i <= 2000000; i++) {
            DataHandling location = new DataHandling("Location " + i);

            location.addLocationKeyValue("Population", i * 100);
            location.addLocationKeyValue("Area", i * 5);
            location.addLocationKeyValue("Currency", "Currency " + i);

            locations.add(location);
        }
        for (DataHandling location : locations){
            location.printKeyValues();
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000000000.0 + " Seconds");
    }

    public static void testFileCreation(){
        dataStorage.initializeFiles();


        System.out.println("Beginning testing of LocationKeyValue...");

        DataHandling paris = new DataHandling("Paris");

        paris.addLocationKeyValue("Population",2103000);
        paris.addLocationKeyValue("Area",40.7);
        paris.addLocationKeyValue("Currency","Euro");

        System.out.println("\n--- Print All Key Value pairs ---\n");
        paris.printKeyValues();

        dataStorage.writeToFile(paris.getLocationData(),paris.getActivitiesData());

        Scanner temp = new Scanner(System.in);
        System.out.println("Would you like to terminate the test and delete the file? (Y/N)");
        if (temp.nextLine().toUpperCase().equals("Y")){
            dataStorage.deleteFile();
        } else {
            System.out.println("Program terminated.");
        }
    }
}