import static java.lang.Math.sqrt;

public class Vector2D {

    float x;
    float y;

    public Vector2D(){
        this(0,0);
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }


    public void print(){
        System.out.println("x = " + this.x + "," + "y = " +this.y);
    }

    public void set(float x , float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D clone(){
        Vector2D newVector2D = new Vector2D(this.x, this.y);
        return newVector2D;
    }

    public void addUp(float x, float y){
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D vector2D){
        this.addUp(vector2D.x,vector2D.y);
    }


    public Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D vector2D){
        return add(vector2D.x, vector2D.y);
    }

    public void subtractBy(float x, float y){
        this.x -= x;
        this.y -= y;
    }


    public void subtractBy (Vector2D vector2D){
        this.subtractBy(vector2D.x,vector2D.y);
    }


    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x - x, this.y - y);
    }


    public Vector2D subtract(Vector2D vector2D){
//        Vector2D newVector2D = new Vector2D(this.x - vector2D.x, this.y - vector2D.y);
        return new Vector2D(this.x - vector2D.x, this.y - vector2D.y );
    }


    public Vector2D multiply(float x){
        return new Vector2D(this.x * x, this.y *x);
    }

    public double length(){
        return sqrt(this.x*this.x + this.y * this.y);
    }
}
