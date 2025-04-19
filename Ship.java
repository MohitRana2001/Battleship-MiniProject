import java.util.ArrayList;
import java.util.List;

public abstract class Ship {
    private final String name;
    private final int length;
    private int hits = 0;
    private final List<Coordinate> cells = new ArrayList<>();

    protected Ship(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void addPosition(Coordinate c) {
        cells.add(c);
    }

    public boolean occupies(Coordinate c) {
        return cells.contains(c);
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}

class Battleship extends Ship {
    public Battleship() {
        super("Battleship", 4);
    }
}

class Cruiser extends Ship {
    public Cruiser() {
        super("Cruiser", 3);
    }
}

class Destroyer extends Ship {
    public Destroyer() {
        super("Destroyer", 2);
    }
}

class Submarine extends Ship {
    public Submarine() {
        super("Submarine", 3);
    }
}
