package Items;

import People.Person;

public class Knife implements Consumables {
    public void use(Person p) {
        System.out.println("You slashed the monster's face." + "\n" + "You cut its arms off." + "\n" + "You pierce its face.");
    }

    public String getName() {
        return "Knife";
    }

    public String describe() {
        return ("Use the knife to kill the monster!");
    }

    public int wepDmg() {
        return 50;
    }
}
