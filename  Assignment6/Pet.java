public class Pet implements Boardable {
    private String name;
    private String owner;
    private String color;
    protected Sex sex;

    private int startYear;
    private int startMonth;
    private int startDay;
    private int endYear;
    private int endMonth;
    private int endDay;

    public Pet(String name, String owner, String color) {
        this.name = name;
        this.owner = owner;
        this.color = color;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        if (month > 12 || month < 1
                || day > 31 || day < 1
                || year > 2020) {
            throw new IllegalArgumentException("Date is invalid.");
        }

        this.startMonth = month;
        this.startDay = day;
        this.startYear = year;
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        if (month > 12 || month < 1
                || day > 31 || day < 1
                || year > 2020) {
            throw new IllegalArgumentException("Date is invalid.");
        }

        this.endMonth = month;
        this.endDay = day;
        this.endYear = year;
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        return combineDate(month, day, year) <= combineDate(endMonth, endDay, endYear)
                && combineDate(month, day, year) >= combineDate(startMonth, startDay, startYear);
    }

    private int combineDate(int month, int day, int year) {
        return year * 10000 + month * 100 + day;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(int value) {
        this.sex = Sex.fromValue(value);
    }

    @Override
    public String toString() {
        return String.format("%s owned by %s \nColor: %s\nSex: %s", getName(), getOwner(), getColor(), getSex());
    }

    private enum Sex {
        MALE, FEMALE, SPAYED, NEUTERED, UNKNOWN;

        public static Sex fromValue(int value) {
           if(value == 1) {
               return MALE;
           }

            if(value == 2) {
                return FEMALE;
            }

            if(value == 3) {
                return SPAYED;
            }

            if(value == 4) {
                return NEUTERED;
            }

            return UNKNOWN;
        }
    }

    public static void main(String[] args) {
        Pet spot = new Pet("Spot", "Mary", "Black and White");
        spot.setSex(1);
        System.out.println(spot);
    }
}
