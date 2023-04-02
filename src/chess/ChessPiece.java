package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;

    // Constructor
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // Getter
    public Color getColor() {
        return color;
    }

    // Converts the position into a Chess position
    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    // Verifies if there is an opponent piece
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
