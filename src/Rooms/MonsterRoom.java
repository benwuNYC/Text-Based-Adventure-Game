package Rooms;
import java.util.Scanner;

import Game.Runner;
import People.Person;
import Items.Knife;
//Room shown as [ ]
public class MonsterRoom extends Room {
    String in = "[ ]";
//Calls constructor in main room (Room)
    public MonsterRoom(int x, int y) {
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
        System.out.println("BOO! You walk into a room and a monster jumps out at you!" + "\n" + "Do you fight it or grab a knife nearby?");
        Scanner wep = new Scanner(System.in);
        String weapon = wep.nextLine();
        while (!weapon.equals("fight") || !weapon.equals("knife")) {
            System.out.println("Grab a weapon, you don't have much time!");
            weapon = wep.nextLine();
        }
            if (weapon.equals("fight")) {
                System.out.println("You falcon punched the monster!" + "\n" + "You uppercut him!" + "\n" + "You stomp on his face!");
            } else {
                if (weapon.equals("knife")) {
                    System.out.println("Oh no! The knife is locked in the dishwasher! Guess the combination from 1-5 to get it!");
                    int a = (int) (Math.random() * 5 + 1);
                    Scanner guess = new Scanner(System.in);
                    int guess1 = guess.nextInt();
                    while (guess1 != a) {
                        System.out.println("Try again, that's not the number!");
                        numGuess++;
                        guess1 = guess.nextInt();
                    }
                    System.out.println("Nice! You guess the number in " + numGuess + " tries");
                }
            }
            System.out.println("Great job! You've defeated the monster. Now, hurry and get out the house before it haunts you!");
        }
    // When person leavesRoom, the Room is shown as [M] to show "Monster Room"
    public void leaveRoom(Person x) {
        in = "[M]";
    }
//Returns Room; [ ] if not entered and [M] if entered
    public String toString() {
        return in;
    }
}
