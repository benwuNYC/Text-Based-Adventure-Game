package Items;

import People.Person;

public interface Consumables {
    void use(Person x);
    String getName();
    String describe();
}
