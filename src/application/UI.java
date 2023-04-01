package application;

import chess.ChessPiece;

public class UI {

    // Imprime o tabuleiro utilizando a matriz quadrada 8x8
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    // Posiciona uma peça no lugar desejado, se o valor de peça estiver vazio, imprime um - indicando espaço vazio no tabuleiro
    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        } else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }

}
