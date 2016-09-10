package com.ai.david.state.impl;

import com.ai.david.state.State;

import java.util.LinkedList;
import java.util.List;

public class PancakePuzzleState extends State {

  private LinkedList<Integer> pancakes;

  public PancakePuzzleState(int numberOfPancakes) {

    pancakes = new LinkedList<Integer>();

    for (int i = 1; i <= numberOfPancakes; i++) {
      pancakes.add(i);
    }

  }

  public PancakePuzzleState(List<Integer> pancakes) {

    this.pancakes = new LinkedList<Integer>(pancakes);

  }

  public LinkedList<Integer> getPancakes() {
    return pancakes;
  }

  public void setPancakes(LinkedList<Integer> pancakes) {
    this.pancakes = pancakes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PancakePuzzleState that = (PancakePuzzleState) o;

    return pancakes.equals(that.pancakes);

  }

  @Override
  public int hashCode() {
    return pancakes.hashCode();
  }

  @Override
  public String toString() {
    return "PancakePuzzleState{" +
        "pancakes=" + pancakes +
        '}';
  }

}
