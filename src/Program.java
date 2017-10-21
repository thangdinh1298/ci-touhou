import bases.Vector2D;


public class Program {
    public static void main(String[] args) {
        Vector2D v = new Vector2D();
        System.out.println(v);

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
