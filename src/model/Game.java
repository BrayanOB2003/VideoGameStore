package model;

public class Game {
	private double price;
	private int indentifier;
	private int quantity;
	
	public Game(double p, int id, int q) {
		price = p;
		indentifier = id;
		quantity = q;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIndentifier() {
		return indentifier;
	}

	public void setIndentifier(int indentifier) {
		this.indentifier = indentifier;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void takeGame() {
		quantity--;
	}
}
