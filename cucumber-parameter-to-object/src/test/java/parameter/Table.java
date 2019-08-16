package parameter;

public class Table {

	private int number;

	public Table(String number) {
		this.number = Integer.parseInt(number);
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Table [number=" + number + "]";
	}
	
}
