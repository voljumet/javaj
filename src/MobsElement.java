import javax.swing.*;
import java.awt.*;

public abstract class MobsElement extends GraphicalElement {

        boolean inGame = false;

        int mapPlace;
        int mobSize;
        int PictureNumber;
        int mobHealth, maxHealth;
        int mobPayout;
        int mobArmySize;
        int mobDamage;
        Rectangle MobReach;
        boolean inReach;

        public MobsElement() {

                mobSize = 45;
                height = mobSize;
                width = mobSize;

                img = new ImageIcon();
                image = img.getImage();
        }

        @Override
        public void Draw(Graphics g) {
                g.drawImage(image, posX, posY, width, height, null);

                g.setColor(new Color(180,50,50));
                g.fillRect(posX,posY - (3 + 6),width, 6) ;

                g.setColor(new Color(50,180,50));
                g.fillRect(posX,posY - (3 + 6),width*mobHealth /maxHealth, 6) ;

                g.setColor(new Color(0,0,0));
                g.drawRect(posX, posY - (3 + 6),width-1, 6-1);

                MobReach = new Rectangle(posX, posY,45,45);
        }
}


