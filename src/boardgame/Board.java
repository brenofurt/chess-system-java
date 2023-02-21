package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

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
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
							//esse piece só pode estar vindo do método
	public void placePiece(Piece piece, Position position) { //por argumento esta vindo uma matriz
		pieces[position.getRow()][position.getColumn()] = piece; // essa matriz é a matriz do meu tabuleiro
		piece.position = position;  // o método piece esta acessando o atributo position que é protected da classe Piece e passando a ele uma nova posição
	}
	
}
