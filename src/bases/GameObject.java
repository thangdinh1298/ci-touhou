package bases;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public float x;
    public float y;
    public BufferedImage image;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObject = new Vector<>();

    public static void runAll(){
        for (GameObject gameObject : gameObjects){
            gameObject.run();
        }
        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public static void renderAll(Graphics g){
        for(GameObject gameObject : gameObjects){
            gameObject.render(g);
        }
    }

    public static void add(GameObject gameObject){
        newGameObject.add(gameObject);
    }


    public void run(){

    }

    public void render(Graphics g){
        if(image != null){
            g.drawImage(image, (int) x, (int) y,null);
        }
    }
}
