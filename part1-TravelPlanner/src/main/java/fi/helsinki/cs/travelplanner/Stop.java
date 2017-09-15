package fi.helsinki.cs.travelplanner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

/**
 * Danger! Don't edit this class!
 *
 * Contains the details of a stop and its neighbors
 */
public class Stop {

    /**
     * A unique identifier for the stop
     */
    private String code;

    /**
     * Stop's address
     */
    private String address;

    /**
     * Stop's name
     */
    private String name;

    /**
     * X-coordinate of the stop.
     */
    private int x;

    /**
     * Y-coordinate of the stop.
     */
    private int y;

    /**
     * Codes of neighboring stops
     */
    private HashMap<String, String[]> neighbors;

    private Collection<Stop> neighborStops;

    public Stop() {
        this.code = "";
        this.address = "";
        this.name = "";
        this.x = 0;
        this.y = 0;
        this.neighbors = new HashMap<String, String[]>();
    }

    public String toString() {
        return this.code + "(" + this.name + ")";
    }

    public String getCode() {
        return code;
    }

    public Collection<String> getNeighborStopCodes() {
        return this.neighbors.keySet();
    }

    /**
     * Returns all the neighbors for stops ie. the stops this stop is
     * directly connected to
     *
     * @return neighbors
     */
    public Collection<Stop> getNeighbors() {
        return this.neighborStops;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.code);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stop other = (Stop) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    public void setNeighbors(Collection<Stop> stops) {
        this.neighborStops = stops;
    }

}
