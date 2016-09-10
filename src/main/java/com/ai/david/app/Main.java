package com.ai.david.app;

import com.ai.david.algorithm.impl.PancakePuzzleAStar;
import com.ai.david.heuristic.impl.PancakePuzzleManhattanHeuristic;
import com.ai.david.operator.impl.PancakePuzzleOperator;
import com.ai.david.problem.impl.PancakePuzzleProblem;
import com.ai.david.state.impl.PancakePuzzleState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    PancakePuzzleState start = new PancakePuzzleState(Arrays.asList(3, 2, 5, 1, 6, 4, 7));
    PancakePuzzleState goal = new PancakePuzzleState(7);

    List<PancakePuzzleOperator> operators = new ArrayList<>();
    for (int i = 2; i <= 7; i++) {
      operators.add(new PancakePuzzleOperator(i));
    }

    PancakePuzzleProblem problem = new PancakePuzzleProblem(start, goal, operators);

    PancakePuzzleAStar
        ppas =
        new PancakePuzzleAStar(problem, new PancakePuzzleManhattanHeuristic());

    List<PancakePuzzleOperator> result = ppas.search();

    System.out.println("Megoldás:");
    for (PancakePuzzleOperator operator : result) {
      System.out.print(operator.getNumberOfPancakesToReverse() + " ");
    }
    System.out.println();

  }

}
