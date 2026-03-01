package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Show;
import br.com.alura.screenmatch.models.Title;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainLists {
    public static void main(String[] args) {
        Movie movieA = new Movie("Rocky", 1976);
        movieA.rate(10);
        Movie movieB = new Movie("I'm Still Here", 2024);
        movieB.rate(8.9);
        Movie movieC = new Movie("Vitória", 2025);
        movieC.rate(9.6);
        Show lupin = new Show("Lupin", 2021);

        ArrayList<Title> list = new ArrayList<>();
        list.add(movieA);
        list.add(movieB);
        list.add(movieC);
        list.add(lupin);
        for (Title item : list) {
            System.out.println("Name: " + item.getName());
            if (item instanceof Movie movie && movie.getRating() > 2) {
                System.out.println("Rating: " + movie.getRating());
            }
        }

        ArrayList<String> searchArtist = new  ArrayList<>();
        searchArtist.add("Fernanda Montenegro");
        searchArtist.add("Fernanda Torres");
        searchArtist.add("Sylvester Stallone");

        System.out.println("List of artists: ");
        Collections.sort(searchArtist);
        System.out.println(searchArtist);

        System.out.println("List of movies: ");
        Collections.sort(list);
        System.out.println(list);

        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("List of movies reverse order: ");
        System.out.println(list);

    }
}