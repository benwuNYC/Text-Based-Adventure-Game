package Rooms;

import Game.Helper;
import Game.Runner;
import People.Person;
import Game.Helper;
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
        in = "[D";
        System.out.println("Congratulations! You found your way out and made it out alive!");
    }
//Returns D for door

    public String toString() {
        if (occupant != null) {
            return "[x]";
        }
        return in;
    }
}