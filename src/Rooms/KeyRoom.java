package Rooms;
//

import Game.Runner;
import People.Person;
    //Keyroom is in array Room;

public class KeyRoom extends Room {
    String in = "[ ]";
    boolean gotKey = false;
    //Calls constructor in parent class Room

    public KeyRoom(int x, int y) {
        super(x, y);

    }

    // If person enters room, their position is initialized and their position is shown in array as [x]
    // Prints out "You Found a Key"
    public void enterRoom(Person x) {
        in = "[x]";
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("You found a key!");
    }
    //If person leaves room, the room becomes apparent forever as [K]
    //GotKey is true
    public void leaveRoom(Person x) {
        in = "[K]";
        gotKey = true;
    }
    //Returns array
    public String toString() {
        return in;
    }
}