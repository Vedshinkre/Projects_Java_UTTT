package uttt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

public class GetCurrentPlayerSymbolTest {
    @Test
    public void testGetCurrentPlayerSymbol() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        simulator.setCurrentPlayerSymbol(Symbol.CROSS);
        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertNotNull(currentPlayerSymbol);
        assertEquals(Symbol.CROSS, currentPlayerSymbol);
    }

    @Test
    public void testGetCurrentPlayerSymbolnill() {
        assertThrows(IllegalArgumentException.class, () -> {
            SimulatorInterface simulator = UTTTFactory.createSimulator();
            simulator.setCurrentPlayerSymbol(null);
        });
    }

}