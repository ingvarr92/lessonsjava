package homeWork.patterns.strategy;

public class ConsoleLogger implements ILogger {
    @Override
    public void write(String mes, String fileName) {
        System.out.println(mes);
    }
}
