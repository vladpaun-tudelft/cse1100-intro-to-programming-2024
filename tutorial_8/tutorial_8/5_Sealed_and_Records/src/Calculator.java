import expression.*;

public final class Calculator {

    /**
     * Calculates the value of a given expression.
     *
     * @param e The expression to calculate
     * @return The result
     */
    public static int calculate(Expression e) {
        return switch(e) {
            case null -> throw new NullPointerException();
            case Constant(int value) -> value;
            case Add(Expression left, Expression right) -> calculate(left) + calculate(right);
            case Subtract(Expression left, Expression right) -> calculate(left) - calculate(right);
            case Multiply(Expression left, Expression right) -> calculate(left) * calculate(right);
        };
    }

}
