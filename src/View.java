import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    JPanel MainGameWindow;

    public View(){

        this.setSize(900,900);
        this.setTitle("Blowout TD");
        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        JLabel background = new JLabel(imageIcon);
        add(background);


        this.setVisible(true); //MÅ VÆRE SISTE LINJE!

    }
}

