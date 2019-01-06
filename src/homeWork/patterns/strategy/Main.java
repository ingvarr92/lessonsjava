package homeWork.patterns.strategy;

public class Main {
    public static void main(String[] args) {
//        ILogger logger = new FileLogger();
//        logger.write();
        Loggers loggers = new Loggers(new TimeFileLogger());
            loggers.write("Сообщение","f2");
            loggers.setiLogger(new ConsoleLogger());
            loggers.write("Сообщения", "1");
            loggers.setiLogger(new FileLogger());
            loggers.write("Сообщение", "FD");
    }
}
