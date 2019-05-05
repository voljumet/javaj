import java.awt.*;

public class Store{
    public static int shopHeight = 4;
    public static int buttonSize = 45;
    public static int cellSpace = 2;
    public static int itemIn = 4;
    public static int heldID = -1;
    public static int[] buttonID = {1, 2, 3, 4};
    public static int[] buttonPrice = {20, 30, 0, 0};

    public boolean holdsItem = false;
    public Rectangle[] button = new Rectangle[shopHeight];

    public Store() {
        /** Init Shop */
        for (int i = 0; i < button.length; i++) {
            button[i] = new Rectangle(850, 5 + ((buttonSize + cellSpace) * i), buttonSize, buttonSize);
        }
    }

    public void click(int mouseButton, Point mse) {

        /** Hvis man trkker på musen på shop*/
        if (mouseButton == 1) {
            for (int i = 0; i < button.length; i++) {

                /** Sjekker at knappen er blitt trykket*/
                if (ContSetup.MenuButton1 || ContSetup.MenuButton2 || ContSetup.MenuButton3 || ContSetup.MenuButton4) {
                    if (button[i].contains(mse)) {

                        /** Ikonet skal ikke plukkes opp om man trykker på ikon 3 og 4 i shop*/
                        if (buttonID[i] == 3 || buttonID[i] == 4) {
                            holdsItem = false;
                        } else {
                            heldID = buttonID[i];
                            holdsItem = true;
                        }
                    }
                }
            }
        }
    }

    public void draw(Graphics g, Point mse) {
        for (int i = 0; i < button.length; i++) {

            /** Hvis man holder musepeker over Shop, farges laget over til lysere for å vise dette*/
            if (mse != null && button[i].contains(mse)) {
                g.setColor(new Color(255, 255, 255, 170));
                g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);

            }
            if (Controller.drawFPS) {
                /** Tegner knapper i shop*/
                g.drawImage(Controller.tileset[0], button[i].x, button[i].y, button[i].width, button[i].height, null);
                g.drawImage(Controller.tileset[i + 1], button[i].x + itemIn, button[i].y + itemIn, button[i].width - (itemIn * 2), button[i].height - (itemIn * 2), null);

                /** Tegner pris i shop*/
                if (buttonPrice[i] > 0) {
                    g.setColor(new Color(0, 0, 0));
                    g.setFont(new Font("Courier New", Font.BOLD, 16));
                    g.drawString("$" + buttonPrice[i], button[i].x + itemIn * 2, button[i].y + itemIn * 7);
                }

                /** Hvis man trykker i shop, vil bilde festes til mus Pos X & Y */
                if (mse != null && holdsItem) {
                    g.drawImage(Controller.tileset[heldID], mse.x - (75 / 2), mse.y - (75 / 2), 75, 75, null);
                }
            }
        }
    }
}
