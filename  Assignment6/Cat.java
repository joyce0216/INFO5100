public class Cat extends Pet {
    private String hairLength;

    public Cat(String name, String owner, String color, String hairLength) {
        super(name, owner, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHair: " + getHairLength();
    }

    public static void main(String[] args) {
        Cat spot = new Cat("Spot", "Mary", "Black and White", "Short");
        spot.setSex(3);
        spot.setBoardStart(1, 14, 1993);
        spot.setBoardEnd(11, 14, 2020);
        System.out.println(spot);
        System.out.println("Onboarding: " + spot.boarding(10, 19, 2020));
        System.out.println("Onboarding: " + spot.boarding(12, 19, 2020));
    }
}
