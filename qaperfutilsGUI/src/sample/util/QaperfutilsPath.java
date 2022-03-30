package sample.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QaperfutilsPath {
    private String path;

    public String readPropertyPath() {
        Properties prop = new Properties();
        String fileName = "GUIconfig.properties";
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty("QAPERFUTILS_PATH");

    }
}
