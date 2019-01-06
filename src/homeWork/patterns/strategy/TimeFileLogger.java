package homeWork.patterns.strategy;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TimeFileLogger implements ILogger {

    String mes = "Сообщение";
    @Override
    public void write(String mes, String fileName) {
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(mes +" " +new Date()+ '\n');
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
