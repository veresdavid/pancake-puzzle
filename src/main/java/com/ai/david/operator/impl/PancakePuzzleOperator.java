package com.ai.david.operator.impl;

import com.ai.david.operator.Operator;
import com.ai.david.state.impl.PancakePuzzleState;

import java.util.LinkedList;

public class PancakePuzzleOperator extends Operator<PancakePuzzleState> {

  private int numberOfPancakesToReverse;

  public PancakePuzzleOperator(int numberOfPancakesToReverse) {
    this.numberOfPancakesToReverse = numberOfPancakesToReverse;
  }

  @Override
  public boolean applicable(PancakePuzzleState state) {
    return true;
  }

  @Override
  public PancakePuzzleState apply(PancakePuzzleState state) {

    // the stack of pancakes before the reverse
    LinkedList<Integer> oldPancakes = state.getPancakes();

    // the new stack of pancakes
    LinkedList<Integer> newPancakes = new LinkedList<>();

    // reverse the top pancakes
    for (int i = numberOfPancakesToReverse - 1; i >= 0; i--) {
      newPancakes.add(oldPancakes.get(i));
    }

    // place the remaining pancakes in the list
    for (int i = numberOfPancakesToReverse; i < oldPancakes.size(); i++) {
      newPancakes.add(oldPancakes.get(i));
    }

    // the new state
    PancakePuzzleState newPancakePuzzleState = new PancakePuzzleState(newPancakes);

    return newPancakePuzzleState;

  }

  public int getNumberOfPancakesToReverse() {
    return numberOfPancakesToReverse;
  }

  public void setNumberOfPancakesToReverse(int numberOfPancakesToReverse) {
    this.numberOfPancakesToReverse = numberOfPancakesToReverse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PancakePuzzleOperator that = (PancakePuzzleOperator) o;

    return numberOfPancakesToReverse == that.numberOfPancakesToReverse;

  }

  @Override
  public int hashCode() {
    return numberOfPancakesToReverse;
  }

  @Override
  public String toString() {
    return "PancakePuzzleOperator{" +
        "numberOfPancakesToReverse=" + numberOfPancakesToReverse +
        '}';
  }

}
