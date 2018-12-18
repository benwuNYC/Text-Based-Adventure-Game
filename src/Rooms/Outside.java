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
        in = "[\uD83D\uDEA9]";
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("Congratulations! You've made it out alive!");
    }
//Returns flag

    public String toString() {
        return in;
    }
}