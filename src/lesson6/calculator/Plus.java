package lesson6.calculator;

public class Plus extends Operation{
    public Plus(int a, int b) {
        super(a, b);
    }

    @Override
    public void execute() {
        System.out.println(getA() + getB());
    }


}
