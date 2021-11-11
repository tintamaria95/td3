package td3;

public class MyList<T> {

	private Cell<T> ref_prec = null;
	private int size = 0;

	public static void main(String[] args) {
		MyList<String> ml = new MyList<String>();
		ml.addLast("tatu");
		ml.add("toto");
		ml.add("titi");
		ml.addLast("tutu");
		System.out.println(ml);
		System.out.println(ml.get(3));
		System.out.println(ml.sumLetters());

	}

	public boolean contains(Object o) {
		Cell<T> c = ref_prec;
		while (c != null) {
			if (c.getS().equals(o)) {
				return true;
			}
			c = c.getRef();
		}
		return false;
	}

	public void add(T s) {
		size = getSize() + 1;
		Cell<T> c = new Cell<T>(s, ref_prec);
		this.ref_prec = c;
	}

	public void add(T s, int i) {
		size = getSize() + 1;
		int cpt = 1;
		if (i == 0) {
			this.add(s);
		} else {
			Cell<T> c = ref_prec;
			while (cpt < i) {
				c = c.getRef();
				cpt += 1;
			}
			c.setRef(new Cell<T>(s, c.getRef()));
		}

	}

	public void addLast(T s) {
		size = getSize() + 1;
		if (this.ref_prec == null) {
			this.add(s);
		} else {
			Cell<T> c = ref_prec;
			while (c.getRef() != null) {
				c = c.getRef();
			}
			c.setRef(new Cell<T>(s, null));
		}

	}

	public Object get(int i) throws NullPointerException {
		int cpt = 0;
		Cell<T> c = ref_prec;
		while (cpt < i) {
			try {
				c = c.getRef();
				cpt += 1;
			} catch (NullPointerException e) {
				System.out.println("entrée invalide");
				return "";
			}
		}
		if (c == null) {
			throw new NullPointerException("entrée invalide");
		}
		return c.getS();
	}

	public int sumLetters() throws NullPointerException {
		int cpt = 0;
		Cell<T> c = ref_prec;
		int sum_letters = 0;
		while (cpt < this.size) {
			try {
				sum_letters += c.getS().toString().length();
				c = c.getRef();
				cpt += 1;
			} catch (NullPointerException e) {
				System.out.println("hors limite");
				return sum_letters;
			}
		}
		if (c == null) {
			throw new NullPointerException("c est null");
		}
		return sum_letters;
	}

	@Override
	public String toString() {
		Cell<T> c = ref_prec;
		String liste_str = "";
		while (c != null) {
			liste_str = liste_str + ", " + c.getS();
			c = c.getRef();
		}
		return liste_str;
	}

	public int getSize() {
		return size;
	}

//	public int size() {
//	int cpt = 0;
//	Cell c = ref_prec;
//	if (c != null) {
//		cpt++;
//	}
//	while (c.getRef() != null) {
//		c = c.getRef();
////		System.out.println(c.getS());
//		cpt += 1;
//	}
//	return cpt;
//}
}
