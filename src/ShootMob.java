import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.sqrt;

/*Shootmob sjekker om en mob kommer innenfor tårnets rekkevidde og tegnger
     i tilfellet en "Stråle" fra tårn til mob.*/

public class ShootMob extends ContSetup {
//    public ShootMob() { }

    public void Draw(Graphics g) {
//        ArrayList<Double> DistanceArray = new ArrayList<>();

        for (Towers t : TowerArray) {
            if (!mobsArrayList.isEmpty()) {
                if (t.target == null) {

                    t.target = mobsArrayList.get(0);
                    double minDistance = t.getDistance(t.target);

                    for (MobsElement m : mobsArrayList) { /*Loop legger til avstand fra tårn til hver mob og lagrer i Distancearray*/
                        double currentDistance = t.getDistance(m);
                        if (currentDistance < minDistance) {
                            t.target = m;
                            minDistance = currentDistance;
                        }
                    }
                } else { /*if sjekker om target er i rekkevidden til tårnet. dersom den er det, skyter tårnet*/

                    if (t.target.inGame && t.TowerReach.intersects(t.target.MobReach)) {
//                            System.out.println("t.target.inGame = " + t.TowerReach.intersects(t.target.MobReach));
                        g.setColor(new Color(0xF8EE2B));
                        g.drawLine(t.posX + t.towerSize / 2, t.posY + t.towerSize / 2, t.target.posX + 22, t.target.posY + 23);

                        t.target.mobHealth -= 1;
                        if (t.target.mobHealth == 0) {
                            t.target.inGame = false;
                            Cash += t.target.mobPayout;
                            Kills += 1;
                            mobsArrayList.remove(t.target);
                            t.target = null;
                        }
                    } else {
                        /*setter target til null slik at tårnet igjen kan finne nærmeste mob i rekkevidde.*/
                        t.target = null;
                    }
                }
            }
//            System.out.println("t.target = " + t.target);
        }
    }
}



