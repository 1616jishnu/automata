import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class DfaTest {
  Transitions transitions;
  States q1;
  States q2;
  States q3;
  States q4;
  States q5;
  States q6;
  @Before
  public void setUp() throws Exception {
    q1 = new States("q1");
    q2 = new States("q2");
    q3 = new States("q3");
    q4 = new States("q4");
    q5 = new States("q5");
    q6 = new States("q6");
    transitions = new Transitions();
  }

  @org.junit.Test
  public void should_return_true_when_DFA_accepts_string() throws Exception {
    transitions.setTransition(q1, q2, "0");
    List<States> states = new ArrayList<States>(){{add(q1);add(q2);}};
    ArrayList<String> alphabets = new ArrayList<String>(){{add("0"); add("1");}};
    States initialState = q1;
    List<States> finalStates = new ArrayList<States>() {{
      add(q2);
    }};
    Tuple tuple = new Tuple(states, alphabets, transitions, initialState, finalStates);
    Dfa dfa = new Dfa(tuple);
    ArrayList<String> inputString = new ArrayList<String>(){{add("0");}};
    boolean result = dfa.process(inputString);
    Assert.assertTrue(result);
  }

  @org.junit.Test
  public void should_return_flase_when_DFA_accepts_even_numbers_as_binary() throws Exception {
    transitions.setTransition(q1, q2, "1");
    transitions.setTransition(q1, q1, "0");
    transitions.setTransition(q2, q1, "1");
    transitions.setTransition(q2, q2, "0");

    ArrayList<States> states = new ArrayList<States>(){{add(q1);add(q2);}};
    ArrayList<String> alphabets = new ArrayList<String>(){{add("1");add("0");}};
    States initialState = q1;
    List<States> finalStates = new ArrayList<States>() {{add(q2);}};
    Tuple tuple = new Tuple(states, alphabets, transitions, initialState, finalStates);
    Dfa dfa = new Dfa(tuple);
    ArrayList<String> inputString = new ArrayList<String>(){{add("1");add("1");add("1");add("1");}};
    boolean result = dfa.process(inputString);
    Assert.assertFalse(result);
  }

  @org.junit.Test
  public void should_return_true_when_DFA_accepts_string_starts_with_one_and_contains_substring_001() throws Exception {
    transitions.setTransition(q1, q2, "1");
    transitions.setTransition(q1, q6, "0");
    transitions.setTransition(q2, q2, "1");
    transitions.setTransition(q2, q3, "0");
    transitions.setTransition(q3, q2, "1");
    transitions.setTransition(q3, q4, "0");
    transitions.setTransition(q4, q4, "0");
    transitions.setTransition(q4, q5, "1");
    transitions.setTransition(q5, q5, "1");
    transitions.setTransition(q5, q5, "0");
    transitions.setTransition(q6, q6, "0");
    transitions.setTransition(q6, q6, "1");


    List<States> states = new ArrayList<States>(){{add(q1);add(q2);add(q3);add(q4);add(q5);add(q6);}};
    ArrayList<String> alphabets = new ArrayList<String>(){{add("1");add("0");}};
    States initialState = q1;
    List<States> finalStates = new ArrayList<States>() {{
      add(q5);
    }};
    Tuple tuple = new Tuple(states, alphabets, transitions, initialState, finalStates);
    Dfa dfa = new Dfa(tuple);

    ArrayList<String> inputString = new ArrayList<String>(){{add("1");add("0");add("0");add("1");add("0");}};
    boolean result = dfa.process(inputString);
    Assert.assertTrue(result);
  }

}