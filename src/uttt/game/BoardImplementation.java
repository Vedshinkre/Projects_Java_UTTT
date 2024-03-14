package uttt.game;

import uttt.utils.Symbol;

public class BoardImplementation implements BoardInterface {
    private MarkInterface[] marks;

    @Override
    public MarkInterface[] getMarks() {
        return marks;
    }

    public BoardImplementation() {
        marks = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            marks[i] = new MarkImplementation(Symbol.EMPTY, i);
        }
    }

    @Override
    public void setMarks(MarkInterface[] marks) throws IllegalArgumentException {
        if (marks == null) {
            throw new IllegalArgumentException("Marks cannot be null.");
        }
        this.marks = marks;
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int markIndex) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("Symbol is null.");
        }
        if (markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException("Markindex out of bounds.");
        }
        if (marks[markIndex].getSymbol() == Symbol.EMPTY) {
            marks[markIndex].setSymbol(symbol);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isClosed() {
        // Horizontal wins
        if ((marks[0].getSymbol() == marks[1].getSymbol()) && (marks[1].getSymbol() == marks[2].getSymbol())
                && (marks[0].getSymbol() != Symbol.EMPTY)) {
            return true;
        }
        if ((marks[3].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[5].getSymbol())
                && (marks[3].getSymbol() != Symbol.EMPTY)) {
            return true;
        }
        if ((marks[6].getSymbol() == marks[7].getSymbol()) && (marks[7].getSymbol() == marks[8].getSymbol())
                && (marks[6].getSymbol() != Symbol.EMPTY)) {
            return true;
        }

        // Vertical wins
        if ((marks[0].getSymbol() == marks[3].getSymbol()) && (marks[3].getSymbol() == marks[6].getSymbol())
                && (marks[0].getSymbol() != Symbol.EMPTY)) {
            return true;
        }
        if ((marks[1].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[7].getSymbol())
                && (marks[1].getSymbol() != Symbol.EMPTY)) {
            return true;
        }
        if ((marks[2].getSymbol() == marks[5].getSymbol()) && (marks[5].getSymbol() == marks[8].getSymbol())
                && (marks[2].getSymbol() != Symbol.EMPTY)) {
            return true;
        }

        // Diagonal wins
        if ((marks[0].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[8].getSymbol())
                && (marks[0].getSymbol() != Symbol.EMPTY)) {
            return true;
        }
        if ((marks[2].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[6].getSymbol())
                && (marks[2].getSymbol() != Symbol.EMPTY)) {
            return true;
        }

        // Tie scenario
        boolean isFull = true;
        for (int i = 0; i < 9; i++) {
            if (marks[i].getSymbol() == Symbol.EMPTY) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    @Override
    public boolean isMovePossible(int markIndex) throws IllegalArgumentException {
        if (markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException("Markindex out of bounds.");
        }
        if (marks[markIndex].getSymbol() == Symbol.EMPTY) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Symbol getWinner() {
        if ((marks[0].getSymbol() == marks[1].getSymbol()) && (marks[1].getSymbol() == marks[2].getSymbol())
                && (marks[0].getSymbol() != Symbol.EMPTY)) {
            return marks[0].getSymbol();
        }
        if ((marks[3].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[5].getSymbol())
                && (marks[3].getSymbol() != Symbol.EMPTY)) {
            return marks[3].getSymbol();
        }
        if ((marks[6].getSymbol() == marks[7].getSymbol()) && (marks[7].getSymbol() == marks[8].getSymbol())
                && (marks[6].getSymbol() != Symbol.EMPTY)) {
            return marks[6].getSymbol();
        }
        // Vertical wins
        if ((marks[0].getSymbol() == marks[3].getSymbol()) && (marks[3].getSymbol() == marks[6].getSymbol())
                && (marks[0].getSymbol() != Symbol.EMPTY)) {
            return marks[3].getSymbol();
        }
        if ((marks[1].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[7].getSymbol())
                && (marks[1].getSymbol() != Symbol.EMPTY)) {
            return marks[1].getSymbol();
        }
        if ((marks[2].getSymbol() == marks[5].getSymbol()) && (marks[5].getSymbol() == marks[8].getSymbol())
                && (marks[2].getSymbol() != Symbol.EMPTY)) {
            return marks[2].getSymbol();
        }

        // Diagonal wins
        if ((marks[0].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[8].getSymbol())
                && (marks[0].getSymbol() != Symbol.EMPTY)) {
            return marks[0].getSymbol();
        }
        if ((marks[2].getSymbol() == marks[4].getSymbol()) && (marks[4].getSymbol() == marks[6].getSymbol())
                && (marks[2].getSymbol() != Symbol.EMPTY)) {
            return marks[2].getSymbol();
        }
        return Symbol.EMPTY;

    }

}
