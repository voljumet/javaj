
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {


    public View(){

//        menu = new Menu();
//        backgroundImage = new BackgroundImage();

        // Adding frame functionalities.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(900,800);
        this.setTitle("Oil Platform Defence");
        this.setLocationRelativeTo(null);

        // Adding background image
        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(imageIcon);
        this.add(background);
        

        // Setting frame visible/ not resizeable.
        this.setResizable(false);
        this.setVisible(true);

    }
}

