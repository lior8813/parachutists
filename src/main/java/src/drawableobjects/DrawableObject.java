package src.drawableobjects;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by lior on 8/9/2017.
 */
public abstract class DrawableObject {

    protected int currentX;
    protected int currentY;
    protected int objectHeight;
    protected int objectWidth;
    protected int objectSpeed;
    protected Image image;

    public DrawableObject(int width, int height, int speed, String imagePath){
        this.objectWidth = width;
        this.objectHeight = height;
        this.objectSpeed = speed;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {}
    }

    public abstract boolean paint(Graphics g, int frameWidth, int frameHeight);

    public int getRightEdge(){
        return currentX + (objectWidth / 2);
    }

    public int getLeftEdge(){
        return currentX - (objectWidth / 2);
    }

    public int getUpperEdge(){
        return currentY - (objectHeight / 2);
    }

    public int getBottomEdge(){
        return currentY + (objectHeight / 2);
    }
}
