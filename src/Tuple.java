import java.util.ArrayList;
import java.util.List;

class Tuple{
  private List<States> allStates;
  private ArrayList<String> alphabates;
  private Transitions transitions;
  private States initialState;
  private List<States> finalStates;

  Tuple(List<States> allStates, ArrayList<String> alphabates, Transitions transitions, States initialState, List<States> finalStates) {
    this.allStates = allStates;
    this.alphabates = alphabates;
    this.transitions = transitions;
    this.initialState = initialState;
    this.finalStates = finalStates;
  }

  ArrayList<String> getAlphabates() { return alphabates;}

  Transitions getTransitions() { return transitions; }

  States getInitiaslState() {
    return initialState;
  }

  List<States> getFinalStates() {
    return finalStates;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tuple tuple = (Tuple) o;
    return finalStates != null ? finalStates.equals(tuple.finalStates) : tuple.finalStates == null;

  }
}
