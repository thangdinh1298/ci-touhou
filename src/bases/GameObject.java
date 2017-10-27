package bases;

import bases.physics.BoxCollider;
import bases.physics.Deactivated;
import bases.physics.PhysicsBody;
import touhou.backgrounds.BackGround;
import touhou.enemies.Boss;
import touhou.enemies.EnemiesSpawner;
import touhou.players.Player;
import touhou.players.Spell;

import javax.swing.*;
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
            System.out.println(gameObjects.size());
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

//    public static Boss collideWith(BoxCollider boxCollider){
//        for(GameObject gameObject : gameObjects){
//            if (gameObject.isActive && gameObject instanceof Boss){
//                Boss boss = (Boss)gameObject;
//                if (boss.boxCollider.collideWith(boxCollider)){
//                    return boss;
//                }
//            }
//        }
//        return null;
//    }

    public static <T extends PhysicsBody > T collideWith(BoxCollider boxCollider, Class<? extends PhysicsBody> cls){
        for(GameObject gameObject: gameObjects){
            if(!(gameObject.isActive)) continue;
            if (!(gameObject.getClass().equals(cls)))continue;

            if(((PhysicsBody) gameObject).getBoxCollider().collideWith(boxCollider)){
                return (T) gameObject;
            }
        }
        return null;
    }

    public static void stop(){
        for(GameObject gameObject: gameObjects){
            if(!(gameObject instanceof BackGround)){
                gameObject.isActive = false;
            }
        }
    }

    public static <T extends GameObject > T recycle(Class<T> cls){
        for(GameObject gameObject: gameObjects){
            if (gameObject.isActive) continue;
            if(gameObject.getClass().equals(cls)){
                gameObject.isActive = true;
                return (T) gameObject;
            }
        }
        try {
            T newGameObject1 = cls.newInstance();
            add(newGameObject1);
            return newGameObject1;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}

