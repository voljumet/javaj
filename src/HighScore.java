import javax.swing.*;
import java.io.*;

public class HighScore{

    int hs;
    String name;
    String file = "HS.juice";
    String HSString;

    public HighScore() throws IOException { }

    /** Åpner Highscore fil */
    void OpenFile() throws IOException {
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

    /** Lagrer Highscore fil */
    void SaveToFile() throws IOException {
        String fileContent = name+" got "+hs+" kills!\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        writer.write(fileContent);
        writer.close();
    }

    /** Game val */
    public boolean getHighscore() throws IOException {
        name = JOptionPane.showInputDialog(null,"Enter name to highscore list","HighScore");
        hs = ContSetup.Kills;
        SaveToFile();
        OpenFile();
        JOptionPane.showMessageDialog(null, HSString,"Highscore",JOptionPane.INFORMATION_MESSAGE);
        String[] Options = {"New Game", "Quit Game"};
        int Option = JOptionPane.showOptionDialog(null, "Options", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, Options, Options[1]);
        if(Option == 0){
            System.out.println("New Game");
            return true;
        }else {
            return false;
        }
    }

    /** Highscore menubutton*/
    public void HighSc() throws IOException {
        OpenFile();
        JOptionPane.showMessageDialog(null, HSString,"Highscore",JOptionPane.INFORMATION_MESSAGE);
    }
}
