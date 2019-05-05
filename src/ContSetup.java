import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContSetup extends JFrame {

    static View View;
    static PPListXY PipePositionListXY;
    public HighScore highScore;
    public Store store;
    public PipeBuildSound PPSound;
    public ShootMob Shootmob;
    public Stats stats;
    public Sound Sound;

    /**----------DEBUG MODE----------*/
    public static boolean debugMode = false;
    /**----------DEBUG MODE----------*/

    boolean outOfMap = false;
    boolean MenuX = false;
    boolean MenuY1 = false;
    boolean MenuY2 = false;
    boolean MenuY3 = false;
    boolean MenuY4 = false;
    static boolean drawFPS = false;
    boolean gameLost = false;
    boolean gameWon;
    boolean gameinprogress = false;
    static boolean onlyHS = false;
    public static boolean MenuButton1 = false;
    public static boolean MenuButton2 = false;
    public static boolean MenuButton3 = false;
    public static boolean MenuButton4 = false;

    public static int count;

    /** Starter med følgende stats */
    static int Cash = 40;
    static int Kills = 0;
    static int health = 100;
    /** Starter med følgende stats */

    public static final long NANOSECONDS_PER_MILLISECOND = 1000000;
    public static final long MS_PER_FRAME = 10; //gir FPS
    long elapsedTime;

    Point mse = new Point(0,0);

    int mseposX;
    int mseposY;
    int countDown = 5;
    int timer = 1;

    public static int wave;
    public static int mobsInWave; /**Passer på at 20 mobs spawner hver Wave.*/
    public static int mobsInPipe; /**Sjekker hvor mange mobs som er i banen til hvert tidspunkt*/

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();
    public static ArrayList<MobsElement> mobsArrayList = new ArrayList<>();

    public static Image[] tileset = new Image[100];

    ImageIcon cashIcon = new ImageIcon("Pictures/Icons/Icon-03.png");
    ImageIcon killsIcon = new ImageIcon("Pictures/Icons/Icon-02.png");
    ImageIcon healthIcon = new ImageIcon("Pictures/Icons/Icon-04.png");
    ImageIcon backgroundImage = new ImageIcon("Pictures/Background-01.png");



}
