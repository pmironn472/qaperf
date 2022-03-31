package sample.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ConfigFile {
    public void createConfigFile(){
        File myObj = new File("GUIconfig.properties");
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeConfigFile(String path){
        try {
            FileWriter myWriter = new FileWriter("GUIconfig.properties");
            myWriter.write("QAPERFUTILS_PATH=" + path);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
