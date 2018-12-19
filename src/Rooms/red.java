package Rooms;

import Items.Potions;
import Items.bluePotion;
import People.Person;

import java.util.Scanner;

public class red extends Room {
    String in = "[ ]";
    private Potions redPotion;

    public red(int x, int y) {
        super(x, y);
        this.redPotion = new bluePotion();
    }

    public void enterRoom(Person x) {
        in = "[x]";
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println("You stumble upon a potion. Do you chug the mysterious bottle?");
        Scanner potionDrink = new Scanner(System.in);
        String response = potionDrink.nextLine();
        if (response.equals("yes")) {
            x.loseHP(20);
            System.out.println("Now your hp is " + x.checkHP());
        } else {
            System.out.println("I'll ask you again: do you want to drink the potion? You only have " + x.checkHP() + " health");
            response = potionDrink.nextLine();
            if (response.equals("yes")) {
                x.loseHP(50);
            } else {
            }
            System.out.println("Now your hp is " + x.checkHP());
        }
    }
    public void leaveRoom(Person x) {
        in = "[r]";
    }

    public String toString() {
        return in;
    }
}