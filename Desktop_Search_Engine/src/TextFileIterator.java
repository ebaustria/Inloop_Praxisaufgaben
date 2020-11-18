import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class TextFileIterator implements java.util.Iterator<String> {
	private String file;
	private String current;
	private String[] array;
	private List<String> words;
	private String hyphen;
	
	public TextFileIterator(Resource res) {
		if (res == null) {
			throw new NullPointerException("The resource parameter cannot be null.");
		}
		file = getAsString(res);
		file = file.replace("\n", "");
		hyphen = "-";
		
		for (int i = 0; i < file.length(); i++) {
			if (Character.toString(file.charAt(i)).equals(hyphen)) {
				if (Character.isLowerCase(file.charAt(i + 1))) {
					file = file.replace(hyphen, "");
				} else {
					file = file.replace(hyphen, " ");
				}
			}
		}
		for (int i = 0; i < file.length(); i++) {
			if (!Character.isLetter(file.charAt(i)) &&
					!Character.isDigit(file.charAt(i))) {
				file = file.replace(Character.toString(file.charAt(i)), " ");
			}
		}
		array = file.split(" ");
		words = Arrays.asList(array);
		words = new ArrayList<String>();
		Collections.addAll(words, array);
		current = words.get(0);
	}

	@Override
	public boolean hasNext() {
		if (words.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String next() {
		if (this.hasNext()) {
			String result = current;
			words.remove(current);
			if (this.hasNext()) {
				current = words.get(0);
			}
			System.out.println(result);
			return result;
		}
		throw new NoSuchElementException("There is no next word.");
	}
	
	public void remove() {
		throw new UnsupportedOperationException("The remove() method cannot be called.");
	}
	
	public String getAsString(Resource res) {
		String str = "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
		return str;
	}
}
