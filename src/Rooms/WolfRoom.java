package Rooms;

import People.Person;

import java.util.Scanner;
import Game.Runner;
import Game.Helper;

//Room shown as [ ]
public class WolfRoom extends Room {
    String in = "[ ]";

    //Calls constructor in main room (Room)
    public WolfRoom(int x, int y) {
        super(x, y);

    }

    // If person enters room, their position is initialized and shown as [x]
    public void enterRoom(Person x) {
        in = "[x]";
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("You walk into a room and a monster jumps out. Do you fight it or stay silent?");
        Scanner fight = new Scanner(System.in);
        String response = fight.nextLine();
        response = response.toLowerCase().trim();
        if (response.equals("fight")) {
            int dmgTake = (int) (((Math.random() * 95 + 5)));
            x.loseHP(dmgTake);
        } else {
            System.out.println("The monster stabs you." + "\n" + "The monster kicks you. " + "\n" + "The monster punches you you. ");
            int dmgTake2 = (int) (((Math.random() * 100) + 50));
            x.loseHP(dmgTake2);
            System.out.println("Luckily, you scare him away");
        }
        System.out.println("You've killed the monster, but you've taken some damage");
        System.out.println("Health:" + x.checkHP());
    }

    // When person leavesRoom, the Room is shown as [M] to show "Monster Room"
    public void leaveRoom(Person x) {
        in = "[W]";
    }

    //Returns Room; [ ] if not entered and [M] if entered
    public String toString() {
        return in;
    }
}
