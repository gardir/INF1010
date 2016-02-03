public class Main{
    public static void main(String[] args){
        Circle c1 = new Circle(1.0);
        Square s1 = new Square(4.0);
        Square s2 = new Square(6.0);

        ShapeDemo<Square> demo = new ShapeDemo<Square>();
        demo.commandLoop(s1, s2);

    }

}