package lesson7.annonimus;

import lesson6.calculator.Operation;

public class AnnonimysClass {
    public static void main(String[] args) {
        Calc calc = new Calc(3, 6);
        calc.summ(new Operation1() { // анонимный класс и класс описали и объект создали
            @Override
            public double apply(double var1, double var2) {
                return var1 + var2;
            }

        });
        calc.summ((var1,var2)-> var1 + var2);// то же самое что и выражение сверху Лямда функция
    }

}
