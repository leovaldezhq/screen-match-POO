package br.com.alura.screenmatch.models;

public class Show extends Title {
    private int seasons;
    private int episodesPerSeason;
    private boolean active;
    private int episodesLengthInMinutes;

    public Show(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesLengthInMinutes() {
        return episodesLengthInMinutes;
    }

    public void setEpisodesLengthInMinutes(int lengthInMinutes) {
        this.episodesLengthInMinutes = lengthInMinutes;
    }

    @Override
    public int getLengthInMinutes() {
        return seasons * episodesPerSeason * episodesLengthInMinutes;
    }

    @Override
    public String toString() {
        return "Show: " + this.getName() + " (" + getReleaseYear() + ")";
    }
}
