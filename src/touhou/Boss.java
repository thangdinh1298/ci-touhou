package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Boss {
    public static int x = 175;
    public static int y = -100;

    ArrayList<String> direction = new ArrayList<>(Arrays.asList("left", "right", "up","down","upleft","upright","downleft","downright"));

    final int SPEED = 2;

    BufferedImage image;

    int rightStep;
    int diagStep;
    int upStep;
    int leftStep;
    int downStep;

    int index;
    int countLeft = 0;
    int countRight = 0;
    int countUp = 0;
    int countDown = 0;

    int countAppear = 0;

    public boolean appeared = false;
    boolean iteration = false;

    public Boss() {
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
    }

    public void initVal() {
        rightStep = randomStepRight();
        leftStep = randomStepLeft();
        downStep = randomStepDown();
        upStep = randomStepUp();
        Collections.shuffle(direction);
        index = 0;
        countRight = 0;
        countLeft = 0;
        countUp = 0;
        countDown = 0;
    }

    public int movePattern() {//huong di chuyen cua boss
        if (index == 7) {
            iteration = true;
            return 0;
        }
        if (direction.get(index) == "left") {
            if (countLeft < leftStep) {
                x -= SPEED;
                countLeft++;
            } else if (countLeft >= leftStep)
                {
                System.out.println(index);
                index++;
            }
        }
        else if ( direction.get(index) == "right"){
            if (countRight < rightStep) {
                x += SPEED;
                countRight++;
            } else if (countRight >= rightStep){
                index++;
            }
        }
        else if ( direction.get(index) == "up"){
            if (countUp < upStep) {
                y -= SPEED;
                countUp++;
            } else if (countUp >= upStep){
                index++;
            }
        }
        else if(direction.get(index) == "down"){
            if (countDown < downStep) {
                y += SPEED;
                countDown++;
            } else if (countDown >= downStep){
                index++;
            }
        }
        else if(direction.get(index) == "upleft"){
            if (countLeft < leftStep) {
                x -= SPEED;
                countLeft++;
            }
            if (countUp < upStep) {
                y -= SPEED;
                countUp++;
            }
            if(countLeft >= leftStep || countUp >= upStep)
                index++;
        }
        else if(direction.get(index) == "upright"){
            if (countRight < rightStep) {
                x += SPEED;
                countRight++;
            }
            if (countUp < upStep) {
                y -= SPEED;
                countUp++;
            }
            if(countRight >= rightStep || countUp >= upStep)
                index++;
        }
        else if(direction.get(index) == "downright"){
            if (countRight < rightStep) {
                x += SPEED;
                countRight++;
            }
            if (countDown < downStep) {
                y += SPEED;
                countDown++;
            }
            if(countRight >= rightStep || countDown >= downStep)
                index++;
        }
        else if(direction.get(index) == "downleft"){
            if (countLeft < leftStep) {
                x -= SPEED;
                countLeft++;
            }
            if (countDown < downStep) {
                y += SPEED;
                countDown++;
            }
            if(countLeft >= leftStep || countDown >= downStep)
                index++;
        }
        return 1 ;
    }


    public void appear(){
        if(countAppear < 34){
            y += 5;
            countAppear++;
        }
        else {
            appeared = true;
            initVal();
        }
    }


    public void render(Graphics g){
        g.drawImage(image, x, y, null);
    }
    public void run(){

        if(this.appeared == false){
            this.appear();
        }
        else if(this.appeared == true){
            if(this.iteration == false){
                this.movePattern();
            }
            else{
                initVal();
                this.iteration = false;
            }
        }
    }
    private int randomStepRight(){
        return ThreadLocalRandom.current().nextInt(1, 384 - this.x)/SPEED;
    }
    private int randomStepLeft(){
        return ThreadLocalRandom.current().nextInt(1,this.x )/SPEED;
    }
    private int randomStepUp(){
        return ThreadLocalRandom.current().nextInt(1,this.y )/SPEED;
    }
    private  int randomStepDown(){
        return ThreadLocalRandom.current().nextInt(1,300 - this.y)/SPEED;
    }
}
