package uttt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

public class CurrentPlayerTest {

    SimulatorInterface simulator = UTTTFactory.createSimulator();

    @Test
    public void SetCurrentPlayer() {

        Symbol symbol = Symbol.CROSS;
        simulator.setCurrentPlayerSymbol(symbol);

        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(symbol, currentPlayerSymbol);
    }

    @Test
    public void testSetCurrentPlayerSymbol_InvalidSymbol() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        Symbol invalidSymbol = Symbol.EMPTY;
        simulator.setCurrentPlayerSymbol(invalidSymbol);

        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(invalidSymbol, currentPlayerSymbol);

    }

    @Test
    public void testSetCurrentPlayerSymbol_InvalidSymbol2() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        assertThrows(IllegalArgumentException.class, ()->{simulator.setCurrentPlayerSymbol(null);});

    }
}