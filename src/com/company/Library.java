package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private Scanner input = new Scanner(System.in);
    private List<Game> gamesLibrary = new ArrayList<Game>();
    private Menu menu;


    public Library(Menu menu) {
        this.menu = menu;
    }


    public void addGame() {


        System.out.println("What is the title of your game? ");
        String title = input.nextLine();
        System.out.println("What is the genre of your game? ");
        String type = input.nextLine();
        System.out.println("What is the ID number of your game? ");
        int idNumber = input.nextInt();

        Game game = new Game(title, type, idNumber);
        gamesLibrary.add(game);
        System.out.println(game.getTitle() + " has been added to the Video Game Library. This game can now be checked out. \n");

        //go back to main menu after game is added
        menu.startMenu();

    }

    public void listGamesInLibrary() {

        int index = 1;
        for (Game inLibrary : gamesLibrary) {
            System.out.println(index++ + ": "+ inLibrary.getTitle() +"\n");
        }

        //go back to start menu
        menu.startMenu();

    }

    public void removeGame(){

        System.out.println("What game would you like to remove from your library? ");

//        for (int i = 0; i < gamesLibrary.size(); i++) {
//            System.out.println((i + 1) + " " + gamesLibrary.get(i));
//        }

        int numberToRemove = input.nextInt() - 1;
        if (numberToRemove >= gamesLibrary.size() || numberToRemove < 0) {
            System.out.println("That is not a valid number");
        } else {
            gamesLibrary.remove(numberToRemove);
        }
        System.out.println("You have removed the game from the Video Game Library. ");

        menu.startMenu();

    }

}
