import javax.swing.*;
import java.util.ArrayList;

public class ContSetup extends JFrame {

    static View View;
    static PipeLine PipeLine;
    static PPListXY PipePositionListXY;
    static PipeBuildSound PPSound;
    public static Mob Mob;
    public menuFrameStart menuFrameStart;

    public static boolean running = true;
    public static boolean newG = true;

    public int mseClicked;
    public int mseposX;
    public int mseposY;

    public static boolean debugMode = false;
    public static boolean pipeDrawn = false;
    public static boolean gameRunning = false;
    public static boolean timeToDraw = false;



    public static int count;
    public static int timerT = 0;
    public static int countDown = 5;
    public static int pipeBlocks = 32;
    public static int mobCount = 0;

    public static Towers Towers;
    public static MobsElement MobsElement;

    static int Cash = 20;
    static int kills = 0;
    static int health = 100;

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<MobsElement> EnemyArray = new ArrayList<>(); //Placeholder for MobArray.
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();
    public static ArrayList<MobsElement> mobsArrayList = new ArrayList<>();


}
