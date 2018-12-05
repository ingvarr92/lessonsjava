package oct_nov.lesson6.calculator;

public class Multiplication extends Operation{
    public Multiplication(int a, int b) {
        super(a, b);
    }

    @Override
    public void execute() {
        System.out.println(getA()*getB());
    }
}
