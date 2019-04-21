import javax.swing.*;
import java.awt.*;

public class GraphicalElement extends JPanel{

    int posX, posY;
    int height, width;
    String description;
    ImageIcon i;
    Image image;

    public void Draw (Graphics g){

        //direction direction;
        if(image == null){
            System.out.println("IMAGE NULL");
            return;
        }
        g.drawImage(image, posX, posY, width, height, null);

//        System.out.println(description+" number "+Controller.count+" drawn!");    //debug for PPList
//        System.out.println("Element drawn");
//        System.out.println("X: " +posX+ " Y: "+posY);
        
        }
    }




