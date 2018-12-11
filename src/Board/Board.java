package Board;

import Rooms.DarkRoom;

public class Board {
    private DarkRoom[][] building;
    private int length;
    private int width;

    public Board(int length, int width) {
        this.length=length;
        this.width=width;
        this.building = new DarkRoom[length][width];
    }

    public String Mode (String input, int length, int width, Board[][] building) {
        if (input.equals("easy")) {
            width = 5;
            length = 5;
            building = new Board[width][length];
            print();
        }
        if (input.equals("medium")) {
            width = 7;
            length = 7;
            building = new Board[width][length];
            print();
        }
        if (input.equals("hard")) {
            width = 9;
            length = 9;
            building = new Board[width][length];
            print();
        }
        return "Okay, you are on difficulty level " + input;
    }

    public void print() {
        String row = "";
        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                row+= building[i][j].toString();
            }
            System.out.println(row);
        }
    }
}