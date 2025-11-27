package capgemini.opps;

public class Main {
    public static void main(String[] args) {
        Shape shape = new BoxVolume(3);
        int area = shape.calcArea();
        System.out.println(area);
    }
}
