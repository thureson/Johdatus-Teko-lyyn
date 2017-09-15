package fi.helsinki.cs.travelplanner;

public class State {

    /**
     * Previous state -- the state from which we got to this point
     */
    private State previous;
    private Stop stop;


    public State(Stop stop, State previous) {
        this.stop = stop;
        this.previous = previous;
    }

    public State getPrevious() {
        return previous;
    }

    public Stop getStop() {
        return stop;
    }
}
