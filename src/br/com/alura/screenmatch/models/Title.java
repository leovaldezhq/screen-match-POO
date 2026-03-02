package br.com.alura.screenmatch.models;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInSubscription;
    private double ratingSum;
    private int totalRatings;
    private int lengthInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb omdbTitle) {
        this.name = omdbTitle.Title();
        this.releaseYear = Integer.parseInt(omdbTitle.Year().substring(0, 4));
        this.lengthInMinutes = Integer.parseInt(omdbTitle.Runtime().substring(0, 3));
    }

    public void showTechnicalSpecs() {
        System.out.println("Name: " + name);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Length in minutes: " + lengthInMinutes);
        System.out.println("Included in subscription: " + includedInSubscription);
    }
    public void rate(double rating) {
        ratingSum +=  rating;
        totalRatings++;
    }

    public double getAverageRating() {
        return ratingSum/totalRatings;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean getIncludedInSubscription() {
        return this.includedInSubscription;
    }

    public void setIncludedInSubscription(boolean includedInSubscription) {
        this.includedInSubscription = includedInSubscription;
    }

    public int getLengthInMinutes() {
        return this.lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public int getTotalRatings() {
        return this.totalRatings;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "(Name = " + name +
                ", Release year = " + releaseYear +
                ", Runtime = " + lengthInMinutes +
                 "min) ";
    }
}