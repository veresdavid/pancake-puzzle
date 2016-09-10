package com.ai.david.node.impl;

import com.ai.david.node.Node;
import com.ai.david.operator.impl.PancakePuzzleOperator;
import com.ai.david.state.impl.PancakePuzzleState;

public class PancakePuzzleNode extends Node<PancakePuzzleState, PancakePuzzleOperator> {

  private PancakePuzzleNode parent;
  private int edgeCostFromParent;

  public PancakePuzzleNode(PancakePuzzleState state, PancakePuzzleNode parent,
                           PancakePuzzleOperator operator, int heuristic, int edgeCostFromParent,
                           int cost) {
    setState(state);
    setParent(parent);
    setOperator(operator);
    setHeuristic(heuristic);
    this.edgeCostFromParent = edgeCostFromParent;
    setCost(cost);
  }

  public int getEdgeCostFromParent() {
    return edgeCostFromParent;
  }

  public void setEdgeCostFromParent(int edgeCostFromParent) {
    this.edgeCostFromParent = edgeCostFromParent;
  }

  public PancakePuzzleNode getParent() {
    return parent;
  }

  public void setParent(PancakePuzzleNode parent) {
    this.parent = parent;
  }

}
