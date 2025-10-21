package expression;

public sealed interface Expression permits Add, Constant, Multiply, Subtract {
}
