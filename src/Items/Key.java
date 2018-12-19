package Items;
import People.Person;

import java.util.Scanner;

public class Key implements Consumables {
    private int item;
    public String getName() {
        return "Key";
    }
    public Key (int item)
    {
        this.item = item;
    }
    public void use(Person x) {
        System.out.println("Do you wish to turn the key left or right?");
        Scanner turn = new Scanner(System.in);
        if (turn.equals("left")) {
            System.out.println("Try again, you were unable to unlock the door!");
        } else {
            System.out.println("You successfully escaped from the wretched house!" + "\n I'm happy you're alive");
        }

    }
    public int item(){
        return this.item;
    }
    public String describe() {
        return "Find the door and unlock it with the key!";
    }
    public void hasKey(){

    }
}