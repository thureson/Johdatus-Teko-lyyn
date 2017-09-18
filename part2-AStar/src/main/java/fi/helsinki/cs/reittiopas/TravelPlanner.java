package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logic.Stop;
import fi.helsinki.cs.reittiopas.logic.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import java.util.PriorityQueue;
import java.util.Set;

public class TravelPlanner {

    private StateComparator stateComparator;

    /**
     * Implement A*
     *
     */
    public State search(Stop start, Stop goal, int timeAteginning) {
        this.stateComparator = new StateComparator(goal);
        PriorityQueue<State> examinees = new PriorityQueue<>(stateComparator);
        State startState = new State(start, null, timeAteginning);
        Set<State> closed = new HashSet<>();
        examinees.add(startState);
        
        while (examinees.size() > 0){
            State temp = examinees.remove();
            if (temp.getStop() == goal){
                return temp;
            }
            closed.add(temp);
            Collection<Stop> nbsCollection = temp.getStop().getNeighbors();
            List<Stop> nbs = new ArrayList(nbsCollection);
            int time = 1;
            while ((temp.getCurrentTime()+time) % 10 != 0){
                time++;
            }
            for (int i = 0; i < nbs.size(); i++){
                Stop nb = nbs.get(i);
                State nbState = new State(nb, temp, temp.getCurrentTime()+time);
                if (closed.contains(nbState)){
                    continue;
                }
                if (!examinees.contains(nbState)){
                    examinees.add(nbState);
                }
            }
        }
        return null;
    }
}
