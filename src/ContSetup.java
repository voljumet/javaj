import javax.swing.*;
import java.util.ArrayList;

public class ContSetup extends JFrame {

    static View View;
    static PPListXY PipePositionListXY;
    public menuFrameStart menuFrameStart;
    PipeBuildSound PPSound;

    public static boolean debugMode = false;

    static int count;
    public static int pipeBlocks = 32;

    static int Cash = 20;
    static int kills = 0;
    static int health = 100;

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();
    public static ArrayList<MobsElement> mobsArrayList = new ArrayList<>();

}
