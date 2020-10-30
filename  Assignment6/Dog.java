public class Dog extends Pet {
    private String size;

    public Dog(String name, String owner, String color, String size) {
        super(name, owner, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSize: " + getSize();
    }

    public static void main(String[] args) {
        Dog spot = new Dog("Spot", "Mary", "Black and White", "Medium");
        spot.setSex(2);
        spot.setBoardStart(1, 14, 1993);
        spot.setBoardEnd(11, 14, 2020);
        System.out.println(spot);
        System.out.println("Onboarding: " + spot.boarding(10, 19, 2020));
        System.out.println("Onboarding: " + spot.boarding(12, 19, 2020));
    }
}
