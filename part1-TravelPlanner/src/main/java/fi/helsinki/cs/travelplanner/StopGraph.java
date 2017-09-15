package fi.helsinki.cs.travelplanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A class that represents a stop graph and can read its information from a JSON-file
 */
public class StopGraph {

    /**
     * All stops as an array
     *
     * Note that the graph is directed
     *
     */
    private final Stop[] stops;

    /**
     * Contains the same objects as the stops array.
     * You can use this to look up the stops by their code
     *
     */
    private HashMap<String, Stop> stopMap;

    /**
     * Constructor. Reads a JSON json file that describes the graph
     * and constructs a graph based on it.
     *
     * @param filePath path to the file (includes the name)
     */
    public StopGraph(String filePath) {
        JsonArray psArr = readJSON(filePath);
        Gson gson = new Gson();
        this.stops = new Stop[psArr.size()];
        for (int i = 0; i < psArr.size(); i++) {
            this.stops[i] = gson.fromJson(psArr.get(i), Stop.class);
        }
        stopMap = new HashMap<String, Stop>();
        for (Stop p : stops) {
            this.stopMap.put(p.getCode(), p);
        }

        for (Stop p : stops) {
            Collection<Stop> naapurit = new ArrayList<>();
            for (String s : p.getNeighborStopCodes()) {
                naapurit.add(stopMap.get(s));
            }
            p.setNeighbors(naapurit);
        }
    }

    /**
     * Returns the Stop object that corresponds to the specified code
     */
    public Stop getStop(String code) {
        return stopMap.get(code);
    }

    /**
     * Return all the stops in this graph
     */
    public Stop[] getStopList() {
        return stops.clone();
    }

    private String readFileAsString(String filePath) {
        File file = new File(this.getClass().getClassLoader().getResource(filePath).getFile());
        byte[] buffer;
        try {
            buffer = Files.readAllBytes(file.toPath());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return new String(buffer);
    }

    private JsonArray readJSON(String filePath) {
        JsonParser parser = new JsonParser();
        String json = "";

        json = readFileAsString(filePath);

        JsonArray arr = parser.parse(json).getAsJsonArray();
        return arr;
    }
}
