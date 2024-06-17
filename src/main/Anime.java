package main;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Anime implements Serializable {
    @Serial
    private static final long serialVersionUID = -1668269290246788651L;
    private String name;
    private int year;
    private List<Genre> genres;

    public Anime(String name, int year, List<Genre> genres) {
        setName(name);
        setYear(year);
        setGenres(genres);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getMaxNameLength(List<Anime> animes) {
        int maxLength = 0;
        for (Anime anime : animes) {
            if (maxLength < anime.getName().length()) maxLength = anime.getName().length();
        }
        return maxLength;
    }

    public String toString(Anime anime, int maxLength) {
        String string = ("Name: " + anime.getName());
        for (int i = anime.getName().length(); i < maxLength; i++) {
            string = string.concat(" ");
        }
        return string.concat("\tReleased: " + anime.getYear() + "\tGenres: " + anime.getGenres());
    }

}
