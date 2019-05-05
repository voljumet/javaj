import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class HighScore{

    int hs;
    String name;
    String file = "HS.juice";
    String HSString;


    public HighScore() throws IOException {

        if (!ContSetup.onlyHS){
//            name = JOptionPane.showInputDialog(null,"Enter name to highscore list","HighScore");
            hs = ContSetup.Kills;
            SaveFile();
        }
        SortFile();
        JOptionPane.showMessageDialog(null, HSString,"Highscore",0);

    }

    void SortFile() throws IOException {
        ContSetup.HighScoreArrayList.clear();

        Scanner s = new Scanner(new FileReader(file));

        while(s.hasNext()){
            ContSetup.HighScoreArrayList.add(Integer.parseInt(s.next()));
        }
        Collections.sort(ContSetup.HighScoreArrayList);

        System.out.println("ContSetup.HighScoreArrayList = " + ContSetup.HighScoreArrayList);
//        InputStream is = new FileInputStream(file);
//        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
//
//        String line = buf.readLine();
//        StringBuilder sb = new StringBuilder();
//
//        while(line != null){
//            sb.append(line).append("\n");
//            line = buf.readLine();
//        }
//
//        HSString = sb.toString();
//
//
//        buf.close();
    }

    void SaveFile() throws IOException {
        String fileContent = hs +"\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        writer.write(fileContent);
        writer.close();
    }
}
