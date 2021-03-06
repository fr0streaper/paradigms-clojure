package expression;

public class Xor extends BinaryOperator {
  public Xor(GenericExpression first, GenericExpression second) {
    super(first, second);
  }

  public int apply(int x, int y) {
    return x ^ y;
  }
}