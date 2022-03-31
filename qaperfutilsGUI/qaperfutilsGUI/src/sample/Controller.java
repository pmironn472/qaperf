package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.util.ConfigFile;
import sample.util.LoadTestFiles;
import sample.util.QaperfutilsPath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public static final String QAPERFUTILS_PATH = "";

    @FXML
    private Button loadQaperfutils, backButton, pteOneButton, pteTwoButton, saveButton;

    @FXML
    private TextField qaperfutilsPathField;


    public void loadQaperfutilScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene/loadQaperfutilsPath.fxml")));

            Stage window = (Stage) loadQaperfutils.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene/startApp.fxml")));

            Stage window = (Stage) backButton.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pteOneScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene/pteOneScene.fxml")));

            Stage window = (Stage) pteOneButton.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pteTwoScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene/pteTwoScene.fxml")));

            Stage window = (Stage) pteTwoButton.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePath() {
        ConfigFile configFile = new ConfigFile();
        configFile.createConfigFile();
        configFile.writeConfigFile(qaperfutilsPathField.getText());
    }

    @FXML
    private Button loadTestFileButton;

    ///////////////////////// Core configuration. /////////////////////////
    @FXML
    private TextField testTicketTosPteOne;

    @FXML
    private TextField getHeapDumps;
    @FXML
    private TextField getHeapHistograms;
    @FXML
    private TextField restartAllApps;

    @FXML
    private TextField testDurationTime;
    @FXML
    private TextField uttVersion;

    @FXML
    private TextField branchNameTos;
    @FXML
    private TextField buildMajorTos;
    @FXML
    private TextField buildMinorTos;

    @FXML
    private TextField branchNameChart;
    @FXML
    private TextField buildMajorChart;
    @FXML
    private TextField buildMinorChart;

    @FXML
    private TextField branchNameMgw;
    @FXML
    private TextField buildMajorMgw;
    @FXML
    private TextField buildMinorMgw;

    @FXML
    private TextField oldBranch;
    @FXML
    private TextField oldBranchName;
    @FXML
    private TextField oldBranchVersion;
    @FXML
    private TextField oldTosTicket;

    @FXML
    private TextField oldestBranch;
    @FXML
    private TextField oldestBranchName;
    @FXML
    private TextField oldestBranchVersion;
    @FXML
    private TextField oldestTosTicket;

    ///////////////////////// MGW configuration. /////////////////////////

    @FXML
    private TextField testTicketMgwPteOne;


    public void loadTestFileCfg() {
        LoadTestFiles loadTestFiles = new LoadTestFiles();
        getHeapDumps.setText(loadTestFiles.loadFileTestCfg("getHeapDumps_flag","(?<==\")(.*?)(?=\")"));
        testTicketTosPteOne.setText(loadTestFiles.loadFileTestCfg("test_ticket_tos=","(?<==\")(.*?)(?=\")"));
        getHeapHistograms.setText(loadTestFiles.loadFileTestCfg("getHeapHisto_flag=","(?<==\")(.*?)(?=\")"));
        restartAllApps.setText(loadTestFiles.loadFileTestCfg("restart_all_apps_flag=","(?<==\")(.*?)(?=\")"));

        testDurationTime.setText(loadTestFiles.loadFileTestCfg("plainTestDurationMinutes=","=(.*)").split("=")[1]);
        uttVersion.setText(loadTestFiles.loadFileTestCfg("uttVersion=","=(.*)").split("=")[1]);

        branchNameTos.setText(loadTestFiles.loadFileTestCfg("branchName_tos=","(?<==\")(.*?)(?=\")"));
        buildMajorTos.setText(loadTestFiles.loadFileTestCfg("buildMajor_tos=","(?<==\")(.*?)(?=\")"));
        buildMinorTos.setText(loadTestFiles.loadFileTestCfg("buildMinor_tos=","(?<==\")(.*?)(?=\")"));

        branchNameChart.setText(loadTestFiles.loadFileTestCfg("branchName_toschart=","(?<==\")(.*?)(?=\")"));
        buildMajorChart.setText(loadTestFiles.loadFileTestCfg("buildMajor_toschart=","(?<==\")(.*?)(?=\")"));
        buildMinorChart.setText(loadTestFiles.loadFileTestCfg("buildMinor_toschart=","(?<==\")(.*?)(?=\")"));

        branchNameMgw.setText(loadTestFiles.loadFileTestCfg("branchName_tosmgw=","(?<==\")(.*?)(?=\")"));
        buildMajorMgw.setText(loadTestFiles.loadFileTestCfg("buildMajor_tosmgw=","(?<==\")(.*?)(?=\")"));
        buildMinorMgw.setText(loadTestFiles.loadFileTestCfg("buildMinor_tosmgw=","(?<==\")(.*?)(?=\")"));

        oldBranch.setText(loadTestFiles.loadFileTestCfg("_oldBranch_=","(?<==\")(.*?)(?=\")"));
        oldBranchName.setText(loadTestFiles.loadFileTestCfg("_oldBranchName_=","(?<==\")(.*?)(?=\")"));
        oldBranchVersion.setText(loadTestFiles.loadFileTestCfg("_oldBranchVersion_=","(?<==\")(.*?)(?=\")"));
        oldTosTicket.setText(loadTestFiles.loadFileTestCfg("_oldTosTicket_=","(?<==\")(.*?)(?=\")"));

        oldestBranch.setText(loadTestFiles.loadFileTestCfg("_oldestBranch_=","(?<==\")(.*?)(?=\")"));
        oldestBranchName.setText(loadTestFiles.loadFileTestCfg("_oldestBranchName_=","(?<==\")(.*?)(?=\")"));
        oldestBranchVersion.setText(loadTestFiles.loadFileTestCfg("_oldestBranchVersion_=","(?<==\")(.*?)(?=\")"));
        oldestTosTicket.setText(loadTestFiles.loadFileTestCfg("_oldestTosTicket_=","(?<==\")(.*?)(?=\")"));
    }
}