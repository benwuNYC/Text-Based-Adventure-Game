package People;

import Game.Helper;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    private String name;
    private int xLoc, yLoc;
    private int hp;


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

    public Person(String name, int xLoc, int yLoc, int hp)
    {
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.hp = hp;
    }

    public int checkHP() {
        if (hp < 0) {
            System.out.println("Rest in piece, you've died, adventurer");
            Helper.gameOff();
        }
            return hp;
    }

    public void loseHP(int lose) {
        this.hp = hp - lose;
    }

    public void gainHP(int gain) {
        this.hp = hp + gain;
    }

    public void gameOff(){
        System.exit(0);
    }
}