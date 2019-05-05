import javax.swing.*;
import java.io.*;

public class HighScore{

    int hs;
    String name;
    String file = "HS.juice";
    String HSString;


    public HighScore() throws IOException {

        if (!ContSetup.onlyHS){
            name = "Player";
            name = JOptionPane.showInputDialog(null,"Enter name to highscore list","HighScore");
            hs = ContSetup.Kills;
            SaveFile();
        }
        SortFile();
        JOptionPane.showMessageDialog(null, HSString,"Highscore",0);

    }

    void SortFile() throws IOException {
        ContSetup.HighScoreArrayList.clear();

        InputStream is = new FileInputStream(file);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        
        HSString = sb.toString();


        buf.close();
    }

    void SaveFile() throws IOException {
        String fileContent = name+" got "+hs+" kills!\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        writer.write(fileContent);
        writer.close();
    }
}

