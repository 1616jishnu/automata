import java.util.HashMap;
import java.util.Map;

class Transitions {

  private Map<States, Map<String, States>> transitions = new HashMap<>();
  void setTransition(States state1, States state2, String alphabet) {
    transitions.putIfAbsent(state1, new HashMap<>());
    transitions.get(state1).put(alphabet, state2);
  }

  States process(States state, String alphabet) {
    if(transitions.containsKey(state)){
      return transitions.get(state).get(alphabet);
    }
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Transitions transition = (Transitions) o;

    return this.transitions != null ? this.transitions.equals(transition.transitions) : transition.transitions == null;

  }

  @Override
  public int hashCode() {
    return transitions != null ? transitions.hashCode() : 0;
  }
}
