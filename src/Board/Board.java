package Game;

import Rooms.Room;

//Creates board with array of room called map
//length and width
public class Board {
    private Room[][] map;
    private int length;
    private int width;

//Initializes fields
    public Board(int length, int width, Room[][] map) {
        this.length = length;
        this.width = width;
        this.map = new Room[length][width];
    }
//Prints out Board
    public void print() {
        String row = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                row += map[i][j].toString();
            }
            System.out.println(row);
            row = "";
        }
    }
}

