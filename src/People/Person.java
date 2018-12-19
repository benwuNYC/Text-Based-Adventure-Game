package People;
import Items.Consumables;
import People.Person;
/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String name;
    int xLoc, yLoc;
    private static int hp;
    private static Consumables[] inventory = new Consumables[3];



    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    //Spawn HP
    public static void setHp(){
        hp= 100;
    }
    public static int getHp() {
        return hp;
    }

    public Person(String name, int xLoc, int yLoc) {
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    public String invPrint()
    {
        String output = "";
        for (int i = 0; i < inventory.length; i++)
        {
            if (inventory[i] != null)
            {
                output = output + i + ":" + "[" +inventory[i].getName() +"]";
            }
            else
            {
                output = output + i + ":" + "[" +" " +"]";
            }

        }
        return output;
    }

    public Consumables getItem (int index)
    {
        return inventory[index];
    }
}
