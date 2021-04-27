package edu.gcit.todo_9;

public class Calculator {
    public enum operator{ADD,SUB,MUL,DIV};

    public double add(double OperandOne,double OperandTwo){
        return OperandOne + OperandTwo;
    }
    public double sub(double OperandOne,double OperandTwo){
        return OperandOne - OperandTwo;
    }
    public double mul(double OperandOne,double OperandTwo){
        return OperandOne * OperandTwo;
    }
    public double div(double OperandOne,double OperandTwo){
        return OperandOne / OperandTwo;
    }
}
