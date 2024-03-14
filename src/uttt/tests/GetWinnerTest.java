package uttt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class GetWinnerTest {
    private BoardInterface board;

    @Before
    public void winn() {
        board = UTTTFactory.createBoard();
    }

    @Test
    public void testGetWinner_PlayerWonHorizontal() {

        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CROSS, 2);

        assertEquals(Symbol.CROSS, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonHorizontal2() {

        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);

        assertEquals(Symbol.CIRCLE, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonVertical() {

        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CIRCLE, 6);

        assertEquals(Symbol.CIRCLE, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonVertical2() {

        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CROSS, 6);

        assertEquals(Symbol.CROSS, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonDiagonal1() {

        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 8);

        assertEquals(Symbol.CROSS, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonDiagonal2() {

        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 6);

        assertEquals(Symbol.CROSS, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonDiagonal1a() {

        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CIRCLE, 8);

        assertEquals(Symbol.CIRCLE, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonDiagonal2a() {

        board.setMarkAt(Symbol.CIRCLE, 2);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CIRCLE, 6);

        assertEquals(Symbol.CIRCLE, board.getWinner());
    }

    @Test
    public void testGetWinner_Tie() {
        // Set marks on the board to simulate a tie state
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CIRCLE, 5);
        board.setMarkAt(Symbol.CIRCLE, 6);
        board.setMarkAt(Symbol.CROSS, 7);
        board.setMarkAt(Symbol.CIRCLE, 8);

        assertEquals(Symbol.EMPTY, board.getWinner());
    }

    @Test
    public void testGetWinner_UnfinishedBoard() {

        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 3);

        assertEquals(Symbol.EMPTY, board.getWinner());
    }

    @Test
    public void testGetWinner_EmptyBoard() {
        // No marks set on the board

        assertEquals(Symbol.EMPTY, board.getWinner());
    }

    @Test
    public void testGetWinner_PlayerWonDiagonal2_false() {

        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 6);

        assertNotEquals(Symbol.CIRCLE, board.getWinner());
    }
}
