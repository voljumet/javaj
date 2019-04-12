import javax.swing.*;
import java.awt.*;


public class GraphicalElement extends JPanel{

    int posX, posY;
    int height, width;
    ImageIcon i;
    Image image;


    public void Draw (Graphics g){ // g: null. HVORFOR ???????


        if(image == null){
            System.out.println("IMAGE NULL");
            return;
        }

        g.drawImage(image, posX, posY, width, height, null);
        System.out.println("Enemy drawn");

        }
    }




