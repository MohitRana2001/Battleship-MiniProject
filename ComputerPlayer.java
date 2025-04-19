import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random rnd = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void placeShips() {
        BoardPlacer.autoPlace(board, fleet);
    }

    @Override
    public Coordinate nextShot() {
        Coordinate c;

        do {
            c = new Coordinate(rnd.nextInt(10), rnd.nextInt(10));
        } while (board.alreadyTried(c));

        System.out.printf("Computer fires at %s%n", c);
        return c;
    }

}
