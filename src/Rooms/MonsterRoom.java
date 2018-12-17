package Rooms;
import java.util.Scanner;

import Game.Runner;
import People.Person;
import Items.Knife;

public class MonsterRoom extends Room {
    String in = "[ ]";

    public MonsterRoom(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     *
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        in = "[x]";
        int numGuess = 0;
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("BOO! A monster jumps out at you! Do you fight it or grab a knife nearby?");
        Scanner wep = new Scanner(System.in);
        String weapon = wep.nextLine();
        while (!weapon.equals("fight") || !weapon.equals("knife")) {
            System.out.println("Hurry you don't have much time!");
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
                    break;
                }
            }
        }
        System.out.println("Great job! You've defeated the monster. Now, hurry and get out the house before it haunts you!");
    }

    public void leaveRoom(Person x) {
        in = "[M]";
    }

    public String toString() {
        return in;
    }
}
