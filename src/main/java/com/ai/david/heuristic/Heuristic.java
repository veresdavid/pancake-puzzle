package com.ai.david.heuristic;

import com.ai.david.state.State;

@FunctionalInterface
public interface Heuristic<StateType extends State> {

  int heuristic(StateType state, StateType goal);

}
