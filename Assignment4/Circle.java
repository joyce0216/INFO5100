package info5100;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this(1);
    }


    public Circle(double radius) {
        this(radius, "red");
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        double area = Math.PI * radius * radius;
        return area;
    }
}
