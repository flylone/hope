package com.wsq.hope.domain.biz;


public interface MathOperation {

    int operation(int a, int b);

    MathOperation add = (a, b) -> a + b;
    MathOperation sub = (a, b) -> a - b;
    MathOperation mul = (a, b) -> a * b;
    MathOperation div = (a, b) -> a / b;

    static void operate(int a, int b, MathOperation operation) {
        System.out.println(a + getType(operation) + b + "=" + operation.operation(a, b));
    }

    static String getType(MathOperation operation) {
        if (add == operation) {
            return "+";
        } else if (sub == operation) {
            return "-";
        } else if (mul == operation) {
            return "*";
        } else {
            return "/";
        }
    }

    static void main(String[] args) {
        operate(10, 15, add);
        operate(10, 15, sub);
        operate(10, 15, mul);
        operate(10, 15, div);
    }
}
