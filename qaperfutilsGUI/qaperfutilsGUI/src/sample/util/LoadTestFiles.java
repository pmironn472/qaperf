package sample.util;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadTestFiles {

    private QaperfutilsPath qaperfutilsPath = new QaperfutilsPath();
    private BufferedReader readerTestFilePteOne;

    public String loadFileTestCfg(String lookingFor, String regex) {
        File testFile = new File (qaperfutilsPath.readPropertyPath() + "/orange/etc/ztospte1/test.cfg");
        String findText = "";
        String text = "";
        try {
            readerTestFilePteOne = new BufferedReader(new FileReader(
                    testFile));
            String line = readerTestFilePteOne.readLine();
            while (line != null) {
                if (line.contains(lookingFor)) {
                    text = new String(line.getBytes());
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(text);
                    if (matcher.find()) {
                        findText = matcher.group(0);
                    }
                }
                line = readerTestFilePteOne.readLine();
            }
            readerTestFilePteOne.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return findText;
    }
    
}
