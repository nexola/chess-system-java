package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    // Inica um novo tabuleiro
    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    // Percorre o tabuleiro
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }

        }
        return mat;
    }

    // Place the pieces on the board at the start of the game
    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(7, 0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7, 7));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 3));
    }

}
