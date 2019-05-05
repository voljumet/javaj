import java.awt.*;

public class Store extends ContSetup {
    public static int shopHeight = 4;
    public static int buttonSize = 45;
    public static int cellSpace = 2;
    public static int itemIn = 4;
    public static int heldID = -1;
    public static int[] buttonID = {1, 2, 3, 4};
    public static int[] buttonPrice = {20,30,0,0};

    public boolean holdsItem = false;

    public Rectangle[] button = new Rectangle[shopHeight];

    public Store() {
        for (int i = 0; i < button.length; i++) {
            button[i] = new Rectangle(850,5 + ((buttonSize+cellSpace)*i),buttonSize,buttonSize);
        }
    }

    public void click(int mouseButton){
        if (mouseButton == 1){
            for (int i = 0; i < button.length; i++) {
                if (button[i].contains(mse)){
                    if (buttonID[i] == 3 || buttonID[i] == 4){ /* hvis man trykker på knapp 3 & 4, plukker man ikke opp ikonet*/
                        holdsItem = false;
                    } else {
                        heldID = buttonID[i];
                        holdsItem = true;
                    }
                }
            }
        }
    }



    public void draw(Graphics g){
        for (int i = 0; i < button.length; i++) {

           // mse = View.getMousePosition();

            if (mse != null && button[i].contains(mse)){
                g.setColor(new Color(255,255,255,80));
                g.fillRect(button[i].x,button[i].y,button[i].width,button[i].height);

            }
//            if (Controller.drawFPS){
            g.drawImage(Controller.tileset[0],button[i].x,button[i].y,button[i].width,button[i].height,null);
            g.drawImage(Controller.tileset[i+1],button[i].x + itemIn,button[i].y+ itemIn, button[i].width-(itemIn*2), button[i].height-(itemIn*2),null);

            if (buttonPrice[i] > 0){
                g.setColor(new Color(0,0,0));
                g.setFont(new Font("Courier New", Font.BOLD, 16));
                g.drawString("$" + buttonPrice[i],button[i].x + itemIn*2,button[i].y + itemIn*7);
            }

            if (mse != null && holdsItem){
                g.drawImage(Controller.tileset[heldID], mse.x - (75/2), mse.y - (75/2),75, 75,null);
            }
        }
    }
}
