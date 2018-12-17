package Rooms;
//

import Game.Runner;
import People.Person;

public class DimRoom extends Room {

    public DimRoom(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     *
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("You found a key!");
    }

    public String toString() {
        String Room = "";
        return Room + "[ ]";
    }
}