package Rooms;
//

import Game.Runner;
import People.Person;

public class MonsterRoom extends DarkRoom
{

    public MonsterRoom(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.CaveX);
        x.setyLoc(this.CaveY);
        System.out.println("You fell into the lava! You died, idiot!.");
        Runner.gameOff();
    }
}