package Items;
import People.Person;
import Items.Potions;
public class bluePotion implements Potions {
    public void use(Person x){
        x.gainHP(50);
    }
    public String getName(){
        return "You stumbled upon a blue potion. ";
    }

    public String describe() {
        return ("You can either gain +50 HP or -50 HP. Pick your poison");
    }
}
