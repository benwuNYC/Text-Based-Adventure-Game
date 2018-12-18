package Game;

// Author: Benjamin Wu

import People.Person;
import Rooms.KeyRoom;
import Rooms.MonsterRoom;
import Rooms.Room;
import Rooms.Outside;


import java.util.Scanner;

public class Runner {

//Game is "on"
    private static boolean gameOn = true;

//Welcomes player into house
    public static void main(String[] args)
    {  Scanner in = new Scanner(System.in);

        Scanner name = new Scanner(System.in);
        System.out.println("Welcome! You wandered into a haunted house." + "\n" + "Suddenly, the door slams shut from the inside." + "\n" + "What's your name, adventurer?");
        //Ask for player's name; refers to it throughout
        String playerName = name.nextLine();
        System.out.println(playerName +", find a key in one of the rooms to escape." + "\n" + "There is also a hidden torch, which if you find, will help you with your quest." + "\n" + "However, I must warn you not to stumble upon the monster." + "\n");
    // Board Size (array in room called building) creates a instance with dimensions 3 x 3
        Room[][] building = new Room[3][3];

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

        //Create Monster Room
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new MonsterRoom(x, y);
        // Create Outside Room
        int a = (int)(Math.random()*building.length);
        int b = (int)(Math.random()*building.length);
        building[a][b] = new Outside(a, b);
       //Create KeyRoom
        int c = (int)(Math.random()*building.length);
        int d = (int)(Math.random()*building.length);
        building[a][b] = new KeyRoom(c, d);


        //Setup player 1 and the input scanner
        // Sets where player spawns
        Person player1 = new Person("name", 0, 0);
        int i = 0;
        int j = 0;
        building[i][j].enterRoom(player1);
        building[0][0].enterRoom(player1);
        Board map = new Board(3,3,building);
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
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
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

    //Method that closes game

    public static void gameOff()
    {
        gameOn = false;
    }



}