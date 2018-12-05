package lesson17Patterns.decorator;

public class Main {
    public static void main(String[] args) {
        IService service = new Service2 (new WashDecorator(new TO()));

        System.out.println(service.getPrice());
        System.out.println(service.getDesciption());

        IService service1 = new WashDecorator(new TO());
        System.out.println(service1.getPrice());
        System.out.println(service1.getDesciption());

    }
}
