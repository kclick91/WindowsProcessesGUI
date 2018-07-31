package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    Label taskLabelOne;
    @FXML
    Label taskLabelTwo;
    private ArrayList<String> processesOne;
    private ArrayList<String> processesTwo;
    private boolean filtered = false;
    public void WriteToFileOne() {
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
        processesOne = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("tasks.txt")));
        String line = "";
        String s = "";
        line += reader.readLine();
        while((s = reader.readLine()) != null)
        {
            line += s + "\n";
            processesOne.add(s);
        }
        reader.close();
        taskLabelOne.setText(line);
    }
    public void ReadFileTwo() throws IOException {
        processesTwo = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("tasksTwo.txt")));
        String line = "";
        String s = "";
        line += reader.readLine();
        while((s = reader.readLine()) != null)
        {
            line += s + "\n";
            processesTwo.add(s);
        }
        reader.close();
        taskLabelTwo.setText(line);
    }
    public void Filter() throws IOException {
        if (!filtered)
        {
            filtered = true;
            String filtered = "";
            String filteredTwo = "";
            for (String s : processesOne)
            {
                if(!(processesTwo.contains(s)))
                {
                    filtered += s + "\n";
                }
            }
            for (String s : processesTwo)
            {
                if (!(processesOne.contains(s)))
                {
                    filteredTwo += s + "\n";
                }
            }
            taskLabelOne.setText(filtered);
            taskLabelTwo.setText(filteredTwo);
        }
        else

        {
            UnFilter();
        }



    }
    public void UnFilter() throws IOException {
        filtered = false;
        ReadFileOne();
        ReadFileTwo();
    }
}
