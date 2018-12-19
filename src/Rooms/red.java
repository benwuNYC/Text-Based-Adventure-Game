package Rooms;

import Items.Potions;
import Items.redPotion;
import People.Person;

import java.util.Scanner;

public class red extends Room {
    String in = "[ ]";
    private Potions redPotion;

    public red(int x, int y) {
        super(x, y);
        this.redPotion = new redPotion();
    }

    public void enterRoom(Person x) {
        in = "[x]";
        occupant = x;
        x.setxLoc(this.x);
        x.setyLoc(this.y);
        System.out.println(redPotion.getName() + "Do you chug the mysterious bottle? " + redPotion.describe());
        redPotion.describe();
        Scanner potionDrink = new Scanner(System.in);
        String response = potionDrink.nextLine();
        if (response.equals("yes")) {
            x.loseHP(20);
            System.out.println("Unfortunately, now your hp is " + x.checkHP());
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