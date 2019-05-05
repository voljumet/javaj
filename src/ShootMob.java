import java.awt.*;

/** Shootmob sjekker intersect mellom tårn og mob og tegner strek*/
public class ShootMob extends ContSetup {

//    public ShootMob() { }

    public void ShootMob(Graphics g) {
        for (Towers t : TowerArray) {
            if (!mobsArrayList.isEmpty()) {

                /** Tårn finner mob med kortest avstand, og setter til target */
                if (t.target == null) {
                    t.target = mobsArrayList.get(0);
                    double minDistance = t.getDistance(t.target);
                    for (MobsElement m : mobsArrayList) {
                        double currentDistance = t.getDistance(m);
                        if (currentDistance < minDistance) {
                            t.target = m;
                            minDistance = currentDistance;
                            t.target.inReach = false;
                        }
                    }
                }
                /** sjekker om target er i rekkevidden til tårnet. dersom den er det, skyter tårnet*/
                else {

                    if (t.target.inGame && t.TowerReach.intersects(t.target.MobReach)) {
                        t.target.inReach = true;
                        g.setColor(new Color(0xF8EE2B));
                        g.drawLine(t.posX + t.towerSize / 2, t.posY + t.towerSize / 2, t.target.posX + 22, t.target.posY + 23);
                        t.target.mobHealth -= 1;

                        /** Hvis mob dør */
                        if (t.target.mobHealth == 0) {
                            ContSetup.mobsInPipe -= 1;
                            t.target.inGame = false;
                            Cash += t.target.mobPayout;
                            Kills += 1;
                            if(t.target.inReach) { t.target = null; }
                        }
                    } else {
                        /** Setter target til null slik at tårnet igjen kan finne nærmeste mob */
                        t.target = null;
                    }
                }
            }
        }
    }
}



