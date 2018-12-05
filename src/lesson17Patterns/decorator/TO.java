package lesson17Patterns.decorator;

public class TO implements IService{



    @Override
    public double getPrice() {
        return 3000;
    }

    @Override
    public String getDesciption() {
        return "TO";
    }
}
