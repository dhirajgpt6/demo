package capgemini.opps;

import java.awt.*;

public class BoxVolume extends Shape {
    public BoxVolume(int length) {
        this.length = length;
        this.breadth = 2*length;
        this.height = 4*breadth;
    }

    @Override
    int calcArea() {
        return length * breadth * height;
    }
}
