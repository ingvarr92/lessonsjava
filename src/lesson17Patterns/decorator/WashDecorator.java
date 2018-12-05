package lesson17Patterns.decorator;

public class WashDecorator extends ServiceDecorator{

    public WashDecorator(IService service){
        super(service);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1000;
    }

    @Override
    public String getDesciption() {
        return super.getDesciption() + " and Wash";
    }
}
