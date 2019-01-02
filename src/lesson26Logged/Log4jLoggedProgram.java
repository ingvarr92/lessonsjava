package lesson26Logged;
//import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Arrays;

public class Log4jLoggedProgram {

    //Log4jProgram

    //уровни
//      FATAL
//      ERROR
//      WARN
//      INFO
//
//
//
//private static final Logger LOGGER = Logger.getLogger(Log4jLoggedProgram.class);
//
//    public static void main(String[] args) {
//        LOGGER.info("Started with: " + Arrays.toString(args));
//        try {
//            int result = 3 / 0;
//        } catch (Exception e) {
//            LOGGER.error("Fatal error: " + e.getMessage());
//        }
//    }



}


// slf4j


class Slf4jLoggerProgram{
    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jLoggerProgram.class);

    public static void main(String[] args) {
        LOGGER.info("Started with: " + Arrays.toString(args));
        try {
            int result = 3 / 0;
        } catch (Exception e) {
            LOGGER.error("Fatal error: " + e.getMessage());
        }
    }


}
