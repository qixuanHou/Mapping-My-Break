public class Move {
    private int rowDelta;
    private int colDelta;
    private String name;
    public Move(int rowDelta, int colDelta) {
        this("Move", rowDelta, colDelta);
    }
    public Move(String name, int rowDelta, int colDelta) {
        this.name = name;
        this.rowDelta = rowDelta;
        this.colDelta = colDelta;
    }
    public int getRowDelta() {
        return rowDelta;
    }
    public int getColDelta() {
        return colDelta;
    }
    public String toString() {
        return name;
    }
}
