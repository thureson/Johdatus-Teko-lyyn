package fi.helsinki.cs.travelplanner;

import fi.helsinki.cs.tmc.edutestutils.Points;
import static junit.framework.Assert.*;
import org.junit.*;

@Points("TravelPlanner")
public class TravelPlannerTest {

    private TravelPlanner travelPlanner;
    private StopGraph graph;

    @Before
    public void setUp() {
        graph = new StopGraph("network.json");
        travelPlanner = new TravelPlanner();
    }

    @Test
    public void findRouteReturnsTheCorrectThing() {
        Stop start = graph.getStop("1250429");
        Stop goal = graph.getStop("1121480");
        State state = travelPlanner.search(start, goal);

        String[] correctAnswer = {"1121480", "1121438", "1220414", "1220416", "1220418",
            "1220420", "1220426", "1173416", "1173423", "1250425", "1250427", "1250429"};

        for (int i = 0; i < correctAnswer.length; i++) {
            if (state == null) {
                fail("The route you returned was too short. The list you returned was " + i +", stops long whereas the length of the shortest possible answer is: " + correctAnswer.length);
            }

            if (state.getStop() == null) {
                fail("The route you returned included a state that was null");
            }

            assertEquals(correctAnswer[i], state.getStop().getCode());
            state = state.getPrevious();
        }

        assertNull("The route you returned was longer than 12", state);

    }

}
