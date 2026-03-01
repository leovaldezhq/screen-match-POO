package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculations.Rateable;

public class Episode implements Rateable {
    private int number;
    private String title;
    private Show show;
    private int totalViews;

    public Episode(String title) {
        this.setTitle(title);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    @Override
    public int getRating() {
        if (totalViews >= 100) {
            return 4;
        } else {
            return 2;
        }
    }
}