package Items;

import People.Person;

public class Torch implements Consumables {
    @Override
    public void use(Person p) {
        System.out.println("Congratulations! You can now see all the rooms and the way out");

    }

    @Override
    public String getName() {
        return "Torch";
    }

    public String describe() {
        return ("Use the torch to light up the dark room and find your way out");
    }
}