package lesson26Logged;

import javafx.scene.input.DataFormat;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

public class Logged {

    // создание логгера
    private static final Logger LOGGER = Logger.getLogger(Logged.class.getName());

    static {

        // настройка уровня событий для логирования
        LOGGER.setLevel(Level.ALL);
    }

    public static void main(String[] args) {


        LOGGER.info("Started with: " + Arrays.toString(args));
        try {
            int result = 3 / 0;
        } catch (Exception e) {
            LOGGER.severe("Fatal error: " + e.getMessage());
        }


    }
}

    class LoggerFile{
        private static final Logger LOGGER = Logger.getLogger(LoggerFile.class.getName());


        static {
            try {
                LOGGER.addHandler(new FileHandler("logger.log.xml"));

                FileHandler fileHandler = new FileHandler("logger2.log");
                fileHandler.setFormatter(new MyFormatter());



                LOGGER.addHandler(fileHandler);


            } catch (IOException e) {
                LOGGER.warning("Не удалось создать файл.");
            }
        }


        public static void main(String[] args) {


            LOGGER.info("Started with: " + Arrays.toString(args));


            try {
                int result = 3 / 0;
            } catch (Exception e) {
                LOGGER.severe("Fatal error: " + e.getMessage());
            }
        }
    }
class MyFormatter extends Formatter {
    private final static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Override
    public String format(LogRecord record) {
        // свой формат записи логов в файл
        StringBuilder stringBuilder = new StringBuilder();
       //record.getMillis();
        stringBuilder.append("[").append(formatTime(record.getMillis())).append("]");
        stringBuilder.append("[").append(record.getLevel()).append("]");
        stringBuilder.append("\n");
        stringBuilder.append(record.getMessage());



        return stringBuilder.toString();
    }

    private String formatTime (long mls){
        return dateFormat.get().format(new Date(mls));
    }
}



