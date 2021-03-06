import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DFAIntegrationTest {
  @Test
  public void should_return_true_when_a_String_is_accepted_by_dfa() throws Exception{
    String json = "{\"states\":[\"q1\", \"q2\",\"q3\", \"q4\",\"q5\"], \"alphabets\":[\"1\", \"0\"], \"initialState\":\"q1\", " +
      "\"finalStates\":[\"q4\"], \"transitions\":[[\"q1\", \"q2\", \"1\"],[\"q1\", \"q2\", \"0\"],[\"q2\", \"q3\", \"1\"],[\"q2\", \"q3\", \"0\"]" +
      ",[\"q3\", \"q4\", \"1\"],[\"q3\", \"q5\", \"0\"],[\"q4\", \"q4\", \"1\"],[\"q4\", \"q4\", \"0\"],[\"q5\", \"q5\", \"1\"],[\"q5\", \"q5\", \"0\"]]}";

    Tuple tuple = new InputParser().parse(json);
    ArrayList<String> inputString = new ArrayList<String>(){{add("1"); add("0"); add("1"); add("0");add("1"); add("0");}};
    boolean result = new Dfa(tuple).process(inputString);

    Assert.assertTrue(result);
  }
}
