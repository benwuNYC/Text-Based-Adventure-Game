package Rooms;

import Game.Runner;
import People.Person;
import Items.Key;

public class Outside extends Room
{
    String in = "[ ]";
    private int item;
    private static boolean win = false;
    public Outside(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
//If player enters this room, it prints out you've made it out alive
    public void enterRoom(Person x, Key i) {
        if(i.item() == item) {
            in = "[\uD83D\uDEA9]";
            occupant = x;
            x.setxLoc(this.x);
            x.setyLoc(this.y);
            System.out.println("Congratulations! You've made it out alive!");
        }else{
            in = "[D]";
            System.out.println("The door is blocking your path. Now, just find a Key to get out!");
        }
    }
//Returns flag

    public String toString() {
        if (occupant != null) {
            return "[x]";
        }
        return in;
    }
}