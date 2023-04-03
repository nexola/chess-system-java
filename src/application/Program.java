package application;

import boardgame.BoardException;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();


        while (!chessMatch.getCheckMate()) {
            try {

                // Clears the screen
                UI.clearScreen();

                // Prints the match
                UI.printMatch(chessMatch, captured);

                // Asks and performs a move
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                // Captures the piece if so
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                // Adds the piece to the list of captured pieces
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                // Case promoted
                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/C/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("C") && !type.equals("R") && !type.equals("Q")) {
                        System.out.print("Invalid value! Enter piece for promotion (B/C/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
                // Exception treatment
            } catch (ChessException | InputMismatchException | InvalidParameterException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        // Prints the final state of match
        UI.printMatch(chessMatch, captured);
    }
}
