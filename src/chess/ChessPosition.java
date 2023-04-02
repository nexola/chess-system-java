package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    // Constructor
    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are fom A1 to H8");
        }
        this.column = column;
        this.row = row;
    }

    // Getters
    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    // Converting Chess Position (A8) to Matrix Position [0][0]
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    // Converting Matrix Position [0][0] to Chess Position (A8)
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }

}
