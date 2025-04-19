public class GameHelper {

    public static Coordinate parseCoordinate(String s) {
        s = s.toUpperCase().trim();
        int row = s.charAt(0) - 'A';
        int col = Integer.parseInt(s.substring(1)) - 1;
        return new Coordinate(row, col);
    }

    public static boolean validateCoordinate(String s) {
        return s.matches("[A-J](10|[1-9])");
    }

    private GameHelper() {
    }
}
