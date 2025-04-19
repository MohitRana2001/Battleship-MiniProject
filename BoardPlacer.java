import java.util.List;
import java.util.Random;

public final class BoardPlacer {

    private static final Random rnd = new Random();

    public static void autoPlace(Board board, List<Ship> fleet) {
        for (Ship s : fleet) {
            while (true) {
                boolean horiz = rnd.nextBoolean();
                int r = rnd.nextInt(10);
                int c = rnd.nextInt(10);

                if (board.placeShip(s, new Coordinate(r, c), horiz))
                    break;
            }
        }
    }

    private BoardPlacer() {
    }

}
