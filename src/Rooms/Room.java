package Rooms;

import People.Person;

public class Room {
    Person occupant;
    int x,y;
    Room[][] items;

    public Room(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.items = items;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You're in a pitch black room.");
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }

    public String toString() {
        String Room = "";
        Room = Room + "[ ]";
        if (occupant != null) {
            return "[x]";
        }
        return Room;
    }


}
