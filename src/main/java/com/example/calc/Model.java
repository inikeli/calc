package com.example.calc;

public class Model {
    public long sum(long a, long b, String operation){
        switch (operation) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                if (b == 0){
                    return 0;
                }
                return a/b;
        }
        System.out.println("Неизвестный оператор"+operation);
        return 0;
    }
}
