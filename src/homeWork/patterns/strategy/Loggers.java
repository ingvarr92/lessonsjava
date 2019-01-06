package homeWork.patterns.strategy;

public class Loggers {
    ILogger iLogger;

    public Loggers(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    public void setiLogger(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    public void write (String mes, String fileName){
        iLogger.write(mes, fileName);
    }

}
