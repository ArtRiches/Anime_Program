package main.Command;

import java.io.*;
import java.util.*;

import main.Anime;
import main.Genre;


import java.time.Year;

public class AnimeList {
    static List<Anime> animes = new ArrayList<>();

    public static void readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Anime anime = (Anime) ois.readObject();
            while (anime != null) {
                AnimeList.getAnimeList().add(anime);
                anime = (Anime) ois.readObject();
            }
        } catch (EOFException e) {
            System.out.println("The data from the file has been successfully read and added to the list!");
        } catch (ClassNotFoundException | IOException exception) {
            System.out.println("An error occurred while reading from a file!");
        }
    }

    public static Vector<String> getNameList() {
        Vector<String> animeNameList = new Vector<>();
        animeNameList.add("");
        for (Anime anime : animes) {
            animeNameList.add(anime.getName());
        }
        return animeNameList;
    }

    public static void add(InputStream inputStream) {
        Scanner in = new Scanner(inputStream);
        String name;
        while (true) {
            System.out.print("Enter anime name: ");
            String string = in.nextLine();
            if (string.trim().length() > 0) {
                name = string;
                break;
            } else System.out.println("An anime name should not be empty!");
        }
        int year;
        while (true) {
            System.out.print("Enter the year the anime was created: ");
            try {
                year = Integer.parseInt(in.nextLine());
                if (1900 <= year && year <= Integer.parseInt(Year.now().toString())) break;
                else {
                    System.out.println("Wrong year!");
                }
            } catch (NumberFormatException e) {
                System.out.println("The year should consist only of numbers!");
            }
        }
        boolean addGenreLoop = false;
        String string;
        List<Genre> genres = new ArrayList<>();
        while (!addGenreLoop) {
            System.out.println("Enter one of the suggested anime genres \n" + Arrays.toString(Genre.values()));
            string = in.nextLine();
            try {
                if ((string.trim().length() > 0) && (!genres.contains(Genre.valueOf(string.toUpperCase())))) {
                    genres.add(Genre.valueOf(string.toUpperCase()));
                } else {
                    System.out.println("The anime genre cannot be empty or duplicated!");
                    continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect data entry, try again!");
                continue;
            }
            System.out.println("Want to add another genre? (y/n)");
            boolean ynLoop = false;
            while (!ynLoop) {
                String yn = in.nextLine();
                switch (yn.toLowerCase()) {
                    case "y" -> ynLoop = true;
                    case "n" -> addGenreLoop = ynLoop = true;
                    default -> System.out.println("Incorrect data entry, try again!");
                }
            }
        }
        AnimeList.getAnimeList().add(new Anime(name, year, genres));
        System.out.println("Anime has been successfully added to the list!");
        AnimeList.show();
    }

    public static void show() {
        if (AnimeList.getAnimeList().size() == 0) {
            System.out.println("The list is empty!");
            return;
        }
        for (Anime anime : AnimeList.getAnimeList()) {
            System.out.println(anime.toString(anime, anime.getMaxNameLength(AnimeList.getAnimeList())));
        }
    }

    public static void remove(InputStream inputStream) {
        if (AnimeList.getAnimeList().size() == 0) {
            System.out.println("The list is empty!");
            return;
        }
        Scanner in = new Scanner(inputStream);
        int id;
        int index = 0;
        for (Anime anime : AnimeList.getAnimeList()) {
            System.out.println("id[" + index + "] " + anime.toString(anime, anime.getMaxNameLength(AnimeList.getAnimeList())));
            index++;
        }
        boolean removeLoop = true;
        while (removeLoop) {
            System.out.print("Enter the id of the Anime you want to delete: ");
            try {
                id = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data entry, try again!");
                continue;
            }
            if (0 <= id && id < (AnimeList.getAnimeList().size())) {
                AnimeList.getAnimeList().remove(id);
                System.out.println("The anime has been successfully removed from the list!\n");
                AnimeList.show();
                break;
            } else {
                System.out.println("Anime with this id does not exist!\nDo you want to continue? (y/n)");
                boolean ynLoop = true;
                while (ynLoop) {
                    String string = in.nextLine();
                    switch (string.toLowerCase()) {
                        case "y" -> ynLoop = false;
                        case "n" -> removeLoop = ynLoop = false;
                        default -> System.out.println("Incorrect data entry, try again!");
                    }
                }
            }
        }
    }

    public static void search(InputStream inputStream) {
        if (AnimeList.getAnimeList().size() == 0) {
            System.out.println("The list is empty!");
            return;
        }
        boolean searchLoop = true;
        boolean caseLoop;
        int count = 0;
        Scanner in = new Scanner(inputStream);
        while (searchLoop) {
            caseLoop = true;
            System.out.println("Enter 'name' to search by name\n" +
                    "Enter 'year' to search by year of creation\n" +
                    "Enter 'genre' to search by genre\n" +
                    "Enter 'back' to go back");
            switch (in.nextLine().toLowerCase()) {
                case "name" -> {
                    while (caseLoop) {
                        System.out.print("Enter anime name: ");
                        String string = in.nextLine();
                        if (string.trim().length() == 0) {
                            System.out.println("An anime name should not be empty!");
                            continue;
                        }
                        for (Anime anime : AnimeList.getAnimeList()) {
                            for (int i = 0; i < anime.getName().length() - (string.length() - 1); i++) {
                                if (anime.getName().regionMatches(true, i, string, 0, string.length())) {
                                    count++;
                                    System.out.println(anime.toString(anime, anime.getMaxNameLength(AnimeList.getAnimeList())));
                                    break;
                                }
                            }
                        }
                        if (count != 0) searchLoop = false;
                        else System.out.println("No such anime found!\n");
                        caseLoop = false;
                    }
                }
                case "year" -> {
                    while (caseLoop) {
                        System.out.print("Enter the year the anime was created: ");
                        String string = in.nextLine();
                        try {
                            Integer.parseInt(string);
                        } catch (NumberFormatException e) {
                            System.out.println("The year should consist only of numbers!");
                            continue;
                        }
                        for (Anime anime : AnimeList.getAnimeList()) {
                            for (int i = 0; i < Integer.toString(anime.getYear()).length() - (string.length() - 1); i++) {
                                if (Integer.toString(anime.getYear()).regionMatches(i, string, 0, string.length())) {
                                    count++;
                                    System.out.println(anime.toString(anime, anime.getMaxNameLength(AnimeList.getAnimeList())));
                                    break;
                                }
                            }
                        }
                        if (count != 0) searchLoop = false;
                        else System.out.println("No such anime found!\n");
                        caseLoop = false;
                    }
                }
                case "genre" -> {
                    while (caseLoop) {
                        System.out.println("Enter one of the suggested anime genres \n" + Arrays.toString(Genre.values()));
                        String string = in.nextLine();
                        try {
                            for (Anime anime : AnimeList.getAnimeList()) {
                                if (anime.getGenres().contains(Genre.valueOf(string.toUpperCase()))) {
                                    count++;
                                    System.out.println(anime.toString(anime, anime.getMaxNameLength(AnimeList.getAnimeList())));
                                }
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Incorrect data entry, try again!");
                            continue;
                        }
                        if (count != 0) searchLoop = false;
                        else System.out.println("No such anime found!\n");
                        caseLoop = false;
                    }
                }
                case "back" -> searchLoop = false;
                default -> System.out.println("Incorrect data entry, try again!");
            }
        }
    }

    public static void save(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Anime anime : AnimeList.getAnimeList()) {
                oos.writeObject(anime);
            }
            System.out.println("Data successfully saved to file!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing data to the file!");
            throw new RuntimeException(e);
        }
    }

    public static List<Anime> getAnimeList(){
        return animes;
    }

    public static String getInfoAboutCommand() {
        return ("""
                add:    add a new element to the list
                show:   display information about all elements of a list
                remove: remove an element from a list by its id
                search: display all list elements by name, year of creation or genre
                save:   save data from list to file
                """);

    }

}
