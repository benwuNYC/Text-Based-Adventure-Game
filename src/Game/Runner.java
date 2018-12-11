package Game;

// Author: Benjamin Wu
import People.Person;
import Rooms.DarkRoom;
import Rooms.Outside;


import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        Scanner name = new Scanner(System.in);
        System.out.println("Welcome! You wandered into a haunted house and suddenly, the door slams shut from the inside. What's your name?");
        String playerName = name.nextLine();
        System.out.println(playerName +", find a key in one of the rooms and get out as soon as possible before the monster attacks!");
        DarkRoom [][] building = new DarkRoom[2][2];

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new DarkRoom(x,y);
            }
        }

        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new Outside(x, y);

        //Create TorchRoom
        int a = (int)(Math.random()*building.length);
        int b = (int)(Math.random()*building.length);

        //Setup player 1 and the input scanner
        Person player1 = new Person("Benjamin",0,0);
        building[0][0].enterRoom(player1);
        Scanner nextMove = new Scanner(System.in);

        // While gameOn, it prints "Where would you like to go" and if the user's move is valid, it prints out the player's location.
        // Else, it says to do another move

        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = nextMove.nextLine();
            if(validMove(move, player1, building))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                building.print();

            }
            else {
                System.out.println("You bumped into the wall! Try moving somewhere else!");
            }

        }

        nextMove.close();
    }

    /**
     * Checks that the movement chosen is within the valid game building.
     * @param move the move chosen
     * @param p person moving
     * @param building the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, DarkRoom[][] building) {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0) {
                    building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    building[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
                    return true;
                } else {
                    return false;
                }
            case "e":
                if (p.getyLoc() < building[p.getyLoc()].length - 1) {
                    building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    building[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                } else {
                    return false;
                }

            case "s":
                if (p.getxLoc() < building.length - 1) {
                    building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    building[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
                    return true;
                } else {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0) {
                    building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    building[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
                    return true;
                } else {
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