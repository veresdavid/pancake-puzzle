package com.ai.david.operator;

import com.ai.david.state.State;

public abstract class Operator<StateType extends State> {

  public abstract boolean applicable(StateType state);

  public abstract StateType apply(StateType state);

}
