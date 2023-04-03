package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    // Constructor
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // Getters
    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    // Increase and decrease move count
    public void increaseMoveCount() {
        moveCount++;
    }

    public void decreaseMoveCount() {
        moveCount--;
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
