package info5100;

public class TestCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(2);
        circle.setColor("yellow");
        System.out.println(
                "Radius is " + circle.getRadius() +
                ", Color is " + circle.getColor() +
                ", Base area is " + circle.getArea());

        Cylinder cylinder1 = new Cylinder();
        System.out.println(
                "Radius is " + cylinder1.getRadius() +
                ", Height is " + cylinder1.getHeight() +
                ", Color is " + cylinder1.getColor() +
                ", Base area is " + cylinder1.getArea() +
                ", Volume is " + cylinder1.getVolume());

        Cylinder cylinder2 = new Cylinder(5, 2);
        System.out.println(
                "Radius is " + cylinder2.getRadius() +
                        ", Height is " + cylinder2.getHeight() +
                        ", Color is " + cylinder2.getColor() +
                        ", Base area is " + cylinder2.getArea() +
                        ", Volume is " + cylinder2.getVolume());
    }

}
