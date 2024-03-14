package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;

public class PlayerImplementation implements PlayerInterface {
    private Symbol symbol;

    public PlayerImplementation(Symbol sym) {
        this.symbol = sym;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public Move getPlayerMove(SimulatorInterface game, UserInterface ui) throws IllegalArgumentException {
        if (game == null || ui == null) {
            throw new IllegalArgumentException("Bad");
        }
        return ui.getUserMove();
    }

}
