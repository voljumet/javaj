import java.io.IOException;
import javax.swing.*;


public class Enemies extends GraphicalElement {

        public  Enemies() {

                posY = 100;
                posX = 100;
                height = 80;
                width = 80;
                description = "Enemies";
                i = new ImageIcon("Pictures/Icons/Iconse-01.png");
                image = i.getImage();


        }
}


