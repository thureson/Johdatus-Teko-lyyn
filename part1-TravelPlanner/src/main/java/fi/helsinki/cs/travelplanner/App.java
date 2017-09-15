package fi.helsinki.cs.travelplanner;

public class App {

    /**
     *
     * Implement class TravelPlanner so that when searching for a route between
     * two stops, it returns a route as a linked list where the returned State
     * object points to the destination stop.
     *
     * For example when calling the travelplanner with starting stop
     * "1250429(Metsolantie)" and destination "1121480(Urheilutalo)"
     * it will return a linked list of the following form:
     *
     * 1121480(Urheilutalo)[GOAL] -> 1121438(Brahenkatu) -> 1220414(Roineentie)
     * -> 1220416(Hattulantie) -> 1220418(Rautalammintie) ->
     * 1220420(Mäkelänrinne) -> 1220426(Uintikeskus) -> 1173416(Pyöräilystadion)
     * -> 1173423(Koskelantie) -> 1250425(Kimmontie) -> 1250427(Käpylänaukio) ->
     * 1250429(Metsolantie)[START] -> null
     *
     * The unit tests only test this route but your algorithm should work
     * correctly for other paths too.
     *
     * @param args args
     */
    public static void main(String[] args) {

        StopGraph stopGraph = new StopGraph("network.json");
        TravelPlanner travelPlanner = new TravelPlanner();
        Stop start = stopGraph.getStop("1250429");
        Stop goal = stopGraph.getStop("1121480");
        State state = travelPlanner.search(start, goal);
        while (state != null) {
            System.out.println(state.getStop());
            state = state.getPrevious();
        }
    }
}
