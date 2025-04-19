import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public void placeShips() {
        System.out.printf("%n%s, do you want automatic ship placement? (Y/N) ", name);
        boolean auto = !"n".equalsIgnoreCase(scanner.nextLine().trim());

        if (auto) {
            BoardPlacer.autoPlace(board, fleet);
            board.display(false);
            return;
        }

        for (Ship s : fleet) {
            while (true) {
                System.out.printf("Enter bow coordinate & direction (H/V) for %s (len=%d), e.g. \"B7 H\": ",
                        s.getName(),
                        s.getLength());
                String line = scanner.nextLine().trim().toUpperCase();

                if (!line.matches("^[A-J]([1-9]|10)\\s+[HV]$")) {
                    System.out.println("must be LETTER(A-J) + 1-10, space, then H or V");
                    continue;
                }

                String[] parts = line.split("\\s+");
                Coordinate bow = GameHelper.parseCoordinate(parts[0]);
                boolean horiz = parts[1].equals("H");
                if (board.placeShip(s, bow, horiz))
                    break;
                System.out.println("Cannot place there. Try again.");
            }
            board.display(false);
        }
    }

    @Override
    public Coordinate nextShot() {
        while (true) {
            System.out.println("Enter target (e.g. B7): ");
            String in = scanner.nextLine().trim().toUpperCase();

            if (!GameHelper.validateCoordinate(in)) {
                System.out.println("Bad Coordinate.");
                continue;
            }

            Coordinate c = GameHelper.parseCoordinate(in);
            if (c.isOutofBounds()) {
                System.out.println("Out of bounds.");
            }
            return c;
        }
    }
}
