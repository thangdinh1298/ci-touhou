package bases;

import bases.physics.BoxCollider;
import touhou.backgrounds.BackGround;
import touhou.enemies.Boss;
import touhou.players.Player;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;

    public static boolean gameOver ;


    public BufferedImage image;

    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObject = new Vector<>();

    public GameObject(){
        position = new Vector2D();
        isActive = true;
    }

    public static void runAll(){
        for (GameObject gameObject : gameObjects){
            if(gameObject.isActive)
                gameObject.run();
        }
        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public static void renderAll(Graphics g){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive)
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
            g.drawImage(
                    image,
                    (int) (position.x - image.getWidth() / 2),
                    (int) (position.y - image.getHeight() / 2),
                    null);
        }
    }

    public static Boss collideWith(BoxCollider boxCollider){
        for(GameObject gameObject : gameObjects){
            if (gameObject.isActive && gameObject instanceof Boss){
                Boss boss = (Boss)gameObject;
                if (boss.boxCollider.collideWith(boxCollider)){
                    return boss;
                }
            }
        }
        return null;
    }
    public static boolean playerHit(BoxCollider boxCollider){
        for(GameObject gameObject: gameObjects){
            if(gameObject instanceof  Player){
                Player player = (Player) gameObject;
                if(player.boxCollider.collideWith(boxCollider)){
                    player.isActive = false;
                    return true;
                }
            }
        }
        return false;
    }
    public static void stop(){
        for(GameObject gameObject: gameObjects){
            if(!(gameObject instanceof BackGround)){
                gameObject.isActive = false;
            }
        }
    }
}
