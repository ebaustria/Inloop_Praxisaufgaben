
public class MatrixIndex {
	private int row;
	private int column;
	
	MatrixIndex(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (this.getClass() != o.getClass() || o == null) {
			return false;
		}
		MatrixIndex mi = (MatrixIndex) o;
		
		if (this.row == mi.getRow() && this.column == mi.getColumn()) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		return row + column;
	}
}
