import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyMatrix<T> implements Matrix<T> {
	private Map<MatrixIndex, T> matrixEntries;
	
	public MyMatrix() {
		matrixEntries = new HashMap<MatrixIndex, T>();
	}

	@Override
	public int getRowCount() {
		int row = 0;
		Set<MatrixIndex> keys = matrixEntries.keySet();
		if (keys.size() == 0) {
			return row;
		}
		for (MatrixIndex index : keys) {
			if (index.getRow() > row) {
				row = index.getRow();
			}
		}
		return row + 1;
	}

	@Override
	public int getColumnCount() {
		int column = 0;
		Set<MatrixIndex> keys = matrixEntries.keySet();
		if (keys.size() == 0) {
			return column;
		}
		for (MatrixIndex index : keys) {
			if (index.getColumn() > column) {
				column = index.getColumn();
			}
		}
		return column + 1;
	}

	@Override
	public int getObjectCount() {
		int count = 0;
		for (Entry<MatrixIndex, T> entry : matrixEntries.entrySet()) {
			if (entry.getValue() != null) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getDistinctObjectCount() {
		Set<T> result = new HashSet<T>();
		for (T value : matrixEntries.values()) {
			if (value != null) {
				result.add(value);
			}
		}
		return result.size();
	}

	@Override
	public Iterator<T> iterator() {
		return new DepthFirstIterator(this);
	}

	@Override
	public T get(int row, int column) {
		if (row >= getRowCount()) {
			throw new IllegalArgumentException("The row parameter cannot exceed the number of rows.");
		}
		if (column >= getColumnCount()) {
			throw new IllegalArgumentException("The column parameter cannot exceed the number of columns.");
		}
		if (row < 0) {
			throw new IllegalArgumentException("The row cannot be negative.");
		}
		if (column < 0) {
			throw new IllegalArgumentException("The column cannot be negative.");
		}
		
		MatrixIndex index = new MatrixIndex(row, column);
		for (MatrixIndex in : matrixEntries.keySet()) {
			if (index.equals(in)) {
				index = in;
			}
		}
		return matrixEntries.get(index);
	}

	@Override
	public T put(int row, int column, T value) {
		if (row < 0) {
			throw new IllegalArgumentException("The row cannot be negative.");
		}
		if (column < 0) {
			throw new IllegalArgumentException("The column cannot be negative.");
		}
		
		MatrixIndex index = new MatrixIndex(row, column);
		for (MatrixIndex in : matrixEntries.keySet()) {
			if (index.equals(in)) {
				index = in;
			}
		}
		T oldValue = matrixEntries.get(index);
		matrixEntries.put(index, value);
		return oldValue;
	}

	@Override
	public boolean contains(T value) {
		if (matrixEntries.containsValue(value)) {
			return true;
		}
		return false;
	}
	
	class DepthFirstIterator implements Iterator<T> {
		List<MatrixIndex> indexList = new LinkedList<MatrixIndex>();
		List<MatrixIndex> newIndexList = new LinkedList<MatrixIndex>();
		int current;
		MyMatrix<T> matrix;

		DepthFirstIterator(MyMatrix<T> matrix) {
			int row = 0;
			int column = 0;
			
			while (column < matrix.getColumnCount()) {
				while (row < matrix.getRowCount()) {
					indexList.add(new MatrixIndex(row, column));
					row++;
				}
				row = 0;
				column++;
			}
			for (MatrixIndex index : indexList) {
				T value = matrix.matrixEntries.get(index);
				if (value != null) {
					newIndexList.add(index);
				}
			}
			current = 0;
			this.matrix = matrix;
		}
		@Override
		public boolean hasNext() {
			if (current < newIndexList.size()) {
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			if (this.hasNext()) {
				MatrixIndex nextIndex = newIndexList.get(current);
				T next = (T) matrix.get(nextIndex.getRow(), nextIndex.getColumn());
				current++;
				return next;
			}
			throw new NoSuchElementException("There is no next element.");
		}
	}

}
