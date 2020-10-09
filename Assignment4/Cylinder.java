package info5100;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super(1,"red");
        this.height = 1;
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        double volume = super.getArea() * height;
        return volume;
    }

    @Override
    public double getArea(){
        double area;
        area = Math.PI * 2 * getRadius() * (getRadius() + height);
        return  area;
    }


}
