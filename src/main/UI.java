package main;

import main.Command.AnimeList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UI{
    static JButton searchButton = new JButton();
    static JButton addNewAnimeButton = new JButton();
    static JButton deleteAnimeButton = new JButton();
    static JTextField searchTextField = new JTextField();
    static JComboBox deleteComboBox = new JComboBox<>();
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();


    public UI() {
        //Frame
        frame.setSize( 1920, 1080);
        frame.setTitle("My Shikimori");
        frame.getContentPane().setBackground(new Color(30,30,30));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);

        //Upper Panel
        Panel upperPanel = new Panel();
        upperPanel.setBackground(new Color(50,50,50));
        upperPanel.setBounds(0,0,2000,50);
        upperPanel.setLayout(null);
        frame.add(upperPanel);

        // "My Shikimori" title
        JLabel panelText = new JLabel();
        panelText.setText("My Shikimori");
        panelText.setHorizontalTextPosition(JLabel.LEFT);
        panelText.setVerticalTextPosition(JLabel.CENTER);
        panelText.setForeground(new Color(215,215,215));
        panelText.setFont(new Font("Helvetica Neue (Основной текст)",Font.BOLD,20));
        panelText.setBounds(10,0,150,50);
        upperPanel.add(panelText);

        //Search
        searchTextField.setBounds(panelText.getWidth()+panelText.getX()+50,10,250,30);
        Border buttonBorder = BorderFactory.createLineBorder(new Color(50,50,50));
        searchTextField.setBorder(buttonBorder);
        searchTextField.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,18));
        searchTextField.setBackground(new Color(225,225,225));
        upperPanel.add(searchTextField);
        searchButton.setText("search");
        searchButton.setBackground(new Color(54,90,120));
        searchButton.setBorder(buttonBorder);
        searchButton.setForeground(new Color(215,215,215));
        searchButton.setBounds(searchTextField.getX()+searchTextField.getWidth()+20,10,80,30);
        searchButton.setFocusable(false);
        upperPanel.add(searchButton);
        //Search button Action
        searchButton.addActionListener(e -> searchAnime());


        //Delete
        deleteComboBox = new JComboBox<>(AnimeList.getNameList());
        deleteComboBox.setEditable(true);
        deleteComboBox.setBounds(1400,10,130,30);
        deleteComboBox.setFocusable(false);
        deleteComboBox.setBorder(buttonBorder);
        upperPanel.add(deleteComboBox);
        deleteAnimeButton.setBounds(1600,10,80,30);
        deleteAnimeButton.setText("delete");
        deleteAnimeButton.setBackground(new Color(54,90,120));
        deleteAnimeButton.setBorder(buttonBorder);
        deleteAnimeButton.setForeground(new Color(215,215,215));
        deleteAnimeButton.setFocusable(false);
        upperPanel.add(deleteAnimeButton);
        //Delete button Action
        deleteAnimeButton.addActionListener(e -> {
            for(Anime anime: AnimeList.getAnimeList()) {
                if(deleteComboBox.getSelectedItem().equals(anime.getName())){
                AnimeList.getAnimeList().remove(anime);
                deleteComboBox.removeItem(anime.getName());
                break;
                }
            }
            deleteComboBox.setSelectedIndex(0);
            showAnime(AnimeList.getAnimeList());
                });

        //Add new Anime button
        addNewAnimeButton.setBounds(5,5,290,450);
        addNewAnimeButton.setText("+");
        addNewAnimeButton.setForeground(new Color(215,215,215));
        addNewAnimeButton.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,125));
        addNewAnimeButton.setBackground(new Color(80,80,80));
        Border addButtonBorder = BorderFactory.createLineBorder(new Color(70,70,70));
        addNewAnimeButton.setBorder(addButtonBorder);
        addNewAnimeButton.setFocusable(false);
        //Add new Anime button Action
        addNewAnimeButton.addActionListener(e -> {
            new NewWindow();
            searchTextField.setEnabled(false);
            searchButton.setEnabled(false);
            addNewAnimeButton.setEnabled(false);
        });

        showAnime(AnimeList.getAnimeList());

        frame.setVisible(true);
    }

    public static void showAnime(List<Anime> animes){
        panel.removeAll();
        panel.setBounds(125,60,1600,frame.getHeight());
        panel.setBackground(new Color(30,30,30));
        panel.setLayout(new FlowLayout());
        JLabel animeLabel;
        for(Anime anime : animes){
            animeLabel = new JLabel(anime.getName());
            ImageIcon animeImage = new ImageIcon("src/"+anime.getName()+".png");
            animeLabel.setIcon(animeImage);
            animeLabel.setHorizontalTextPosition(JLabel.CENTER);
            animeLabel.setVerticalTextPosition(JLabel.BOTTOM);
            animeLabel.setForeground(new Color(215,215,215));
            animeLabel.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,20));
            animeLabel.setVerticalAlignment(JLabel.CENTER);
            animeLabel.setHorizontalAlignment(JLabel.CENTER);
            animeLabel.setBackground(new Color(50,50,50));
            animeLabel.setOpaque(true);
            animeLabel.setPreferredSize(new Dimension(300,490));
            panel.add(animeLabel);
        }
        animeLabel = new JLabel("Add new Anime");
        animeLabel.add(addNewAnimeButton);
        ImageIcon animeImage = new ImageIcon("src/Pokemon.png");
        animeLabel.setIcon(animeImage);
        animeLabel.setHorizontalTextPosition(JLabel.CENTER);
        animeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        animeLabel.setForeground(new Color(215,215,215));
        animeLabel.setFont(new Font("Helvetica Neue (Основной текст)",Font.PLAIN,20));
        animeLabel.setVerticalAlignment(JLabel.CENTER);
        animeLabel.setHorizontalAlignment(JLabel.CENTER);
        animeLabel.setBackground(new Color(50,50,50));
        animeLabel.setOpaque(true);
        animeLabel.setPreferredSize(new Dimension(300,490));
        animeLabel.setLayout(null);
        panel.add(animeLabel);
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
    }

    public void searchAnime() {
        String string = searchTextField.getText();
        if (string.equals("")) {showAnime(AnimeList.getAnimeList());}
        else {
            searchTextField.setText("");
            List<Anime> searchedAnime = new ArrayList<>();
            List<Anime> animes = AnimeList.getAnimeList();
            for (Anime anime : animes) {
                for (int i = 0; i < anime.getName().length() - (string.length() - 1); i++) {
                    if (anime.getName().regionMatches(true, i, string, 0, string.length())) {
                        searchedAnime.add(anime);
                        break;
                    }
                }
            }
            showAnime(searchedAnime);
        }
    }
}

