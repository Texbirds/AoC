public class Position {

    private int xStart = -1;
    private int xEnd = -1;
    private int y = -1;
    private int number = 0;
    private String numberStr = "";
    public void addNumber(int x, int y, String num) {
        this.y = y;
        if (xStart == -1) {
            xStart = x;
        }
        this.xEnd = x;
        numberStr += num;
        number = Integer.parseInt(numberStr);
    }

    public boolean isAdjacent(int[] map) {
        for (int x = xStart; x < xEnd + 1; x++) {
            if (map[y * 150 + (x + 1)] != 0) return true;
            if (x > 0 && map[y * 150 + (x - 1)] != 0) return true;
            if (y > 0 && map[(y - 1) * 150 + x] != 0) return true;
            if (y > 0 && map[(y - 1) * 150 + (x + 1)] != 0) return true;
            if (x > 0 && y > 0 && map[(y - 1) * 150 + (x - 1)] != 0) return true;
            if (map[(y + 1) * 150 + x] != 0) return true;
            if (map[(y + 1) * 150 + (x + 1)] != 0) return true;
            if (x > 0 && map[(y + 1) * 150 + (x - 1)] != 0) return true;
        }
        return false;
    }

    public int getNumber() {
        return number;
    }
}
