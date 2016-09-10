package com.ai.david.heuristic.impl;

import com.ai.david.heuristic.Heuristic;
import com.ai.david.state.impl.PancakePuzzleState;

import java.util.List;

public class PancakePuzzleManhattanHeuristic implements Heuristic<PancakePuzzleState> {

  @Override
  public int heuristic(PancakePuzzleState state, PancakePuzzleState goal) {

    int heuristic = 0;

    List<Integer> statePancakes = state.getPancakes();
    List<Integer> goalPancakes = goal.getPancakes();

    for (int i = 0; i < statePancakes.size(); i++) {
      if (statePancakes.get(i) != goalPancakes.get(i)) {
        heuristic++;
      }
    }

    return heuristic;

  }

}
