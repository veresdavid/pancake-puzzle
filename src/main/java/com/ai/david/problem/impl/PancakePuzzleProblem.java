package com.ai.david.problem.impl;

import com.ai.david.operator.impl.PancakePuzzleOperator;
import com.ai.david.problem.Problem;
import com.ai.david.state.impl.PancakePuzzleState;

import java.util.List;

public class PancakePuzzleProblem extends Problem<PancakePuzzleState, PancakePuzzleOperator> {

  private PancakePuzzleState start;
  private PancakePuzzleState goal;
  private List<PancakePuzzleOperator> operators;

  public PancakePuzzleProblem(PancakePuzzleState start,
                              PancakePuzzleState goal,
                              List<PancakePuzzleOperator> operators) {
    this.start = start;
    this.goal = goal;
    this.operators = operators;
  }

  public PancakePuzzleState getStart() {
    return start;
  }

  public void setStart(PancakePuzzleState start) {
    this.start = start;
  }

  public PancakePuzzleState getGoal() {
    return goal;
  }

  public void setGoal(PancakePuzzleState goal) {
    this.goal = goal;
  }

  public List<PancakePuzzleOperator> getOperators() {
    return operators;
  }

  public void setOperators(List<PancakePuzzleOperator> operators) {
    this.operators = operators;
  }

}
