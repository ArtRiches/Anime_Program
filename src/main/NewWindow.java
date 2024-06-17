package main;

import main.Command.AnimeList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewWindow {
    JFrame frame = new JFrame();
    JLabel label;
    JTextField nameTextField;
    JTextField yearTextField;
    JCheckBox comedyCheckBox;
    JCheckBox romanceCheckBox;
    JCheckBox schoolCheckBox;
    JCheckBox dramaCheckBox;
    JCheckBox historicalCheckBox;
    JCheckBox actionCheckBox;
    JCheckBox adventuresCheckBox;
    JCheckBox fantasyCheckBox;
    JCheckBox fantasticCheckBox;
    JCheckBox supernaturalCheckBox;
    JCheckBox detectiveCheckBox;
    JButton addAnimeButton = new JButton();
    JButton backButton = new JButton();

    public NewWindow(){

        frame.setTitle("Add new anime");
        frame.getContentPane().setBackground(new Color(30,30,30));
        frame.setLayout(null);
        frame.setBounds(700,100,470,500);
        frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
        label = new JLabel();
        label.setText("Enter");
        label.setForeground(new Color(215,215,215));
        label.setBounds(20,25,100,25);
        label.setFont(new Font("Helvetica Neue (Основной текст)",Font.BOLD,24));
        frame.add(label);

        //Name
        Border border = BorderFactory.createLineBorder(new Color(30,30,30));
        label = new JLabel();
        label.setText("Name:");
        label.setForeground(new Color(215,215,215));
        label.setBounds(20,60,100,25);
        label.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,20));
        frame.add(label);
        nameTextField = new JTextField();
        nameTextField.setBounds(label.getX()+label.getWidth()+5,label.getY(),250,35);
        nameTextField.setBorder(border);
        nameTextField.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,20));
        frame.add(nameTextField);

        //Year
        label = new JLabel();
        label.setText("Year:");
        label.setForeground(new Color(215,215,215));
        label.setBounds(20,105,100,25);
        label.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,20));
        frame.add(label);
        yearTextField = new JTextField();
        yearTextField.setBounds(label.getX()+label.getWidth()+5,label.getY(),250,35);
        yearTextField.setBorder(border);
        yearTextField.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,20));
        frame.add(yearTextField);

        label = new JLabel();
        label.setText("Choose");
        label.setForeground(new Color(215,215,215));
        label.setBounds(20,160,100,25);
        label.setFont(new Font("Helvetica Neue (Основной текст)",Font.BOLD,24));
        frame.add(label);

        comedyCheckBox = new JCheckBox("Comedy");
        comedyCheckBox.setForeground(new Color(215,215,215));
        comedyCheckBox.setBounds(20,200,130,25);
        comedyCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        comedyCheckBox.setBackground(new Color(50,50,50));
        comedyCheckBox.setFocusable(false);
        frame.add(comedyCheckBox);

        romanceCheckBox = new JCheckBox("Romance");
        romanceCheckBox.setForeground(new Color(215,215,215));
        romanceCheckBox.setBounds(170,200,130,25);
        romanceCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        romanceCheckBox.setBackground(new Color(50,50,50));
        romanceCheckBox.setFocusable(false);
        frame.add(romanceCheckBox);

        schoolCheckBox = new JCheckBox("School");
        schoolCheckBox.setForeground(new Color(215,215,215));
        schoolCheckBox.setBounds(320,200,130,25);
        schoolCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        schoolCheckBox.setBackground(new Color(50,50,50));
        schoolCheckBox.setFocusable(false);
        frame.add(schoolCheckBox);

        dramaCheckBox = new JCheckBox("Drama");
        dramaCheckBox.setForeground(new Color(215,215,215));
        dramaCheckBox.setBounds(20,230,130,25);
        dramaCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        dramaCheckBox.setBackground(new Color(50,50,50));
        dramaCheckBox.setFocusable(false);
        frame.add(dramaCheckBox);

        historicalCheckBox = new JCheckBox("Historical");
        historicalCheckBox.setForeground(new Color(215,215,215));
        historicalCheckBox.setBounds(170,230,130,25);
        historicalCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        historicalCheckBox.setBackground(new Color(50,50,50));
        historicalCheckBox.setFocusable(false);
        frame.add(historicalCheckBox);

        actionCheckBox = new JCheckBox("Action");
        actionCheckBox.setForeground(new Color(215,215,215));
        actionCheckBox.setBounds(320,230,130,25);
        actionCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        actionCheckBox.setBackground(new Color(50,50,50));
        actionCheckBox.setFocusable(false);
        frame.add(actionCheckBox);

        adventuresCheckBox = new JCheckBox("Adventure");
        adventuresCheckBox.setForeground(new Color(215,215,215));
        adventuresCheckBox.setBounds(20,260,130,25);
        adventuresCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        adventuresCheckBox.setBackground(new Color(50,50,50));
        adventuresCheckBox.setFocusable(false);
        frame.add(adventuresCheckBox);

        fantasyCheckBox = new JCheckBox("Fantasy");
        fantasyCheckBox.setForeground(new Color(215,215,215));
        fantasyCheckBox.setBounds(170,260,130,25);
        fantasyCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        fantasyCheckBox.setBackground(new Color(50,50,50));
        fantasyCheckBox.setFocusable(false);
        frame.add(fantasyCheckBox);

        fantasticCheckBox = new JCheckBox("Fantastic");
        fantasticCheckBox.setForeground(new Color(215,215,215));
        fantasticCheckBox.setBounds(320,260,130,25);
        fantasticCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        fantasticCheckBox.setBackground(new Color(50,50,50));
        fantasticCheckBox.setFocusable(false);
        frame.add(fantasticCheckBox);

        supernaturalCheckBox = new JCheckBox("Supernatural");
        supernaturalCheckBox.setForeground(new Color(215,215,215));
        supernaturalCheckBox.setBounds(20,290,130,25);
        supernaturalCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        supernaturalCheckBox.setBackground(new Color(50,50,50));
        supernaturalCheckBox.setFocusable(false);
        frame.add(supernaturalCheckBox);

        detectiveCheckBox = new JCheckBox("Detective");
        detectiveCheckBox.setForeground(new Color(215,215,215));
        detectiveCheckBox.setBounds(170,290,130,25);
        detectiveCheckBox.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        detectiveCheckBox.setBackground(new Color(50,50,50));
        detectiveCheckBox.setFocusable(false);
        frame.add(detectiveCheckBox);

        Panel panel = new Panel();
        panel.setBounds(0,340,470,150);

        backButton.setPreferredSize(new Dimension(90,45));
        backButton.setText("Back");
        backButton.setBackground(new Color(54,90,120));
        backButton.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        backButton.setBorder(border);
        backButton.setForeground(new Color(215,215,215));
        backButton.setFocusable(false);
        panel.add(backButton);
        backButton.addActionListener(e -> {
            UI.searchTextField.setEnabled(true);
            UI.searchButton.setEnabled(true);
            UI.addNewAnimeButton.setEnabled(true);
            frame.dispose();
        });

        addAnimeButton.setPreferredSize(new Dimension(90,45));
        addAnimeButton.setText("Add");
        addAnimeButton.setBackground(new Color(54,90,120));
        addAnimeButton.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        addAnimeButton.setBorder(border);
        addAnimeButton.setForeground(new Color(215,215,215));
        addAnimeButton.setFocusable(false);
        panel.add(addAnimeButton);
        addAnimeButton.addActionListener(e -> {
            List<Genre> genres = new ArrayList<>();
            if(comedyCheckBox.isSelected()) {genres.add(Genre.COMEDY);}
            if(romanceCheckBox.isSelected()) {genres.add(Genre.ROMANCE);}
            if(schoolCheckBox.isSelected()) {genres.add(Genre.SCHOOL);}
            if(dramaCheckBox.isSelected()) {genres.add(Genre.DRAMA);}
            if(historicalCheckBox.isSelected()) {genres.add(Genre.HISTORICAL);}
            if(actionCheckBox.isSelected()) {genres.add(Genre.ACTION);}
            if(adventuresCheckBox.isSelected()) {genres.add(Genre.ADVENTURES);}
            if(fantasyCheckBox.isSelected()) {genres.add(Genre.FANTASY);}
            if(fantasticCheckBox.isSelected()) {genres.add(Genre.FANTASTIC);}
            if(supernaturalCheckBox.isSelected()) {genres.add(Genre.SUPERNATURAL);}
            if(detectiveCheckBox.isSelected()) {genres.add(Genre.DETECTIVE);}
            Anime anime = new Anime(nameTextField.getText(), Integer.parseInt(yearTextField.getText()), genres);
            AnimeList.getAnimeList().add(anime);
            UI.searchTextField.setEnabled(true);
            UI.searchButton.setEnabled(true);
            UI.addNewAnimeButton.setEnabled(true);
            UI.deleteComboBox.addItem(nameTextField.getText());
            UI.showAnime(AnimeList.getAnimeList());
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
