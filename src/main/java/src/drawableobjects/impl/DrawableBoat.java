package src.drawableobjects.impl;

import src.drawableobjects.DrawableConstants;
import src.drawableobjects.DrawableObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by lior on 8/9/2017.
 */
public class DrawableBoat extends DrawableObject implements KeyListener{

    private boolean leftKeyDown = false;
    private boolean rightKeyDown = false;

    public DrawableBoat(){
        super(DrawableConstants.Boat.WIDTH,
                DrawableConstants.Boat.HEIGHT,
                DrawableConstants.Boat.SPEED,
                DrawableConstants.Boat.IMAGE_PATH
                );
    }

    public boolean paint(Graphics g, int frameWidth, int frameHeight){
        if(leftKeyDown){
            currentX -= objectSpeed;
        }
        if(rightKeyDown){
            currentX += objectSpeed;
        }
        if(currentX < 0){
            currentX = objectWidth;
        } else if(currentX > frameWidth){
            currentX = frameWidth - objectWidth;
        }
        currentY = frameHeight - 3*objectHeight;
        g.drawImage(image, currentX, currentY, objectWidth, objectHeight, null);
        return true;
    }


    public void keyTyped(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT){
            currentX -= 2;
        }

        if(c == KeyEvent.VK_RIGHT){
            currentX += 2;
        }
    }

    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT){
            leftKeyDown = true;
        }

        if(c == KeyEvent.VK_RIGHT){
            rightKeyDown = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT){
            leftKeyDown = false;
        }

        if(c == KeyEvent.VK_RIGHT){
            rightKeyDown = false;
        }
    }
}
