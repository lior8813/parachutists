package src;

import src.drawableobjects.impl.DrawableBoat;
import src.drawableobjects.DrawableObjectsManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lior on 8/8/2017.
 */
public class Main extends JFrame{


    public Main(){
        setFrameSettings();
        this.add(new GameManager());
        DrawableBoat drawableBoat = new DrawableBoat();
        DrawableObjectsManager.getInstance().setBoat(drawableBoat);
        this.addKeyListener(drawableBoat);
    }

    private void setFrameSettings(){
        this.setSize(1000,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("parachutists");
        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new Main();
    }


}
