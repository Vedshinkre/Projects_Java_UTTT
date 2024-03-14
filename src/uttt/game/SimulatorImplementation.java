package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;

public class SimulatorImplementation implements SimulatorInterface {
    private BoardInterface[] boards;
    private Symbol currentPlayerSymbol;
    private int newindex;

    public SimulatorImplementation() {
        this.boards = new BoardInterface[9];
        this.currentPlayerSymbol = Symbol.EMPTY;
        this.newindex = -1;
        initializeBoards();
    }

    public void initializeBoards() {
        for (int i = 0; i < 9; i++) {
            boards[i] = new BoardImplementation();
            MarkInterface[] marks = new MarkInterface[9];
            for (int b = 0; b < 9; b++) {
                marks[b] = new MarkImplementation(Symbol.EMPTY, b);
            }
            boards[i].setMarks(marks);
        }
    }

    public void run(PlayerInterface playerOne, PlayerInterface playerTwo, UserInterface ui)
            throws IllegalArgumentException {
        if (playerOne == null || playerTwo == null || ui == null) {
            throw new IllegalArgumentException("Players and UI cannot be null.");
        }
        setCurrentPlayerSymbol(Symbol.CROSS);
        // initializeBoards();
        while (!isGameOver()) {
            PlayerInterface currentPlayer;
            if (getCurrentPlayerSymbol() == Symbol.CROSS) {
                currentPlayer = playerOne;
            } else {
                currentPlayer = playerTwo;
            }

            Move playerMove = currentPlayer.getPlayerMove(this, ui);
            int markIndex = playerMove.getMarkIndex();
            int boardIndex = playerMove.getBoardIndex();
            if (isMovePossible(boardIndex, markIndex)) {
                setMarkAt(currentPlayer.getSymbol(), boardIndex, markIndex);
                ui.updateScreen(this);
                setIndexNextBoard(markIndex);
            } else {

                continue;
            }

            if (getWinner() == Symbol.CIRCLE) {
                ui.showGameOverScreen(Symbol.CIRCLE);
                return;
            } else if (getWinner() == Symbol.CROSS) {
                ui.showGameOverScreen(Symbol.CROSS);
                return;
            }

            if (getCurrentPlayerSymbol() == Symbol.CROSS) {
                setCurrentPlayerSymbol(Symbol.CIRCLE);
            } else {
                setCurrentPlayerSymbol(Symbol.CROSS);

            }
            ui.updateScreen(this);
        }

        ui.showGameOverScreen(Symbol.EMPTY);
    }

    @Override
    public BoardInterface[] getBoards() {
        return boards;
    }

    @Override
    public void setBoards(BoardInterface[] boards) throws IllegalArgumentException {
        if (boards == null) {
            throw new IllegalArgumentException("Boards null.");
        }
        this.boards = boards;
    }

    @Override
    public Symbol getCurrentPlayerSymbol() {

        return currentPlayerSymbol;
    }

