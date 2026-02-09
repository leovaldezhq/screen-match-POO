public class Main {
    public static void main(String[] args) {
        Movie movieA = new Movie();
        movieA.name = "O Agente Secreto";
        movieA.releaseYear = 2025;
        movieA.movieDurationMinutes = 160;
        movieA.includedInSubscription = true;

            movieA.showTechnicalSpecs();
            movieA.rate(8);
            movieA.rate(7);
            movieA.rate(5);

            System.out.println("Média das avaliações: " + movieA.averageRating());
    }
}