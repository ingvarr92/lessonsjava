package lesson17Patterns.decorator;

public class ServiceDecorator implements IService{

    private IService iService;
    public ServiceDecorator(IService iService){
        this.iService = iService;
    }


    @Override
    public double getPrice() {
        return this.iService.getPrice();
    }

    @Override
    public String getDesciption() {
        return this.iService.getDesciption();
    }
}
