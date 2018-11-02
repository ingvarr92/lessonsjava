package lesson6.calculator;

public class Minus extends Operation {
    public Minus(int a, int b) {
        super(a, b);
    }

    @Override
    public void execute() {
        System.out.println(getA() - getB());
    }


}
