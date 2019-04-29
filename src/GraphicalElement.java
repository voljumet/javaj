import javax.swing.*;
import java.awt.*;

public class GraphicalElement extends JPanel{

    public boolean mob = false;
    static int posX, mobPosX;
    static int posY, mobPosY;
    int height, width;
    String description;
    ImageIcon i;
    Image image;


    public void Draw (Graphics g){

        //direction direction;
        if(image == null){
            System.out.println("IMAGE NULL");
            return;
        }else {
            if (mob){
                g.drawImage(image, mobPosX, mobPosY, width, height, null);
            } else{
                g.drawImage(image, posX, posY, width, height, null);
            }
        }

        }
    }




