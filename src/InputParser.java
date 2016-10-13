import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class InputParser {
  Tuple parse(String jsonText) throws ParseException {
    JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonText);
    List<States> states = ((List<String>) jsonObject.get("states")).stream().map(States::new).collect(Collectors.toList());
    JSONArray alphabets = (JSONArray) jsonObject.get("alphabets");
    States initialState = new States((String) jsonObject.get("initialState"));
    List<States> finalStates = ((List<String>) jsonObject.get("finalStates")).stream().map(States::new).collect(Collectors.toList());

    JSONArray transitions = (JSONArray) jsonObject.get("transitions");
    Transitions allTransitions = mapToTransitions(transitions);
    return new Tuple(states, alphabets, allTransitions, initialState, finalStates);
  }

  private Transitions mapToTransitions(JSONArray transitions) {
    Transitions allTransitions = new Transitions();
    for(Object transition: transitions){
      JSONArray eachTransition = (JSONArray) transition;
      allTransitions.setTransition(new States((String) eachTransition.get(0)), new States((String) eachTransition.get(1)), (String) eachTransition.get(2));
    }
    return allTransitions;
  }
}
