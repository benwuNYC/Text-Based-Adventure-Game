package Rooms;

import Game.Helper;
import Game.Runner;
import People.Person;
import Game.Helper;
import java.util.Scanner;
public class Outside extends Room
{
    String in = "[ ]";
    private static boolean win = false;
    public Outside(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
//If player enters this room, it prints out you've made it out alive
    public void enterRoom(Person x) {
        in = "[D]";
        System.out.println("Congratulations! You found your way out and made it out alive!");
        System.out.println("You've made it out. Do you want to go back in to explore the other rooms?");
        Scanner ask = new Scanner(System.in);
        String reply = ask.nextLine();
        if(reply.equals("no")){
            System.out.print("Thanks for playing, Mr. Levin!");
            Helper.gameOff();
        }
    }
//Returns D for door

    public String toString() {
        if (occupant != null) {
            return "[x]";
        }
        return in;
    }
}