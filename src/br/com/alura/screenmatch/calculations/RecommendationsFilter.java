package br.com.alura.screenmatch.calculations;

public class RecommendationsFilter {

    public void filter(Rateable rateable) {
        if (rateable.getRating() >= 4) {
            System.out.println("Fan favorite of the week!");
        } else if  (rateable.getRating() >= 3) {
            System.out.println("Great ratings this week!");
        } else {
            System.out.println("Add to watch later");
        }
    }
}