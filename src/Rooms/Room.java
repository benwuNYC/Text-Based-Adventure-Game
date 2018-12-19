package Rooms;

import People.Person;
//Room contains Person, int x+y, array of items
public class Room {
    Person occupant;
    int x,y;
//Initializes Items and x+y
    public Room(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    //When player enters ANY ROOM, it prints "You're in a pitch black room"
    // Prints out player's location
    public void enterRoom(Person x)
    {
        System.out.println("You walk into a pitch black room.");
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
//Array prints [x] if Person x is in there; else it prints a empty bracket
    public String toString() {
        String Room = "[ ]";
        if (occupant != null) {
            return "[x]";
        }
        return Room;
    }


}
