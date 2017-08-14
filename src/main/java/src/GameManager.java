package src;

import src.drawableobjects.DrawableConstants;
import src.drawableobjects.impl.DrawableAirplane;
import src.drawableobjects.DrawableObjectsManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lior on 8/9/2017.
 */
public class GameManager extends JComponent{


    public GameManager(){
        initializeDrawableObjectsManager();
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if(DrawableObjectsManager.getInstance().getLives() > 0) {
                        repaint();
                        try {
                            Thread.sleep(10);
                        } catch (Exception ex) {
                        }
                    } else {
                        break;
                    }
                }
            }
        });

        animationThread.start();
    }

    private void initializeDrawableObjectsManager() {
        DrawableObjectsManager manager = DrawableObjectsManager.getInstance();
        manager.setAirplane(new DrawableAirplane());
    }


    public void paintComponent(Graphics g) {
        DrawableObjectsManager.getInstance().getAirplane().paint(g, getWidth(), getHeight());
        DrawableObjectsManager.getInstance().getBoat().paint(g, getWidth(), getHeight());
        DrawableObjectsManager.getInstance().drawParachutists(g, getWidth(), getHeight());
        DrawableObjectsManager.getInstance().drawScore(g);
        DrawableObjectsManager.getInstance().drawOcean(g, getWidth(), getHeight());
     }

}
