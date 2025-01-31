import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class DataHandling {
    private ArrayList<KeyValue> locationData;
    private ArrayList<KeyValue> activitiesData;
    private String name;
    public DataHandling(String name) {
        locationData = new ArrayList<>();
        this.name = name;
        activitiesData = new ArrayList<>();
    }
    public void printKeyValues() {
        System.out.println("Location: " + getName());
        for (KeyValue pair : locationData){
            System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        }
    }
    public <K,V> void addLocationKeyValue(K key, V value){
        locationData.add(new KeyValue(key,value));
    }
    public <K> boolean removeLocationKeyValue(K key){
        for (int i = 0; i < locationData.size(); ++i){
            if (locationData.get(i).getKey().equals(key)){
                locationData.remove(i);
                return true;
            }
        }
        System.out.println("There was an error removing this key.");
        return false;
    }
    public <K,V> V getLocationKeyValue(K key){
        for (int i = 0; i < locationData.size(); ++i){
            if (locationData.get(i).getKey().equals(key)){
                return (V)(locationData.get(i).getValue());
            }
        }
        System.out.println("There was an error removing this key.");
        return null;
    }
    public <K,V> void addActivitiesKeyValue(K key, V value){
        activitiesData.add(new KeyValue(key,value));
    }
    public <K> boolean removeActivitiesLocationKeyValue(K key){
        for (int i = 0; i < activitiesData.size(); ++i){
            if (activitiesData.get(i).getKey().equals(key)){
                activitiesData.remove(i);
                return true;
            }
        }
        System.out.println("There was an error removing this key.");
        return false;
    }
    public String getName() {
        return name;
    }
    public ArrayList<KeyValue> getLocationData() {
        return locationData;
    }
    public ArrayList<KeyValue> getActivitiesData() {
        return activitiesData;
    }


    public void setName(String name) {
        this.name = name;
    }
}

class KeyValue <K,V>{
    private K key;
    private V value;
    public <Thing> KeyValue(){
        this.key = null;
        this.value = null;
    }

    public <Thing> KeyValue(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    public void setValue(V value){
        this.value = value;
    }
}
//beginning of Scoring class
class Scoring <K,V>{
    private ArrayList<KeyValue> preferences;

    public Scoring() {
        this.preferences = new ArrayList<>();

//        Initialize general specific key values for scoring and storage
//        Climate
        KeyValue temperature = new KeyValue();
        KeyValue humidity = new KeyValue();

//        Entertainment
        KeyValue diningQuality = new KeyValue();
        KeyValue parksAmt = new KeyValue();
        KeyValue beaches = new KeyValue();

//        Location
        KeyValue populationSize = new KeyValue();
        KeyValue populationDensity = new KeyValue();
        KeyValue walkabilityScore = new KeyValue();
        KeyValue airportAccess = new KeyValue();
        KeyValue crimeRate = new KeyValue();
        KeyValue corruption = new KeyValue();
    }
    public void generalize(){}
    public void addPreference(K key, V value){
        KeyValue temp = new KeyValue(key, value);
    }

    public void removePreference(K key, V value){
        KeyValue temp = new KeyValue(key, value);
    }
}

class dataStorage {
    private static File locationDataFile;
    private static File activitiesDataFile;
    static boolean fileExists = false;

    public static void initializeFiles() {
        try {
            locationDataFile = new File("Location_Data_File.txt");
            if (locationDataFile.createNewFile()) {
                System.out.println("File created: " + locationDataFile.getName());
                System.out.println("System path: " + locationDataFile.getAbsolutePath());
                fileExists = true;
            } else {
                System.out.println("File already exists.");
                fileExists = true;
            }

            activitiesDataFile = new File("Activities_Data_File.txt");
            if (locationDataFile.createNewFile()) {
                System.out.println("File created: " + locationDataFile.getName());
                System.out.println("System path: " + locationDataFile.getAbsolutePath());
                fileExists = true;
            } else {
                System.out.println("File already exists.");
                fileExists = true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void deleteFile(){
        if (locationDataFile.delete()){
            System.out.println("File was deleted successfully...Ending process...");
        } else {
            System.out.println("File was not deleted successfully...Ending process...");
        }
    }
    public static void writeToFile(ArrayList<KeyValue> locationArray, ArrayList<KeyValue> activitiesArray){
//        Writes Location Data
        try{
            FileWriter locationWriter = new FileWriter("Location_Data_File.txt");
            for (int i = 0; i < locationArray.size(); ++i){
                KeyValue current = locationArray.get(i);
                if (i == locationArray.size()-1){
                    locationWriter.append(current.getKey() + " " + current.getValue());
                } else if(i == 0) {
                    locationWriter.append(locationArray.get(0).getKey() + " " + locationArray.get(0).getValue() + ",");
                } else {
                    locationWriter.append(current.getKey() + " " + current.getValue() + ",");
                }
            }
            locationWriter.close();
        } catch (IOException e){
            System.out.println("There was a data storage error when writing to the Location file.");
            e.printStackTrace();
        }
//        Writes Activities Data
        try{
            FileWriter activitiesWriter = new FileWriter("Activities_Data_File.txt");
            for (int i = 0; i < activitiesArray.size(); ++i){
                KeyValue current = activitiesArray.get(i);
                if(i != activitiesArray.size()-1) {
                    activitiesWriter.write(current.getKey() + " " + current.getValue() + ",");
                } else {
                    activitiesWriter.write(current.getKey() + " " + current.getValue());
                }
            }
        } catch (IOException e){
            System.out.println("There was a data storage error when writing to the Activities file.");
            e.printStackTrace();
        }
    }
}