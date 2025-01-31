import java.util.ArrayList;
import java.lang.Math;
import java.io.File;
import java.io.IOException;

public class Scoring <K,V>{
    private ArrayList<KeyValue> preferences;

    public Scoring() {
        this.preferences = new ArrayList<>();

//        Initialize general specific key values for scoring and storage
//        Climate
        KeyValue temperature = new KeyValue("temperature", null);
        KeyValue humidity = new KeyValue("humidity",null);

//        Entertainment
        KeyValue diningQuality = new KeyValue("diningQuality",null);
        KeyValue parksAmt = new KeyValue("parksAmt",null);
        KeyValue beaches = new KeyValue("beaches",null);

//        Location
        KeyValue populationSize = new KeyValue("populationSize",null);
        KeyValue populationDensity = new KeyValue("populationDensity",null);
        KeyValue walkabilityScore = new KeyValue("walkabilityScore",null);
        KeyValue airportAccess = new KeyValue("airportAccess",null);
        KeyValue crimeRate = new KeyValue("crimeRate",null);
        KeyValue corruption = new KeyValue("corruption",null);
    }

    public void updatePreferences(){
        
    }

    public void generalize(){}
    public void score(){
        
    }
    public void addPreference(K key, V value){
        KeyValue temp = new KeyValue(key, value);
    }

    public void removePreference(K key, V value){
        KeyValue temp = new KeyValue(key, value);
    }
}