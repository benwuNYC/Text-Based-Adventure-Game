package Items;
import People.Person;
import Items.Potions;
public class redPotion implements Potions {
    public void use(Person x){
        x.loseHP(20);
    }
    public String getName(){
        return "red potion";
    }

    public String describe() {
        return ("You can either gain +20 HP or -20 HP. Pick your poison");
    }
}
