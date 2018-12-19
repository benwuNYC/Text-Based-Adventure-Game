package Rooms;

import java.util.Scanner;

import People.Person;
import Game.Runner;

//Room shown as [ ]
public class BoogieMan extends Room {
    String in = "[ ]";

    //Calls constructor in main room (Room)
    public BoogieMan(int x, int y) {
        super(x, y);

    }

    // If person enters room, their position is initialized and shown as [x]
    //Number of Guesses to open dish washer begins at 0
    //Monster jumps out; Asks if you want to fight
    //If fight= Displays some action
    //IF KNIFE = Guess a number to unlock dishwasher and prints out numGuess taken
    public void enterRoom(Person x) {
        in = "[x]";
        int numGuess = 0;
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("You walk into a room and a monster jumps out. Do you fight it or stay silent?");
        Scanner fight = new Scanner(System.in);
        String response = fight.nextLine();
        response = response.toLowerCase().trim();
        if (response.equals("fight")) {
            int dmgTake = (int) (((Math.random() * 50) + 40));
            x.loseHP(dmgTake);
        } else {
            System.out.println("The monster stabs you." + "\n" + "The monster kicks you. "+ "\n" + "The monster punches you you. ");
            int dmgTake2 = (int) (((Math.random() * 90) + 10));
            x.loseHP(dmgTake2);
            System.out.println("Luckily, your silence scares him away");
        }
        System.out.println("You've killed the monster, but you've taken some damage");
        System.out.println("Health:" + x.checkHP());
        if(x.checkHP()<0){
            System.out.println("Rest in piece, you've died, adventurer");
            x.gameOff();
        }
    }

    // When person leavesRoom, the Room is shown as [M] to show "Monster Room"
    public void leaveRoom(Person x) {
        in = "[B]";
    }

    //Returns Room; [ ] if not entered and [M] if entered
    public String toString() {
        return in;
    }
}
