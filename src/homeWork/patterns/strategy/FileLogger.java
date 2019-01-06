package homeWork.patterns.strategy;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {

    @Override
    public void write(String mes, String fileName) {
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(mes + '\n');
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
