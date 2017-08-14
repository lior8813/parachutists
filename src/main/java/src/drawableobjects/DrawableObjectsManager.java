package src.drawableobjects;

import src.drawableobjects.impl.DrawableAirplane;
import src.drawableobjects.impl.DrawableBoat;
import src.drawableobjects.impl.DrawableParachutist;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lior on 8/9/2017.
 */
public class DrawableObjectsManager {

    private DrawableAirplane airplane;
    private List<DrawableParachutist> parachutists;
    private DrawableBoat boat;
    public static DrawableObjectsManager drawableObjectsManager;
    private int score;
    private int lives = 3;

    private DrawableObjectsManager(){}

    public static DrawableObjectsManager getInstance(){
        if(drawableObjectsManager == null) {
            drawableObjectsManager = new DrawableObjectsManager();
        }
        return drawableObjectsManager;
    }

    public void setAirplane(DrawableAirplane airplane){
        this.airplane = airplane;
    }

    public void drawParachutists(Graphics g, int frameWidth, int frameHeight) {
        if(parachutists != null) {
            Iterator<DrawableParachutist> parachutistsIterator = parachutists.iterator();
            while (parachutistsIterator.hasNext()) {
                boolean shouldKeepPainting = parachutistsIterator.next().paint(g, frameWidth, frameHeight);
                if (!shouldKeepPainting) {
                    parachutistsIterator.remove();
                }
            }
        }
    }

    public void dropParachutist(int currentX, int currentY) {
        if(parachutists == null) {
            parachutists = new ArrayList<DrawableParachutist>();
        }
        parachutists.add(new DrawableParachutist(currentX, currentY));
    }

    public DrawableAirplane getAirplane() {
        return airplane;
    }

    public void setBoat(DrawableBoat boat) {
        this.boat = boat;
    }

    public DrawableBoat getBoat() {
        return boat;
    }

    public void drawScore(Graphics g) {
        g.drawString("Score: " + score, 30, 30);
        g.drawString("Lives: " + lives, 30, 50);
    }

    public void wonPoints(){
        score += 10;
    }

    public void lostLives(){
        lives -= 1;
    }

    public void drawOcean(Graphics g, int frameWidth, int frameHeight) {
        g.setColor(Color.BLUE);
        g.fillRect(0, frameHeight - 2 * DrawableConstants.Boat.HEIGHT, frameWidth, 3*DrawableConstants.Boat.HEIGHT);
    }

    public int getLives() {
        return lives;
    }
}
