package main;

import main.Command.*;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("AnimeList.txt");
        AnimeList.readFromFile(file.getName());
        System.out.println("If you want to run the desktop application, write \"yes\". If you want to run a console application, write \"no\".");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                new UI();
                break;
            }
            else {
                if (answer.equals("no")) {
                    Command.search(System.in, file.getName());
                    break;
                }
                else {
                    System.out.println("Invalid data entry, try again");
                }
            }
        }
    }
}