import java.util.Random;
public class CandyMountain {
    private char[][] grid;
    private Position quester;
    private Position goal;
    private Position liopleurodon;
    public static final Move NORTH = new Move(-1, 0);
    public static final Move SOUTH = new Move(1, 0);
    public static final Move EAST = new Move(0, 1);
    public static final Move WEST = new Move(0, -1);
    public CandyMountain() {
        this(8);
    }
    public CandyMountain(int size) {
        grid = new char[size][size];
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                grid[row][col] = ' ';
            }
        }
        quester = new Position(0, 0);
        grid[0][0] = 'Q';
        Random rand = new Random();
        int goalRow = rand.nextInt(size / 2);
        int goalCol = rand.nextInt(size / 2);
        goal = new Position(goalRow + size / 2, goalCol + size / 2);
        int liopleurodonRow = rand.nextInt(size / 2);
        int liopleurodonCol = rand.nextInt(size / 2);
        liopleurodon = new Position(liopleurodonRow,
            size / 2 + liopleurodonCol);
    }
    public Position getGoal() {
        return goal;
    }

    public Position getLiopleurodon() {
        return liopleurodon;
    }

    public int getSize() {
        return grid.length;
    }

    public Position getQuester() {
        return quester;
    }

    public char[][] getGrid() {
        return grid;
    }
    public boolean hasSeenLiopleurodon() {
        if (quester.equals(liopleurodon)) {
            grid[liopleurodon.getRow()][liopleurodon.getCol()] = 'L';
            grid[goal.getRow()][goal.getCol()] = 'G';
            return true;

        } else {
            return false;
        }
    }

    public boolean hasReachedGoal() {
        if (quester.equals(goal)
            && grid[liopleurodon.getRow()][liopleurodon.getCol()] == 'L') {
            return true;
        }
        return false;
    }

    public int moveQuester(Move move) {
        if (isValidPosition(quester, move)) {
            int row = quester.getRow();
            int col = quester.getCol();
            if (grid[row][col] != 'L') {
                grid[row][col] = '.';
            }
            quester = quester.update(move);
            if (grid[quester.getRow()][quester.getCol()] != 'L') {
                grid[quester.getRow()][quester.getCol()] = 'Q';
            }
            boolean hasSeenLiopleurodon = hasSeenLiopleurodon();
            int rowDelta = move.getRowDelta();
            int colDelta = move.getColDelta();
            int healthChange = Math.abs(rowDelta) + Math.abs(colDelta);
            return healthChange;
        }
        return -1;
    }

    public String toString() {
        int size = grid.length;
        String theTable = "+";
        for (int i = 0; i < size; i++) {
            theTable = theTable + "---+";
        }
        String gridWorld = theTable + "\n";
        for (int row = 0; row < grid.length; ++row) {
            String theLine = "|";
            for (int col = 0; col < grid[row].length; ++col) {
                theLine = theLine + " " + grid[row][col] + " |";
            }
            gridWorld = gridWorld + theLine + "\n" + theTable + "\n";
        }
        return gridWorld;
    }


    public boolean isValidPosition(Position p, Move move) {
        if (quester.getRow() + move.getRowDelta() < grid.length
            && quester.getRow() + move.getRowDelta() >= 0) {
            if (quester.getCol() + move.getColDelta() < grid.length
                && quester.getCol() + move.getColDelta() >= 0) {
                return true;
            }
        }
        return false;
    }
}
