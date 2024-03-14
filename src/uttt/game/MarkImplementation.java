package uttt.game;

import uttt.utils.Symbol;

public class MarkImplementation implements MarkInterface {
    private Symbol symbol;
    private int position;

    public MarkImplementation(Symbol symbol, int position) {

        this.symbol = symbol;
        this.position = position;
        if ((symbol == null) || (position < 0 || position > 8)) {
            throw new IllegalArgumentException("Out of bounds");
        }
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("Wrong Symbol.");
        }

        this.symbol = symbol;
    }

}
