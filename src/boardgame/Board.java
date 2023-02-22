package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	// Verifica se a posição especificada existe no tabuleiro
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column]; //Retorna a peça na posição especificada
	}
	
	// Verifica se a posição especificada existe no tabuleiro
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()]; //// Retorna a peça na posição especificada
	}
		// Coloca a peça na posição especificada
	public void placePiece(Piece piece, Position position) { //por argumento esta vindo uma matriz
		if(thereIsAPiece(position)) {
			throw new BoardException("there is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece; // essa matriz é a matriz do meu tabuleiro
		piece.position = position;  // o método piece esta acessando o atributo position que é protected da classe Piece e passando a ele uma nova posição
	}  // Atualiza a posição da peça Piece position
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
