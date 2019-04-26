import javax.swing.*;
import java.awt.*;

public class View extends JFrame{

    public static JPanel background;

    public View(){

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(900,900);
        this.setTitle("Oil Platform Defence");

        this.setLocationRelativeTo(null);

        background = new JPanel();
        this.add(background);
        //setUndecorated(true);
        this.setResizable(false);
        this.setVisible(true);
    }
}