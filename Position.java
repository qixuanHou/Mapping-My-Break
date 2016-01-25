
public class Position {
    private int row;
    private int col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Position update(Move move) {
        row = move.getRowDelta() + this.row;
        col = move.getColDelta() + this.col;
        Position newPosition = new Position(row, col);
        return newPosition;
    }
    public String toString() {
        return "row is " + row + "; col is " + col;
    }
    public int hashCode() {
        return super.hashCode();
    }
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Position)) {
            return false;
        }
        Position otherPosition = (Position) other;
        return row == otherPosition.row
            && col == otherPosition.col;
    }
}
