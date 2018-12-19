package Rooms;

import Game.Runner;
import People.Person;
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
        in = "[W]";
        System.out.println("Congratulations! You found your way out and made it out alive!");
        x.gameOff();
    }
//Returns flag

    public String toString() {
        if (occupant != null) {
            return "[x]";
        }
        return in;
    }
}