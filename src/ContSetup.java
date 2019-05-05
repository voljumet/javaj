import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContSetup extends JFrame {

    static View View;
    static PPListXY PipePositionListXY;
    public HighScore highScore;
    public MenuBox menu;
    public Store store;
    public PipeBuildSound PPSound;
    public ShootMob Shootmob;
    public Stats stats;
    public Sound Sound;

            /*DEBUG MODE*/
    public static boolean debugMode = false;
            /*DEBUG MODE*/

    boolean outOfMap = false;
    boolean MenuX = false;
    boolean MenuY1 = false;
    boolean MenuY2 = false;
    boolean MenuY3 = false;
    boolean MenuY4 = false;
    static boolean drawFPS = false;
    boolean gameLost = false;
    static boolean onlyHS = false;

    Point mse = new Point(0,0);

    public static boolean towerbutton1 = false;
    public static boolean towerbutton2 = false;
    public static int count;

    /* Starter med følgende stats */
    static int Cash = 20;
    static int Kills = 0;
    static int health = 100;

    /* RIKTIG MÅTE Å BRUKE TIMER!!-------------------------------------------------------------------------------------- */

    public static final long NANOSECONDS_PER_MILLISECOND = 1000000;
    public static final long MS_PER_FRAME = 10; //gir FPS
    long elapsedTime;

    /* RIKTIG MÅTE Å BRUKE TIMER!!-------------------------------------------------------------------------------------- */

    int mseposX;
    int mseposY;
    int countDown = 5;
    int timer = 1;

    public static int wave = 1;
    public static int waveSize = 20;
    public static int spawnedmobs = 0;

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();
    public static ArrayList<MobsElement> mobsArrayList = new ArrayList<>();
    public static ArrayList<Integer> HighScoreArrayList = new ArrayList<>();

    public static Image[] tileset = new Image[100];

    ImageIcon cashIcon = new ImageIcon("Pictures/Icons/Icon-03.png");
    ImageIcon killsIcon = new ImageIcon("Pictures/Icons/Icon-02.png");
    ImageIcon healthIcon = new ImageIcon("Pictures/Icons/Icon-04.png");

    ImageIcon backgroundImage = new ImageIcon("Pictures/Background-01.png");



}
