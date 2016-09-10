package com.ai.david.node;

import com.ai.david.operator.Operator;
import com.ai.david.state.State;

public abstract class Node<StateType extends State, OperatorType extends Operator> {

  private StateType state;
  private OperatorType operator;
  private int heuristic;
  private int cost;

  public StateType getState() {
    return state;
  }

  public void setState(StateType state) {
    this.state = state;
  }

  public OperatorType getOperator() {
    return operator;
  }

  public void setOperator(OperatorType operator) {
    this.operator = operator;
  }

  public int getHeuristic() {
    return heuristic;
  }

  public void setHeuristic(int heuristic) {
    this.heuristic = heuristic;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

}
