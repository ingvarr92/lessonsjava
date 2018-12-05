package lesson17Patterns.Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private static final File CONFIG = new File("app.properties");
    private static AppConfig instance;
    private final Properties properties;
    private AppConfig(){
        properties = new Properties();

        try {
            properties.load(new FileInputStream(CONFIG));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public static AppConfig getConfig(){
        if (instance == null){
            instance = new AppConfig();
        }
        return instance;
    }

    public String getParam(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
     // использование

        AppConfig config = new AppConfig();
        System.out.println(config.getParam("db.login"));
    }




}
