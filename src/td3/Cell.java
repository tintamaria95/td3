package td3;

public class Cell<T> {
	private T s;
	private Cell<T> ref;

	public Cell(T s, Cell<T> ref) {
		this.s = s;
		this.ref = ref;
	}

	public Cell<T> getRef() {
		return ref;
	}

	public void setRef(Cell<T> c) {
		this.ref = c;
	}

	public T getS() {
		return s;
	}

	public void setS(T s) {
		this.s = s;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getS() instanceof String) {
			str = (String) this.getS();
		}
		return str;

	}

	public static void main(String[] args) {
//		Cell c1 = new Cell("a", null);
//		Cell c2 = new Cell("b", c1);
//		System.out.println(c2.s + c2.ref.s);
	}
}
