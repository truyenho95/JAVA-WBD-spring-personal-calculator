package com.truyenho.model;

public class CalculatorModel {
  private double firstOperand;
  private double secondOperand;
  private char operator;

  public CalculatorModel() {
  }

  public CalculatorModel(double firstOperand, double secondOperand, char operator) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
    this.operator = operator;
  }

  public double getFirstOperand() {
    return firstOperand;
  }

  public void setFirstOperand(double firstOperand) {
    this.firstOperand = firstOperand;
  }

  public double getSecondOperand() {
    return secondOperand;
  }

  public void setSecondOperand(double secondOperand) {
    this.secondOperand = secondOperand;
  }

  public char getOperator() {
    return operator;
  }

  public void setOperator(char operator) {
    this.operator = operator;
  }
}
