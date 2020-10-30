import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mreview implements Comparable<Mreview> {
    private String title;
    private List<Integer> ratings;

    public Mreview() {
        this("");
    }

    public Mreview(String title) {
        this.title = title;
        this.ratings = new ArrayList<>();
    }

    public Mreview(String title, int rating) {
        this.title = title;
        this.ratings = new ArrayList<>(Arrays.asList(rating));
    }

    public void addRating(int r) {
        ratings.add(r);
    }

    public double aveRating() {
        return ratings.stream().mapToDouble(Integer::doubleValue).sum() / ratings.size();
    }

    public String getTitle() {
        return title;
    }

    public int numRatings() {
        return ratings.size();
    }

    @Override
    public int compareTo(Mreview o) {
        return Double.compare(aveRating(),o.aveRating());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nAverage rating: %.2f\nNumber of ratings: %d", getTitle(), aveRating(), numRatings());
    }

    public static void main(String[] args) {
        Mreview killBillReview = new Mreview("Kill Bill");
        killBillReview.addRating(3);
        killBillReview.addRating(4);
        killBillReview.addRating(4);
        System.out.println(killBillReview);

        Mreview killBill2Review = new Mreview("Kill Bill 2", 5);
        killBill2Review.addRating(3);
        killBill2Review.addRating(4);
        killBill2Review.addRating(4);
        System.out.println(killBill2Review);
    }
}
