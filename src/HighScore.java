import javax.swing.*;
import java.io.*;

public class HighScore {

    String hs;
    String name;
    String file = "HS.juice";
    String HSString;

    public HighScore() throws IOException {
        name = JOptionPane.showInputDialog(null,"Enter name to highscore list");
        hs = Integer.toString(ContSetup.Kills);

        SaveFile();
        SortFile();

        JOptionPane.showMessageDialog(null, HSString);

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
