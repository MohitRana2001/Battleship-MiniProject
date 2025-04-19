public record Coordinate(int row, int col) {

    public boolean isOutofBounds() {
        return row < 0 || row >= 10 || col < 0 || col >= 10;
    }

    @Override
    public String toString() {
        return "%c%d".formatted('A' + row, col + 1);
    }

}
