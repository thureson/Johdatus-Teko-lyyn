package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logic.Stop;
import fi.helsinki.cs.reittiopas.logic.State;
import java.util.Comparator;

public class StateComparator implements Comparator<State> {

    private final Stop goal;

    public StateComparator(Stop goalStop) {
        this.goal = goalStop;
    }

    /**
     * Implement this
     *
     * @param stop
     * @return Estimated remaining time
     */
    public double heuristic(Stop stop) {
        double distanceX = Math.abs(goal.getX() - stop.getX());
        double distanceY = Math.abs(goal.getY() - stop.getY());
        double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
        
        return distance/260;
    }

    /**
     * Implement this
     *
     * @param t1
     * @param t2
     * @return result of the comparison
     */
    @Override
    public int compare(State t1, State t2) {
        double t1H = heuristic(t1.getStop());
        double t2H = heuristic(t2.getStop());
        
        if (t1H > t2H){
            return 1;
        } else if (t1H < t2H){
            return -1;
        }
        return 0;
    }

}
