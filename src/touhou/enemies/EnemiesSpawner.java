package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemiesSpawner extends GameObject {

    Random random = new Random();

    FrameCounter frameCounter = new FrameCounter(300);

    @Override
    public void run(){
        if(frameCounter.run()){
            frameCounter.reset();
            spawn();
        }
    }
    private void spawn(){
        Boss boss = new Boss();
        position.set(10,random.nextInt(360));
        GameObject.add(boss);

    }
}
