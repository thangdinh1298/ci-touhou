package bases;

public class Rectangles {
    public int topLeftX;
    public int topLeftY;
    public int bottomRightX;
    public int bottomRightY;

    public Rectangles(int topLeftX,int topLeftY, int bottomRightX, int bottomRightY){
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
        this.topLeftY = topLeftY;
        this.topLeftX = topLeftX;
    }

    public boolean collided(Rectangles rectangle){
        if(this.topLeftX > rectangle.bottomRightX || this.bottomRightX < rectangle.topLeftX){
            return false;
        }
        if(this.topLeftY > rectangle.bottomRightY || this.bottomRightY < rectangle.topLeftY){
            return false;
        }
        return true;
    }
}
