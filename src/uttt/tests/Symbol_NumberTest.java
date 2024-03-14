package uttt.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class Symbol_NumberTest {

    MarkInterface s0 = UTTTFactory.createMark(Symbol.EMPTY, 0);
    MarkInterface s1 = UTTTFactory.createMark(Symbol.CROSS, 1);
    MarkInterface s2 = UTTTFactory.createMark(Symbol.CIRCLE, 2);
    MarkInterface s3 = UTTTFactory.createMark(Symbol.CIRCLE, 3);
    MarkInterface s4 = UTTTFactory.createMark(Symbol.CROSS, 4);
    MarkInterface s5 = UTTTFactory.createMark(Symbol.EMPTY, 5);
    MarkInterface s6 = UTTTFactory.createMark(Symbol.CIRCLE, 6);
    MarkInterface s7 = UTTTFactory.createMark(Symbol.CROSS, 7);
    MarkInterface s8 = UTTTFactory.createMark(Symbol.EMPTY, 8);

    @Test
    public void symbolte() {
        assertEquals(Symbol.EMPTY, s0.getSymbol());
        assertEquals(Symbol.CROSS, s1.getSymbol());
        assertEquals(Symbol.CIRCLE, s2.getSymbol());
        assertEquals(8, s8.getPosition());
        assertEquals(7, s7.getPosition());
        assertEquals(6, s6.getPosition());
        assertEquals(5, s5.getPosition());
        assertEquals(4, s4.getPosition());
        assertEquals(3, s3.getPosition());
        assertEquals(2, s2.getPosition());
        assertEquals(1, s1.getPosition());
        assertEquals(0, s0.getPosition());

    }

}
