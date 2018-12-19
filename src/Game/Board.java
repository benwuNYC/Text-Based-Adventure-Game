package Game;

import Rooms.Room;

//Creates board with array of room called map
public class Board {
    private Room[][] map;

//Initializes fields
    public Board( Room[][] map) {
        this.map=map;
    }
//Prints out Board
    public void print() {
        String row = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                row+= map[i][j].toString();
            }
            System.out.println(row);
            row = "";
        }
    }
}

