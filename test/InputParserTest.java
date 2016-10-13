import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InputParserTest {
  @Test
  public void should_parse_input_and_construct_tuple() throws Exception {
    String json = "{\"states\":[\"q1\"], \"alphabets\":[\"1\"], \"initialState\":\"q1\", " +
      "\"finalStates\":[\"q1\"], \"transitions\":[[\"q1\", \"q1\", \"1\"]]}";

    Tuple actualTuple = new InputParser().parse(json);
    States q1 = new States("q1");
    States q2 = new States("q2");
    Transitions transitions = new Transitions();
    transitions.setTransition(q1, q1, "1");
    List<States> states = new ArrayList<States>() {{add(q1);}};
    ArrayList<String> alphabets = new ArrayList<String>() {{add("1");}};
    States initialState = q1;
    List<States> finalStates = new ArrayList<States>() {{add(q1);}};
    Tuple expectedTuple = new Tuple(states, alphabets, transitions, initialState, finalStates);

    Assert.assertEquals(expectedTuple, actualTuple);
  }
}