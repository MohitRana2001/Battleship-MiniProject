public class Board {
    private final char[][] grid = new char[10][10];

    public Board() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                grid[r][c] = ' ';
            }
        }
    }

    public boolean placeShip(Ship s, Coordinate bow, boolean horizontal) {
        int len = s.getLength();
        int dr = horizontal ? 0 : 1, dc = horizontal ? 1 : 0;
        int r = bow.row(), c = bow.col();

        for (int i = 0; i < len; i++, r += dr, c += dc) {
            if (out(r, c) || grid[r][c] != ' ')
                return false;
        }

        r = bow.row();
        c = bow.col();

        for (int i = 0; i < len; i++, r += dr, c += dc) {
            grid[r][c] = 'S';
            s.addPosition(new Coordinate(r, c));
        }
        return true;
    }

    public void markMiss(Coordinate c) {
        grid[c.row()][c.col()] = 'M';
    }

    public void markHit(Coordinate c) {
        grid[c.row()][c.col()] = 'H';
    }

    public boolean alreadyTried(Coordinate c) {
        char ch = grid[c.row()][c.col()];
        return ch == 'H' || ch == 'M';
    }

    public void display(boolean hideShips) {
        System.out.print("   ");

        for (int c = 1; c <= 10; c++) {
            System.out.printf("%3d", c);
        }

        System.out.println();

        for (int r = 0; r < 10; r++) {
            System.out.printf("%c |", 'A' + r); // row‑label + left bar
            for (int c = 0; c < 10; c++) {
                char ch = grid[r][c];
                if (hideShips && ch == 'S') {
                    ch = ' '; // hide ships
                } else if (ch == '\0') {
                    ch = ' '; // empty cells as blank
                }
                System.out.printf(" %c ", ch); // width=3, so everything lines up
            }
            System.out.println("|"); // trailing bar + newline
        }
    }

    private static boolean out(int r, int c) {
        return r < 0 || r >= 10 || c < 0 || c >= 10;
    }
}