    @Override
    public void setCurrentPlayerSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("Symbol is null.");
        }
        currentPlayerSymbol = symbol;
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int boardIndex, int markIndex) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("Symbol cannot be null.");
        }
        if (markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException("Markindex out of bounds.");
        }
        if (boardIndex < 0 || boardIndex > 8) {
            throw new IllegalArgumentException("Boardindex out of bounds.");
        }

        BoardInterface board = boards[boardIndex];
        MarkInterface[] marks = board.getMarks();

        if (symbol == currentPlayerSymbol) {
            if (!board.isClosed()) {
                if (marks[markIndex].getSymbol() == Symbol.EMPTY) {
                    newindex = markIndex;
                    marks[markIndex].setSymbol(symbol);
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public int getIndexNextBoard() {
        if (newindex == (-1)) {
            return newindex;
        } else if (!boards[newindex].isClosed()) {
            return newindex;
        } else {
            return -1;
        }
    }

    @Override
    public void setIndexNextBoard(int index) throws IllegalArgumentException {
        if (index < (-1) || index > 8) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        newindex = index;
    }

    @Override
    public boolean isGameOver() {
        // horizontal wins
        if ((boards[0].getWinner() == boards[1].getWinner()) && (boards[1].getWinner() == boards[2].getWinner())) {
            if ((boards[0].getWinner() == Symbol.EMPTY) && (boards[0].isClosed())) {
                return true;
            } else {
                return false;
            }
        }
        if ((boards[3].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[5].getWinner())) {
            if ((boards[3].getWinner() == Symbol.EMPTY) && (boards[3].isClosed())) {
                return true;
            } else {
                return false;
            }
        }
        if ((boards[6].getWinner() == boards[7].getWinner()) && (boards[7].getWinner() == boards[8].getWinner())) {
            if ((boards[6].getWinner() == Symbol.EMPTY) && (boards[6].isClosed())) {
                return true;
            } else {
                return false;
            }
        }
        // vertical wins
        if ((boards[0].getWinner() == boards[3].getWinner()) && (boards[3].getWinner() == boards[6].getWinner())) {
            if ((boards[0].getWinner() == Symbol.EMPTY) && (boards[0].isClosed())) {
                return true;
            } else {
                return false;
            }
        }
        if ((boards[1].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[7].getWinner())) {
            if ((boards[1].getWinner() == Symbol.EMPTY) && (boards[1].isClosed())) {
                return true;
            } else {
                return false;
            }
        }
        if ((boards[2].getWinner() == boards[5].getWinner()) && (boards[5].getWinner() == boards[8].getWinner())
                && (boards[2].getWinner() != Symbol.EMPTY)) {
            if ((boards[2].getWinner() == Symbol.EMPTY) && (boards[2].isClosed())) {
                return true;
            } else {
                return false;
            }
        }
        // diagonal wins
        if ((boards[0].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[8].getWinner())) {
            if ((boards[0].getWinner() == Symbol.EMPTY) && (boards[0].isClosed())) {
                return true;
            } else {
                return false;
            }
        }
        if ((boards[2].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[6].getWinner())) {
            if ((boards[2].getWinner() == Symbol.EMPTY) && (boards[2].isClosed())) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean isMovePossible(int boardIndex) throws IllegalArgumentException {
        if (boardIndex < 0 || boardIndex > 8) {
            throw new IllegalArgumentException("boradindex out of bounds.");
        }
        if (!boards[boardIndex].isClosed()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isMovePossible(int boardIndex, int markIndex) throws IllegalArgumentException {
        if (boardIndex < 0 || boardIndex > 8) {
            throw new IllegalArgumentException("Board index out of bounds.");
        }

        if (markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException("Mark index out of bounds.");
        }

        // Check if the current board is open
        BoardInterface currentBoard = boards[boardIndex];
        if (currentBoard.isClosed()) {
            return false;
        }

        if (getIndexNextBoard() == -1) {
            return true;
        }

        // Check if the markIndex corresponds to the next board index
        int nextBoardIndex = getIndexNextBoard();
        if (boardIndex != nextBoardIndex) {
            return false;
        }

        // Check if the markIndex is available in the current board
        MarkInterface[] marks = currentBoard.getMarks();
        if (marks[markIndex].getSymbol() != Symbol.EMPTY) {
            return false;
        }

        return true;
    }

    @Override
    public Symbol getWinner() {
        // horizontal wins
        if ((boards[0].getWinner() == boards[1].getWinner()) && (boards[1].getWinner() == boards[2].getWinner())
                && (boards[0].getWinner() != Symbol.EMPTY)) {
            return boards[0].getWinner();
        }
        if ((boards[3].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[5].getWinner())
                && (boards[3].getWinner() != Symbol.EMPTY)) {
            return boards[3].getWinner();
        }
        if ((boards[6].getWinner() == boards[7].getWinner()) && (boards[7].getWinner() == boards[8].getWinner())
                && (boards[6].getWinner() != Symbol.EMPTY)) {
            return boards[6].getWinner();
        }
        // vertical wins
        if ((boards[0].getWinner() == boards[3].getWinner()) && (boards[3].getWinner() == boards[6].getWinner())
                && (boards[0].getWinner() != Symbol.EMPTY)) {
            return boards[0].getWinner();
        }
        if ((boards[1].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[7].getWinner())
                && (boards[1].getWinner() != Symbol.EMPTY)) {
            return boards[1].getWinner();
        }
        if ((boards[2].getWinner() == boards[5].getWinner()) && (boards[5].getWinner() == boards[8].getWinner())
                && (boards[2].getWinner() != Symbol.EMPTY)) {
            return boards[2].getWinner();
        }
        // diagonal wins
        if ((boards[0].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[8].getWinner())
                && (boards[0].getWinner() != Symbol.EMPTY)) {
            return boards[0].getWinner();
        }
        if ((boards[2].getWinner() == boards[4].getWinner()) && (boards[4].getWinner() == boards[6].getWinner())
                && (boards[2].getWinner() != Symbol.EMPTY)) {
            return boards[2].getWinner();
        }

        return Symbol.EMPTY;
    }

}
