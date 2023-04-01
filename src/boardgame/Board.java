package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    // Constructor
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // Getters and Setters
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    // Posicona a peça para o local desejado
    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    // Seleciona a posição da peça
    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    // Move a peça de posição
    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
