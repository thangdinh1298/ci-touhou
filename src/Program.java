import bases.Rectangles;

import java.util.ArrayList;


public class Program {
    public static void main(String[] args) {
        Rectangles rec1 = new Rectangles(3,4,5,6);
        System.out.println(rec1.collided(new Rectangles(12,13,14,15)));

        GameWindow gameWindow = new GameWindow();
        gameWindow.GameLoop();



    }
}
//        Base base = new Base();
//        base.sayHello();
//
//        A a = new A();
//        a.sayHello();
//
//        B b = new B();
//        b.sayHello();

//        ArrayList<Base> bases = new ArrayList<>();
//
//        Base base = new Base();
//        bases.add(base);
//
//        A a = new A();
//        bases.add(a);
//
//        for( Base be : bases){
//            be.sayHello();
//        }
//
