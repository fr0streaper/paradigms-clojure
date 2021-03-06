package expression;

import expression.exceptions.EvaluationException;
import expression.operations.TypeOperator;

public class Count<T> extends UnaryOperator<T> {
  public Count(TripleExpression<T> x, TypeOperator<T> op) {
    super(x, op);
  }

  public T apply(T x) throws EvaluationException {
    return operator.count(x);
  }
}