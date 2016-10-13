import java.util.ArrayList;
import java.util.List;

class Dfa{

  private Tuple tuple;

  Dfa(Tuple tuple) {
    this.tuple = tuple;
  }
  boolean process(ArrayList<String> inputString){
    ArrayList<String> alphabets = tuple.getAlphabates();
    Transitions transitions = tuple.getTransitions();
    States nextState = tuple.getInitiaslState();
    List<States> finalStates = tuple.getFinalStates();

    for (String alphabet : inputString) {
      nextState = transitions.process(nextState, alphabet);
    }
    return finalStates.contains(nextState);
  }

}
