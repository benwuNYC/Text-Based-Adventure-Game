package Rooms;

import Game.Runner;
import People.Person;

public class Outside extends Room
{

    public Outside(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("You fell into the lava! You died, idiot!.");
        Runner.gameOff();
    }
    public String toString() {
        String Room = "";
        return Room + "[ ]";
    }


}
