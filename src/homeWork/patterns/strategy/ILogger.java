package homeWork.patterns.strategy;


//Самостоятельно изучить паттерн Стратегия. Реализовать Logger.
//        1. Интерфейс ILogger с мотодом write()
//        2. Реализовать три стратегии:
//        ConsoleLogger - выводит сообщения в консоль
//        FileLogger - записывает сообщение в файл
//        TimeFileLogger - записывает сообщение в файл + текущее время
//        3. Реализовать классы, исползующие эти стратегии.
//        Запись в файл должна работать!

public interface ILogger {
    void write(String mes, String fileName);
}
