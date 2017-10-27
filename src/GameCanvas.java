import bases.GameObject;
import touhou.backgrounds.BackGround;
import touhou.enemies.Boss;
import touhou.enemies.EnemiesSpawner;
import touhou.players.Player;

import touhou.players.playerOrb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameCanvas extends JPanel {

    public static BufferedImage background;

    Player player = new Player();

    int backGroundX = 0;
    int backGroundY = 0;

    BufferedImage backBuffer;
    Graphics backGraphics;

    Boss boss1 = new Boss();

    BackGround backGround = new BackGround();

    playerOrb orb1;
    playerOrb orb2;


    public GameCanvas(){

        //0.Create back buffer
        backBuffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        GameObject.add(backGround);
        GameObject.add(player);
        orb1 = new playerOrb(30);
        GameObject.add(orb1);
        orb2 = new playerOrb(-30);
        GameObject.add(orb2);
        orb1.playerPosition = player.position;
        orb2.playerPosition = player.position;
        GameObject.add(new EnemiesSpawner());

    }

    public void render(){
        //1.Draw everything on back buffer


        GameObject.renderAll(backGraphics);



        //2.call repaint
        repaint();
    }
    public void run() {
        GameObject.runAll();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);
    }
}