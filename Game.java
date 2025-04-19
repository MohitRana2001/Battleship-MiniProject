import java.util.Scanner;

public class Game {

    private final Player player1;
    private final Player player2;
    private Player current;
    private Player opponent;
    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("Enter name for Player 1: ");
        player1 = new HumanPlayer(scanner.nextLine(), scanner);
        System.out.println("Play against computer? (y/N) ");
        boolean vsCpu = scanner.nextLine().trim().equalsIgnoreCase("y");

        if (vsCpu) {
            player2 = new ComputerPlayer("Computer");
        } else {
            System.out.println("Enter name for Player 2: ");
            player2 = new HumanPlayer(scanner.nextLine(), scanner);
        }

        current = player1;
        opponent = player2;
    }

    public void start() {
        System.out.println("\n--- Ship placement ---");
        player1.placeShips();
        player2.placeShips();

        System.out.println("\n--- Battle begins! ---");
        while (true) {
            System.out.printf("%n%s's turn%n", current.getName());
            opponent.getBoard().display(true);
            current.getBoard().display(false);

            Coordinate shot = current.nextShot();
            boolean hit = opponent.receiveShot(shot);

            if (hit)
                System.out.println(">> HIT <<");
            else
                System.out.println("MISS");

            if (opponent.hasLost()) {
                System.out.printf("%n*** %s wins! ***%n", current.getName());
                break;
            }
            switchTurns();
        }
    }

    public void switchTurns() {
        Player tmp = current;
        current = opponent;
        opponent = tmp;
    }
}
