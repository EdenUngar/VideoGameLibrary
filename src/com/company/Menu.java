package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private Library library = new Library(this);

    //menu to prompt user for library options
    public void startMenu() {

        System.out.println("What would you like to do? " +
                "\n1. Add Game to Library " +
                "\n2. Remove Game from Library " +
                "\n3. View Available Games " +
                "\n4. Check Out a Game " +
                "\n5. Check In a Game" +
                "\n6. View Checked Out Games" +
                "\n7. Exit Program ");
        try {
            switch (input.nextInt()) {
                case 1:
                    //add game to library
                    input.nextLine();
                    System.out.println("You have chosen to add a game.");
                    library.addGame();
                    break;
                case 2:
                    System.out.println("Which number would you like to remove? ");
                    library.listGamesInLibrary("forRemoval");
                    library.removeGame(input.nextInt() - 1);
                    //remove game from library
                    break;
                case 3:
                    input.nextLine();
                    //view available games
                    library.listGamesInLibrary("inLibrary");
                    break;
                case 4:
                    input.nextLine();
                    //check out a game
                    System.out.println("You have chosen to check out a game." +
                            "\nHere is a list of all games available to check out:");
                    library.listGamesInLibrary("checkOut");
                    System.out.println("Choose the number for the game you would like: ");
                    library.checkOutGame(input.nextInt()-1);
                    break;
                case 5:
                    input.nextLine();
                    //check in a game
                    System.out.println("What game are you checking in? ");
                    //list checked out games
                    library.listCheckedOut("checkIn");
                    library.checkInGame(input.nextInt() - 1);
                    break;
                case 6:
                    //view checked out games
                    library.listCheckedOut("viewCheckedOut");
                    break;
                case 7:
                    System.out.println("Thank you for using the Video Game Library");
                    //exit program
                    System.exit(0);
                    break;
                default:
                    //handle invalid int inputs (prompt user and loop to menu)
                    System.out.println("Not a valid entry. Please enter a number between 1 and 7. ");
                    startMenu();
                    break;
            }
        } catch (InputMismatchException ime) {
            //handle non int invalid inputs (prompt user and loop to menu)
            input.nextLine();
            System.out.println("Not a valid entry. Please enter a number between 1 and 7. ");
            startMenu();
        } catch (IndexOutOfBoundsException ioobe){
            input.nextLine();
            System.out.println("You have not entered a correct number. Taking you back to the main menu. ");
            startMenu();
        }

    }

}
