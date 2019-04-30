import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PPListXY {

    static public ArrayList<Integer> PPX = new ArrayList<>();
    static public ArrayList<Integer> PPY = new ArrayList<>();

    public PPListXY() throws FileNotFoundException {

        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(4);
        String MapY = "";
        String MapX = "";

        if (randomNumber == 0){
            MapY = "Maps/Y-tall1.txt";
            MapX = "Maps/X-tall1.txt";
        }else if(randomNumber == 1){
            MapY = "Maps/Y-tall2.txt";
            MapX = "Maps/X-tall2.txt";
        }else if(randomNumber == 2){
            MapY = "Maps/Y-tall3.txt";
            MapX = "Maps/X-tall3.txt";
        }else if(randomNumber == 3){
            MapY = "Maps/Y-tall4.txt";
            MapX = "Maps/X-tall4.txt";
        }

        Scanner ScannerY = new Scanner(new BufferedReader(new FileReader(MapY)));
        while(ScannerY.hasNextInt()){ PPY.add(ScannerY.nextInt()); }ScannerY.close();

        Scanner ScannerX = new Scanner(new BufferedReader(new FileReader(MapX)));
        while(ScannerX.hasNextInt()){ PPX.add(ScannerX.nextInt()); }ScannerX.close();

        System.out.println("Map "+randomNumber+" loaded!");
    }
}
