package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculations.LengthCalculator;
import br.com.alura.screenmatch.calculations.RecommendationsFilter;
import br.com.alura.screenmatch.models.Episode;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Show;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie movieA = new Movie("The Secret Agent", 2025);
        movieA.setLengthInMinutes(160);
        movieA.setIncludedInSubscription(true);

        movieA.showTechnicalSpecs();
        movieA.rate(8);
        movieA.rate(7);
        movieA.rate(5);

        System.out.println("Average rating: " + movieA.getAverageRating());

        Movie movieB = new Movie("I'm Still Here", 2024);
        movieB.setLengthInMinutes(135);
        movieB.setIncludedInSubscription(true);

        Show lupin = new Show("Lupin", 2021);
        lupin.setIncludedInSubscription(true);
        lupin.setSeasons(3);
        lupin.setEpisodesPerSeason(7);
        lupin.setEpisodesLengthInMinutes(60);
        System.out.println("It will take you: " + lupin.getLengthInMinutes() + " minutes to binge-watch Lupin.");

        LengthCalculator calculator = new LengthCalculator();
        calculator.includes(movieA);
        calculator.includes(movieB);
        calculator.includes(lupin);
        System.out.println("Total length: " + calculator.getTotalLength());

        RecommendationsFilter filter = new RecommendationsFilter();
        filter.filter(movieA);

        Episode episode = new Episode("Chapter 1");
        episode.setNumber(1);
        episode.setShow(lupin);
        episode.setTotalViews(500);
        filter.filter(episode);

        Movie movieC = new Movie("Vitória", 2025);
        movieC.setLengthInMinutes(112);
        movieC.setIncludedInSubscription(true);
        movieC.rate(10);

        ArrayList<Movie> list = new ArrayList<>();
        list.add(movieA);
        list.add(movieB);
        list.add(movieC);

        System.out.println("List size: " + list.size());
        System.out.println("First movie: " +  list.get(0));
        System.out.println("Full movies list: ");
        for (Movie movie :  list) {
            System.out.println(movie);
        }
    }
}