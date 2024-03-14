package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class GetSetMarksTest {
    private BoardInterface board;
    private MarkInterface[] marks;

    @Before
    public void getset() {
        board = UTTTFactory.createBoard();
        marks = new MarkInterface[9];

        // Create marks with specific symbols and positions
        marks[0] = UTTTFactory.createMark(Symbol.CROSS, 0);
        marks[1] = UTTTFactory.createMark(Symbol.EMPTY, 1);
        marks[2] = UTTTFactory.createMark(Symbol.CIRCLE, 2);
        marks[3] = UTTTFactory.createMark(Symbol.CROSS, 3);
        marks[4] = UTTTFactory.createMark(Symbol.EMPTY, 4);
        marks[5] = UTTTFactory.createMark(Symbol.CIRCLE, 5);
        marks[6] = UTTTFactory.createMark(Symbol.EMPTY, 6);
        marks[7] = UTTTFactory.createMark(Symbol.CIRCLE, 7);
        marks[8] = UTTTFactory.createMark(Symbol.CROSS, 8);

        // Set the marks on the board
        board.setMarks(marks);

    }

    @Test
    public void testGetSetMarks() {
        MarkInterface[] retrievedMarks = board.getMarks();

        for (int i = 0; i < marks.length; i++) {
            assertEquals(marks[i].getSymbol(), retrievedMarks[i].getSymbol());
            assertEquals(marks[i].getPosition(), retrievedMarks[i].getPosition());
        }
    }

    @Test
    public void testSetMarks_Error() {
        assertThrows(IllegalArgumentException.class, () -> {
            board.setMarks(null);
        });
    }
}
