import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContSetup extends JFrame {

    static View View;
    static PPListXY PipePositionListXY;
    public menuFrameStart menuFrameStart;
    public Store store;
    public PipeBuildSound PPSound;
    public ShootMob Shootmob;

            /*DEBUG MODE*/
    public static boolean debugMode = true;
            /*DEBUG MODE*/

    boolean outOfMap = false;
    boolean MenuX = false;
    boolean MenuY1 = false;
    boolean MenuY2 = false;
    boolean MenuY3 = false;
    boolean MenuY4 = false;
    static boolean drawFPS = false;

    boolean HoldItem = false;

    Point mse = new Point(0,0);

    public static boolean towerbutton = false;
    public static int count;

    static int Cash = 200;
    static int Kills = 0;
    static int health = 100;
    int mseposX;
    int mseposY;
    int countDown = 5;
    int timer = 1;

    public static int myWidth = 900;
    public static int myHeight = 900;
    public static int wave = 1;

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();
    public static ArrayList<MobsElement> mobsArrayList = new ArrayList<>();
    public static ArrayList<String> HighScoreArrayList = new ArrayList<>();

    public static Image[] tileset = new Image[100];
    public static Image[] tileset_1 = new Image[100];

    ImageIcon cashIcon = new ImageIcon("Pictures/Icons/Icon-03.png");
    ImageIcon killsIcon = new ImageIcon("Pictures/Icons/Icon-02.png");
    ImageIcon healthIcon = new ImageIcon("Pictures/Icons/Icon-04.png");

    ImageIcon icon5 = new ImageIcon("Pictures/Icons/Icon-05.png");
    ImageIcon icon6 = new ImageIcon("Pictures/Icons/Icon-06.png");

    ImageIcon towerIcon1 = new ImageIcon("Pictures/Icons/Towers-01.png");
    ImageIcon imageIcon2 = new ImageIcon("Pictures/Icons/Towers-02.png");

    ImageIcon backgroundImage = new ImageIcon("Pictures/Background-01.png");

}
