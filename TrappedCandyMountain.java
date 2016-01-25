import java.util.Random;
public class TrappedCandyMountain extends CandyMountain {
    private char[][] traps;
    public TrappedCandyMountain(int numTraps) {
        super(16);
        traps = new char[16][16];
        for (int row = 0; row < traps.length; ++row) {
            for (int col = 0; col < traps[row].length; ++col) {
                traps[row][col] = ' ';
            }
        }
        Random rand = new Random();
        int i = 0;
        while (i < numTraps) {
            int row = rand.nextInt(getSize());
            int col = rand.nextInt(getSize());
            Position aTrap = new Position(row, col);
            if (isValidPosition(aTrap)) {
                traps[row][col] = '#';
                i = i + 1;
            }
        }
    }
    @Override
    public int moveQuester(Move move) {
        Position quester = getQuester();
        char[][] grid = getGrid();
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
            if (traps[quester.getRow()][quester.getCol()] == '#') {
                return 999;
            }
            return healthChange;
        }
        return -1;
    }
    @Override
    public boolean hasSeenLiopleurodon() {
        Position quester = getQuester();
        Position goal = getGoal();
        char[][] grid = getGrid();
        Position liopleurodon = getLiopleurodon();
        if (quester.equals(liopleurodon)) {
            grid[liopleurodon.getRow()][liopleurodon.getCol()] = 'L';
            grid[goal.getRow()][goal.getCol()] = 'G';
            for (int row = 0; row < traps.length; ++row) {
                for (int col = 0; col < traps[row].length; ++col) {
                    if (traps[row][col] == '#') {
                        grid[row][col] = '#';
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    private boolean isValidPosition(Position p) {
        if (p.equals(getGoal())) {
            return false;
        }
        if (p.equals(getLiopleurodon())) {
            return false;
        }
        Position a = new Position(0, 0);
        if (p.equals(a)) {
            return false;
        }
        return true;
    }
}
