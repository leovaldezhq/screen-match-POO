public class Movie {
    String name;
    int releaseYear;
    boolean includedInSubscription;
    double ratingSum;
    int totalRatings;
    int movieDurationMinutes;

        void showTechnicalSpecs() {
            System.out.println("Nome do filme: " + name);
            System.out.println("Ano de lançamento: " + releaseYear);
    }
        void rate(double rating) {
            ratingSum +=  rating;
            totalRatings++;
        }

        double averageRating() {
            return ratingSum/totalRatings;
        }
}