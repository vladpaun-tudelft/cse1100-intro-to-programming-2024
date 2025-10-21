package expression;

public record Add(Expression left, Expression right) implements Expression {}