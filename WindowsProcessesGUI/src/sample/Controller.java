package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {

    @FXML
    Label taskLabelOne;
    @FXML
    Label taskLabelTwo;
    public void WriteToFileOne() throws IOException {
        String batch = "processes.bat";
        String command = "cmd /c start \"\" ";
        try {
            //The executables will be written to a text file
            Process p = Runtime.getRuntime().exec(command + batch);
            Thread.sleep(1000);
            ReadFileOne();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void WriteToFileTwo()
    {
        String batch = "processesTwo.bat";
        String command = "cmd /c start \"\" ";
        try {
            //The executables will be written to a text file
            Process p = Runtime.getRuntime().exec(command + batch);
            Thread.sleep(1000);
            ReadFileTwo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ReadFileOne() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("tasks.txt")));
        String line = "";
        String s = "";
        line += reader.readLine();
        while((s = reader.readLine()) != null)
        {
            line += s + "\n";
        }
        reader.close();
        taskLabelOne.setText(line);
    }
    public void ReadFileTwo() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("tasksTwo.txt")));
        String line = "";
        String s = "";
        line += reader.readLine();
        while((s = reader.readLine()) != null)
        {
            line += s + "\n";
        }
        reader.close();
        taskLabelTwo.setText(line);
    }
}
