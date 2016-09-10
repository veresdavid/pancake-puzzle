package com.ai.david.algorithm.impl;

import com.ai.david.algorithm.SearchAlgorithm;
import com.ai.david.heuristic.Heuristic;
import com.ai.david.node.impl.PancakePuzzleNode;
import com.ai.david.operator.impl.PancakePuzzleOperator;
import com.ai.david.problem.impl.PancakePuzzleProblem;
import com.ai.david.state.impl.PancakePuzzleState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PancakePuzzleAStar extends SearchAlgorithm<PancakePuzzleOperator> {

  private PancakePuzzleProblem problem;
  private List<PancakePuzzleNode> open;
  private List<PancakePuzzleNode> closed;
  private Heuristic heuristic;

  public PancakePuzzleAStar(PancakePuzzleProblem problem, Heuristic heuristic) {

    this.problem = problem;
    this.heuristic = heuristic;
    open = new ArrayList<>();
    closed = new ArrayList<>();

    PancakePuzzleNode
        node =
        new PancakePuzzleNode(problem.getStart(), null, null,
            heuristic.heuristic(problem.getStart(), problem.getGoal()), 0, 0);
    open.add(node);

  }

  @Override
  public List<PancakePuzzleOperator> search() {

    while (!open.isEmpty()) {

      // pop the best node from queue
      PancakePuzzleNode current = null;
      for (PancakePuzzleNode node : open) {
        if (current == null || node.getHeuristic() < current.getHeuristic()) {
          current = node;
        }
      }
      open.remove(current);
      closed.add(current);

      // if the current node is goal, we have found a solution
      if (current.getState().equals(problem.getGoal())) {

        LinkedList<PancakePuzzleOperator> result = new LinkedList<>();

        PancakePuzzleNode tmp = current;
        while (tmp.getOperator() != null) {
          result.addFirst(tmp.getOperator());
          tmp = tmp.getParent();
        }

        return result;

      }

      // generate successors
      List<PancakePuzzleNode> neighbours = new ArrayList<>();
      PancakePuzzleState currentState = current.getState();

      for (PancakePuzzleOperator operator : problem.getOperators()) {

        if (operator.applicable(currentState)) {

          PancakePuzzleState newState = operator.apply(currentState);

          PancakePuzzleNode
              neighbour =
              new PancakePuzzleNode(newState, current, operator,
                  heuristic.heuristic(newState, problem.getGoal()), 1, current.getCost() + 1);

          neighbours.add(neighbour);

        }

      }

      int bestHeuristic = 0;
      for (PancakePuzzleNode neighbour : neighbours) {
        bestHeuristic =
            Math.max(bestHeuristic, neighbour.getHeuristic() - neighbour.getEdgeCostFromParent());
      }

      current.setHeuristic(Math.max(current.getHeuristic(), bestHeuristic));

      for (PancakePuzzleNode neighbour : neighbours) {

        int edgeCost = neighbour.getEdgeCostFromParent();

        PancakePuzzleNode openNode = null;
        for (PancakePuzzleNode node : open) {
          if (neighbour.getState().equals(node.getState())) {
            openNode = node;
            break;
          }
        }

        PancakePuzzleNode closedNode = null;
        for (PancakePuzzleNode node : closed) {
          if (neighbour.getState().equals(node.getState())) {
            closedNode = node;
            break;
          }
        }

        if (closedNode != null) {

          if (closedNode.getHeuristic() < bestHeuristic - edgeCost) {
            closedNode.setHeuristic(bestHeuristic - edgeCost);
          }

          if (current.getCost() + edgeCost < closedNode.getCost()) {
            closedNode.setParent(current);
            closedNode.setCost(current.getCost() + edgeCost);
            closedNode.setOperator(neighbour.getOperator());
            closed.remove(closedNode);
            open.add(closedNode);
          }

        } else if (openNode != null) {

          if (current.getCost() + edgeCost < openNode.getCost()) {
            openNode.setParent(current);
            openNode.setCost(current.getCost() + edgeCost);
            openNode.setOperator(neighbour.getOperator());
          }

          if (bestHeuristic - edgeCost > openNode.getHeuristic()) {
            openNode.setHeuristic(bestHeuristic - edgeCost);
          }

        } else {

          neighbour.setCost(current.getCost() + edgeCost);
          neighbour.setHeuristic(Math.max(neighbour.getHeuristic(), bestHeuristic - edgeCost));
          open.add(neighbour);

        }

      }

    }

    return null;

  }

}

