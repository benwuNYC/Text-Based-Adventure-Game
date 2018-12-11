package Rooms;

import People.Person;

public class DarkRoom {
    Person occupant;
    int CaveX,CaveY;

    public DarkRoom(int x, int y)
    {
        CaveX = x;
        CaveY = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You are lost in a pitch black cave!");
        occupant = x;
        x.setxLoc(this.CaveX);
        x.setyLoc(this.CaveY);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }

}
