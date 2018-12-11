package Board;

import Rooms.DarkRoom;

public class HauntedHouse {
    private HauntedHouse[][] map;
    private int length;
    private int width;

    public HauntedHouse(HauntedHouse[][] map) {
        this.map = map;
    }

    public String Mode (String input, int length, int width, HauntedHouse[][] map) {
        if (input.equals("easy")) {
            width = 5;
            length = 5;
            map = new HauntedHouse[width][length];
            print();
        }
        if (input.equals("medium")) {
            width = 7;
            length = 7;
            map = new HauntedHouse[width][length];
            print();
        }
        if (input.equals("hard")) {
            width = 9;
            length = 9;
            map = new HauntedHouse[width][length];
            print();
        }
        return "Okay, you are on difficulty level " + input;
    }

    public void print() {
        String row = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                row = row + map[i][j].toString();
            }
        }
        System.out.println(row);
    }
}