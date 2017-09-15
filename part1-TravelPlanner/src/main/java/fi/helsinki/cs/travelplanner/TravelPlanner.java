package fi.helsinki.cs.travelplanner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TravelPlanner {

    /**
     * Implement breadth-first search. Return the answer as a linked list
     * where the first node points to the goal and each node has a stop
     * and is linked to the previous node in the path.
     * The last node in the list is the starting stop and its previous node is null.
     *
     * You can get the neighboring stops by calling the getNeighbors()-method on a stop.
     *
     * @param start Code of the start stop
     * @param goal Code of the goal stop
     * @return A linked list of States from goal to start
     */
    public State search(Stop start, Stop goal) {
        // Implement breadth-first search
        HashSet<Stop> s = new HashSet<>();
        Queue<State> q = new LinkedList();
        
        State state = null;
        q.add(new State(start, null));
        s.add(start);
        
        while (q.size() != 0){
            State temp = q.remove();
            state = new State(temp.getStop(), temp.getPrevious());
            if (state.getStop() == goal){
                return state;
            }
            Collection<Stop> n = state.getStop().getNeighbors();
            ArrayList<Stop> nbrs = new ArrayList<>(n);
            for (int i = 0; i < nbrs.size(); i++){
                Stop t = nbrs.get(i);
                if (!s.contains(t)){
                    State st = new State(t, state);
                    s.add(t);
                    q.add(st);
                }
            }
        }
        return null;
    }
}
