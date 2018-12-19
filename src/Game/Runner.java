package Game;

// Author: Benjamin Wu

import People.Person;
import Rooms.*;


import java.util.Scanner;

public class Runner {
    //Game is "on"
    private static boolean gameOn = true;


    //Welcomes player into house
    public static void main(String[] args)
    {  Scanner in = new Scanner(System.in);
    boolean hasKey = false;

        Scanner name = new Scanner(System.in);
        System.out.println("Welcome! You wandered into a haunted house." + "\n" + "Suddenly, the door slams shut from the inside." + "\n" + "What's your name, adventurer?");
        //Ask for player's name; refers to it throughout
        String playerName = name.nextLine();
        System.out.print(playerName + ", find your way out before the monster gets you." + "\n");

        String mode = "";
        int size = 0;
        while(!mode.equals("nyc") && !mode.equals("boston") && !mode.equals("newark")){
            System.out.println("Do you want to explore on easy, medium, or hard?");
            mode= mode.toLowerCase().trim();
            mode = in.nextLine();
            if(mode.equals("easy")){
                size = 3;
                break;
            } else if(mode.equals("medium")){
                size = 5;
                break;
            } else if(mode.equals("hard")){
                size = 7;
                break;
            }
        }

        // Board Size (array in room called building) creates a instance with dimensions
        Room[][] building = new Room[size][size];

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }


        //Create Boogieman Room
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new BoogieMan(x, y);
        //Create Wolf Room
        int r = (int)(Math.random()*building.length);
        int s = (int)(Math.random()*building.length);
        building[r][s] = new WolfRoom(r, s);
        // Create Outside Room
        int a = (int)(Math.random()*building.length);
        int b = (int)(Math.random()*building.length);
        building[a][b] = new Outside(a, b);

        // Create red Room
        int e = (int)(Math.random()*building.length);
        int f = (int)(Math.random()*building.length);
        building[e][f] = new red (e, f);

        // Create blue Room
        int g = (int)(Math.random()*building.length);
        int h = (int)(Math.random()*building.length);
        building[g][h] = new blue(g, h);


        //Setup player 1 and the input scanner
        // Sets where player spawns, and hp
        Person player1 = new Person("Ben",1,2,100);
        int q = (int)(Math.random()*building.length);
        int w = (int)(Math.random()*building.length);
        if(q !=a) {

            building[q][w].enterRoom(player1);
        }
    //Creates Board and prints it
        Board map = new Board(building);
        map.print();

        //If player's move is checked by method "ValidMove", then it prints out coordinates and map
        //Else; Try again
        //In.Close closes Scanner
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, player1, building))
            {
                System.out.println("You walked into Aisle  " + player1.getxLoc() + ", Section " + player1.getyLoc());
                map.print();

            }
            else {
                System.out.println("You got lost in the darkness! Keep moving!");
            }
        }
        in.close();
    }



    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    //User's input is made lowercase by .toLowerCase().trim
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()+ 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }

    /**
     * Creates the actual board.
     * @return a Floor[] that is the board.
     */
    //Method that closes game

    public static void gameOff()
    {
        gameOn = false;
    }



}