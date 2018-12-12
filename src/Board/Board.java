package Game;

import Rooms.Room;


public class Board {
    private Room[][] map;
    private int length;
    private int width;


    public Board(int length, int width, Room[][] map) {
        this.length = length;
        this.width = width;
        this.map = map;
    }

    public Board(int length, int width) {
        this.map = new Room[length][width];
    }

    public Room[][] getBoard() {
        return this.map;
    }

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

