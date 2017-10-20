import bases.GameObject;
import touhou.Boss;
import touhou.EnemyBullet;
import touhou.Spell;
import touhou.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {

    public static BufferedImage background;

    Player player = new Player();


    ArrayList<EnemyBullet> enemybullets = new ArrayList<>();


    int backGroundX = 0;
    int backGroundY = 0;


    long lastExec = 0;

    BufferedImage backBuffer;
    Graphics backGraphics;



    Boss boss1 = new Boss();



    public GameCanvas(){

        //0.Create back buffer
        backBuffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        //1.load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameObject.add(player);

    }

    public void render(){
        //1.Draw everything on back buffer

        backGraphics.drawImage(background, backGroundX, backGroundY, null);
        GameObject.renderAll(backGraphics);



        //2.call repaint
        repaint();
    }
public void keyPressed (KeyEvent e){
        player.keyPressed(e);

}
public  void keyReleased (KeyEvent e){
    player.keyReleased(e);

}
    public void run() {
        GameObject.runAll();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);
    }
}