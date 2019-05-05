import javax.swing.*;
import java.awt.*;
import java.io.*;

public class HighScore{

    int hs;
    String name;
    String file = "HS.juice";
    String HSString;


    public HighScore() throws IOException {
    }

    /**SortFile skal sortere highscores for å printe dem ut i synkende rekkefølge (påbegynt)*/
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
    /**SaveFile lagrer strings som inneholder navn og score fra spillet i filen HS.juice*/
    void SaveFile() throws IOException {
        String fileContent = name+" got "+hs+" kills!\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        writer.write(fileContent);
        writer.close();
    }
    /**getHighscore legger inn score i HS.juice, henter tidligere scores fra filen og printer dem i en messagedialog.
     * deretter settes det opp en optionsdialog for nytt spill eller avslutt spill utifra hva man velger returnerer funksjonen true eller false
     * denne booleanen blir brukt i controller for å starte spillet på nytt.*/

    public boolean getHighscore() throws IOException {
        if (!ContSetup.onlyHS){
            name = "Player";
            name = JOptionPane.showInputDialog(null,"Enter name to highscore list","HighScore");
            hs = ContSetup.Kills;
            SaveFile();
        }
        SortFile();
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

}
