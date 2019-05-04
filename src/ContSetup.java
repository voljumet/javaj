import javax.swing.*;
import java.util.ArrayList;
import java.awt.Rectangle;

public class ContSetup extends JFrame {

    static View View;
    static PPListXY PipePositionListXY;
    public menuFrameStart menuFrameStart;
    PipeBuildSound PPSound;

    public static boolean debugMode = true;
    boolean outOfMap = false;
    boolean MenuX = false;
    boolean MenuY1 = false;
    boolean MenuY2 = false;
    boolean MenuY3 = false;
    boolean MenuY4 = false;
    boolean drawFPS = false;

    public static boolean towerbutton = false;


    public static int count;

    static int Cash = 20;
    static int Kills = 0;
    static int health = 100;
    int mseposX;
    int mseposY;
    int countDown = 5;
    int timer = 1;
    public static int wave = 1;

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();
    public static ArrayList<MobsElement> mobsArrayList = new ArrayList<>();
    public static ArrayList<String> HighScoreArrayList = new ArrayList<>();

}
