package com.ulto.game;

public class Pair <A, B> {
	private A a;
	private B b;

	public Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}

	public void setA(A a) {
		this.a = a;
	}

	public void setB(B b) {
		this.b = b;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pair))
			return false;
		Pair<?, ?> other = (Pair<?, ?>)obj;
		return a.equals(other.getA()) && b.equals(other.getB());
	}
}