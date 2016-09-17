package com.ai.david.app;

import com.ai.david.algorithm.impl.PancakePuzzleAStar;
import com.ai.david.heuristic.impl.PancakePuzzleManhattanHeuristic;
import com.ai.david.operator.impl.PancakePuzzleOperator;
import com.ai.david.problem.impl.PancakePuzzleProblem;
import com.ai.david.state.impl.PancakePuzzleState;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int numberOfProblems = 0;

    while (scanner.hasNext()) {

      numberOfProblems++;

      int numberOfPancakes;
      List<Integer> startPancakes = new ArrayList<>();
      List<Integer> goalPancakes = new ArrayList<>();

      numberOfPancakes = scanner.nextInt();

      for (int i = 0; i < numberOfPancakes; i++) {
        startPancakes.add(scanner.nextInt());
      }

      for (int i = 0; i < numberOfPancakes; i++) {
        goalPancakes.add(scanner.nextInt());
      }

      PancakePuzzleState start = new PancakePuzzleState(startPancakes);
      PancakePuzzleState goal = new PancakePuzzleState(goalPancakes);

      List<PancakePuzzleOperator> operators = new ArrayList<>();
      for (int i = 2; i <= numberOfPancakes; i++) {
        operators.add(new PancakePuzzleOperator(i));
      }

      PancakePuzzleProblem problem = new PancakePuzzleProblem(start, goal, operators);

      PancakePuzzleAStar
          pancakePuzzleAStar =
          new PancakePuzzleAStar(problem, new PancakePuzzleManhattanHeuristic());

      List<PancakePuzzleOperator> solution = pancakePuzzleAStar.search();

      System.out.println("PROBLEM #" + numberOfProblems + ":");

      for (PancakePuzzleOperator operator : solution) {
        System.out.print(operator.getNumberOfPancakesToReverse() + " ");
      }
      System.out.println();

      System.out.println("-------------------------------");

    }

    scanner.close();

  }

}
