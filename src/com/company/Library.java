package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Library {

    private Scanner input = new Scanner(System.in);
    private List<Game> gamesLibrary = new ArrayList<Game>();
    private List<Game> checkedOutGames = new ArrayList<Game>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    private Menu menu;


    public Library(Menu menu) {
        this.menu = menu;
    }


    //add
    public void addGame() {


        System.out.println("What is the title of your game? ");
        String title = input.nextLine();
        System.out.println("What is the genre of your game? ");
        String type = input.nextLine();
        System.out.println("What is the ID number of your game? ");
        int idNumber = input.nextInt();
        input.nextLine();

        Game game = new Game(title, type, idNumber);
        gamesLibrary.add(game);
        System.out.println(game.getTitle() + " has been added to the Video Game Library. This game can now be checked out. \n");

        //go back to main menu after game is added
        menu.startMenu();

    }

    //remove
    public void removeGame(int index) {

        gamesLibrary.remove(index);
        System.out.println("This game has been removed from your library. ");

        //bring back to start
        menu.startMenu();
    }


    //view
    public void listGamesInLibrary(String location) {

        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library. ");
            menu.startMenu();
        } else {
            int index = 1;
            for (Game inLibrary : gamesLibrary) {
                System.out.println(index++ + ": " + inLibrary.getTitle());
            }
            if (location.equals("inLibrary")) {
                menu.startMenu();
            }
        }

    }

    //check out
    public void checkOutGame(int index) {

        if (gamesLibrary.isEmpty()){
            System.out.println("There are no games in your library. Add games to be able to check out. ");
            menu.startMenu();
        } else {
            //placeholder for game taken out of array list
            Game game = gamesLibrary.get(index);

            //create an instance of a calender object
            Calendar calendar = Calendar.getInstance();
            //add 7 days to the current date
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            //uses the line above to set a due date in the future to a variable
            String dueDate = dateFormat.format(calendar.getTime());
            //tell user what their due date is
            System.out.println(game.getTitle() + " is due on " + dueDate);
            //set due date for this game 
            game.setDueDate(dueDate);
        }


    }


}
