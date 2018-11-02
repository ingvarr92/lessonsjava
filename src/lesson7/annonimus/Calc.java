package lesson7.annonimus;

import lesson6.calculator.Operation;

public class Calc {
    int a;
    int b;

    public Calc(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public double summ (Operation1 operation1){
        return operation1.apply (a,b);

    }


}
