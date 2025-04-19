import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected final String name;
    protected final Board board = new Board();
    protected final List<Ship> fleet = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        buildFleet();
    }

    public abstract void placeShips();

    public abstract Coordinate nextShot();

    public boolean receiveShot(Coordinate c) {
        for (Ship s : fleet) {
            if (s.occupies(c)) {
                s.hit();
                board.markHit(c);
                if (s.isSunk())
                    System.out.printf("%s's %s sunk!%n", name, s.getName());
                return true;
            }
        }
        board.markMiss(c);
        return false;
    }

    public boolean hasLost() {
        return fleet.stream().allMatch(Ship::isSunk);
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    private void buildFleet() {
        fleet.add(new Battleship());
        fleet.add(new Cruiser());
        fleet.add(new Destroyer());
        fleet.add(new Destroyer());
        fleet.add(new Destroyer());
        fleet.add(new Submarine());
        fleet.add(new Submarine());
        fleet.add(new Submarine());
        fleet.add(new Submarine());
    }

}
