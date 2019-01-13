package com.truyenho.controller;

import com.truyenho.model.CalculatorModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("index");
    return modelAndView;
  }

  @PostMapping("/cal")
  public ModelAndView cal(@RequestParam("firstOpenrand") double firstOpenrand, @RequestParam("secondOpenrand") double secondOpenrand, @RequestParam("operator") char operator) {
    ModelAndView modelAndView = new ModelAndView("index");
    CalculatorModel calculatorModel = new CalculatorModel(firstOpenrand, secondOpenrand, operator);
    double result = calculate(calculatorModel.getFirstOperand(), calculatorModel.getSecondOperand(), calculatorModel.getOperator());
    String operatorSub = makeOperatorSub(operator);

    modelAndView.addObject("operator", operatorSub);
    modelAndView.addObject("result", result);
    return modelAndView;
  }

  private String makeOperatorSub(char operator) {
    switch (operator) {
      case '+':
        return "Addition";
      case '-':
        return "Subtraction";
      case '*':
        return "Multiplication";
      case '/':
        return "Division";
    }
    return "";
  }

  @GetMapping("/cal")
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView("index");
    return modelAndView;
  }


  private double calculate(double firstOperand, double secondOperand, char operator) {
    switch (operator) {
      case '+':
        return firstOperand + secondOperand;
      case '-':
        return firstOperand - secondOperand;
      case '*':
        return firstOperand * secondOperand;
      case '/':
        if (secondOperand != 0)
          return firstOperand / secondOperand;
        else
          throw new RuntimeException("Can't divide by zero");
      default:
        throw new RuntimeException("Invalid operation");
    }
  }
}
