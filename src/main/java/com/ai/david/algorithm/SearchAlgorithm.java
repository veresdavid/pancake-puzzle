package com.ai.david.algorithm;

import com.ai.david.operator.Operator;

import java.util.List;

public abstract class SearchAlgorithm<OperatorType extends Operator> {

  public abstract List<OperatorType> search();

}
