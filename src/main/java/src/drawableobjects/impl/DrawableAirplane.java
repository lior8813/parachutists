package src.drawableobjects.impl;

import src.drawableobjects.DrawableConstants;
import src.drawableobjects.DrawableObject;
import src.drawableobjects.DrawableObjectsManager;

import java.awt.*;

/**
 * Created by lior on 8/9/2017.
 */
public class DrawableAirplane extends DrawableObject {


    public DrawableAirplane() {
        super(DrawableConstants.Airplane.WIDTH,
                DrawableConstants.Airplane.HEIGHT,
                DrawableConstants.Airplane.SPEED,
                DrawableConstants.Airplane.IMAGE_PATH
                );
    }


    public boolean paint(Graphics g, int frameWidth, int frameHeight) {
        currentX -= objectSpeed;
        currentY = 2*objectHeight;
        if (currentX < -objectWidth) {
            currentX = frameWidth + objectWidth;
        }
        g.drawImage(image, currentX, currentY, objectWidth, objectHeight, null);
        if(currentX > objectWidth && currentX < frameWidth - objectWidth &&
                currentX % ((int)((Math.random() * 5) + 1) * 70) == 0){
            dropParachutist(currentX, currentY);
        }
        return true;
    }

    private void dropParachutist(int x, int y) {
        DrawableObjectsManager.getInstance().dropParachutist(x, y);
    }
}
