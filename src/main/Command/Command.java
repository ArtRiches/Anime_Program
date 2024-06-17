package main.Command;

import java.io.InputStream;
import java.util.Scanner;


public class Command {

    public static void search(InputStream inputStream, String fileName) {
        System.out.print("help: display all commands\nEnter the command: ");
        Scanner in = new Scanner(inputStream);
        while (in.hasNextLine()) {
            String command = in.nextLine();
            switch (command.toLowerCase()) {
                case "help" -> System.out.println(AnimeList.getInfoAboutCommand() + "exit:   exit the program");
                case "show" -> AnimeList.show();
                case "add" -> AnimeList.add(inputStream);
                case "remove" -> AnimeList.remove(inputStream);
                case "search" -> AnimeList.search(inputStream);
                case "save" -> AnimeList.save(fileName);
                case "exit" -> {
                    System.out.println("Save the file before exiting? (y/n)");
                    boolean loop = true;
                    while (loop) {
                        String string = in.nextLine();
                        switch (string.toLowerCase()) {
                            case "y" -> {
                                AnimeList.save(fileName);
                                loop = false;
                            }
                            case "n" -> loop = false;
                            default -> System.out.println("Incorrect data entry, try again!");
                        }
                    }
                    System.out.print("Сlosing...");
                    System.exit(1);
                }
                default -> System.out.print("The command was not found!\nhelp: display all commands");
            }
            System.out.print("\nEnter the command: ");
        }
    }
}
