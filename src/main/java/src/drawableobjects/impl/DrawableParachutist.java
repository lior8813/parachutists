package src.drawableobjects.impl;

import src.drawableobjects.DrawableConstants;
import src.drawableobjects.DrawableObject;
import src.drawableobjects.DrawableObjectsManager;

import java.awt.*;

/**
 * Created by lior on 8/9/2017.
 */
public class DrawableParachutist extends DrawableObject {

    public DrawableParachutist(int currentX, int currentY){
        super(DrawableConstants.Parachutist.WIDTH,
                DrawableConstants.Parachutist.HEIGHT,
                DrawableConstants.Parachutist.SPEED,
                DrawableConstants.Parachutist.IMAGE_PATH
                );
        this.currentX = currentX;
        this.currentY = currentY;
    }

    public boolean paint(Graphics g, int frameWidth, int frameHeight) {
        currentY += objectSpeed;
        DrawableBoat boat = DrawableObjectsManager.getInstance().getBoat();
        if(getLeftEdge() <= boat.getRightEdge() && getRightEdge() >= boat.getLeftEdge() &&
                getUpperEdge() <= boat.getBottomEdge() && getBottomEdge() >= boat.getUpperEdge()){
            DrawableObjectsManager.getInstance().wonPoints();
            return false;
        }
        if(currentY > frameHeight - 5) {
            DrawableObjectsManager.getInstance().lostLives();
            return false;
        }
        g.drawImage(image, currentX, currentY, objectWidth, objectHeight, null);
        return true;
    }

}
