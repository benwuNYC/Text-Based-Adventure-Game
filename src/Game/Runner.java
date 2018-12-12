package Game;

// Author: Benjamin Wu

import People.Person;
import Rooms.MonsterRoom;
import Rooms.Room;
import Rooms.Outside;


import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {  Scanner in = new Scanner(System.in);

        Scanner name = new Scanner(System.in);
        System.out.println("Welcome! You wandered into a haunted house and suddenly, the door slams shut from the inside. What's your name?");
        String playerName = name.nextLine();
        System.out.println(playerName +", find a key in one of the rooms and get out as soon as possible before the monster attacks!");

        Room[][] building = new Room[3][3];
        Game.Board map= new Game.Board(3,3, building);

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new MonsterRoom(x, y);


        //Setup player 1 and the input scanner
        // Sets where player spawns
        Person player1 = new Person("name", 0, 0);
        building[1][1].enterRoom(player1);

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
                System.out.println("You bumped into the wall! Try moving somewhere else!");
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

    public static void gameOff()
    {
        gameOn = false;
    }



}