package oct_nov.lesson6.calculator;

public class Divide extends Operation{
    public Divide(int a, int b) {
        super(a, b);
    }

    @Override
    public void execute() {
        if (getB() == 0){
            System.out.println("На ноль делить нельзя. Придумайте что нибудть получше.");
        }
        else {
            float af = getA();
            float bf = getB();
            //float i = af/bf;
            System.out.println(af/bf);
        }
    }


}
