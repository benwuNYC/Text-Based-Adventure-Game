package Rooms;

import Game.Runner;
import People.Person;

public class Outside extends Room
{
    String in = "[ ]";

    public Outside(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
//If player enters this room, it prints out you've made it out alive
    public void enterRoom(Person x) {
        if(gotKey) {
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