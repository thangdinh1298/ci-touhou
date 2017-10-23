package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemiesSpawner extends GameObject {

    Random random = new Random();

    FrameCounter frameCounter = new FrameCounter(120);

    @Override
    public void run(){
        if(frameCounter.run()){
            frameCounter.reset();
            spawn();
        }
    }
    private void spawn(){
        Boss boss = new Boss();
        boss.position.x = random.nextInt(360);
        boss.position.y = -75;
        boss.boxCollider.position.set(boss.position);
        GameObject.add(boss);

    }
}
