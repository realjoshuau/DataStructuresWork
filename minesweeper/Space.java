// This class has almost no logic - just storing the state of a space on the board.
public class Space {
    private boolean hasMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int numAdjacentMines;

    public Space() {
        this.hasMine = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.numAdjacentMines = 0;
    }

    public boolean hasMine() {
        return this.hasMine;
    }

    public void setMine() {
        this.hasMine = true;
    }

    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isRevealed() {
        return this.isRevealed;
    }

    public void reveal() {
        this.isRevealed = true;
    }

    public boolean isFlagged() {
        return this.isFlagged;
    }

    public void toggleFlag() {
        this.isFlagged = !this.isFlagged;
    }

    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public void setNumAdjacentMines(int numAdjacentMines) {
        this.numAdjacentMines = numAdjacentMines;
    }

    public int getNumAdjacentMines() {
        return this.numAdjacentMines;
    }

    @Override
    public String toString() {
        if (this.isRevealed) {
            if (this.hasMine) {
                return Color.BOLD + Color.RED + "*" + Color.RESET;
            } else {
                if (this.numAdjacentMines == 0) {
                    return " ";
                } else {
                    return Color.NUM[this.numAdjacentMines - 1] + this.numAdjacentMines + Color.RESET;
                }
            }
        } else {
            if (this.isFlagged) {
                return Color.CYAN + ">" + Color.RESET;
            } else {
                return ".";
            }
        }
    }

    public String toStringRevealed() {
        if (this.hasMine) {
            return Color.BOLD + Color.RED + "*" + Color.RESET;
        } else {
            if (this.numAdjacentMines == 0) {
                return " ";
            } else {
                return Color.NUM[this.numAdjacentMines - 1] + this.numAdjacentMines + Color.RESET;
            }
        }
    }

}