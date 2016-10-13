import org.junit.Assert;
import org.junit.Test;

public class TransitionsTest {
  @Test
  public void should_return_next_state() throws Exception {
    States q1 = new States("q1");
    States q2 = new States("q2");
    Transitions transitions = new Transitions();
    transitions.setTransition(q1, q2, "1");
    States nextState = transitions.process(q1, "1");
    Assert.assertEquals(q2, nextState);
  }

  @Test
  public void should_return_null_when_no_next_state_will_present() throws Exception {
    States q1 = new States("q1");
    States q2 = new States("q2");
    Transitions transitions = new Transitions();
    transitions.setTransition(q1, q2, "1");
    States nextState = transitions.process(q2, "1");
    Assert.assertEquals(null, nextState);
  }
}