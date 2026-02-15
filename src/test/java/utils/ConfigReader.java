package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public Properties init_prop(){
        prop = new Properties();
        try {
           // FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getProperties(String key){
        if (prop == null){
            init_prop();
        }
        String value = prop.getProperty(key);
        if (value == null){
            throw new RuntimeException("Property with key"+ key+ "not found");
        }
        return value;
    }
}
