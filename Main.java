import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("🎉🎇=== Welcome to Battleship! ===🎇🎉");
        try (Scanner scanner = new Scanner(System.in)) {
            Game game = new Game(scanner);
            game.start();
        }
        System.out.println("🚢 Thanks for playing! 🏴‍☠️  See you on the high seas! 🚢");
    }
}