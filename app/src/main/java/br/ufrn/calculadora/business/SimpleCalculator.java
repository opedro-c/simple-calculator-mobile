package br.ufrn.calculadora.business;

public class SimpleCalculator {

    private Double n1 = null;
    private Double n2 = 0.0;
    private String operation;
    private Boolean newNumber = false;

    public Double typeNumber(Double number) {
        if (newNumber) {
            n1 = n2;
            newNumber = false;
            n2 = number;
        } else {
            n2 = (n2 == 0.0) ? number : Double.parseDouble(String.valueOf(Math.round(n2)).concat(String.valueOf(Math.round(number))));
        }
        return n2;
    }

    public Double setOperation(String operation) {
        System.out.println(operation);
        this.operation = operation;
        newNumber = true;
        System.out.println(this);
        if (!newNumber && n1 != null) {
            calculate();
        }
        return n2;
    }

    public Double calculate() {
        Double result = null;
        switch (operation) {
            case "X":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
        }
        n2 = result;
        newNumber = true;
        return result;
    }

    public Double clear() {
        n1 = null;
        n2 = 0.0;
        operation = "";
        newNumber = true;
        return 0.0;
    }

    public Double del() {
        String s = String.valueOf(Math.round(n2));
        n2 = Double.parseDouble((s.length() > 1) ? s.substring(0, s.length() - 1) : "0");
        return n2;
    }

    @Override
    public String toString() {
        return "SimpleCalculator{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", operation='" + operation + '\'' +
                ", newNumber=" + newNumber +
                '}';
    }
}
